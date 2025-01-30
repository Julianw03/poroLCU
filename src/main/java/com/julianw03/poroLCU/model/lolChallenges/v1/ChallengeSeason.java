package com.julianw03.poroLCU.model.lolChallenges.v1;

import lombok.Getter;

@Getter
public class ChallengeSeason {
    private boolean isActive;
    private long    seasonEnd;
    private int     seasonId;
    private long    seasonStart;

    private ChallengeSeason() {}
}
