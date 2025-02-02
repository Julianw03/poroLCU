package com.julianw03.poroLCU;

import com.julianw03.poroLCU.configuration.Configuration;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.Model;
import com.julianw03.poroLCU.model.lolChallenges.v1.ChallengeData;
import com.julianw03.poroLCU.model.lolChallenges.v1.ChallengeLevel;
import com.julianw03.poroLCU.model.lolChallenges.v1.ChallengesV1;
import com.julianw03.poroLCU.state.LCUConnectionState;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class Example {
    public static void main(String[] args) {
        Configuration configuration = new Configuration.Builder()
                .setExitOnError(true)
                .setLogMessages(false)
                .setSearchOnStartup(true)
                .build();
        CoreFacade coreFacade = new Core(configuration);

        ConnectionStateListener simpleListener = state -> {
            if (state != LCUConnectionState.CONNECTED) {
                return;
            }

            Optional<LCUHttpConnector> connector = coreFacade.getHttpConnector();
            if (connector.isEmpty()) {
                return;
            }

            LCUApiResponse<Map<Integer, ChallengeData>> resp = Model.get(ChallengesV1.class).getLocalPlayerChallengeData().apply(connector.get());
            if (resp.isErrorResponse()) {
                System.out.println("Failed to get local player challenge data");
                System.out.println(resp.getErrorResponseBody().getMessage());
                return;
            }

            Map<Integer, ChallengeData> challengeData = resp.getSuccessResponseBody();
            challengeData.values()
                    .stream()
                    .filter(data -> data.getCurrentLevel() == ChallengeLevel.CHALLENGER)
                    .filter(data -> data.getRetireTimestamp() == 0)
                    .sorted(Comparator.comparing(ChallengeData::getPercentile))
                    .limit(5)
                    .forEach(
                            data -> System.out.printf("In the challenge %s, you are in the top %.2f%% of players\n", data.getName(), data.getPercentile())
                    );

            coreFacade.stop();
        };

        coreFacade.addConnectionStateListener(simpleListener);

        coreFacade.start();
        coreFacade.awaitStop();
    }
}
