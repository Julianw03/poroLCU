package com.julianw03.poroLCU.connection.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LCUMessageType {
    @JsonProperty("Create")
    CREATE,
    @JsonProperty("Update")
    UPDATE,
    @JsonProperty("Delete")
    DELETE;

    LCUMessageType() {
    }
}
