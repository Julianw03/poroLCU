package com.julianw03.poroLCU.model.lolHonorV2.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.function.Function;

public interface HonorV2V1 extends PluginInterface {
    Function<LCUConnector, LCUApiResponse<Void>> postAcknowledgeHonorNotification(String mailId);
    Function<LCUConnector, LCUApiResponse<Void>> deleteHonorBallot();
    Function<LCUConnector, LCUApiResponse<HonorBallot>> getHonorBallot();
    Function<LCUConnector, LCUApiResponse<HonorBallot.HonorConfig>> getHonorConfig();
    Function<LCUConnector, LCUApiResponse<Void>> postHonorPlayer(String gameId, SummonerId summonerId, String honorCategory, Puuid puuid);
}
