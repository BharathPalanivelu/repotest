package io.b.e.e.c;

import io.b.d.a;
import io.b.d.f;
import io.b.h;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T> extends AtomicReference<io.b.b.b> implements io.b.b.b, h<T> {
    private static final long serialVersionUID = -6076952298809384986L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;

    public b(f<? super T> fVar, f<? super Throwable> fVar2, a aVar) {
        this.onSuccess = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
    }

    public void dispose() {
        io.b.e.a.b.dispose(this);
    }

    public boolean isDisposed() {
        return io.b.e.a.b.isDisposed((io.b.b.b) get());
    }

    public void a(io.b.b.b bVar) {
        io.b.e.a.b.setOnce(this, bVar);
    }

    public void a(T t) {
        lazySet(io.b.e.a.b.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.b.c.b.b(th);
            io.b.g.a.a(th);
        }
    }

    public void a(Throwable th) {
        lazySet(io.b.e.a.b.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.b.c.b.b(th2);
            io.b.g.a.a((Throwable) new io.b.c.a(th, th2));
        }
    }

    public void a() {
        lazySet(io.b.e.a.b.DISPOSED);
        try {
            this.onComplete.a();
        } catch (Throwable th) {
            io.b.c.b.b(th);
            io.b.g.a.a(th);
        }
    }
}
