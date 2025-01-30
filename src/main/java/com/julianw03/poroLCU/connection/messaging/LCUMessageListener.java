package com.julianw03.poroLCU.connection.messaging;

public interface LCUMessageListener {
    void onLCUMessage(LCUWebsocketMessage message);
}
