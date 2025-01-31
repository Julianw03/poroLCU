package com.julianw03.poroLCU.model.lolChampionMastery.v1;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class MasterySet {
    @Getter
    public static class ChampionSet {
        private List<Integer> champions;
        private Boolean       completed;
        private Integer       totalMilestone;

        private ChampionSet() {
        }
    }

    @Getter
    public static class ChampionSetReward {
        private String  id;
        private String  type;
        private Integer value;

        private ChampionSetReward() {
        }
    }

    @Getter
    public static class CustomReward {
        private Integer level;
        private Integer quantity;
        private String  rewardValue;
        private String  type;

        private CustomReward() {
        }
    }

    private Map<Integer, Integer>                         championCountByMilestone;
    private List<ChampionMastery>                         championMasteries;
    private ChampionSet                                   championSet;
    private Map<Integer, ChampionSetReward>               championSetRewards;
    private List<CustomReward>                            customRewards;
    private ChampionMastery                               defaultChampionMastery;
    private Map<Integer, ChampionMastery.SeasonMilestone> seasonMilestoneRequireAndRewards;
    private Integer                                       totalScore;
}
