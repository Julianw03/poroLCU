package com.julianw03.poroLCU.model.lolChat.v1;

import lombok.Getter;

@Getter
public class FriendCountsObject {
    private Integer numFriends;
    private Integer numFriendsAvailable;
    private Integer numFriendsAway;
    private Integer numFriendsInChampSelect;
    private Integer numFriendsInGame;
    private Integer numFriendsInQueue;
    private Integer numFriendsMobile;
    private Integer numFriendsOnline;

    private FriendCountsObject() {}
}
