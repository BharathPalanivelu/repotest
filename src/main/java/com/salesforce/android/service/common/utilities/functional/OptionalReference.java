package com.salesforce.android.service.common.utilities.functional;

import java.lang.ref.WeakReference;

public class OptionalReference<T> extends WeakReference<T> {
    public OptionalReference(T t) {
        super(t);
    }

    public T get() {
        return super.get();
    }

    public boolean isPresent() {
        return get() != null;
    }

    public boolean is(T t) {
        return t == get();
    }

    public void clearIfSame(T t) {
        if (is(t)) {
            clear();
        }
    }

    public void ifPresent(Consumer<? super T> consumer) {
        Object obj = get();
        if (obj != null) {
            consumer.consume(obj);
        }
    }

    public T orElse(T t) {
        T t2 = get();
        return t2 != null ? t2 : t;
    }
}
