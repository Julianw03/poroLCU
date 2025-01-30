package com.julianw03.poroLCU.connection.messaging;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.Util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

public class LCUWebsocketListener implements WebSocket.Listener {
    private static final Logger            log = LoggerFactory.getLogger(LCUWebsocketListener.class);
    private final        LCUMessageManager messageManager;

    public LCUWebsocketListener(
            LCUMessageManager messageManager
    ) {
        this.messageManager = messageManager;
    }

    private StringBuilder messageBuffer = new StringBuilder();

    @Override
    public void onOpen(WebSocket webSocket) {
        log.info("Websocket opened");
        ArrayNode node = (ArrayNode) Utils.getObjectReader().createArrayNode();
        node.add(5);
        node.add("OnJsonApiEvent");
        webSocket.sendText(node.toString(), true).thenAccept(
                result -> log.info("Sent OnJsonApiEvent")
        );
        WebSocket.Listener.super.onOpen(webSocket);
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        messageBuffer.append(data);
        if (last) {
            messageManager.dispatchMessage(messageBuffer.toString());
            messageBuffer = new StringBuilder();
        }
        return WebSocket.Listener.super.onText(webSocket, data, last);
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        log.info("Websocket closed with status code {} and reason {}", statusCode, reason);
        return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
    }

    public void onError(WebSocket webSocket, Throwable error) {
        log.error("Websocket error", error);
        WebSocket.Listener.super.onError(webSocket, error);
    }
}
