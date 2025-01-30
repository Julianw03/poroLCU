package com.julianw03.poroLCU.model.riotclient;

import lombok.Getter;

@Getter
public class RegionLocale {
    private String region;
    private String locale;
    private String webRegion;
    private String webLanguage;

    private RegionLocale() {}
}
