package com.julianw03.poroLCU.model.shared.stringified.Integer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianw03.poroLCU.Util.Wrapper;
import org.jetbrains.annotations.NotNull;

@JsonSerialize(using = StringifiedIntegerSerializer.class)
@JsonDeserialize(using = StringifiedIntegerDeserializer.class)
public class StringifiedInteger extends Wrapper<Integer> {
    private static Integer getValue(String val) {
        try {
            return Integer.parseInt(val);
        } catch (Exception e) {
            return null;
        }
    }

    public StringifiedInteger(@NotNull String value) {
        super(getValue(value));
    }
}
