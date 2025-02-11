package com.julianw03.poroLCU.model.lolCollections.v1;

import com.julianw03.poroLCU.model.shared.Ownership;
import lombok.Getter;

@Getter
public class WardSkin {
    private String    description;
    private Integer   id;
    private String    name;
    private Ownership ownership;
    private String    wardImagePath;
    private String    wardShadowImagePath;

    private WardSkin() {}
}
