package com.julianw03.poroLCU.model.lolChampions.v1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.model.shared.Ownership;
import lombok.Getter;

@Getter
public class MinimalSkin {
    @Getter
    public static class SkinAugments {
        private ArrayNode augments;

        private SkinAugments() {
        }
    }

    protected Integer      championId;
    protected String       chromaPath;
    protected Boolean      disabled;
    protected Integer      id;
    protected Boolean      isBase;
    protected Boolean      lastSelected;
    protected String       name;
    protected Ownership    ownership;
    protected SkinAugments skinAugments;
    protected String       splashPath;
    protected Boolean      stillObtainable;
    protected String       tilePath;

    protected MinimalSkin() {
    }
}
