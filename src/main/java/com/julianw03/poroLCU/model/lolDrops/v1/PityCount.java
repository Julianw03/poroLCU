package com.julianw03.poroLCU.model.lolDrops.v1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class PityCount {
    private Integer count;
    private UUID    dropTableId;
}
