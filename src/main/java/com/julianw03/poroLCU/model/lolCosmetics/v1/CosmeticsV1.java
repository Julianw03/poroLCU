package com.julianw03.poroLCU.model.lolCosmetics.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface CosmeticsV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<Void>> addFavourite(String cosmeticType, String contentId);

    Function<LCUHttpConnector, LCUApiResponse<Void>> removeFavourite(String cosmeticType, String contentId);

    Function<LCUHttpConnector, LCUApiResponse<Favourites<Companion>>> getFavouriteCompanions();

    Function<LCUHttpConnector, LCUApiResponse<Favourites<DamageSkin>>> getFavouriteDamageSkins();

    Function<LCUHttpConnector, LCUApiResponse<Favourites<MapSkin>>> getFavouriteMapSkins();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedChampion(Integer itemId);

    /**
     * Removes the current selection and resets the Companion to the Default Companion
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedCompanion();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedDamageSkin(Integer itemId);

    /**
     * Removes the current selection and resets the Companion to the Default Damage Skin
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedDamageSkin();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedMapSkin(Integer itemId);

    /**
     * Removes the current selection and resets the Companion to the Default Map Skin
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedMapSkin();
}
