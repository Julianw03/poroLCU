package com.julianw03.poroLCU.model.lolBanners.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;

import java.util.List;
import java.util.function.Function;

public interface BannersV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<List<BannerFlag>>> getBannerFlags();
    Function<LCUHttpConnector, LCUApiResponse<BannerFlag>> getEquippedBannerFlag();
    Function<LCUHttpConnector, LCUApiResponse<BannerFlag>> equipBannerFlag(EquipBannerFlagObject equipBannerFlag);
    Function<LCUHttpConnector, LCUApiResponse<BannerFlagFrame>> getEquippedBannerFlagFrame();
    Function<LCUHttpConnector, LCUApiResponse<BannerFlag>> getEquippedBannerFlag(Puuid puuid);
}
