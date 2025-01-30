package com.julianw03.poroLCU.connection.messaging;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.Util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class LCUMessageManager {
    private static final Logger log = LoggerFactory.getLogger(LCUMessageManager.class);

    protected final List<LCUMessageListener> listeners;

    public LCUMessageManager(List<LCUMessageListener> listeners) {
        this.listeners = listeners;
    }

    public LCUMessageManager() {
        this.listeners = new ArrayList<>();
    }

    private void notifyListenersSecure(LCUWebsocketMessage message) {
        Thread.currentThread().setName("LCU-Message-Notifier");
        listeners.forEach(
                listeners -> {
                    try {
                        listeners.onLCUMessage(message);
                    } catch (Exception e) {
                        log.warn("Error in listener", e);
                    }
                }
        );
    }

    public void dispatchMessage(String message) {
        if (message == null || message.isEmpty()) return;
        try {
            ArrayNode arrayNode = (ArrayNode) Utils.getObjectReader().readTree(message);
            LCUWebsocketMessage parsedMessage = Utils.getObjectReader().readValue(arrayNode.get(2), LCUWebsocketMessage.class);
            notifyListenersSecure(parsedMessage);
        } catch (Exception e) {
            log.error("Failed to parse message", e);
        }
    }

    public boolean addListener(LCUMessageListener listener) {
        return listeners.add(listener);
    }

    public boolean removeListener(LCUMessageListener listener) {
        return listeners.remove(listener);
    }
}
