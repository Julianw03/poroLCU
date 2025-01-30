package com.julianw03.poroLCU.model.lolChallenges.v1;

import lombok.Getter;

import java.util.List;

@Getter
public class ChallengeSummary {
    @Getter
    public static class CategoryProgress {
        private String         category;
        private int            current;
        private ChallengeLevel level;
        private int            max;
        private double         positionPercentile;

        private CategoryProgress() {
        }
    }

    private long                   apexLadderUpdateTime;
    private long                   apexLeaderboardPosition;
    private String                 bannerId;
    private List<CategoryProgress> categoryProgress;
    private String                 crestId;
    private boolean                isApex;
    private ChallengeLevel         overallChallengeLevel;
    private int                    pointsUntilNextRank;
    private double                 positionPercentile;
    private int                    prestigeCrestBorderLevel;
    /**
     * A string in this format "challengeId,challengeId,challengeId"
     */
    private String                 selectedChallengesString;
    private ChallengeTitle         title;
    private List<ChallengeData>    topChallenges;
    private int                    totalChallengeScore;

    private ChallengeSummary() {
    }
}
