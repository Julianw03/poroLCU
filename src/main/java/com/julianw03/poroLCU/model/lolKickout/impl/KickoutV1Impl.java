package com.julianw03.poroLCU.model.lolKickout.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolKickout.KickoutNotification;
import com.julianw03.poroLCU.model.lolKickout.KickoutV1;

import java.net.http.HttpResponse;
import java.util.function.Function;

public class KickoutV1Impl implements KickoutV1 {

    private static final String RELATIVE_PATH = "/lol-kickout/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<KickoutNotification>> getKickoutNotification() {
        return (
                lcuHttpConnector -> {
                    HttpResponse<JsonNode> response = lcuHttpConnector.sendApiRequest(
                            HttpMethod.GET,
                            RELATIVE_PATH + "/notification",
                            null
                    );

                    return new LCUApiResponse<>(response, KickoutNotification.class);
                }
        );
    }
}
