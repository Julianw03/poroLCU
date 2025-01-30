package com.julianw03.poroLCU.model.lolChallenges.v2.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolChallenges.v1.ChallengeTitle;
import com.julianw03.poroLCU.model.lolChallenges.v2.ChallengesV2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ChallengesV2Impl implements ChallengesV2 {

    private static final String BASE_PATH = "/lol-challenges/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Map<String, ChallengeTitle>>> getAllTitles() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/titles/all",
                        null
                ), new TypeReference<Map<String,ChallengeTitle>>(){})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<ChallengeTitle>>> getLocalPlayerTitles() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/titles/local-player",
                        null
                ), new TypeReference<List<ChallengeTitle>>(){})
        );
    }
}
