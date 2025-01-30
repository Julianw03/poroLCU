package com.julianw03.poroLCU.model.shared.summonerId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SummonerIdSerializer extends JsonSerializer<SummonerId> {
    @Override
    public void serialize(SummonerId summonerId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(summonerId.getValue());
    }
}
