package com.julianw03.poroLCU.connection;

import com.julianw03.poroLCU.process.LeagueClientProcessParameters;
import com.julianw03.poroLCU.state.LCUConnectionState;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public interface ConnectionService {
    LeagueClientProcessParameters getParameters();

    LCUConnectionState getCurrentConnectionState();

    CompletableFuture<LeagueClientProcessParameters> onReady();

    CompletableFuture<Void> onDisconnection();

    void connect();
}
