package com.julianw03.poroLCU.model.lolChampions.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;
import java.util.function.Function;

public interface ChampionsV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<List<Champion>>> getChampionInventory(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<List<MinimalChampion>>> getMinimalChampionInventory(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<PlayableChampionsCount>> getPlayableChampionsInventory(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<Champion>> getChampionFromInventory(SummonerId summonerId, Integer championId);

    Function<LCUHttpConnector, LCUApiResponse<List<Skin>>> getChampionSkinsFromInventory(SummonerId summonerId, Integer championId);

    Function<LCUHttpConnector, LCUApiResponse<Skin>> getChampionSkinFromInventory(SummonerId summonerId, Integer championId, Integer skinId);

    Function<LCUHttpConnector, LCUApiResponse<List<Skin.Chroma>>> getChampionSkinChromasFromInventory(SummonerId summonerId, Integer championId, Integer skinId);

    Function<LCUHttpConnector, LCUApiResponse<List<MinimalSkin>>> getMinimalChampionSkinsFromInventory(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<List<MinimalChampion>>> getOwnedChampionsMinimal();
}
