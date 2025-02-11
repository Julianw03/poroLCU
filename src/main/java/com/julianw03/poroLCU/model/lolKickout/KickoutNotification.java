package com.julianw03.poroLCU.model.lolKickout;

import lombok.Getter;

@Getter
public class KickoutNotification {
    private String message;

    private KickoutNotification() {}

    public String getMessage() {
        return message;
    }
}
