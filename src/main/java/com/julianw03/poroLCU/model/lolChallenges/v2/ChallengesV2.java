package com.julianw03.poroLCU.model.lolChallenges.v2;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.lolChallenges.v1.ChallengeTitle;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface ChallengesV2 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<Map<String, ChallengeTitle>>> getAllTitles();

    Function<LCUHttpConnector, LCUApiResponse<List<ChallengeTitle>>> getLocalPlayerTitles();
}
