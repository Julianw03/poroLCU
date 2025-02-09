package com.julianw03.poroLCU.model.lolChat.v2;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.function.Function;

public interface ChatV2 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<List<FriendRequest>>> getFriendRequests();

    Function<LCUHttpConnector, LCUApiResponse<Void>> sendFriendRequest(AddFriendRequest friendRequest);

    //TODO: Find out what put expects, does and returns

    Function<LCUHttpConnector, LCUApiResponse<Void>> removeFriendRequest(Puuid puuid);
}
