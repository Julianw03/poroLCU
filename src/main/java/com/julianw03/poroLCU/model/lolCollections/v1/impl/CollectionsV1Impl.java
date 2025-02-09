package com.julianw03.poroLCU.model.lolCollections.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolCollections.v1.Backdrop;
import com.julianw03.poroLCU.model.lolCollections.v1.CollectionsV1;
import com.julianw03.poroLCU.model.lolCollections.v1.SpellInventory;
import com.julianw03.poroLCU.model.lolCollections.v1.WardSkin;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;
import java.util.function.Function;

public class CollectionsV1Impl implements CollectionsV1 {

    private static final String BASE_PATH = "/lol-collections/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Backdrop>> getBackdrop(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", summonerId.toString(), "backdrop"),
                        null
                ), Backdrop.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SpellInventory>> getSpells(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", summonerId.toString(), "spells"),
                        null
                ), SpellInventory.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<WardSkin>>> getWardSkins(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", summonerId.toString(), "ward-skins"),
                        null
                ), new TypeReference<List<WardSkin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<WardSkin>> getWardSkin(SummonerId summonerId, Integer wardSkinId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", summonerId.toString(), "ward-skins", wardSkinId.toString()),
                        null
                ), WardSkin.class
        );
    }
}
