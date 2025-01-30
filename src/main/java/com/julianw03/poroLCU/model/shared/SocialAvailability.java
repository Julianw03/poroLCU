package com.julianw03.poroLCU.model.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SocialAvailability {
    @JsonProperty("chat")
    CHAT,
    @JsonProperty("online")
    ONLINE,
    @JsonProperty("dnd")
    DND,
    @JsonProperty("away")
    AWAY,
    @JsonProperty("mobile")
    MOBILE,
    @JsonProperty("offline")
    OFFLINE
}
