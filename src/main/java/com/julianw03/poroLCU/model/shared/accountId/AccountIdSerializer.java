package com.julianw03.poroLCU.model.shared.accountId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AccountIdSerializer extends JsonSerializer<AccountId> {
    @Override
    public void serialize(AccountId accountId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(accountId.getValue());
    }
}
