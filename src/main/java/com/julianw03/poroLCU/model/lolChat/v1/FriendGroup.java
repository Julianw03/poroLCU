package com.julianw03.poroLCU.model.lolChat.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendGroup {
    private Boolean collapsed;
    private Integer id;
    private Boolean isLocalized;
    private Boolean isMetaGroup;
    private String  name;
    private Integer priority;

    public FriendGroup() {}
}
