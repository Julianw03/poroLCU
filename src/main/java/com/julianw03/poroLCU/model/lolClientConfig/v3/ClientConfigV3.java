package com.julianw03.poroLCU.model.lolClientConfig.v3;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface ClientConfigV3 extends PluginInterface {
    /**
     * Return values from this endpoint are dependent on the configType parameter.
     * Therefore, we return {@link JsonNode} to allow for flexibility in the return type.
     */
    Function<LCUHttpConnector, LCUApiResponse<JsonNode>> getClientConfig(String configType);
}
