package com.julianw03.poroLCU.model.shared.accountId;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianw03.poroLCU.Util.Wrapper;

@JsonSerialize(using = AccountIdSerializer.class)
@JsonDeserialize(using = AccountIdDeserializer.class)
public class AccountId extends Wrapper<Long> {
    public AccountId(Long value) {
        super(value);
    }
}
