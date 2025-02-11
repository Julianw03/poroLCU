package com.julianw03.poroLCU.model.lolChat.v1;

import com.julianw03.poroLCU.model.shared.id.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitConversationObject {
    private Id     id;
    private String type;

    public InitConversationObject() {
        this.type = "chat";
    }
}
