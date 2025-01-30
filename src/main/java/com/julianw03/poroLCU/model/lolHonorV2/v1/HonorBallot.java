package com.julianw03.poroLCU.model.lolHonorV2.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class HonorBallot {
    private long                 gameId;
    private List<EligiblePlayer> eligibleAllies;
    private List<EligiblePlayer> eligibleOpponents;
    private List<HonoredPlayer>  honoredPlayers;
    private Votepool             votePool;


    @Getter
    public static class EligiblePlayer {
        private String     championName;
        private Puuid      puuid;
        private SummonerId summonerId;
        private String     summonerName;
        private String     skinSplashPath;
        private String     gameName;

        private EligiblePlayer() {
        }

    }

    @Getter
    public static class Votepool {
        private int votes;
        private int fromGamePlayed;
        private int fromHighHonor;
        private int fromRecentHonors;
        private int fromRollover;

        private Votepool() {
        }
    }

    @Getter
    public static class HonorConfig {
        @JsonProperty("Enabled")
        private boolean enabled;
        @JsonProperty("SecondsToVote")
        private int     secondsToVote;
        @JsonProperty("HonorVisibilityEnabled")
        private boolean honorVisibilityEnabled;
        @JsonProperty("HonorSuggestionsEnabled")
        private boolean honorSuggestionsEnabled;
        @JsonProperty("honorEndpointsV2Enabled")
        private boolean honorEndpointsV2Enabled;
        @JsonProperty("ceremonyV3Enabled")
        private boolean ceremonyV3Enabled;

        private HonorConfig() {
        }

    }

    @Getter
    @Setter
    public static class HonoredPlayer {
        private HonorType honorType;
        private Puuid     recipientPuuid;

        public HonoredPlayer() {
        }
    }
}
