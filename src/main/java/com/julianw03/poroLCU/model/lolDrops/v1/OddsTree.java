package com.julianw03.poroLCU.model.lolDrops.v1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OddsTree {
    private List<OddsTree> children;
    private String         nameTraKey;
    private String         nodeId;
    private Double         odds;
    private Integer        priority;
    private Integer        quantity;
    private String         sourceId;
}
