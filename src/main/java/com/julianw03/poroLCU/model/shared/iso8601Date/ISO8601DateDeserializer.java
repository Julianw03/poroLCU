package com.julianw03.poroLCU.model.shared.iso8601Date;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ISO8601DateDeserializer extends JsonDeserializer<ISO8601Date> {
    @Override
    public ISO8601Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return new ISO8601Date(jsonParser.getText());
    }
}
