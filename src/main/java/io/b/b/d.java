package io.b.b;

import io.b.e.b.b;
import java.util.concurrent.atomic.AtomicReference;

abstract class d<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    /* access modifiers changed from: protected */
    public abstract void a(T t);

    d(T t) {
        super(b.a(t, "value is null"));
    }

    public final void dispose() {
        if (get() != null) {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                a(andSet);
            }
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
