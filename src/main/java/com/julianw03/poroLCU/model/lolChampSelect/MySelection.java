package com.julianw03.poroLCU.model.lolChampSelect;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MySelection {
    private Integer selectedSkinId;
    private Integer spell1Id;
    private Integer spell2Id;
    private Integer wardSkinId;

    public MySelection() {
    }
}
