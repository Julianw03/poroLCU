package com.julianw03.poroLCU.model.lolChat.v2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddFriendRequest {
    private String gameName;
    private String tagLine;

    public AddFriendRequest() {}
}
