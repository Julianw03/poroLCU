package com.julianw03.poroLCU.model.lolCollections.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolCollections.v1.BackdropInfo;
import com.julianw03.poroLCU.model.lolCollections.v1.CollectionsV1;
import com.julianw03.poroLCU.model.lolCollections.v1.SpellInfo;
import com.julianw03.poroLCU.model.lolCollections.v1.WardSkin;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;
import java.util.function.Function;

public class CollectionsV1Impl implements CollectionsV1 {

    private static final String BASE_PATH = "/lol-collections/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<BackdropInfo>> getBackdropInfo(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/backdrop",
                        null
                ), BackdropInfo.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SpellInfo>> getSpellInfo(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/spells",
                        null
                ), SpellInfo.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<WardSkin>>> getWardSkins(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/ward-skins",
                        null
                ), new TypeReference<List<WardSkin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<WardSkin>> getWardSkin(SummonerId summonerId, Integer wardSkinId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/ward-skins/" + wardSkinId,
                        null
                ), WardSkin.class
        );
    }
}
