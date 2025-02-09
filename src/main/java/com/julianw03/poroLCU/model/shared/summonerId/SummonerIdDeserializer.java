package com.julianw03.poroLCU.model.shared.summonerId;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SummonerIdDeserializer extends JsonDeserializer<SummonerId> {
    @Override
    public SummonerId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        Long id = jsonParser.getLongValue();
        return new SummonerId(id);
    }
}
