package com.julianw03.poroLCU.model.lolChampSelect.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolChampSelect.v1.*;

import java.util.List;
import java.util.function.Function;

public class ChampSelectV1Impl implements ChampSelectV1 {

    private static final String BASE_PATH = "/lol-champ-select/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<GridChampion>>> getAllGridChampions() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/all-grid-champions",
                        null
                ), new TypeReference<List<GridChampion>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Integer>>> getBannableChampionIds() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/bannable-champion-ids",
                        null
                ), new TypeReference<List<Integer>>() {})
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> launchBattleTraining() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/battle-training/launch",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Integer>> getCurrentChampionId() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/current-champion",
                        null
                ), Integer.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Integer>>> getDisabledChampionIds() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/disabled-champion-ids",
                        null
                ), new TypeReference<List<Integer>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<GridChampion>> getGridChampionById(Integer id) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/grid-champions/" + id,
                        null
                ), GridChampion.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<MutedPlayer>>> getMutedPlayers() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/muted-players",
                        null
                ), new TypeReference<List<MutedPlayer>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Swap>> getOngoingSwaps() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/ongoing-swap",
                        null
                ), Swap.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> clearOngoingSwap(Integer id) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/ongoing-swap/" + id + "/clear",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Trade>> getOngoingTrade() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/ongoing-trade",
                        null
                ), Trade.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> clearOngoingTrade(Integer id) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/ongoing-trade/" + id + "/clear",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Integer>> getPickableChampionIds() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/pickable-champion-ids",
                        null
                ), Integer.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Integer>> getPickableSkinIds() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/pickable-skin-ids",
                        null
                ), Integer.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<PinDropNotification>> getPinDropNotification() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/pin-drop-notification",
                        null
                ), PinDropNotification.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<?>> getLastGameDTO() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/last-game-dto",
                        null
                ), JsonNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Session>> getSession() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/session",
                        null
                ), Session.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<?>> updateAction(Action action) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PATCH,
                        BASE_PATH + "/session/actions/" + action.getId(),
                        action
                ), JsonNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<?>> completeAction(Integer actionId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/actions/" + actionId + "/complete",
                        null
                ), JsonNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> swapToBenchChampion(Integer championId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/bench/swap/" + championId,
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Session.TeamMember>> getMySelection() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/session/my-selection",
                        null
                ), Session.TeamMember.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<?>> updateMySelection(MySelection mySelection) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PATCH,
                        BASE_PATH + "/session/my-selection",
                        mySelection
                ), JsonNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> rerollSelection() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/my-selection/reroll",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getSimpleInventory() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/simple-inventory",
                        null
                ), String.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Swap>>> getPickOrderSwaps() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/session/swaps",
                        null
                ), new TypeReference<List<Swap>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Swap>> getPickOrderSwap(Integer swapId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/session/swaps/" + swapId,
                        null
                ), Swap.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> acceptPickOrderSwap(Integer swapId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/swaps/" + swapId + "/accept",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> cancelPickOrderSwap(Integer swapId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/swaps/" + swapId + "/cancel",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> declinePickOrderSwap(Integer swapId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/swaps/" + swapId + "/decline",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> requestPickOrderSwap(Integer swapId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/swaps/" + swapId + "/request",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Session.Timer>> getTimer() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/session/timer",
                        null
                ), Session.Timer.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Trade>>> getTradeRequests() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/session/trades",
                        null
                ), new TypeReference<List<Trade>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Trade>> getTradeRequest(Integer tradeId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/session/trades/" + tradeId,
                        null
                ), Trade.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> acceptTradeRequest(Integer tradeId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/trades/" + tradeId + "/accept",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> cancelTradeRequest(Integer tradeId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/trades/" + tradeId + "/cancel",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> declineTradeRequest(Integer tradeId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/trades/" + tradeId + "/decline",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> requestTradeRequest(Integer tradeId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/session/trades/" + tradeId + "/request",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ArrayNode>> getSFXNotifications() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/sfx-notifications",
                        null
                ), ArrayNode.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<SkinCarouselItem>>> getSkinCarouselSkins() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/skin-carousel-skins",
                        null
                ), new TypeReference<List<SkinCarouselItem>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SkinSelectorInfo>> getSkinSelectorInfo() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/skin-selector-info",
                        null
                ), SkinSelectorInfo.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SlotSummoner>> getSummoner(Integer slotId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/summoners/" + slotId,
                        null
                ), SlotSummoner.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<TeamBoost>> getTeamBoost() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/team-boost",
                        null
                ), TeamBoost.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> buyTeamBoost() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/team-boost/purchase",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> togglePositionFavorite(Integer championId, Position position) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/toggle-favorite/" + championId + "/" + position.getFavoriteId(),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> togglePlayerMuted(MutedPlayer player) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/toggle-player-muted",
                        player
                ), Void.class
        );
    }
}
