package com.julianw03.poroLCU.model.lolChampSelect.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Action {
    private Integer actorCellId;
    private Integer championId;
    private Boolean completed;
    private Integer id;
    private Boolean isAllyAction;
    private Boolean isInProgress;
    private Integer pickTurn;
    private String  type;

    public Action() {
    }
}
