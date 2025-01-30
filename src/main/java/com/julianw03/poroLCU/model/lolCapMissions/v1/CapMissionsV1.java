package com.julianw03.poroLCU.model.lolCapMissions.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface CapMissionsV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<Boolean>> getPluginReady();
}
