package com.julianw03.poroLCU.model.lolChampSelect;

import lombok.Getter;

import java.util.List;

@Getter
public class PinDropNotification {
    @Getter
    public static class PinDropSummoner {
        private Integer  slotId;
        private Position position;
        private String   lane;
        private Integer  lanePosition;
        private Boolean  isLocalSummoner;
        private Boolean  isPlaceholder;

        private PinDropSummoner() {
        }
    }

    private List<PinDropSummoner> pinDropSummoners;
    private String                mapSide;

    private PinDropNotification() {
    }
}
