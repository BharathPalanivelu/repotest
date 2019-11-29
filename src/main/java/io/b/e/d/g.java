package io.b.e.d;

import io.b.b.b;
import io.b.d.f;
import io.b.g.a;
import io.b.s;
import java.util.concurrent.atomic.AtomicReference;

public final class g<T> extends AtomicReference<b> implements b, s<T> {
    private static final long serialVersionUID = -7012088219455310787L;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;

    public g(f<? super T> fVar, f<? super Throwable> fVar2) {
        this.onSuccess = fVar;
        this.onError = fVar2;
    }

    public void a(Throwable th) {
        lazySet(io.b.e.a.b.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.b.c.b.b(th2);
            a.a((Throwable) new io.b.c.a(th, th2));
        }
    }

    public void a(b bVar) {
        io.b.e.a.b.setOnce(this, bVar);
    }

    public void a(T t) {
        lazySet(io.b.e.a.b.DISPOSED);
        try {
            this.onSuccess.accept(t);
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
