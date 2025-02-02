package com.julianw03.poroLCU.model.lolCosmetics.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.model.lolChampions.v1.Champion;
import lombok.Getter;

import java.util.List;

@Getter
public class Companion extends Item {
    @Getter
    public static class StarShardsPrice {
        private String  offerId;
        private Integer price;

        private StarShardsPrice() {
        }
    }

    private String          color;
    private Integer         level;
    private JsonNode        offerData;
    private String          species;
    private StarShardsPrice starShardsPrice;
    private List<Champion>  upgrades;

    private Companion() {
        super();
    }
}
