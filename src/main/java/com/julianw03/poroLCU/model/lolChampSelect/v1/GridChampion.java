package com.julianw03.poroLCU.model.lolChampSelect.v1;

import lombok.Getter;

import java.util.List;

@Getter
public class GridChampion {
    @Getter
    public static class SelectionStatus {
        private Boolean banIntended;
        private Boolean banIntendedByMe;
        private Boolean isBanned;
        private Boolean pickIntended;
        private Boolean pickIntendedByMe;
        private String  pickIntendedPosition;
        private Boolean pickedOrBanned;
        private Boolean selectedByMe;

        private SelectionStatus() {}
    }

    private Boolean         disabled;
    private Boolean         freeToPlay;
    private Boolean         freeToPlayForQueue;
    private Integer             id;
    private Boolean         loyaltyReward;
    private Integer             masteryLevel;
    private Integer             masteryPoints;
    private String          name;
    private Boolean         owned;
    /**
     * Although the name would imply that only a List of {@link Position} would be stored, the code that handles the toggling of the favorite status of a position
     * accepts any String. Therefore, a List of {@link String} is used instead.
     * */
    private List<String>    positionsFavorited;
    private Boolean         rented;
    private List<String>    roles;
    private SelectionStatus selectionStatus;
    private String          squarePortraitPath;
    private Boolean         xboxGPReward;

    private GridChampion() {}
}
