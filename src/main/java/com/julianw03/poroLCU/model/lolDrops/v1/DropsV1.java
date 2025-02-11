package com.julianw03.poroLCU.model.lolDrops.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public interface DropsV1 extends PluginInterface {
    /**
     * This gives you the drop tables for the TFT Treasure Realms
     */
    Function<LCUHttpConnector, LCUApiResponse<List<DropData>>> getDropTables();

    Function<LCUHttpConnector, LCUApiResponse<DropData>> getDropTable(UUID dropTableId);

    Function<LCUHttpConnector, LCUApiResponse<List<OddsElement>>> getOddsList(UUID dropTableId);

    Function<LCUHttpConnector, LCUApiResponse<OddsTree>> getOddsTree(UUID dropTableId);

    Function<LCUHttpConnector, LCUApiResponse<List<PityCount>>> getPlayerPityCounts(Puuid puuid);

    Function<LCUHttpConnector, LCUApiResponse<JsonNode>> getTotalRollsCounts(Puuid puuid);

    Function<LCUHttpConnector, LCUApiResponse<Boolean>> getEndpointReady();
}
