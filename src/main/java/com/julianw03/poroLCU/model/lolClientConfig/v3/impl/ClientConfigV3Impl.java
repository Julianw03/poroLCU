package com.julianw03.poroLCU.model.lolClientConfig.v3.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolClientConfig.v3.ClientConfigV3;

import java.util.function.Function;

public class ClientConfigV3Impl implements ClientConfigV3 {

    private static final String BASE_PATH = "/lol-client-config/v3/client-config";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<JsonNode>> getClientConfig(String configType) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/" + configType,
                        null
                ), JsonNode.class);
    }
}
