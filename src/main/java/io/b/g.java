package io.b;

import io.b.d.f;
import io.b.e.b.b;
import io.b.e.e.c.c;
import io.b.e.e.c.d;
import io.b.e.e.c.e;
import io.b.g.a;
import java.util.concurrent.Callable;

public abstract class g<T> implements i<T> {
    /* access modifiers changed from: protected */
    public abstract void b(h<? super T> hVar);

    public static <T> g<T> a(Callable<? extends T> callable) {
        b.a(callable, "callable is null");
        return a.a(new c(callable));
    }

    public final g<T> a(f<? super Throwable> fVar) {
        return a.a(new e(this, io.b.e.b.a.b(), io.b.e.b.a.b(), (f) b.a(fVar, "onError is null"), io.b.e.b.a.f33329c, io.b.e.b.a.f33329c, io.b.e.b.a.f33329c));
    }

    public final g<T> b(f<? super T> fVar) {
        return a.a(new e(this, io.b.e.b.a.b(), (f) b.a(fVar, "onSubscribe is null"), io.b.e.b.a.b(), io.b.e.b.a.f33329c, io.b.e.b.a.f33329c, io.b.e.b.a.f33329c));
    }

    public final g<T> a(p pVar) {
        b.a(pVar, "scheduler is null");
        return a.a(new d(this, pVar));
    }

    public final io.b.b.b a() {
        return a(io.b.e.b.a.b(), io.b.e.b.a.f33332f, io.b.e.b.a.f33329c);
    }

    public final io.b.b.b a(f<? super T> fVar, f<? super Throwable> fVar2, io.b.d.a aVar) {
        b.a(fVar, "onSuccess is null");
        b.a(fVar2, "onError is null");
        b.a(aVar, "onComplete is null");
        return (io.b.b.b) c(new io.b.e.e.c.b(fVar, fVar2, aVar));
    }

    public final void a(h<? super T> hVar) {
        b.a(hVar, "observer is null");
        h<? super Object> a2 = a.a(this, hVar);
        b.a(a2, "observer returned by the RxJavaPlugins hook is null");
        try {
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.b.c.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final g<T> b(p pVar) {
        b.a(pVar, "scheduler is null");
        return a.a(new io.b.e.e.c.f(this, pVar));
    }

    public final <E extends h<? super T>> E c(E e2) {
        a(e2);
        return e2;
    }
}
