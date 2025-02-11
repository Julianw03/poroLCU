package com.julianw03.poroLCU.Util;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Just a simple wrapper class to wrap a value.
 * Used to give a value a specific type so that the API is more clear.
 *
 * @param <T> The type of the value to wrap.
 *
 * @implNote {@link Wrapper#hashCode()} uses {@link T#hashCode()}, so that {@code Wrapper<T>} and {@code T} have the same hash code.
 * @implNote {@link Wrapper#equals(Object)} used {@link T#equals(Object)}, so that two {@code Wrapper<T>} objects are equal if their values are equal. A wrapper does not equal its value.
 */
@Getter
public class Wrapper<T> {
    protected final T value;

    protected Wrapper(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Wrapper<?> other)) return false;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return Objects.toString(value);
    }
}
