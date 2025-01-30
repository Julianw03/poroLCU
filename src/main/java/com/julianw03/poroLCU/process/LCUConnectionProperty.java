package com.julianw03.poroLCU.process;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LCUConnectionProperty<T> {

    protected final Pattern              pattern;
    protected final Function<Matcher, T> parser;

    public LCUConnectionProperty(
            String regex,
            Function<Matcher, T> parser
    ) {
        this(Pattern.compile(regex), parser);
    }

    public LCUConnectionProperty(
            Pattern pattern,
            Function<Matcher, T> parser
    ) {
        this.pattern = pattern;
        this.parser = parser;
    }

    public T extract(String data) {
        Matcher matcher = pattern.matcher(data);
        if (!matcher.find()) {
            return null;
        }
        try {
            return parser.apply(matcher);
        } catch (Exception ignored) {}
        return null;
    }
}