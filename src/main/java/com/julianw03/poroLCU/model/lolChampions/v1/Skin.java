package com.julianw03.poroLCU.model.lolChampions.v1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.julianw03.poroLCU.model.shared.Ownership;
import lombok.Getter;

import java.util.List;

@Getter
public class Skin extends MinimalSkin {
    @Getter
    public static class Chroma {
        private Integer      championId;
        private String       chromaPath;
        private List<String> colors;
        private Boolean      disabled;
        private Integer      id;
        private Boolean      lastSelected;
        private String       name;
        private Ownership    ownership;
        private SkinAugments skinAugments;
        private Boolean      stillObtainable;

        private Chroma() {
        }
    }

    private List<Chroma> chromas;
    private String       collectionSplashVideoPath;
    private ArrayNode    emblems;
    private String       featuresText;
    private ObjectNode   questSkinInfo;
    private String       rarityGemPath;
    private String       skinType;
    private String       splashVideoPath;
    private String       uncenteredSplashPath;

    private Skin() {
    }
}
