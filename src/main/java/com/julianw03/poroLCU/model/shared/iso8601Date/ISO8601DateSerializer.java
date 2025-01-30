package com.julianw03.poroLCU.model.shared.iso8601Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ISO8601DateSerializer extends JsonSerializer<ISO8601Date> {
    @Override
    public void serialize(ISO8601Date iso8601Date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(iso8601Date.toString());
    }
}
