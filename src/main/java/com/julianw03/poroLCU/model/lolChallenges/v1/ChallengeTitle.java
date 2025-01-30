package com.julianw03.poroLCU.model.lolChallenges.v1;

import com.julianw03.poroLCU.model.shared.iso8601Date.ISO8601Date;
import lombok.Getter;

import java.util.Map;

@Getter
public class ChallengeTitle {
    @Getter
    public static class ChallengeTitleData {
        private String                      challengeDescription;
        private int                         challengeId;
        private String                      challengeName;
        private ChallengeLevel              level;
        private Map<ChallengeLevel, String> levelToIconPath;

        private ChallengeTitleData() {
        }
    }

    private String             backgroundImagePath;
    private ChallengeTitleData challengeTitleData;
    private String             contentId;
    private String             iconPath;
    private boolean            isPermanentTitle;
    private long               itemId;
    private String             name;
    private ISO8601Date        purchaseDate;
    private String             titleAcquisitionName;
    private String             titleAcquisitionType;
    private String             titleRequirementDescription;

    private ChallengeTitle() {
    }
}
