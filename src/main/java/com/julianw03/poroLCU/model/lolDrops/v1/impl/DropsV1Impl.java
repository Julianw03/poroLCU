package com.julianw03.poroLCU.model.lolDrops.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolDrops.v1.*;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class DropsV1Impl implements DropsV1 {

    private static final String BASE_PATH = "/lol-drops/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<DropData>>> getDropTables() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "drop-tables"),
                        null
                ), new TypeReference<List<DropData>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<DropData>> getDropTable(UUID dropTableId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "drop-tables", dropTableId.toString()),
                        null
                ), DropData.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<OddsElement>>> getOddsList(UUID dropTableId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "drop-tables", dropTableId.toString(), "odds-list"),
                        null
                ), new TypeReference<List<OddsElement>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<OddsTree>> getOddsTree(UUID dropTableId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "drop-tables", dropTableId.toString(), "odds-tree"),
                        null
                ), OddsTree.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<PityCount>>> getPlayerPityCounts(Puuid puuid) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "players", puuid.getValue(), "pity-counts"),
                        null
                ), new TypeReference<List<PityCount>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<JsonNode>> getTotalRollsCounts(Puuid puuid) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "players", puuid.getValue(), "total-rolls-counts"),
                        null
                ), JsonNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Boolean>> getEndpointReady() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "ready"),
                        null
                ), Boolean.class
        );
    }
}
