package com.julianw03.poroLCU.model.lolCosmetics.v1;

import com.julianw03.poroLCU.model.shared.iso8601Date.ISO8601Date;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Item {
    protected UUID        contentId;
    protected String      description;
    protected Boolean     f2p;
    protected Boolean     favorited;
    protected String      groupId;
    protected Boolean     isRecentItem;
    protected Integer     itemId;
    protected String      loadoutsIcon;
    protected Boolean     loyality;
    protected String      name;
    protected Boolean     owned;
    protected ISO8601Date purchaseDate;
    protected Integer     rarityValue;
    protected Boolean     selected;

    protected Item() {
    }
}
