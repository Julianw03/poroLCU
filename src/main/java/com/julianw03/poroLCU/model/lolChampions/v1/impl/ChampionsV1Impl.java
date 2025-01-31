package com.julianw03.poroLCU.model.lolChampions.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolChampions.v1.*;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;
import java.util.function.Function;

public class ChampionsV1Impl implements ChampionsV1 {

    private static final String BASE_PATH = "/lol-champions/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Champion>>> getChampionInventory(SummonerId summonerId) {

        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/champions",
                        null
                ), new TypeReference<List<Champion>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<MinimalChampion>>> getMinimalChampionInventory(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/champions-minimal",
                        null
                ), new TypeReference<List<MinimalChampion>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<PlayableChampionsCount>> getPlayableChampionsInventory(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/champions-playable-count",
                        null
                ), PlayableChampionsCount.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Champion>> getChampionFromInventory(SummonerId summonerId, Integer championId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/champions/" + championId,
                        null
                ), Champion.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Skin>>> getChampionSkinsFromInventory(SummonerId summonerId, Integer championId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/champions/" + championId + "/skins",
                        null
                ), new TypeReference<List<Skin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Skin>> getChampionSkinFromInventory(SummonerId summonerId, Integer championId, Integer skinId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/champions/" + championId + "/skins/" + skinId,
                        null
                ), Skin.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Skin.Chroma>>> getChampionSkinChromasFromInventory(SummonerId summonerId, Integer championId, Integer skinId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/champions/" + championId + "/skins/" + skinId + "/chromas",
                        null
                ), new TypeReference<List<Skin.Chroma>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<MinimalSkin>>> getMinimalChampionSkinsFromInventory(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/inventories/" + summonerId + "/skins-minimal",
                        null
                ), new TypeReference<List<MinimalSkin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<MinimalChampion>>> getOwnedChampionsMinimal() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/owned-champions-minimal/",
                        null
                ), new TypeReference<List<MinimalChampion>>() {}
        );
    }
}
