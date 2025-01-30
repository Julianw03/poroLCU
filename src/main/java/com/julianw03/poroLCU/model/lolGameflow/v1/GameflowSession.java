package com.julianw03.poroLCU.model.lolGameflow.v1;

import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

import java.util.List;

@Getter
public class GameflowSession {
    private GameClient gameClient;
    private GameData   gameData;
    private GameDodge  gameDodge;
    private String     phase;

    @Getter
    public static class GameClient {
        private String  observerServerIp;
        private int     observerServerPort;
        private boolean running;
        private String  serverIp;
        private int     serverPort;
        private boolean visible;
    }

    @Getter
    public static class GameData {
        private long    gameId;
        private String  gameName;
        private boolean isCustomGame;
        private String  password;
        private List<?> playerChampionSelections;

        private boolean spectatorsAllowed;
        private List<?> teamOne;
        private List<?> teamTwo;
    }

    @Getter
    public static class GameDodge {
        private List<SummonerId> dodgeIds;
        private String           phase;
        private String           state;
    }
}
