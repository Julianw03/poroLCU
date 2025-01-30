package com.julianw03.poroLCU.model.shared.puuid;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class PuuidDeserializer extends JsonDeserializer<Puuid> {
    @Override
    public Puuid deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.readValueAs(String.class);
        return new Puuid(value);
    }
}