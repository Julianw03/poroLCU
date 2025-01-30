package com.julianw03.poroLCU.model.shared.accountId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class AccountIdDeserializer extends JsonDeserializer<AccountId> {
    @Override
    public AccountId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Long value = jsonParser.getLongValue();
        return new AccountId(value);
    }
}