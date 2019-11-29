package io.b.e.d;

import io.b.b.b;
import io.b.d.a;
import io.b.d.f;
import io.b.o;
import java.util.concurrent.atomic.AtomicReference;

public final class h<T> extends AtomicReference<b> implements b, o<T> {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onNext;
    final f<? super b> onSubscribe;

    public h(f<? super T> fVar, f<? super Throwable> fVar2, a aVar, f<? super b> fVar3) {
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
    }

    public void a(b bVar) {
        if (io.b.e.a.b.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.b.c.b.b(th);
                bVar.dispose();
                a(th);
            }
        }
    }

    public void a(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                io.b.c.b.b(th);
                ((b) get()).dispose();
                a(th);
            }
        }
    }

    public void a(Throwable th) {
        if (!isDisposed()) {
            lazySet(io.b.e.a.b.DISPOSED);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                io.b.c.b.b(th2);
                io.b.g.a.a((Throwable) new io.b.c.a(th, th2));
            }
        } else {
            io.b.g.a.a(th);
        }
    }

    public void a() {
        if (!isDisposed()) {
            lazySet(io.b.e.a.b.DISPOSED);
            try {
                this.onComplete.a();
            } catch (Throwable th) {
                io.b.c.b.b(th);
                io.b.g.a.a(th);
            }
        }
    }

    public void dispose() {
        io.b.e.a.b.dispose(this);
    }

    public boolean isDisposed() {
        return get() == io.b.e.a.b.DISPOSED;
    }
}
