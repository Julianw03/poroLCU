package com.julianw03.poroLCU.model.lolChampSelect.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum Position {
    TOP("TOP", "top"),
    JUNGLE("JUNGLE", "jungle"),
    MIDDLE("MIDDLE", "middle"),
    SUPPORT("UTILITY", "support"),
    BOTTOM("BOTTOM", "bottom");

    private final String name;
    private final String favoriteId;

    Position(String name, String favoriteId) {
        this.name = name;
        this.favoriteId = favoriteId;
    }

    @JsonCreator
    public static Position fromString(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        for (Position position : Position.values()) {
            if (position.name.equalsIgnoreCase(value)) {
                return position;
            }
        }
        return null;
    }

    public static Optional<Position> fromFavouriteValue(String favId) {
        for (Position position : Position.values()) {
            if (position.favoriteId.equalsIgnoreCase(favId)) {
                return Optional.of(position);
            }
        }
        return Optional.empty();
    }
}
