package com.julianw03.poroLCU.model.lolChat.v2;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import lombok.Getter;

@Getter
public class FriendRequest {
    private String  direction;
    private String  gameName;
    private Integer icon;
    /**
     * A string here as it seems to always be "0" to discourage direct usage of an illegal ID
     */
    private String  id;
    private String  name;
    private String  note;
    /**
     * A string here as it seems to always be "" to discourage direct usage of an illegal PID
     */
    private String  pid;
    private Puuid   puuid;
    /**
     * A string here as it seems to always be 0 to discourage direct usage of an illegal summonerId
     */
    private Long    summonerId;
    private String  tagLine;

    private FriendRequest() {}
}
