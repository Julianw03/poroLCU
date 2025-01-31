package com.julianw03.poroLCU.model.lolChampSelect.v1;

import lombok.Getter;

@Getter
public class Swap {
    @Getter
    public enum State {
        AVAILABLE,
        SENT,
        RECEIVED,
        INVALID;

        State() {
        }
    }

    private Integer cellId;
    private Integer id;
    private State   state;
}
