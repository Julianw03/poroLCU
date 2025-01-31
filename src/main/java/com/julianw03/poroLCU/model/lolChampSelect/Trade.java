package com.julianw03.poroLCU.model.lolChampSelect;

import lombok.Getter;

@Getter
public class Trade {
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

    private Trade() {
    }
}
