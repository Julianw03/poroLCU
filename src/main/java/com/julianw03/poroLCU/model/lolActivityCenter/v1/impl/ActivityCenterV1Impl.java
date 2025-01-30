package com.julianw03.poroLCU.model.lolActivityCenter.v1.impl;

import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolActivityCenter.v1.*;

import java.util.function.Function;

public class ActivityCenterV1Impl implements ActivityCenterV1 {

    private static final String BASE_PATH = "/lol-activity-center/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> clearCache() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/clear-cache",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ConfigData>> getConfig() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/config-data",
                        null
                ), ConfigData.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ContentData>> getContentData(String navigationItemID) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/content-data/" + navigationItemID,
                        null
                ), ContentData.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ClientNav>> getClientNav() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/client-nav",
                        null
                ), ClientNav.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Overrides>> getOverrides() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/overrides",
                        null
                ), Overrides.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Boolean>> getPluginReady() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/ready",
                        null
                ), Boolean.class)
        );
    }
}
