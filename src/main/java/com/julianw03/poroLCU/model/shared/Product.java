package com.julianw03.poroLCU.model.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Product {
    @JsonProperty("league_of_legends")
    LEAGUE_OF_LEGENDS,
    @JsonProperty("bacon")
    LEGENDS_OF_RUNETERRA,
    @JsonProperty("teamfight_tactics")
    TEAMFIGHT_TACTICS,
    @JsonProperty("valorant")
    VALORANT,
    @JsonProperty("ritoplus")
    RIOT_MOBILE,
    @JsonProperty("wildrift")
    WILD_RIFT
}
