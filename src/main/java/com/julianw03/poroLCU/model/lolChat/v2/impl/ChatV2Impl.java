package com.julianw03.poroLCU.model.lolChat.v2.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolChat.v2.AddFriendRequest;
import com.julianw03.poroLCU.model.lolChat.v2.ChatV2;
import com.julianw03.poroLCU.model.lolChat.v2.FriendRequest;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.function.Function;

public class ChatV2Impl implements ChatV2 {

    private static final String BASE_PATH = "/lol-chat/v2";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<FriendRequest>>> getFriendRequests() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "/friend-requests"),
                        null
                ), new TypeReference<List<FriendRequest>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> sendFriendRequest(AddFriendRequest friendRequest) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "/friend-requests"),
                        friendRequest
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> removeFriendRequest(Puuid puuid) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        Utils.createPath(BASE_PATH, "/friend-requests/" + puuid.getValue()),
                        null
                ), Void.class
        );
    }
}
