package com.julianw03.poroLCU.model.lolChampionMastery.v1;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import lombok.Getter;

import java.util.List;

@Getter
public class ScoutingMastery {
    @Getter
    public static class TopMastery {
        private Integer championId;
        private Integer championLevel;
        private Integer championPoints;

        private TopMastery() {
        }
    }

    @Getter
    public static class TopSeasonChampion {
        private Integer championId;
        private Integer gameCount;
        private Double  kda;
        private Integer winCount;

        private TopSeasonChampion() {
        }
    }

    private Long                    playerId;
    private Puuid                   puuid;
    private List<TopMastery>        topMasteries;
    private List<TopSeasonChampion> topSeasonChampions;
    private Integer                 totalMasteryScore;

    private ScoutingMastery() {
    }
}
