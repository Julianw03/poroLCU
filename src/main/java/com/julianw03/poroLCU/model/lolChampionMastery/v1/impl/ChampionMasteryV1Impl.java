package com.julianw03.poroLCU.model.lolChampionMastery.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolChampionMastery.v1.*;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.function.Function;

public class ChampionMasteryV1Impl implements ChampionMasteryV1 {

    private static final String BASE_PATH = "/lol-champion-mastery/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<ChampionMastery>>> getChampionMastery(Puuid puuid) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/" + puuid + "/champion-mastery",
                        null
                ), new TypeReference<List<ChampionMastery>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<TopMasteries>> getTopChampionMasteries(Puuid puuid, int count) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/"+ puuid +"/champion-mastery/top?count=" + count,
                        null
                ), TopMasteries.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<ChampionMastery>>> getLocalPlayerChampionMastery() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/local-player/champion-mastery",
                        null
                ), new TypeReference<List<ChampionMastery>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Integer>> getLocalPlayerChampionMasteryScore() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/local-player/champion-mastery-score",
                        null
                ), Integer.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<MasterySet>> getLocalPlayerMasterySetsAndRewards() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/local-player/champion-mastery-sets-and-rewards",
                        null
                ), MasterySet.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<MasteryNotification>> getMasteryNotification() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/notifications",
                        null
                ), MasteryNotification.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> acknowledgeMasteryNotification() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/notifications/ack",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ArrayNode>> getRewardGrants() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/reward-grants",
                        null
                ), ArrayNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<JsonNode>> deleteRewardGrant(String rewardId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/reward-grants/" + rewardId,
                        null
                ), JsonNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<ScoutingMastery>>> getScoutingMasteryData(List<Puuid> puuids) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/scouting",
                        puuids
                ), new TypeReference<List<ScoutingMastery>>() {}
        );
    }
}
