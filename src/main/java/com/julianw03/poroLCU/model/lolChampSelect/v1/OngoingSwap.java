package com.julianw03.poroLCU.model.lolChampSelect.v1;

import lombok.Getter;

@Getter
public class OngoingSwap {
    private Integer    id;
    private Boolean    initiatedByLocalPlayer;
    private Integer    otherSummonerIndex;
    private Integer    requestorIndex;
    private Integer    responderIndex;
    private Swap.State state;

    private OngoingSwap() {}
}
