package io.b.e.d;

import io.b.b.b;
import io.b.g.a;
import io.b.s;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T> extends AtomicReference<b> implements b, s<T> {
    private static final long serialVersionUID = 4943102778943297569L;
    final io.b.d.b<? super T, ? super Throwable> onCallback;

    public d(io.b.d.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    public void a(Throwable th) {
        try {
            lazySet(io.b.e.a.b.DISPOSED);
            this.onCallback.a(null, th);
        } catch (Throwable th2) {
            io.b.c.b.b(th2);
            a.a((Throwable) new io.b.c.a(th, th2));
        }
    }

    public void a(b bVar) {
        io.b.e.a.b.setOnce(this, bVar);
    }

    public void a(T t) {
        try {
            lazySet(io.b.e.a.b.DISPOSED);
            this.onCallback.a(t, null);
        } catch (Throwable th) {
            io.b.c.b.b(th);
            a.a(th);
        }
    }

    public void dispose() {
        io.b.e.a.b.dispose(this);
    }

    public boolean isDisposed() {
        return get() == io.b.e.a.b.DISPOSED;
    }
}
