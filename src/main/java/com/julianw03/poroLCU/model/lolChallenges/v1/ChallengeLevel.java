package com.julianw03.poroLCU.model.lolChallenges.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public enum ChallengeLevel {
    NONE,
    IRON,
    BRONZE,
    SILVER,
    GOLD,
    PLATINUM,
    DIAMOND,
    MASTER,
    GRANDMASTER,
    CHALLENGER;

    ChallengeLevel() {
    }

    @JsonCreator
    public static ChallengeLevel fromString(String value) {
        if (value == null || value.isEmpty()) {
            return ChallengeLevel.NONE;
        }

        for (ChallengeLevel level : ChallengeLevel.values()) {
            if (level.name().equalsIgnoreCase(value)) {
                return level;
            }
        }
        return ChallengeLevel.NONE;
    }
}
