package com.julianw03.poroLCU.model.lolChallenges.v1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class ChallengeData {
    @Getter
    public static class ThresholdItem {
        @Getter
        public static class Reward {
            private String asset;
            private String category;
            private String name;
            private int    quantity;

            private Reward() {
            }
        }

        private int          value;
        private List<Reward> rewards;

        private ThresholdItem() {
        }
    }

    @Getter
    public static class FiendLevelEntry {
        private List<Puuid>    friends;
        private ChallengeLevel level;

        private FiendLevelEntry() {
        }
    }

    private ArrayNode                          availableIds;
    private int                                capstoneGroupId;
    private String                             capstoneGroupName;
    private List<Integer>                      childrenIds;
    private ArrayNode                          completedIds;
    private ChallengeLevel                     currentLevel;
    private long                               currentLevelAchievedTime;
    private int                                currentThreshold;
    private int                                currentValue;
    private String                             description;
    private String                             descriptionShort;
    private List<FiendLevelEntry>              friendsAtLevels;
    private ArrayNode                          gameModes;
    private boolean                            hasLeaderboard;
    private String                             iconPath;
    private int                                id;
    private String                             idListType;
    private boolean                            isApex;
    private boolean                            isCapstone;
    private boolean                            isReverseDirection;
    private Map<ChallengeLevel, String>        levelToIconPath;
    private String                             name;
    /**
     * Sadly this field is sometimes empty and therefore leads to a deserialization error, therefore we use a String here
     *
     * @implNote You may use {@link ChallengeLevel#fromString} to convert it to a ChallengeLevel
     */
    private ChallengeLevel                     nextLevel;
    private String                             nextLevelIconPath;
    private int                                nextThreshold;
    private int                                parentId;
    private String                             parentName;
    private double                             percentile;
    private int                                playersInLevel;
    private int                                pointsAwarded;
    private int                                position;
    /**
     * Sadly this field is sometimes empty and therefore leads to a deserialization error, therefore we use a String here
     *
     * @implNote You may use {@link ChallengeLevel#fromString} to convert it to a ChallengeLevel
     */
    private String                             previousLevel;
    private int                                previousValue;
    private int                                priority;
    private long                               retireTimestamp;
    private String                             source;
    private Map<ChallengeLevel, ThresholdItem> thresholds;
    private String                             valueMapping;

    private ChallengeData() {
    }
}
