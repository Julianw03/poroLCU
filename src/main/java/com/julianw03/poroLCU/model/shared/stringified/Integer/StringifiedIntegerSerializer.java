package com.julianw03.poroLCU.model.shared.stringified.Integer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class StringifiedIntegerSerializer extends JsonSerializer<StringifiedInteger> {

    @Override
    public void serialize(StringifiedInteger stringifiedInteger, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(String.valueOf(stringifiedInteger.getValue()));
    }
}
