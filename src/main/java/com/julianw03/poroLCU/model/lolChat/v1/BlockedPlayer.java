package com.julianw03.poroLCU.model.lolChat.v1;

import com.julianw03.poroLCU.model.shared.id.Id;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

@Getter
public class BlockedPlayer {
    private String     gameName;
    private String     gameTag;
    private Integer    icon;
    private Id         id;
    private String     name;
    private Id         pid;
    private Puuid      puuid;
    private SummonerId summonerId;

    private BlockedPlayer() {
    }
}
