package com.julianw03.poroLCU.model.lolChampSelect.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.julianw03.poroLCU.model.shared.Ownership;
import lombok.Getter;

import java.util.List;

@Getter
public class SkinCarouselItem {
    private Integer                championId;
    private List<SkinCarouselItem> childSkins;
    private String                 ChromaPreviewPath;
    private Boolean                disabled;
    private ArrayNode              emblems;
    private String                 groupSplash;
    private Integer                id;
    private Boolean                isBase;
    private Boolean                isChampionUnlocked;
    private String                 name;
    private Ownership              ownership;
    private JsonNode               productType;
    private String                 rarityGemPath;
    private ObjectNode             skinAugments;
    private String                 splashPath;
    private String                 splashVideoPath;
    private Boolean                stillObtainable;
    private String                 tilePath;
    private Boolean                unlocked;
}
