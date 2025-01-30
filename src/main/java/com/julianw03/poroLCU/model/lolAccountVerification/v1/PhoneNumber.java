package com.julianw03.poroLCU.model.lolAccountVerification.v1;

import lombok.Getter;

@Getter
public class PhoneNumber {
    @Getter
    public static class Data {
        @Getter
        public static class PhoneNumberObfuscated {
            private String countryCode;
            private String endsWith;
            private int    length;
        }
    }

    @Getter
    public static class Error {
        private String errorCode;
        private String message;
    }

    private String clientMessageId;
    private Data   data;
    private Error  error;

    private PhoneNumber() {
    }
}
