package com.julianw03.poroLCU.Util;

import java.util.function.Consumer;
import java.util.function.Function;


/**
 * Utility class to represent a value that can be either of two types.
 * This implementation allows for {@code null} values.
 * */
public class Either<L, R> {
    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(value, null, true);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(null, value, false);
    }

    private final L left;
    private final R right;
    private final boolean isLeft;

    protected Either(L l, R r, boolean isLeft) {
        left = l;
        right = r;
        this.isLeft = isLeft;
    }

    public final <T> T map(
            Function<? super L, ? extends T> lFunc,
            Function<? super R, ? extends T> rFunc) {
        if (isLeft()) {
            return lFunc.apply(left);
        } else {
            return rFunc.apply(right);
        }
    }

    public final  <T> Either<T, R> mapLeft(Function<? super L, ? extends T> lFunc) {
        return new Either<>(lFunc.apply(left), right, this.isLeft);
    }

    public final <T> Either<L, T> mapRight(Function<? super R, ? extends T> rFunc) {
        return new Either<>(left, rFunc.apply(right), this.isLeft);
    }

    public final void apply(Consumer<? super L> lFunc, Consumer<? super R> rFunc) {
        lFunc.accept(left);
        rFunc.accept(right);
    }

    public final boolean isLeft() {
        return isLeft;
    }

    public final L getLeft() {
        return left;
    }

    public final R getRight() {
        return right;
    }
}
