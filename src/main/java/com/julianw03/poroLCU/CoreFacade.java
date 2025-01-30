package com.julianw03.poroLCU;

import com.julianw03.poroLCU.configuration.Configuration;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.connection.messaging.LCUMessageManager;
import com.julianw03.poroLCU.connection.messaging.LCUWebsocket;
import com.julianw03.poroLCU.state.LCUConnectionState;

import java.util.Optional;

public interface CoreFacade extends Manageable {
    /**
     * Adds a listener that gets notified when the connection state to the LCU changes.
     *
     * @return true if the underlying implementation added the listener, false otherwise.
     */
    boolean addConnectionStateListener(ConnectionStateListener listener);

    /**
     * Removes a listener that gets notified when the connection state to the LCU changes.
     *
     * @return true if the underlying implementation removed the listener, false otherwise.
     */
    boolean removeConnectionStateListener(ConnectionStateListener listener);

    /**
     * Will block until {@link Manageable#stop()} is called.
     */
    void awaitStop();

    /**
     * @return The configuration object used by this facade.
     */
    Configuration getConfiguration();

    /**
     * @return The message manager used by this facade.
     */
    LCUMessageManager getMessageManager();

    /**
     * @return The current connection state to the LCU.
     */
    LCUConnectionState getConnectionState();

    /**
     * @return The http connector used by this facade, if available.
     * @implNote The connector *MUST* be not null when the connection state is {@link LCUConnectionState#CONNECTED}.
     * @implNote This connector may become null when the connection state changes to {@link LCUConnectionState#DISCONNECTED}.
     */
    Optional<LCUHttpConnector> getHttpConnector();

    /**
     * @return The websocket used by this facade, if available.
     * @implNote The websocket *MUST* be not null when the connection state is {@link LCUConnectionState#CONNECTED}.
     * @implNote This websocket may become null when the connection state changes to {@link LCUConnectionState#DISCONNECTED}.
     */
    Optional<LCUWebsocket> getWebsocket();
}
