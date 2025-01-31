package com.julianw03.poroLCU.model.lolChampSelect.v1;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MutedPlayer {
    private Puuid      puuid;
    private SummonerId summonerId;
    private Puuid      obfuscatedPuuid;
    private SummonerId obfuscatedSummonerId;

    public MutedPlayer() {}
}
