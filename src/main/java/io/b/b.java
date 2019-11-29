package io.b;

import io.b.d.f;
import io.b.g.a;
import java.util.concurrent.Callable;

public abstract class b implements d {
    /* access modifiers changed from: protected */
    public abstract void b(c cVar);

    public static b a(Callable<?> callable) {
        io.b.e.b.b.a(callable, "callable is null");
        return a.a((b) new io.b.e.e.a.a(callable));
    }

    private static NullPointerException a(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public final void a(c cVar) {
        io.b.e.b.b.a(cVar, "s is null");
        try {
            b(a.a(this, cVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.b.c.b.b(th);
            a.a(th);
            throw a(th);
        }
    }

    public final io.b.b.b a(io.b.d.a aVar, f<? super Throwable> fVar) {
        io.b.e.b.b.a(fVar, "onError is null");
        io.b.e.b.b.a(aVar, "onComplete is null");
        io.b.e.d.f fVar2 = new io.b.e.d.f(fVar, aVar);
        a((c) fVar2);
        return fVar2;
    }

    public final b a(p pVar) {
        io.b.e.b.b.a(pVar, "scheduler is null");
        return a.a((b) new io.b.e.e.a.b(this, pVar));
    }
}
