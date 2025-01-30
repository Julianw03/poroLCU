package com.julianw03.poroLCU.model.deepLinks.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface DeepLinkV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<String>> getLegendsOfRuneterraLaunchLink();
    Function<LCUHttpConnector, LCUApiResponse<DeepLinkSettings>> getSettings();
}
