package com.julianw03.poroLCU.model.lolContentTargeting.v1.impl;

import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolContentTargeting.v1.ContentTargetingV1;
import com.julianw03.poroLCU.model.lolContentTargeting.v1.FilterObject;
import com.julianw03.poroLCU.model.lolContentTargeting.v1.LocaleObject;

import java.util.function.Function;

public class ContentTargetingV1Impl implements ContentTargetingV1 {

    private static final String BASE_PATH = "/lol-content-targeting/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FilterObject>> getFilters() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "filters"),
                        null
                ), FilterObject.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<LocaleObject>> getLocale() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "locale"),
                        null
                ), LocaleObject.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FilterObject>> getProtectedFilters() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "protected_filters"),
                        null
                ), FilterObject.class
        );
    }
}
