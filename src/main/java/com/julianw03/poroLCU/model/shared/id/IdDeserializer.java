package com.julianw03.poroLCU.model.shared.id;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IdDeserializer extends JsonDeserializer<Id> {
    @Override
    public Id deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        return new Id(value);
    }
}
