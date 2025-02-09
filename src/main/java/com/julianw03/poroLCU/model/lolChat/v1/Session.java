package com.julianw03.poroLCU.model.lolChat.v1;

import lombok.Getter;

@Getter
public class Session {
    private Long   sessionExpire;
    private String sessionState;

    private Session() {}
}
