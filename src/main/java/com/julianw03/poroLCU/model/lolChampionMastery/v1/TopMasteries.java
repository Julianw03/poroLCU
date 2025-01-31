package com.julianw03.poroLCU.model.lolChampionMastery.v1;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

import java.util.List;

@Getter
public class TopMasteries {
    private List<ChampionMastery> masteries;
    private Puuid                 puuid;
    private Integer               score;
    private SummonerId            summonerId;

    private TopMasteries() {}
}
