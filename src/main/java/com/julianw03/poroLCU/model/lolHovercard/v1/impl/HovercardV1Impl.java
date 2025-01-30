package com.julianw03.poroLCU.model.lolHovercard.v1.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolHovercard.v1.FriendHovercardInfo;
import com.julianw03.poroLCU.model.lolHovercard.v1.HovercardV1;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.net.http.HttpResponse;
import java.util.function.Function;

public class HovercardV1Impl implements HovercardV1 {

    private static final String RELATIVE_PATH = "/lol-hovercard/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FriendHovercardInfo>> getFriendInfo(SummonerId summonerId) {
        return (
                lcuHttpConnector -> {
                    HttpResponse<JsonNode> response = lcuHttpConnector.sendApiRequest(
                            HttpMethod.GET,
                            RELATIVE_PATH + "/friend-info-by-summoner/" + summonerId,
                            null
                    );

                    return new LCUApiResponse<>(response, FriendHovercardInfo.class);
                }
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FriendHovercardInfo>> getFriendInfo(Puuid puuid) {
        return (
                lcuHttpConnector -> {
                    HttpResponse<JsonNode> response = lcuHttpConnector.sendApiRequest(
                            HttpMethod.GET,
                            RELATIVE_PATH + "/friend-info/" + puuid,
                            null
                    );

                    return new LCUApiResponse<>(response, FriendHovercardInfo.class);
                }
        );
    }
}
