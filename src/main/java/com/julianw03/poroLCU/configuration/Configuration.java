package com.julianw03.poroLCU.configuration;

import java.time.Duration;

public class Configuration {
    public static class Builder {
        private final Configuration configuration;

        public Builder() {
            configuration = new Configuration();
        }

        public Builder setSearchOnStartup(boolean searchOnStartup) {
            configuration.searchOnStartup = searchOnStartup;
            return this;
        }

        public Builder setExitOnError(boolean exitOnError) {
            configuration.exitOnError = exitOnError;
            return this;
        }

        public Builder setLogMessages(boolean logMessages) {
            configuration.logMessages = logMessages;
            return this;
        }

        public Builder setProcessSearchDelay(Duration processSearchDelay) {
            configuration.processSearchDelay = processSearchDelay;
            return this;
        }

        public Builder setMaximumProcessSearchAttempts(int maximumProcessSearchAttempts) {
            configuration.maximumProcessSearchAttempts = maximumProcessSearchAttempts;
            return this;
        }

        public Builder setLCUConnectionDelay(Duration lcuConnectionDelay) {
            configuration.lcuConnectionDelay = lcuConnectionDelay;
            return this;
        }

        public Builder setMaximumLCUConnectionAttempts(int maximumLCUConnectionAttempts) {
            configuration.maximumLCUConnectionAttempts = maximumLCUConnectionAttempts;
            return this;
        }

        public Configuration build() {
            return configuration;
        }
    }

    public static final boolean  DEFAULT_SEARCH_ON_STARTUP               = true;
    public static final boolean  DEFAULT_EXIT_ON_ERROR                   = true;
    public static final boolean  DEFAULT_LOG_MESSAGES                    = false;
    public static final Duration DEFAULT_PROCESS_SEARCH_DELAY            = Duration.ofSeconds(1);
    public static final int      DEFAULT_MAXIMUM_PROCESS_SEARCH_ATTEMPTS = 10;
    public static final Duration DEFAULT_LCU_CONNECTION_DELAY            = Duration.ofSeconds(1);
    public static final int      DEFAULT_MAXIMUM_LCU_CONNECTION_ATTEMPTS = 10;

    private boolean searchOnStartup;
    private boolean exitOnError;
    private boolean logMessages;

    private Duration processSearchDelay;
    private int      maximumProcessSearchAttempts;

    private Duration lcuConnectionDelay;
    private int      maximumLCUConnectionAttempts;

    public Configuration() {
        searchOnStartup = DEFAULT_SEARCH_ON_STARTUP;
        exitOnError = DEFAULT_EXIT_ON_ERROR;
        logMessages = DEFAULT_LOG_MESSAGES;

        processSearchDelay = DEFAULT_PROCESS_SEARCH_DELAY;
        maximumProcessSearchAttempts = DEFAULT_MAXIMUM_PROCESS_SEARCH_ATTEMPTS;

        lcuConnectionDelay = DEFAULT_LCU_CONNECTION_DELAY;
        maximumLCUConnectionAttempts = DEFAULT_MAXIMUM_LCU_CONNECTION_ATTEMPTS;
    }

    public boolean doSearchOnStartup() {
        return searchOnStartup;
    }

    public boolean doExitOnError() {
        return exitOnError;
    }

    public boolean doLogMessages() {
        return logMessages;
    }

    public Duration getProcessSearchDelay() {
        return processSearchDelay;
    }

    public int getMaximumProcessSearchAttempts() {
        return maximumProcessSearchAttempts;
    }

    public Duration getLcuConnectionDelay() {
        return lcuConnectionDelay;
    }

    public int getMaximumLCUConnectionAttempts() {
        return maximumLCUConnectionAttempts;
    }
}
