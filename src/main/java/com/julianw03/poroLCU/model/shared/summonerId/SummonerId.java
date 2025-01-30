package com.julianw03.poroLCU.model.shared.summonerId;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianw03.poroLCU.Util.Wrapper;

@JsonSerialize(using = SummonerIdSerializer.class)
@JsonDeserialize(using = SummonerIdDeserializer.class)
public class SummonerId extends Wrapper<Integer> {
    public SummonerId(Integer value) {
        super(value);
    }
}
