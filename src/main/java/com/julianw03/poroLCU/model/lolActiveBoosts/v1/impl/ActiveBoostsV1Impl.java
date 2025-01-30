package com.julianw03.poroLCU.model.lolActiveBoosts.v1.impl;

import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolActiveBoosts.v1.ActiveBoosts;
import com.julianw03.poroLCU.model.lolActiveBoosts.v1.ActiveBoostsV1;

import java.util.function.Function;

public class ActiveBoostsV1Impl implements ActiveBoostsV1 {

    private static final String BASE_PATH = "/lol-active-boosts/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ActiveBoosts>> getActiveBoosts() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/active-boosts",
                        null
                ), ActiveBoosts.class)
        );
    }
}
