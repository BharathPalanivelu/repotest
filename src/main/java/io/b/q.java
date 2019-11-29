package io.b;

import io.b.d.g;
import io.b.e.b.b;
import io.b.e.d.e;
import io.b.e.e.e.c;
import io.b.e.e.e.d;
import io.b.e.e.e.f;
import io.b.e.e.e.h;
import io.b.g.a;
import java.util.concurrent.Callable;

public abstract class q<T> implements u<T> {
    /* access modifiers changed from: protected */
    public abstract void b(s<? super T> sVar);

    public static <T> q<T> a(t<T> tVar) {
        b.a(tVar, "source is null");
        return a.a(new io.b.e.e.e.a(tVar));
    }

    public static <T> q<T> a(Callable<? extends T> callable) {
        b.a(callable, "callable is null");
        return a.a(new c(callable));
    }

    public static <T> q<T> a(T t) {
        b.a(t, "value is null");
        return a.a(new d(t));
    }

    public final <R> q<R> a(g<? super T, ? extends u<? extends R>> gVar) {
        b.a(gVar, "mapper is null");
        return a.a(new io.b.e.e.e.b(this, gVar));
    }

    public final T a() {
        e eVar = new e();
        a(eVar);
        return eVar.c();
    }

    public final <R> q<R> b(g<? super T, ? extends R> gVar) {
        b.a(gVar, "mapper is null");
        return a.a(new io.b.e.e.e.e(this, gVar));
    }

    public final q<T> a(p pVar) {
        b.a(pVar, "scheduler is null");
        return a.a(new f(this, pVar));
    }

    public final q<T> a(q<? extends T> qVar) {
        b.a(qVar, "resumeSingleInCaseOfError is null");
        return c(io.b.e.b.a.a(qVar));
    }

    public final q<T> c(g<? super Throwable, ? extends u<? extends T>> gVar) {
        b.a(gVar, "resumeFunctionInCaseOfError is null");
        return a.a(new io.b.e.e.e.g(this, gVar));
    }

    public final io.b.b.b b() {
        return a(io.b.e.b.a.b(), io.b.e.b.a.f33332f);
    }

    public final io.b.b.b a(io.b.d.b<? super T, ? super Throwable> bVar) {
        b.a(bVar, "onCallback is null");
        io.b.e.d.d dVar = new io.b.e.d.d(bVar);
        a(dVar);
        return dVar;
    }

    public final io.b.b.b a(io.b.d.f<? super T> fVar, io.b.d.f<? super Throwable> fVar2) {
        b.a(fVar, "onSuccess is null");
        b.a(fVar2, "onError is null");
        io.b.e.d.g gVar = new io.b.e.d.g(fVar, fVar2);
        a(gVar);
        return gVar;
    }

    public final void a(s<? super T> sVar) {
        b.a(sVar, "subscriber is null");
        s<? super Object> a2 = a.a(this, sVar);
        b.a(a2, "subscriber returned by the RxJavaPlugins hook is null");
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

    public final q<T> b(p pVar) {
        b.a(pVar, "scheduler is null");
        return a.a(new h(this, pVar));
    }
}
