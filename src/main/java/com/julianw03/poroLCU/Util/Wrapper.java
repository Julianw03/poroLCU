package com.julianw03.poroLCU.Util;

import org.jetbrains.annotations.NotNull;

/**
 * Just a simple wrapper class to wrap a value.
 * Used to give a value a specific type so that the API is more clear.
 *
 * @param <T> The type of the value to wrap.
 *
 * @implNote {@link Wrapper#hashCode()} uses {@link T#hashCode()}, so that {@code Wrapper<T>} and {@code T} have the same hash code.
 * @implNote {@link Wrapper#equals(Object)} used {@link T#equals(Object)}, so that two {@code Wrapper<T>} objects are equal if their values are equal. A wrapper does not equal its value.
 */
public class Wrapper<T> {
    protected final T value;

    protected Wrapper(@NotNull T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value = value;
    }

    @NotNull
    public T getValue() {
        return value;
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
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
