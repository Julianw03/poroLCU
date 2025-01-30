package com.julianw03.poroLCU.model.shared.id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianw03.poroLCU.Util.Wrapper;

@JsonSerialize(using = IdSerializer.class)
@JsonDeserialize(using = IdDeserializer.class)
public class Id extends Wrapper<String> {
    public Id(String value) {
        super(value);
    }
}
