package com.julianw03.poroLCU.model.lolAccountVerification.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivationPinObject {
    private String phoneNumber;
    private String locale;

    public ActivationPinObject() {}
}
