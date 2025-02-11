package com.julianw03.poroLCU.connection;

import com.julianw03.poroLCU.process.LeagueClientProcessParameters;
import com.julianw03.poroLCU.state.LCUConnectionState;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ConnectionService test = new ConnectionService() {

            private CompletableFuture<LeagueClientProcessParameters> onConnectFuture    = new CompletableFuture<>();
            private CompletableFuture<Void>                          onDisconnectFuture = new CompletableFuture<>();

            private void onDisconnect() {
                CompletableFuture<Void> prev = this.onDisconnectFuture;
                this.onDisconnectFuture = new CompletableFuture<>();
                prev.complete(null);
            }

            private void onConnect(LeagueClientProcessParameters params) {
                CompletableFuture<LeagueClientProcessParameters> prev = this.onConnectFuture;
                this.onConnectFuture = new CompletableFuture<>();
                prev.complete(params);
            }

            @Override
            public LeagueClientProcessParameters getParameters() {
                return null;
            }

            @Override
            public LCUConnectionState getCurrentConnectionState() {
                return null;
            }

            @Override
            public CompletableFuture<LeagueClientProcessParameters> onReady() {
                return onConnectFuture;
            }

            @Override
            public CompletableFuture<Void> onDisconnection() {
                return onDisconnectFuture;
            }

            @Override
            public void connect() {
                new Thread(() -> {
                    CompletableFuture<LeagueClientProcessParameters> connect = this.onReady();
                    onConnect(new LeagueClientProcessParameters(1234, "Test"));
                    CompletableFuture<LeagueClientProcessParameters> newShit = this.onReady();
                    System.out.println(connect);
                    System.out.println(newShit);
                }).start();
            }
        };

        test.connect();
        new CompletableFuture<Void>().orTimeout(5, TimeUnit.SECONDS).join();
    }
}
