package com.julianw03.poroLCU.model.lolActiveBoosts.v1;

import lombok.Getter;

@Getter
public class ActiveBoosts {
    private String xpBoostEndDate;
    private int    xpBoostPerWinCount;
    private int    xpLoyaltyBoost;
    private String firstWinOfTheDayStartTime;
}
