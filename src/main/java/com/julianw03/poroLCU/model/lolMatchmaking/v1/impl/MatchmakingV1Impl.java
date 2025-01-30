package com.julianw03.poroLCU.model.lolMatchmaking.v1.impl;

import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolMatchmaking.v1.MatchmakingV1;
import com.julianw03.poroLCU.model.lolMatchmaking.v1.SearchState;

import java.util.function.Function;

public class MatchmakingV1Impl implements MatchmakingV1 {

    private static final String RELATIVE_PATH = "/lol-matchmaking/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SearchState>> getSearchState() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/search",
                        null
                ),
                SearchState.class
        ));
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SearchState.Error[]>> getSearchErrors() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/search/errors",
                        null
                ),
                SearchState.Error[].class
        ));
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SearchState.Error>> getErrorById(int id) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/search/errors/" + id,
                        null
                ),
                SearchState.Error.class
        ));
    }
}
