package com.julianw03.poroLCU.model.lolAccountVerification.v1;

import lombok.Getter;

@Getter
public class VerificationStatus {
    private String  message;
    private int     status;
    private boolean success;

    private VerificationStatus() {}
}
