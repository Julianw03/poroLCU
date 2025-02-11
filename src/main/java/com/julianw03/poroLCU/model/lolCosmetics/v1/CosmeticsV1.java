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

    //TODO: Find out what [PUT] /lol-cosmetics/v1/favorites/tft/save does and returns

    /**
     * Although a {@code setName} is required for the call, it doesn't really change anything as of {@code 11.02.2025}
     */
    Function<LCUHttpConnector, LCUApiResponse<Inventory<Companion>>> getCompanionInventory(String setName);

    /**
     * Although a {@code setName} is required for the call, it doesn't really change anything as of {@code 11.02.2025}
     */
    Function<LCUHttpConnector, LCUApiResponse<Inventory<DamageSkin>>> getDamageSkinInventory(String setName);

    /**
     * Although a {@code setName} is required for the call, it doesn't really change anything as of {@code 11.02.2025}
     */
    Function<LCUHttpConnector, LCUApiResponse<Inventory<MapSkin>>> getMapSkinInventory(String setName);

    /**
     * Although a {@code setName} is required for the call, it doesn't really change anything as of {@code 11.02.2025}
     */
    Function<LCUHttpConnector, LCUApiResponse<Inventory<Playbook>>> getPlaybookInventory(String setName);

    //TODO: Find out what [PATCH] /lol-cosmetics/v1/recent/{type} does and returns

    Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedCompanion(Integer itemId);

    /**
     * Removes the current selection and resets the Companion to the Default Companion
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedCompanion();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedDamageSkin(Integer itemId);

    /**
     * Removes the current selection and resets the Damage Skin to the Default Damage Skin
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedDamageSkin();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedMapSkin(Integer itemId);

    /**
     * Removes the current selection and resets the Map Skin to the Default Map Skin
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedMapSkin();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedPlaybook(Integer itemId);

    Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedPlaybook();
}
