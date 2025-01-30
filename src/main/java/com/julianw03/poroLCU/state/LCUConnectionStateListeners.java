package com.julianw03.poroLCU.state;

import com.julianw03.poroLCU.connection.http.LCUConnector;
import com.julianw03.poroLCU.process.LeagueClientProcessParameters;

public interface LCUConnectionStateListeners {
    void onDisconnected();
    void onAwaitingLeagueProcess();
    void onAwaitingLCURestReady(LeagueClientProcessParameters testingParameters);
    void onAwaitingLCUPluginsReady(LCUConnector connector);
    void onAwaitingLCUWebSocketReady(LCUConnector connector);
    void onConnected(LCUConnector connector);
}
