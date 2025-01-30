package com.julianw03.poroLCU.connection.messaging;

import com.julianw03.poroLCU.connection.ssl.RiotSSLContext;
import com.julianw03.poroLCU.process.LeagueClientProcessParameters;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class LCUWebsocket {

    private final LCUMessageManager             messageManager;
    private final LeagueClientProcessParameters parameters;
    private       WebSocket                     webSocket;

    public LCUWebsocket(
            LCUMessageManager messageManager,
            LeagueClientProcessParameters parameters
    ) {
        this.messageManager = messageManager;
        this.parameters = parameters;
    }

    public CompletableFuture<WebSocket> connect() {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .sslContext(RiotSSLContext.create())
                    .build();

            return client.newWebSocketBuilder()
                    .header(
                            "Authorization",
                            parameters.getAuthHeaderValue()
                    ).buildAsync(
                            new URI("wss://127.0.0.1:" + parameters.getAppPort() + "/"),
                            new LCUWebsocketListener(this.messageManager)
                    ).thenApply(webSocket -> {
                        this.webSocket = webSocket;
                        return webSocket;
                    });
        } catch (Exception e) {
        }
        final CompletableFuture<WebSocket> future = new CompletableFuture<>();
        future.completeExceptionally(new RuntimeException("Failed to create websocket"));
        return future;
    }

    public Optional<WebSocket> getWebSocket() {
        return Optional.ofNullable(webSocket);
    }
}
