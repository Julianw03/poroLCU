package com.julianw03.poroLCU.connection.http;

public class LCUApiError {

    private static final LCUApiError DEFAULT = new LCUApiError(
            "UNKNOWN",
            500,
            "An unknown error occurred"
    );

    private String errorCode;
    private int    httpStatus;
    private String message;

    private LCUApiError() {}

    public LCUApiError(String errorCode, int httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public static LCUApiError getDefault() {
        return DEFAULT;
    }
}
