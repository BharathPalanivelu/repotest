package io.b.a.a;

import io.b.c.b;
import io.b.d.g;
import io.b.p;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g<Callable<p>, p> f33311a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile g<p, p> f33312b;

    public static p a(Callable<p> callable) {
        if (callable != null) {
            g<Callable<p>, p> gVar = f33311a;
            if (gVar == null) {
                return b(callable);
            }
            return a(gVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static p a(p pVar) {
        if (pVar != null) {
            g gVar = f33312b;
            if (gVar == null) {
                return pVar;
            }
            return (p) a(gVar, pVar);
        }
        throw new NullPointerException("scheduler == null");
    }

    static p b(Callable<p> callable) {
        try {
            p call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.b.d.g, io.b.d.g<java.util.concurrent.Callable<io.b.p>, io.b.p>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static io.b.p a(io.b.d.g<java.util.concurrent.Callable<io.b.p>, io.b.p> r0, java.util.concurrent.Callable<io.b.p> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            io.b.p r0 = (io.b.p) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.b.a.a.a.a(io.b.d.g, java.util.concurrent.Callable):io.b.p");
    }

    static <T, R> R a(g<T, R> gVar, T t) {
        try {
            return gVar.apply(t);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }
}
