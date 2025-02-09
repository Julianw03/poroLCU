package com.julianw03.poroLCU.model.lolChat.v1.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolChat.v1.*;
import com.julianw03.poroLCU.model.shared.SocialInfo.SocialInfo;
import com.julianw03.poroLCU.model.shared.id.Id;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;
import java.util.function.Function;

public class ChatV1Impl implements ChatV1 {

    private static final String BASE_PATH = "/lol-chat/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<BlockedPlayer>>> getBlockedPlayers() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/blocked-players",
                        null
                ), new TypeReference<List<BlockedPlayer>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> blockPlayer(Id id) {
        final ObjectNode request = new ObjectMapper().createObjectNode();
        request.put("id", id.getValue());
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/blocked-players",
                        request
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> unblockPlayer(Id id) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/blocked-players/" + id.getValue(),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<BlockedPlayer>> getBlockedPlayer(Id id) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/blocked-players/" + id.getValue(),
                        null
                ), BlockedPlayer.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ChatConfig>> getConfig() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/config",
                        null
                ), ChatConfig.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Conversation>>> getConversations() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/conversations",
                        null
                ), new TypeReference<List<Conversation>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Conversation>> initializeConversation(InitConversationObject initObject) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/conversations",
                        initObject
                ), Conversation.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> hideActiveConversations() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/conversations/active",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setActiveConversation(ActiveConversationObject activeConversationObject) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        BASE_PATH + "/conversations/active",
                        activeConversationObject
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<ActiveConversationObject>> getActiveConversation() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/conversations/active",
                        null
                ), ActiveConversationObject.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> toggleEogChat(Boolean newState) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/conversations/eog-chat-toggle",
                        newState
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getConversationsNotify() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/conversations/notify",
                        null
                ), String.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Conversation>> getConversation(Id conversationId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/conversations/" + conversationId.getValue(),
                        null
                ), Conversation.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> removeConversation(Id conversationId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/conversations/" + conversationId.getValue(),
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> deleteMessages(Id conversationId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/conversations/" + conversationId.getValue() + "/messages",
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<Message>>> getMessages(Id conversationId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/conversations/" + conversationId.getValue() + "/messages",
                        null
                ), new TypeReference<List<Message>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Message>> postMessage(Id conversationId, Message message) {
         return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/conversations/" + conversationId.getValue() + "/messages",
                        message
                ), Message.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<SocialInfo>>> getParticipants(Id conversationId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/conversations/" + conversationId.getValue() + "/participants",
                        null
                ), new TypeReference<List<SocialInfo>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SocialInfo>> getParticipant(Id conversationId, Id participantId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/conversations/" + conversationId.getValue() + "/participants/" + participantId,
                        null
                ), SocialInfo.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FriendCountsObject>> getFriendCounts() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friend-counts",
                        null
                ), FriendCountsObject.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Boolean>> isFriend(SummonerId summonerId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friend-exists/" + summonerId.getValue(),
                        null
                ), Boolean.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<List<FriendGroup>>> getFriendGroups() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friend-groups",
                        null
                ), new TypeReference<List<FriendGroup>>() {}
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> createFriendGroup(FriendGroup group) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friend-groups",
                        group
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<FriendGroup>> getFriendGroup(Integer id) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friend-groups/" + id,
                        null
                ), FriendGroup.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> updateFriendGroup(Integer id, FriendGroup group) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friend-groups/" + id,
                        group
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> deleteFriend(Id friendId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        BASE_PATH + "/friends/" + friendId,
                        null
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SocialInfo>> getFriend(Id friendId) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friends/" + friendId,
                        null
                ), SocialInfo.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> updateFriend(Id friendId, SocialInfo updatedInfo) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/friends/" + friendId,
                        updatedInfo
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SocialInfo>> getMe() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/me",
                        null
                ), SocialInfo.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> updateMe(SocialInfo info) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        BASE_PATH + "/me",
                        info
                ), Void.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Resources>> getResources() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/resources",
                        null
                ), Resources.class
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
    public Function<LCUHttpConnector, LCUApiResponse<Settings>> getSettings() {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/settings",
                        null
                ), Settings.class
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> updateSettings(Settings settings) {
        return lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        BASE_PATH + "/settings",
                        settings
                ), Void.class
        );
    }
}
