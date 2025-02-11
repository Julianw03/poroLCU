package com.julianw03.poroLCU.model.lolCollections.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;
import java.util.function.Function;

public interface CollectionsV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<BackdropInfo>> getBackdropInfo(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<SpellInfo>> getSpellInfo(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<List<WardSkin>>> getWardSkins(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<WardSkin>> getWardSkin(SummonerId summonerId, Integer wardSkinId);
}
