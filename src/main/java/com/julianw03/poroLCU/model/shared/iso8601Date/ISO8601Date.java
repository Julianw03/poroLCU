package com.julianw03.poroLCU.model.shared.iso8601Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.julianw03.poroLCU.Util.Wrapper;

import java.time.Instant;


@JsonSerialize(using = ISO8601DateSerializer.class)
@JsonDeserialize(using = ISO8601DateDeserializer.class)
public class ISO8601Date extends Wrapper<Instant> {
    public ISO8601Date(Instant instant) {
        super(instant);
    }

    public ISO8601Date(String str) {
        super(Instant.parse(str));
    }
}
