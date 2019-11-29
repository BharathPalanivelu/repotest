package io.b.e.d;

import io.b.b.b;
import io.b.c;
import io.b.c.d;
import io.b.d.a;
import java.util.concurrent.atomic.AtomicReference;

public final class f extends AtomicReference<b> implements b, c, io.b.d.f<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final a onComplete;
    final io.b.d.f<? super Throwable> onError;

    public f(io.b.d.f<? super Throwable> fVar, a aVar) {
        this.onError = fVar;
        this.onComplete = aVar;
    }

    /* renamed from: b */
    public void accept(Throwable th) {
        io.b.g.a.a((Throwable) new d(th));
    }

    public void a() {
        try {
            this.onComplete.a();
        } catch (Throwable th) {
            io.b.c.b.b(th);
            io.b.g.a.a(th);
        }
        lazySet(io.b.e.a.b.DISPOSED);
    }

    public void a(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.b.c.b.b(th2);
            io.b.g.a.a(th2);
        }
        lazySet(io.b.e.a.b.DISPOSED);
    }

    public void a(b bVar) {
        io.b.e.a.b.setOnce(this, bVar);
    }

    public void dispose() {
        io.b.e.a.b.dispose(this);
    }

    public boolean isDisposed() {
        return get() == io.b.e.a.b.DISPOSED;
    }
}
