package com.julianw03.poroLCU.model.riotclient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrashEnvironment {
    private String environment;
    private String userName;
    private String userId;

    private CrashEnvironment() {}
}
