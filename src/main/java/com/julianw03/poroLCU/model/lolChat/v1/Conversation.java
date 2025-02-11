package com.julianw03.poroLCU.model.lolChat.v1;

import com.julianw03.poroLCU.model.shared.id.Id;
import com.julianw03.poroLCU.model.shared.iso8601Date.ISO8601Date;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

@Getter
public class Conversation {

    @Getter
    public static class MucJwtDto {
        private String channelClaim;
        private String domain;
        private String jwt;
        private String targetRegion;

        private MucJwtDto() {
        }
    }

    private String      gameName;
    private String      gameTag;
    private Id          id;
    private String      inviterId;
    private Boolean     isMuted;
    private Message lastMessage;
    private MucJwtDto   mucJwtDto;
    private String      name;
    private String      password;
    private Id          pid;
    private String      targetRegion;
    private String      type;
    private Integer     unreadMessageCount;

    private Conversation() {}
}
