package com.julianw03.poroLCU;

public enum ExitReason {
    NO_PROCESS_INFORMATION_AGGREGATOR_FOUND(404, "No League Client Information Aggregator found for your operating system."),
    INSUFFICIENT_PERMISSIONS(403, "Insufficient permissions to access the League Client and its command line arguments."),;

    private final int exitCode;
    private final String message;

    ExitReason(int exitCode, String message) {
        this.exitCode = exitCode;
        this.message = message;
    }

    public int getExitCode() {
        return exitCode;
    }

    public String getMessage() {
        return message;
    }
}
