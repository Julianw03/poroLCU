package com.julianw03.poroLCU.model.lolBanners.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolBanners.v1.BannerFlag;
import com.julianw03.poroLCU.model.lolBanners.v1.BannerFlagFrame;
import com.julianw03.poroLCU.model.lolBanners.v1.BannersV1;
import com.julianw03.poroLCU.model.lolBanners.v1.EquipBannerFlagObject;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.function.Function;

public class BannersV1Impl implements BannersV1 {

    private static final String RELATIVE_PATH = "/lol-banners/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<BannerFlag>>> getBannerFlags() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/current-summoner/flags",
                        null
                ), new TypeReference<List<BannerFlag>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<BannerFlag>> getEquippedBannerFlag() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/current-summoner/flags/equipped",
                        null
                ), BannerFlag.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<BannerFlag>> equipBannerFlag(EquipBannerFlagObject equipBannerFlag) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/current-summoner/flags/equipped",
                        equipBannerFlag
                ), BannerFlag.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<BannerFlagFrame>> getEquippedBannerFlagFrame() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/current-summoner/frames/equipped",
                        null
                ), BannerFlagFrame.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<BannerFlag>> getEquippedBannerFlag(Puuid puuid) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/players/" + puuid +"/flags/equipped",
                        null
                ), BannerFlag.class)
        );
    }
}
