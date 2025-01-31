package com.julianw03.poroLCU.model.lolChampSelect;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

import java.util.List;

@Getter
public class TeamBoost {
    private List<Integer> availableSkinIds;
    private Integer       ipReward;
    private Integer       ipRewardForPurchaser;
    private Integer       price;
    private Puuid         puuid;
    private String        skinUnlockMode;
    private SummonerId    summonerId;
    private Boolean       unlocked;

    private TeamBoost() {
    }
}
