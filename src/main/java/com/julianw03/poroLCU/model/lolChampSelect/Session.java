package com.julianw03.poroLCU.model.lolChampSelect;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

import java.util.List;

@Getter
public class Session {
    @Getter
    public static class Bans {
        private List<Integer> myTeamBans;
        private List<Integer> theirTeamBans;
        private Integer       numBans;
    }

    @Getter
    public static class ChatDetails {
        @Getter
        public static class MucJwtDto {
            private String channelClaim;
            private String domain;
            private String jwt;
            private String targetRegion;

            private MucJwtDto() {
            }
        }

        private MucJwtDto mucJwtDto;
        private String    multiUserChatId;
        private String    multiUserChatPassword;

        private ChatDetails() {
        }
    }

    @Getter
    public static class TeamMember {
        private String     assignedPosition;
        private Integer    cellId;
        private Integer    championId;
        private Integer    championPickIntent;
        private String     nameVisibilityType;
        private Puuid      obfuscatedPuuid;
        private SummonerId obfuscatedSummonerId;
        private Puuid      puuid;
        private Integer    selectedSkinId;
        private Integer    spell1Id;
        private Integer    spell2Id;
        private SummonerId summonerId;
        private Integer    team;
        private Integer    wardSkinId;

        private TeamMember() {
        }
    }

    @Getter
    public static class Timer {
        private long    adjustedTimeLeftInPhase;
        private long    internalNowInEpochMs;
        private boolean isInfinite;
        private String  phase;
        private long    totalTimeInPhase;
    }

    private List<List<Action>> actions;
    private boolean            allowBattleBoost;
    private boolean            allowDuplicatePicks;
    private boolean            allowLockedEvents;
    private boolean            allowRerolling;
    private boolean            allowSkinSelection;
    private Bans               bans;
    private List<Integer>      benchChampions;
    private boolean            benchEnabled;
    private Integer            boostableSkinCount;
    private ChatDetails        chatDetails;
    private Integer            counter;
    private long               gameId;
    private boolean            hasSimultaneousBans;
    private boolean            hasSimultaneousPicks;
    private boolean            isCustomGame;
    private boolean            isSpectating;
    private boolean            localPlayerCellId;
    private Integer            lockedEventIndex;
    private List<TeamMember>   myTeam;
    //private List<PickOrderSwaps> pickOrderSwaps;
    private Integer            recoveryCounter;
    private Integer            rerollsRemaining;
    private Integer            skipChampionSelect;
    private List<TeamMember>   theirTeam;
    private Timer              timer;
    private List<Trade>        trades;

    private Session() {
    }
}
