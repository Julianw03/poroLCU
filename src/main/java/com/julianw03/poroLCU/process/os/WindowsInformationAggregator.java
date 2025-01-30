package com.julianw03.poroLCU.process.os;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.process.InformationAggregator;
import com.julianw03.poroLCU.process.LeagueClientProcessParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static com.julianw03.poroLCU.process.LeagueClientProcessParameters.createFromWindowsCommandLine;

public class WindowsInformationAggregator implements InformationAggregator {
    private static final Logger logger = LoggerFactory.getLogger(WindowsInformationAggregator.class);

    private static final String KEY_PS_WMI_CLASS = "__CLASS";
    private static final String KEY_PS_WMI_COMMANDLINE = "CommandLine";

    private static final String POWERSHELL_COMMAND = "\"Get-WmiObject -Query \\\"SELECT CommandLine FROM Win32_Process WHERE Name='LeagueClientUx.exe'\\\" | ConvertTo-Json\"";

    @Override
    public Optional<LeagueClientProcessParameters> findProcess() throws InsufficientPermissionException {
        String[] command = {
                "powershell.exe",
                "-Command",
                POWERSHELL_COMMAND
        };

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        logger.debug("Executing command: {}", String.join(" ", command));

        try {
            Process finderProcess = processBuilder.start();
            Optional<ObjectNode> optCommandLine = Utils.inputStreamToString(finderProcess.getInputStream()).flatMap(Utils::parseJson).flatMap(Utils::asObjectNode);
            if (optCommandLine.isEmpty()) {
                logger.warn("Failed to get and parse find process command line output");
                return Optional.empty();
            }

            ObjectNode commandLine = optCommandLine.get();

            if (!Utils.jsonKeysPresent(commandLine, KEY_PS_WMI_CLASS, KEY_PS_WMI_COMMANDLINE)) {
                logger.warn("Failed to find expected keys in find process command line output");
                return Optional.empty();
            }

            JsonNode commandLineElement = commandLine.get(KEY_PS_WMI_COMMANDLINE);
            if (commandLineElement.isNull()) {
                logger.error("Command line is null, insufficient permissions!");
                throw new InsufficientPermissionException("Command line is null, assuming insufficient permissions!");
            }

            String commandLineString = commandLineElement.asText();
            return createFromWindowsCommandLine(commandLineString);
        } catch (Exception e) {
            logger.error("Failed to find LeagueClientUx process", e);
        }

        return Optional.empty();
    }


}
