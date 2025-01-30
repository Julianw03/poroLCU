package com.julianw03.poroLCU.model.lolActiveBoosts.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface ActiveBoostsV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<ActiveBoosts>> getActiveBoosts();
}
