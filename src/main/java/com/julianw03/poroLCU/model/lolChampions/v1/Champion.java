package com.julianw03.poroLCU.model.lolChampions.v1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Getter;

import java.util.List;

@Getter
public class Champion extends MinimalChampion {
    @Getter
    public static class Ability {
        protected String description;
        protected String name;

        protected Ability() {
        }
    }

    @Getter
    public static class TacticalInfo {
        protected String  damageType;
        protected Integer difficulty;
        protected Integer style;

        protected TacticalInfo() {
        }
    }

    protected Ability       passive;
    //TODO: Model this type
    protected ArrayNode     skins;
    protected List<Ability> spells;
    protected TacticalInfo  tacticalInfo;

    protected Champion() {
        super();
    }
}
