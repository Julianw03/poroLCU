package com.julianw03.poroLCU.model.shared.stringified.Long;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class StringifiedLongSerializer extends JsonSerializer<StringifiedLong> {

    @Override
    public void serialize(StringifiedLong stringifiedInteger, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(String.valueOf(stringifiedInteger.getValue()));
    }
}
