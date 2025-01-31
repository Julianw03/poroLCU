package com.julianw03.poroLCU.model.lolContentTargeting.v1.impl;

import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolContentTargeting.v1.ContentTargetingV1;
import com.julianw03.poroLCU.model.lolContentTargeting.v1.FilterInfo;
import com.julianw03.poroLCU.model.lolContentTargeting.v1.LocaleInfo;

import java.util.function.Function;

public class ContentTargetingV1Impl implements ContentTargetingV1 {

    private static final String BASE_PATH = "/lol-content-targeting/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FilterInfo>> getFilters() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/filters",
                        null
                ), FilterInfo.class);
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<LocaleInfo>> getLocale() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/locale",
                        null
                ), LocaleInfo.class);
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FilterInfo>> getProtectedFilters() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/protected_filters",
                        null
                ), FilterInfo.class);
    }
}
