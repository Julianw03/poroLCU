package com.julianw03.poroLCU.model.lolCosmetics.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolCosmetics.v1.*;

import java.util.function.Function;

public class CosmeticsV1Impl implements CosmeticsV1 {

    private static final String BASE_PATH = "/lol-cosmetics/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> addFavourite(String cosmeticType, String contentId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        Utils.createPath(BASE_PATH, "favorites", "tft", cosmeticType, contentId),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> removeFavourite(String cosmeticType, String contentId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        Utils.createPath(BASE_PATH, "favorites", "tft", cosmeticType, contentId),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Favourites<Companion>>> getFavouriteCompanions() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "favorites", "tft", "companions"),
                        null
                ), new TypeReference<Favourites<Companion>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Favourites<DamageSkin>>> getFavouriteDamageSkins() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "favorites", "tft", "damage-skins"),
                        null
                ), new TypeReference<Favourites<DamageSkin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Favourites<MapSkin>>> getFavouriteMapSkins() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "favorites", "tft", "map-skins"),
                        null
                ), new TypeReference<Favourites<MapSkin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedChampion(Integer itemId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "selection", "companion"),
                        itemId
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Inventory<Companion>>> getCompanionInventory(String setName) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", setName, "companions"),
                        null
                ), new TypeReference<Inventory<Companion>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Inventory<DamageSkin>>> getDamageSkinInventory(String setName) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", setName, "damage-skins"),
                        null
                ), new TypeReference<Inventory<DamageSkin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Inventory<MapSkin>>> getMapSkinInventory(String setName) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", setName, "map-skins"),
                        null
                ), new TypeReference<Inventory<MapSkin>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Inventory<Playbook>>> getPlaybookInventory(String setName) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "inventories", setName, "playbooks"),
                        null
                ), new TypeReference<Inventory<Playbook>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedCompanion(Integer itemId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "selection", "companion"),
                        itemId
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedCompanion() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        Utils.createPath(BASE_PATH, "selection", "companion"),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedDamageSkin(Integer itemId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        Utils.createPath(BASE_PATH, "selection", "tft-damage-skin"),
                        itemId
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedDamageSkin() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        Utils.createPath(BASE_PATH, "selection", "tft-damage-skin"),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedMapSkin(Integer itemId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        Utils.createPath(BASE_PATH, "selection", "tft-map-skin"),
                        itemId
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedMapSkin() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        Utils.createPath(BASE_PATH, "selection", "tft-map-skin"),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setSelectedPlaybook(Integer itemId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        Utils.createPath(BASE_PATH, "selection", "playbook"),
                        itemId
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> resetSelectedPlaybook() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        Utils.createPath(BASE_PATH, "selection", "playbook"),
                        null
                ), Void.class
        );
    }
}
