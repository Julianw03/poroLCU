package com.julianw03.poroLCU.model.lolChallenges.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface ChallengesV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<List<Integer>>> getAvailableQueueIds();

    Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getCategories();

    Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getLocalPlayerChallengeData();

    Function<LCUHttpConnector, LCUApiResponse<String>> getClientState();

    Function<LCUHttpConnector, LCUApiResponse<Map<ChallengeLevel, Integer>>> getLevelPoints();

    Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getUpdatedChallenges(Long GameId, Puuid puuid);

    Function<LCUHttpConnector, LCUApiResponse<Map<Integer, ChallengeData>>> getMyUpdatedChallenges(Long GameId);

    Function<LCUHttpConnector, LCUApiResponse<List<ChallengeSeason>>> getSeasons();

    Function<LCUHttpConnector, LCUApiResponse<ChallengeSummary>> getLocalPlayerChallengeSummary();

    Function<LCUHttpConnector, LCUApiResponse<ChallengeSummary>> getChallengeSummary(Puuid puuid);

    Function<LCUHttpConnector, LCUApiResponse<Map<Puuid, ChallengeSummary>>> getChallengeSummary(List<Puuid> puuids);
}
