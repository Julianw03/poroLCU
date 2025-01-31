package com.julianw03.poroLCU.model.lolChallenges.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolChallenges.v1.*;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ChallengesV1Impl implements ChallengesV1 {

    private static final String BASE_PATH = "/lol-challenges/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Integer>>> getAvailableQueueIds() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/available-queue-ids",
                        null
                ), new TypeReference<List<Integer>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getCategories() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/challenges/category-data",
                        null
                ), new TypeReference<Map<Integer, ChallengeData>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getLocalPlayerChallengeData() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/challenges/local-player",
                        null
                ), new TypeReference<Map<Integer, ChallengeData>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getClientState() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/client-state",
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Map<ChallengeLevel, Integer>>> getLevelPoints() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/level-points",
                        null
                ), new TypeReference<Map<ChallengeLevel, Integer>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getUpdatedChallenges(Long GameId, Puuid puuid) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/updated-challenges/" + GameId + "/" + puuid,
                        null
                ), new TypeReference<Map<Integer, ChallengeData>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getMyUpdatedChallenges(Long GameId) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/my-updated-challenges/" + GameId,
                        null
                ), new TypeReference<Map<Integer, ChallengeData>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<ChallengeSeason>>> getSeasons() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/seasons",
                        null
                ), new TypeReference<List<ChallengeSeason>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ChallengeSummary>> getLocalPlayerChallengeSummary() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/summary-player-data/local-player",
                        null
                ), ChallengeSummary.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ChallengeSummary>> getChallengeSummary(Puuid puuid) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/summary-player-data/player/" + puuid,
                        null
                ), ChallengeSummary.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Map<Puuid, ChallengeSummary>>> getChallengeSummary(List<Puuid> puuids) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/summary-player-data/players?puuids=" + puuids.stream().map(Puuid::toString).reduce((a, b) -> a + "," + b).orElse(""),
                        null
                ), new TypeReference<Map<Puuid, ChallengeSummary>>() {})
        );
    }
}
