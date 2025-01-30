package com.julianw03.poroLCU.model.lolHonorV2.v1.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUConnector;
import com.julianw03.poroLCU.model.lolHonorV2.v1.HonorBallot;
import com.julianw03.poroLCU.model.lolHonorV2.v1.HonorV2V1;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.net.http.HttpResponse;
import java.util.function.Function;

public class HonorV2V1Impl implements HonorV2V1 {

    private static final String RELATIVE_PATH = "/lol-honor-v2/v1";

    @Override
    public Function<LCUConnector, LCUApiResponse<Void>> postAcknowledgeHonorNotification(String mailId) {
        return (lcuConnector -> {
            HttpResponse<JsonNode> response = lcuConnector.sendApiRequest(
                    HttpMethod.POST,
                    RELATIVE_PATH + "/ack-honor-notification/" + mailId,
                    null
            );

            return new LCUApiResponse<>(response, Void.class);
        });
    }

    @Override
    public Function<LCUConnector, LCUApiResponse<Void>> deleteHonorBallot() {
        return null;
    }

    @Override
    public Function<LCUConnector, LCUApiResponse<HonorBallot>> getHonorBallot() {
        return (lcuConnector ->
                new LCUApiResponse<>(
                        lcuConnector.sendApiRequest(
                                HttpMethod.GET,
                                RELATIVE_PATH + "/ballot",
                                null
                        ),
                        HonorBallot.class
                )
        );
    }

    @Override
    public Function<LCUConnector, LCUApiResponse<HonorBallot.HonorConfig>> getHonorConfig() {
        return (lcuConnector -> {
            HttpResponse<JsonNode> response = lcuConnector.sendApiRequest(
                    HttpMethod.GET,
                    RELATIVE_PATH + "/config",
                    null
            );

            return new LCUApiResponse<>(response, HonorBallot.HonorConfig.class);
        });
    }

    @Override
    public Function<LCUConnector, LCUApiResponse<Void>> postHonorPlayer(String gameId, SummonerId summonerId, String honorCategory, Puuid puuid) {
        return null;
    }
}
