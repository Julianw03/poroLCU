package com.julianw03.poroLCU.model.lolClientConfig.v3;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface ClientConfigV3 extends PluginInterface {
    /**
     * The config types return different types of values in different formats.
     * Therefore, they will not be further specified (for now at least)
     */
    Function<LCUHttpConnector, LCUApiResponse<JsonNode>> getClientConfig(String configIdentifier);
}
