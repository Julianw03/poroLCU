package com.julianw03.poroLCU.model.lolContentTargeting.v1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Getter;

@Getter
public class FilterObject {
    private ArrayNode filters;

    private FilterObject() {}
}
