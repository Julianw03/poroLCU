package com.julianw03.poroLCU.model.lolCosmetics.v1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Playbook {
    @Getter
    @NoArgsConstructor
    public static class Augment {
        private String name;
        private String description;
        private String iconPath;
    }

    private String        name;
    private Integer       itemId;
    private UUID          contentId;
    private UUID          capTypeId;
    private UUID          offerId;
    private UUID          alternateOfferId;
    private String        translatedName;
    private String        translatedDescription;
    private List<Augment> earlyAugments;
    private List<Augment> midAugments;
    private List<Augment> lateAugments;
    private boolean       enabled;
    private String        iconPath;
    private String        iconPathSmall;
    private String        splashPath;
    private Boolean       isDisabledInDoubleUp;
}