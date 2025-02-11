package com.julianw03.poroLCU.model.lolDrops.v1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class OddsElement {
    private UUID   contentId;
    private UUID   nodeId;
    private Double odds;
    private UUID   sourceId;
}
