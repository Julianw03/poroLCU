package com.julianw03.poroLCU.model.lolCollections.v1;

import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

import java.util.List;

@Getter
public class SpellInventory {
    private List<Long> spells;
    private SummonerId summonerId;

    private SpellInventory() {}
}
