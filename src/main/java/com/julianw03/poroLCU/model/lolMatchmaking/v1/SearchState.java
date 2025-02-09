package com.julianw03.poroLCU.model.lolMatchmaking.v1;

import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchState {
    @Getter
    public static class DodgeData {
        private SummonerId dodgerId;
        private String     state;
    }

    @Getter
    public static class Error {
        private String     errorCode;
        private int        id;
        private String     message;
        private SummonerId penalizedSummonerId;
        private double     penaltyTimeRemaining;

        private Error() {}
    }

    @Getter
    public static class LowPriorityData {
        private String           bustedLeaverAccessToken;
        private List<SummonerId> penalizedSummonerIds;
        private double           penaltyTime;
        private double           penaltyTimeRemaining;
        private String           reason;

        private LowPriorityData() {}


    }

    public static class ReadyCheck {
        private List<SummonerId> declinerIds;
        private String           dodgeWarning;
        private String           playerResponse;
        private String           state;
        private boolean          supressUx;
        private int              timer;

        private ReadyCheck() {}

        public List<SummonerId> getDeclinerIds() {
            return declinerIds;
        }

        public String getDodgeWarning() {
            return dodgeWarning;
        }

        public String getPlayerResponse() {
            return playerResponse;
        }

        public String getState() {
            return state;
        }

        public boolean isSupressUx() {
            return supressUx;
        }

        public int getTimer() {
            return timer;
        }
    }

    private DodgeData       dodgeData;
    private List<Error>     errors;
    private double          estimatedQueueTime;
    private boolean         isCurrentlyInQueue;
    private String          lobbyId;
    private LowPriorityData lowPriorityData;
    private int             queueId;
    private ReadyCheck      readyCheck;
    private String          searchState;
    private double          timeInQueue;

    private SearchState() {}
}
