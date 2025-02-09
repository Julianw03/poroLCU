package com.julianw03.poroLCU.model.lolChat.v1;

import com.julianw03.poroLCU.model.shared.id.Id;
import com.julianw03.poroLCU.model.shared.iso8601Date.ISO8601Date;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Message {
    @Setter
    private String      body;
    @Setter
    private Id          fromId;
    private SummonerId  fromObfuscatedSummonerId;
    private Id          fromPid;
    @Setter
    private SummonerId  fromSummonerId;
    /**
     * This is a message id
     * Not to be confused with a {@link Puuid} or {@link Id}.
     */
    private String      id;
    @Setter
    private Boolean     isHistorical;
    @Setter
    private ISO8601Date timestamp;
    @Setter
    private String      type;

    public Message() {
    }
}
