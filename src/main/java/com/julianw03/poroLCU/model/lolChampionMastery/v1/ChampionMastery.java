package com.julianw03.poroLCU.model.lolChampionMastery.v1;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class ChampionMastery {
    @Getter
    public static class SeasonMilestone {
        @Getter
        public static class RewardConfig {
            private Integer maximumReward;
            private String  rewardValue;

            private RewardConfig() {
            }
        }

        private Boolean              bonus;
        private Map<String, Integer> requireGradeCounts;
        private RewardConfig         rewardConfig;
        private Integer              rewardMarks;

        private SeasonMilestone() {
        }
    }

    private Integer         championId;
    private Integer         championLevel;
    private Integer         championPoints;
    private Integer         championPointsSinceLastLevel;
    private Integer         championPointsUntilNextLevel;
    private Integer         championSeasonMilestone;
    private String          highestGrade;
    private Long            lastPlayTime;
    private Integer         markRequiredForNextLevel;
    private List<String>    milestoneGrades;
    private SeasonMilestone nextSeasonMilestone;
    private Puuid           puuid;
    private Integer         tokensEarned;

    private ChampionMastery() {
    }
}
