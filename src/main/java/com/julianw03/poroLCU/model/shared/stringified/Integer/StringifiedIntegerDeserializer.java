package com.julianw03.poroLCU.model.shared.stringified.Integer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class StringifiedIntegerDeserializer extends JsonDeserializer<StringifiedInteger> {
    @Override
    public StringifiedInteger deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getText();
        return new StringifiedInteger(value);
    }
}
