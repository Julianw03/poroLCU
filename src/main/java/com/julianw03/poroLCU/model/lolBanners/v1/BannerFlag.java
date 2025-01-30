package com.julianw03.poroLCU.model.lolBanners.v1;

import com.julianw03.poroLCU.model.shared.iso8601Date.ISO8601Date;
import lombok.Getter;

@Getter
public class BannerFlag {
    private ISO8601Date earnedDateIso8601;
    private int         itemId;
    private int         level;
    private int         seasonId;
    private String      theme;

    private BannerFlag() {}
}
