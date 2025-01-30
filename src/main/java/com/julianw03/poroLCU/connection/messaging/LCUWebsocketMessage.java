package com.julianw03.poroLCU.connection.messaging;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class LCUWebsocketMessage {
    @JsonProperty("eventType")
    private LCUMessageType type;
    private String uri;
    private JsonNode data;

    private LCUWebsocketMessage() {}

    public LCUWebsocketMessage(LCUMessageType type, String uri, JsonNode data) {
        this.type = type;
        this.uri = uri;
        this.data = data;
    }

    public LCUMessageType getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public JsonNode getData() {
        return data;
    }
}
