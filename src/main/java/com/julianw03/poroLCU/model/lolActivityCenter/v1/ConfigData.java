package com.julianw03.poroLCU.model.lolActivityCenter.v1;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import lombok.Getter;

@Getter
public class ConfigData {
    private boolean clientNavEnabled;
    private boolean enabled;
    private String  locale;
    private String  publishingLocale;
    private Puuid   puuid;
    private String  region;
    private String  rsoPlatformId;
    private String  SessionId;
    private String  webLocale;
    private String  webRegion;

    private ConfigData() {}
}
