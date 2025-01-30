package com.julianw03.poroLCU.model.deepLinks.v1;

import lombok.Getter;

@Getter
public class DeepLinkSettings {
    private String  externalClientScheme;
    private boolean isSchemeReady;
    private boolean launchLorEnabled;
    private String  launchLorUrl;

    private DeepLinkSettings() {}
}
