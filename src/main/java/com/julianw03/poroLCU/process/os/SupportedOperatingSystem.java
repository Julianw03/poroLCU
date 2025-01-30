package com.julianw03.poroLCU.process.os;

import com.julianw03.poroLCU.process.InformationAggregator;

import java.util.Optional;
import java.util.function.Function;

public enum SupportedOperatingSystem {
    WINDOWS("Windows",
            new WindowsInformationAggregator(),
            osName -> osName.toLowerCase().contains("windows")
    ),
    MAC_OS("Mac OS",
            new DarwinInformationAggregator(),
            osName -> {
                final String osNameLower = osName.toLowerCase();
                return osNameLower.contains("mac") || osNameLower.contains("darwin");
            }
    );

    SupportedOperatingSystem(String displayName, InformationAggregator aggregator, Function<String, Boolean> osNameMatcher) {
        this.displayName = displayName;
        this.aggregator = aggregator;
        this.osNameMatcher = osNameMatcher;
    }

    private final String                displayName;
    private final InformationAggregator aggregator;
    private final Function<String, Boolean> osNameMatcher;

    public static Optional<SupportedOperatingSystem> fromCurrentOS() {
        String osName = System.getProperty("os.name");
        for (SupportedOperatingSystem os : values()) {
            if (os.osNameMatcher.apply(osName)) {
                return Optional.of(os);
            }
        }
        return Optional.empty();
    }

    public String getDisplayName() {
        return displayName;
    }

    public InformationAggregator getAggregator() {
        return aggregator;
    }

    public Function<String, Boolean> getOsNameMatcher() {
        return osNameMatcher;
    }
}
