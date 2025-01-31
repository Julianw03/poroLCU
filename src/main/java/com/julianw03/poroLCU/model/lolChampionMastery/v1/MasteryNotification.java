package com.julianw03.poroLCU.model.lolChampionMastery.v1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import lombok.Getter;

import java.util.List;

@Getter
public class MasteryNotification {
    private Integer                         bonusChampionPointsGained;
    private Integer                         championId;
    private Integer                         championLevel;
    private Boolean                         championLevelUp;
    private Integer                         championPointsBeforeGame;
    private Integer                         championPointsGained;
    private Integer                         championPointsGainedIndividualContribution;
    private Integer                         championPointsSinceLastLevelBeforeGame;
    private Integer                         championPointsUntilNextLevelBeforeGame;
    private Integer                         championSeasonMilestone;
    private Boolean                         championSeasonMilestoneUp;
    private Long                            gameId;
    private ArrayNode                       levelUpList;
    private Integer                         mapId;
    private Integer                         markRequiredForNextLevel;
    private ArrayNode                       memberGrades;
    private List<String>                    milestoneGrades;
    private String                          playerGrade;
    private Puuid                           puuid;
    private Integer                         score;
    private ChampionMastery.SeasonMilestone seasonMilestone;
    private Boolean                         tokenEarnedAfterGame;
    private Integer                         tokensEarned;
    private Boolean                         win;

    private MasteryNotification() {}
}
