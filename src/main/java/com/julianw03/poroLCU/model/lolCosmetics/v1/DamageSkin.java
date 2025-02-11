package com.julianw03.poroLCU.model.lolCosmetics.v1;

import lombok.Getter;

import java.util.List;

@Getter
public class DamageSkin extends Item {
    private String           groupName;
    private Integer          level;
    private List<DamageSkin> upgrades;

    private DamageSkin() {
        super();
    }
}
