package io.b.e.d;

import io.b.e.c.a;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b<T> extends AtomicInteger implements a<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
