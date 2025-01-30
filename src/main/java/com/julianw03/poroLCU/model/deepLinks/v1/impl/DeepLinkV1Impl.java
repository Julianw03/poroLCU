package com.julianw03.poroLCU.model.deepLinks.v1.impl;

import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.deepLinks.v1.DeepLinkSettings;
import com.julianw03.poroLCU.model.deepLinks.v1.DeepLinkV1;

import java.util.function.Function;

public class DeepLinkV1Impl implements DeepLinkV1 {

    private static final String RELATIVE_PATH = "/lol-deeplinks/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getLegendsOfRuneterraLaunchLink() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/launch-lor-link",
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<DeepLinkSettings>> getSettings() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/settings",
                        null
                ), DeepLinkSettings.class)
        );
    }
}
