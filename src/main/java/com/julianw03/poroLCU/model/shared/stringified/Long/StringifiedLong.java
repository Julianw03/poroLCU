package com.julianw03.poroLCU.model.shared.stringified.Long;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianw03.poroLCU.Util.Wrapper;

@JsonSerialize(using = StringifiedLongSerializer.class)
@JsonDeserialize(using = StringifiedLongDeserializer.class)
public class StringifiedLong extends Wrapper<Long> {
    private static Long getValue(String val) {
        try {
            return Long.parseLong(val);
        } catch (Exception e) {
            return null;
        }
    }

    public StringifiedLong(String val) {
        super(getValue(val));
    }
}
