package com.julianw03.poroLCU.model.lolChat.v1;

import lombok.Getter;

import java.util.Map;

@Getter
public class ChatConfig {
    @Getter
    public static class ChatDomain {
        private String ChampSelectDomainName;
        private String ClubDomainName;
        private String CustomGameDomainName;
        private String P2PDomainName;
        private String PostGameDomainName;

        private ChatDomain() {
        }
    }

    @Getter
    public static class LcuSocial {
        private Boolean AggressiveScanning;
        private Boolean ForceChatFilter;
        private Integer QueueJobGraceSeconds;
        private Boolean ReplaceRichMessages;
        private Boolean SilenceChatWhileInGame;
        private Boolean allowGroupByGame;
        private Boolean gameNameTaglineEnabled;

        private LcuSocial() {}
    }

    private ChatDomain          ChatDomain;
    private LcuSocial           LcuSocial;
    private Map<String, String> platformToRegionMap;

    private ChatConfig() {
    }
}
