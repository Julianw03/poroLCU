package com.julianw03.poroLCU;

import com.julianw03.poroLCU.configuration.Configuration;
import com.julianw03.poroLCU.connection.http.LCUConnector;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.connection.messaging.LCUMessageListener;
import com.julianw03.poroLCU.connection.messaging.LCUMessageManager;
import com.julianw03.poroLCU.connection.messaging.LCUWebsocket;
import com.julianw03.poroLCU.connection.messaging.LCUWebsocketMessage;
import com.julianw03.poroLCU.process.InformationAggregator;
import com.julianw03.poroLCU.process.LeagueClientProcessParameters;
import com.julianw03.poroLCU.process.os.InsufficientPermissionException;
import com.julianw03.poroLCU.process.os.SupportedOperatingSystem;
import com.julianw03.poroLCU.state.LCUConnectionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class Core implements CoreFacade {
    private static final Logger log = LoggerFactory.getLogger(Core.class);

    private final Configuration     configuration;
    private final LCUMessageManager messageManager;

    private final List<ConnectionStateListener> connectionStateListeners = Collections.synchronizedList(new ArrayList<>());

    private LCUConnectionState            connectionState = LCUConnectionState.DISCONNECTED;
    private LCUConnector                  connector;
    private LCUWebsocket                  websocket;
    private LeagueClientProcessParameters processParameters;

    private CompletableFuture<Void> stopFuture = null;

    Core(Configuration configuration) {
        this.configuration = configuration;
        this.messageManager = new LCUMessageManager();

        if (configuration.doLogMessages()) {
            messageManager.addListener(new LCUMessageListener() {
                @Override
                public void onLCUMessage(LCUWebsocketMessage message) {
                    log.info("{} {}: {}", message.getType(), message.getUri(), message.getData());
                }
            });
        }
    }

    private void transition(LCUConnectionState newState) {
        if (newState == null || newState == connectionState) {
            return;
        }

        new Thread(() -> {
            doTransition(newState);
        }).start();
    }

    private void doTransition(LCUConnectionState newState) {
        log.info("Transitioning from {} to {}", connectionState, newState);
        connectionState = newState;
        switch (newState) {
            case AWAITING_LEAGUE_PROCESS -> searchForProcess();
            case AWAITING_LCU_REST_READY -> awaitLCUConnection(processParameters);
            case AWAITING_LCU_WEBSOCKET_CONNECTED -> awaitLCUWebsocketConnected();
            case CONNECTED -> log.info("Connected to LCU");
            case DISCONNECTED -> handleDisconnected();
            default -> log.warn("Unhandled state transition to {}", newState);
        }
        connectionStateListeners.forEach(listener -> {
            try {
                listener.onConnectionState(connectionState);
            } catch (Exception e) {
                log.error("Error while notifying connection state listener", e);
            }
        });
    }

    private void stop(ExitReason reason) {
        if (reason == null) {
            return;
        }

        log.info("Exiting due to {}", reason.getMessage());
        stop();
        if (configuration.doExitOnError()) {
            System.exit(reason.getExitCode());
        }
    }

    public void searchForProcess() {
        Thread.currentThread().setName("Process-Search-Thread");
        Optional<SupportedOperatingSystem> operatingSystem = SupportedOperatingSystem.fromCurrentOS();
        if (operatingSystem.isEmpty()) {
            log.error("Could not find a supported operating system");
            stop(ExitReason.NO_PROCESS_INFORMATION_AGGREGATOR_FOUND);
            return;
        }
        SupportedOperatingSystem os = operatingSystem.get();
        log.info("Found supported operating system: {}", os.getDisplayName());
        InformationAggregator informationAggregator = os.getAggregator();

        for (int i = 0; i < configuration.getMaximumProcessSearchAttempts() && isRunning(); i++) {
            log.debug("Running process search attempt {}", i + 1);
            Optional<LeagueClientProcessParameters> optParameters;
            try {
                optParameters = informationAggregator.findProcess();
            } catch (InsufficientPermissionException e) {
                log.error("Insufficient permissions to search for League of Legends process");
                stop(ExitReason.INSUFFICIENT_PERMISSIONS);
                return;
            }
            if (optParameters.isEmpty()) {
                final long retryDelay = configuration.getProcessSearchDelay().toMillis();
                log.debug("Could not find League of Legends process, retrying in {}ms", retryDelay);
                try {
                    Thread.sleep(retryDelay);
                } catch (InterruptedException e) {
                    log.error("Thread interrupted while waiting for process search retry");
                    return;
                }
                continue;
            }
            processParameters = optParameters.get();
            log.info("Found League of Legends process: Auth-Secret: {}; Port: {}", processParameters.getRemotingAuthToken(), processParameters.getAppPort());
            transition(LCUConnectionState.AWAITING_LCU_REST_READY);
            return;
        }
        log.warn("Could not find League of Legends process after {} attempts", configuration.getMaximumProcessSearchAttempts());
    }

    private void awaitLCUConnection(LeagueClientProcessParameters parametersToTest) {
        Thread.currentThread().setName("LCU-Connection-Thread");
        for (int i = 0; i < configuration.getMaximumLCUConnectionAttempts() && isRunning(); i++) {
            log.error("Running LCU connection attempt {}", i + 1);
            if (LCUConnector.testConnection(parametersToTest)) {
                log.info("Successfully connected to LCU");
                connector = new LCUConnector(parametersToTest);
                transition(LCUConnectionState.AWAITING_LCU_WEBSOCKET_CONNECTED);
                return;
            }
            final long retryDelay = configuration.getLcuConnectionDelay().toMillis();
            log.debug("Could not connect to LCU, retrying in {}ms", retryDelay);
            try {
                Thread.sleep(retryDelay);
            } catch (InterruptedException e) {
                log.error("Thread interrupted while waiting for LCU connection retry");
                return;
            }
        }
        log.warn("Could not connect to LCU after {} attempts", configuration.getMaximumLCUConnectionAttempts());
        transition(LCUConnectionState.DISCONNECTED);
    }

    private void awaitLCUWebsocketConnected() {
        Thread.currentThread().setName("LCU-Websocket-Connetion-Thread");
        final LCUWebsocket internalWebsocket = new LCUWebsocket(
                messageManager,
                processParameters
        );
        try {
            internalWebsocket.connect().join();
            websocket = internalWebsocket;
        } catch (Exception e) {
            log.error("Error while connecting to LCU websocket", e);
            transition(LCUConnectionState.DISCONNECTED);
            return;
        }

        log.info("Connected to LCU websocket");
        transition(LCUConnectionState.CONNECTED);
    }

    private void handleDisconnected() {
        Optional.ofNullable(connector);
    }


    @Override
    public boolean addConnectionStateListener(ConnectionStateListener listener) {
        log.info("Registered new Listener");
        return connectionStateListeners.add(listener);
    }

    @Override
    public boolean removeConnectionStateListener(ConnectionStateListener listener) {
        log.info("Unregistered Listener");
        return connectionStateListeners.remove(listener);
    }

    @Override
    public LCUMessageManager getMessageManager() {
        return messageManager;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public void start() {
        if (configuration.doSearchOnStartup()) {
            transition(LCUConnectionState.AWAITING_LEAGUE_PROCESS);
        }
        log.info("Starting PoroLCU");
        stopFuture = new CompletableFuture<>();
        log.info("Startup completed");
    }

    @Override
    public void awaitStop() {
        try {
            stopFuture.join();
        } catch (Exception e) {
            log.error("Error while waiting for stop", e);
        }
    }

    @Override
    public boolean isRunning() {
        return Optional.ofNullable(stopFuture)
                .map(future -> !future.isDone())
                .orElse(false);
    }

    @Override
    public void stop() {
        log.info("Stopping PoroLCU");
        websocket.getWebSocket().ifPresent(WebSocket::abort);
        stopFuture.complete(null);
        log.info("Stopped PoroLCU");
    }

    @Override
    public LCUConnectionState getConnectionState() {
        return connectionState;
    }

    @Override
    public Optional<LCUHttpConnector> getHttpConnector() {
        return Optional.ofNullable(connector);
    }

    @Override
    public Optional<LCUWebsocket> getWebsocket() {
        return Optional.ofNullable(websocket);
    }
}
