package com.julianw03.poroLCU.model.lolHovercard.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.function.Function;

public interface HovercardV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<FriendHovercardInfo>> getFriendInfo(SummonerId summonerId);
    Function<LCUHttpConnector, LCUApiResponse<FriendHovercardInfo>> getFriendInfo(Puuid puuid);
}
