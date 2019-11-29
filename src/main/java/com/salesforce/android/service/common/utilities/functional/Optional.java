package com.salesforce.android.service.common.utilities.functional;

import java.util.NoSuchElementException;

public class Optional<T> {
    private static final Optional EMPTY = of((Object) null);
    private final T value;

    public static <T> Optional<T> empty() {
        return EMPTY;
    }

    public static <T> Optional<T> of(T t) {
        return new Optional<>(t);
    }

    private Optional(T t) {
        this.value = t;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("Optional is empty");
    }

    public void ifPresent(Consumer<? super T> consumer) {
        T t = this.value;
        if (t != null) {
            consumer.consume(t);
        }
    }

    public T orElse(T t) {
        T t2 = this.value;
        return t2 == null ? t : t2;
    }
}
