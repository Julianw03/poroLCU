package com.julianw03.poroLCU.model.shared.puuid;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianw03.poroLCU.Util.Wrapper;

@JsonSerialize(using = PuuidSerializer.class)
@JsonDeserialize(using = PuuidDeserializer.class)
public class Puuid extends Wrapper<String> {
    public Puuid(String value) {
        super(value);
    }
}
