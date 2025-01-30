package com.julianw03.poroLCU.process;

import com.julianw03.poroLCU.process.os.InsufficientPermissionException;

import java.util.Optional;

public interface InformationAggregator {
    /**
     * This method attempts to find the {@link LeagueClientProcessParameters} of the currently running League Client Process.
     *
     * @return <code>{@link Optional#of}({@link LeagueClientProcessParameters})</code>if the process was found, otherwise an {@link Optional#empty()}
     * @throws InsufficientPermissionException If the process was found, but the Commandline could not (and will not be able to) be read due to insufficient permissions
     * **/
    Optional<LeagueClientProcessParameters> findProcess() throws InsufficientPermissionException;
}
