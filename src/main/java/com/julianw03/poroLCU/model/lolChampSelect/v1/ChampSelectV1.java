package com.julianw03.poroLCU.model.lolChampSelect.v1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.List;
import java.util.function.Function;

public interface ChampSelectV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<List<GridChampion>>> getAllGridChampions();

    Function<LCUHttpConnector, LCUApiResponse<List<Integer>>> getBannableChampionIds();

    Function<LCUHttpConnector, LCUApiResponse<Void>> launchBattleTraining();

    Function<LCUHttpConnector, LCUApiResponse<Integer>> getCurrentChampionId();

    Function<LCUHttpConnector, LCUApiResponse<List<Integer>>> getDisabledChampionIds();

    Function<LCUHttpConnector, LCUApiResponse<GridChampion>> getGridChampionById(Integer id);

    Function<LCUHttpConnector, LCUApiResponse<List<MutedPlayer>>> getMutedPlayers();

    Function<LCUHttpConnector, LCUApiResponse<Swap>> getOngoingSwaps();

    Function<LCUHttpConnector, LCUApiResponse<Void>> clearOngoingSwap(Integer id);

    Function<LCUHttpConnector, LCUApiResponse<Trade>> getOngoingTrade();

    Function<LCUHttpConnector, LCUApiResponse<Void>> clearOngoingTrade(Integer id);

    Function<LCUHttpConnector, LCUApiResponse<Integer>> getPickableChampionIds();

    Function<LCUHttpConnector, LCUApiResponse<Integer>> getPickableSkinIds();

    Function<LCUHttpConnector, LCUApiResponse<PinDropNotification>> getPinDropNotification();

    Function<LCUHttpConnector, LCUApiResponse<?>> getLastGameDTO();

    Function<LCUHttpConnector, LCUApiResponse<Session>> getSession();

    Function<LCUHttpConnector, LCUApiResponse<?>> updateAction(Action action);

    Function<LCUHttpConnector, LCUApiResponse<?>> completeAction(Integer actionId);

    Function<LCUHttpConnector, LCUApiResponse<Void>> swapToBenchChampion(Integer championId);

    Function<LCUHttpConnector, LCUApiResponse<Session.TeamMember>> getMySelection();

    Function<LCUHttpConnector, LCUApiResponse<?>> updateMySelection(MySelection mySelection);

    Function<LCUHttpConnector, LCUApiResponse<Void>> rerollSelection();

    Function<LCUHttpConnector, LCUApiResponse<String>> getSimpleInventory();

    Function<LCUHttpConnector, LCUApiResponse<List<Swap>>> getPickOrderSwaps();

    Function<LCUHttpConnector, LCUApiResponse<Swap>> getPickOrderSwap(Integer swapId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> acceptPickOrderSwap(Integer swapId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> cancelPickOrderSwap(Integer swapId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> declinePickOrderSwap(Integer swapId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> requestPickOrderSwap(Integer swapId);

    Function<LCUHttpConnector, LCUApiResponse<Session.Timer>> getTimer();

    Function<LCUHttpConnector, LCUApiResponse<List<Trade>>> getTradeRequests();

    Function<LCUHttpConnector, LCUApiResponse<Trade>> getTradeRequest(Integer tradeId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> acceptTradeRequest(Integer tradeId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> cancelTradeRequest(Integer tradeId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> declineTradeRequest(Integer tradeId);

    //TODO: Check if return type is correct
    Function<LCUHttpConnector, LCUApiResponse<Void>> requestTradeRequest(Integer tradeId);

    Function<LCUHttpConnector, LCUApiResponse<ArrayNode>> getSFXNotifications();

    Function<LCUHttpConnector, LCUApiResponse<List<SkinCarouselItem>>> getSkinCarouselSkins();

    Function<LCUHttpConnector, LCUApiResponse<SkinSelectorInfo>> getSkinSelectorInfo();

    Function<LCUHttpConnector, LCUApiResponse<SlotSummoner>> getSummoner(Integer slotId);

    Function<LCUHttpConnector, LCUApiResponse<TeamBoost>> getTeamBoost();

    Function<LCUHttpConnector, LCUApiResponse<Void>> buyTeamBoost();

    Function<LCUHttpConnector, LCUApiResponse<Void>> togglePositionFavorite(Integer championId, Position position);

    Function<LCUHttpConnector, LCUApiResponse<Void>> togglePlayerMuted(MutedPlayer player);
}
