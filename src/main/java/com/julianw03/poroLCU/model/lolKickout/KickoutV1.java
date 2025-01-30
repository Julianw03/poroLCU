package com.julianw03.poroLCU.model.lolKickout;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface KickoutV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<KickoutNotification>> getKickoutNotification();
}
