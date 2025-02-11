package com.julianw03.poroLCU.model.lolChat.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;
import com.julianw03.poroLCU.model.shared.SocialInfo.SocialInfo;
import com.julianw03.poroLCU.model.shared.id.Id;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;
import java.util.function.Function;

public interface ChatV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<List<BlockedPlayer>>> getBlockedPlayers();

    Function<LCUHttpConnector, LCUApiResponse<Void>> blockPlayer(Id id);

    Function<LCUHttpConnector, LCUApiResponse<Void>> unblockPlayer(Id id);

    Function<LCUHttpConnector, LCUApiResponse<BlockedPlayer>> getBlockedPlayer(Id id);

    Function<LCUHttpConnector, LCUApiResponse<ChatConfig>> getConfig();

    Function<LCUHttpConnector, LCUApiResponse<List<Conversation>>> getConversations();

    Function<LCUHttpConnector, LCUApiResponse<Conversation>> initializeConversation(InitConversationObject initObject);

    /**
     * This behaves a bit unintuitive: While it hides the active conversations in the client, it also acts like a delete call
     * for the {@code /active} endpoint
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> hideActiveConversations();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setActiveConversation(ActiveConversationObject activeConversationObject);

    Function<LCUHttpConnector, LCUApiResponse<ActiveConversationObject>> getActiveConversation();

    Function<LCUHttpConnector, LCUApiResponse<Void>> toggleEogChat(Boolean newState);

    Function<LCUHttpConnector, LCUApiResponse<String>> getConversationsNotify();

    Function<LCUHttpConnector, LCUApiResponse<Conversation>> getConversation(Id conversationId);

    Function<LCUHttpConnector, LCUApiResponse<Void>> removeConversation(Id conversationId);

    //TODO: Add put call ? Not done by client

    /**
     * This just deletes the messages for you, others can still read them.
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> deleteMessages(Id conversationId);

    Function<LCUHttpConnector, LCUApiResponse<List<Message>>> getMessages(Id conversationId);

    Function<LCUHttpConnector, LCUApiResponse<Message>> postMessage(Id conversationId, Message message);

    Function<LCUHttpConnector, LCUApiResponse<List<SocialInfo>>> getParticipants(Id conversationId);

    Function<LCUHttpConnector, LCUApiResponse<SocialInfo>> getParticipant(Id conversationId, Id participantId);

    Function<LCUHttpConnector, LCUApiResponse<FriendCountsObject>> getFriendCounts();

    Function<LCUHttpConnector, LCUApiResponse<Boolean>> isFriend(SummonerId summonerId);

    Function<LCUHttpConnector, LCUApiResponse<List<FriendGroup>>> getFriendGroups();

    Function<LCUHttpConnector, LCUApiResponse<Void>> createFriendGroup(FriendGroup group);

    Function<LCUHttpConnector, LCUApiResponse<FriendGroup>> getFriendGroup(Integer id);

    Function<LCUHttpConnector, LCUApiResponse<Void>> updateFriendGroup(Integer id, FriendGroup group);

    Function<LCUHttpConnector, LCUApiResponse<Void>> deleteFriend(Id friendId);

    Function<LCUHttpConnector, LCUApiResponse<SocialInfo>> getFriend(Id friendId);

    Function<LCUHttpConnector, LCUApiResponse<Void>> updateFriend(Id friendId, SocialInfo updatedInfo);

    Function<LCUHttpConnector, LCUApiResponse<SocialInfo>> getMe();

    Function<LCUHttpConnector, LCUApiResponse<Void>> updateMe(SocialInfo info);

    //TODO: Player mutes

    Function<LCUHttpConnector, LCUApiResponse<Resources>> getResources();

    Function<LCUHttpConnector, LCUApiResponse<Session>> getSession();

    Function<LCUHttpConnector, LCUApiResponse<Settings>> getSettings();

    Function<LCUHttpConnector, LCUApiResponse<Void>> updateSettings(Settings settings);

    //TODO: System mutes
}
