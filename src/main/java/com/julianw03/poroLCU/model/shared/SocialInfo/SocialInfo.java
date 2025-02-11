package com.julianw03.poroLCU.model.shared.SocialInfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.julianw03.poroLCU.model.shared.Product;
import com.julianw03.poroLCU.model.shared.SocialAvailability;
import com.julianw03.poroLCU.model.shared.accountId.AccountId;
import com.julianw03.poroLCU.model.shared.id.Id;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.stringified.Integer.StringifiedInteger;
import com.julianw03.poroLCU.model.shared.stringified.Long.StringifiedLong;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SocialInfo {
    @Getter
    @Setter
    @JsonDeserialize(using = SocialInfoLolObjectDeserializer.class)
    public static class LolObject {
        private StringifiedInteger bannerIdSelected;
        private String             challengeCrystalLevel;
        private StringifiedInteger challengePoints;
        private String             challengeTokensSelected;
        private StringifiedInteger championId;
        private StringifiedInteger companionId;
        private StringifiedInteger damageSkinId;
        private StringifiedLong    gameId;
        private String             gameMode;
        private String             gameModeType;
        private String             iconOverride;
        private StringifiedLong    initSummoner;
        private String             isObservable;
        private StringifiedInteger legendaryMasteryScore;
        private StringifiedInteger level;
        private StringifiedInteger mapId;
        private String             playerTitleSelected;
        private StringifiedInteger profileIcon;
        private Puuid              puuid;
        private StringifiedInteger queueId;
        private String             rankedPrevSeasonDivision;
        private String             rankedPrevSeasonTier;
        private JsonNode           regalia;
        private String             skinVariant;
        private String             skinName;
        private StringifiedLong    timestamp;

        public LolObject() {
        }
    }

    private AccountId          accountId;
    private SocialAvailability availability;
    private Integer            displayGroupId;
    private String             displayGroupName;
    private String             gameName;
    private String             gameTag;
    private Integer            groupId;
    private String             groupName;
    private Integer            icon;
    private Id                 id;
    private Boolean            isP2PConversationMuted;
    private JsonNode           lastSeenOnlineTimestamp;
    private LolObject          lol;
    private Integer            masteryScore;
    private String             name;
    private String             note;
    private List<SummonerId>   partySummoners;
    private String             patchline;
    private String             platformId;
    private Product            product;
    private String             productName;
    private Puuid              puuid;
    private Boolean            remotePlatform;
    private Boolean            remoteProduct;
    private String             remoteProductBackdropUrl;
    private String             remoteProductIconUrl;
    private String             statusMessage;
    private Integer            summonerIcon;
    private SummonerId         summonerId;
    private Integer            summonerLevel;

    /**
     * Some fields on this might be null due to multiple endpoints returning Partials of this class
     */
    public SocialInfo() {
    }
}
