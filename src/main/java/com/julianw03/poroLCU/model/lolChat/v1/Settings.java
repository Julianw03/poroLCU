package com.julianw03.poroLCU.model.lolChat.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.julianw03.poroLCU.model.shared.id.Id;
import lombok.Getter;

import java.util.Map;

@Getter
public class Settings {
    @Getter
    public static class ChatWindow {
        private Boolean detached;
        private Integer height;
        private Integer left;
        private Integer top;
        private Integer width;

        private ChatWindow() {
        }
    }

    private Boolean              bounceDockIconEnabled;
    @JsonProperty("chat-status-message")
    private String               chatStatusMessage;
    private Boolean              chatFilterDisabled;
    private Boolean              chatGBG;
    private Boolean              chatGroupMobile;
    private Boolean              chatGroupOffline;
    private ChatWindow           chatWindow;
    private Integer              chatWindowDockedHeight;
    @JsonProperty("closed-conversations")
    private Map<Id, Long>        closedConversations;
    private Boolean              friendRequestToastsDisabled;
    @JsonProperty("hidden-conversations")
    private Map<Id, Long>        hiddenConversations;
    private Boolean              linkClickWarningEnabled;
    private Boolean              messageNotificationsEnabled;
    private Boolean              moreUnreadsEnabled;
    @JsonProperty("muted-conversations")
    private Map<Id, Long>        mutedConversations;
    private Boolean              recentlyPlayedFirstOpen;
    private Boolean              recentlyPlayedOpen;
    @JsonProperty("roster-group-collapsed")
    private Map<String, Boolean> rosterGroupCollapsed;
    private Boolean              showWhenTypingEnabled;
    private String               sortBy;
    private Boolean              usePlayerPreferences;

    private Settings() {}
}
