package com.julianw03.poroLCU.model.lolHonorV2.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum HonorType {
    @JsonProperty("HEART")
    HEART,
    @JsonProperty("COOL")
    COOL,
    @JsonProperty("SHOTCALLER")
    SHOTCALLER;

    HonorType() {}
}
