package com.julianw03.poroLCU.model.lolChampionMastery.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.function.Function;

public interface ChampionMasteryV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<List<ChampionMastery>>> getChampionMastery(Puuid puuid);

    Function<LCUHttpConnector, LCUApiResponse<TopMasteries>> getTopChampionMasteries(Puuid puuid, int count);

    Function<LCUHttpConnector, LCUApiResponse<List<ChampionMastery>>> getLocalPlayerChampionMastery();

    Function<LCUHttpConnector, LCUApiResponse<Integer>> getLocalPlayerChampionMasteryScore();

    Function<LCUHttpConnector, LCUApiResponse<MasterySet>> getLocalPlayerMasterySetsAndRewards();

    Function<LCUHttpConnector, LCUApiResponse<MasteryNotification>> getMasteryNotification();

    Function<LCUHttpConnector, LCUApiResponse<Void>> acknowledgeMasteryNotification();

    Function<LCUHttpConnector, LCUApiResponse<ArrayNode>> getRewardGrants();

    Function<LCUHttpConnector, LCUApiResponse<JsonNode>> deleteRewardGrant(String rewardId);

    Function<LCUHttpConnector, LCUApiResponse<List<ScoutingMastery>>> getScoutingMasteryData(List<Puuid> puuids);
}
