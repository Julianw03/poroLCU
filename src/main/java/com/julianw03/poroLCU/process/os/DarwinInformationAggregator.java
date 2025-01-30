package com.julianw03.poroLCU.process.os;

import com.julianw03.poroLCU.process.InformationAggregator;
import com.julianw03.poroLCU.process.LeagueClientProcessParameters;

import java.util.Optional;

public class DarwinInformationAggregator implements InformationAggregator {

    @Override
    public Optional<LeagueClientProcessParameters> findProcess() throws InsufficientPermissionException {
        return ProcessHandle.allProcesses()
                .map(
                        processHandle -> processHandle.info().commandLine()
                )
                .filter(
                        commandline -> commandline.map(
                                commandLine -> commandLine.contains("LeagueClientUx")).orElse(false)
                ).map(
                        commandLine -> commandLine.flatMap(LeagueClientProcessParameters::createFromWindowsCommandLine)
                ).filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

    }
}
