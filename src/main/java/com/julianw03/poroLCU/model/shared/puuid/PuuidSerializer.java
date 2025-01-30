package com.julianw03.poroLCU.model.shared.puuid;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PuuidSerializer extends JsonSerializer<Puuid> {
    @Override
    public void serialize(Puuid puuid, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(puuid.getValue());
    }
}
