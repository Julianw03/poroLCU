package com.julianw03.poroLCU.model.lolMatchmaking.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface MatchmakingV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<SearchState>> getSearchState();
    Function<LCUHttpConnector, LCUApiResponse<SearchState.Error[]>> getSearchErrors();
    Function<LCUHttpConnector, LCUApiResponse<SearchState.Error>> getErrorById(int id);
}
