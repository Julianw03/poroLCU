package com.julianw03.poroLCU.model.lolActivityCenter.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface ActivityCenterV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<Void>> clearCache();
    Function<LCUHttpConnector, LCUApiResponse<ConfigData>> getConfig();
    Function<LCUHttpConnector, LCUApiResponse<ContentData>> getContentData(String navigationItemID);
    Function<LCUHttpConnector, LCUApiResponse<ClientNav>> getClientNav();
    Function<LCUHttpConnector, LCUApiResponse<Overrides>> getOverrides();
    Function<LCUHttpConnector, LCUApiResponse<Boolean>> getPluginReady();
}
