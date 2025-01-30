package com.julianw03.poroLCU.model.riotclient;

import lombok.Getter;

@Getter
public class SystemInfo {
    @Getter
    public static class OperatingSystem {
        private String edition;
        private String platform;
        private String versionMajor;
        private String versionMinor;
        private String buildNumber;

        public OperatingSystem() {}
    }

    private OperatingSystem operatingSystem;
    private long            physicalMemory;
    private int             physicalProcessorCores;

    public SystemInfo() {}
}
