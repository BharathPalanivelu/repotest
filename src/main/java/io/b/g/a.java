package io.b.g;

import io.b.b;
import io.b.c.d;
import io.b.d.c;
import io.b.d.e;
import io.b.d.f;
import io.b.d.g;
import io.b.h;
import io.b.j;
import io.b.o;
import io.b.p;
import io.b.q;
import io.b.s;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile f<? super Throwable> f33572a;

    /* renamed from: b  reason: collision with root package name */
    static volatile g<? super Runnable, ? extends Runnable> f33573b;

    /* renamed from: c  reason: collision with root package name */
    static volatile g<? super Callable<p>, ? extends p> f33574c;

    /* renamed from: d  reason: collision with root package name */
    static volatile g<? super Callable<p>, ? extends p> f33575d;

    /* renamed from: e  reason: collision with root package name */
    static volatile g<? super Callable<p>, ? extends p> f33576e;

    /* renamed from: f  reason: collision with root package name */
    static volatile g<? super Callable<p>, ? extends p> f33577f;

    /* renamed from: g  reason: collision with root package name */
    static volatile g<? super p, ? extends p> f33578g;
    static volatile g<? super p, ? extends p> h;
    static volatile g<? super io.b.f, ? extends io.b.f> i;
    static volatile g<? super j, ? extends j> j;
    static volatile g<? super io.b.g, ? extends io.b.g> k;
    static volatile g<? super q, ? extends q> l;
    static volatile g<? super b, ? extends b> m;
    static volatile c<? super io.b.g, ? super h, ? extends h> n;
    static volatile c<? super j, ? super o, ? extends o> o;
    static volatile c<? super q, ? super s, ? extends s> p;
    static volatile c<? super b, ? super io.b.c, ? extends io.b.c> q;
    static volatile e r;
    static volatile boolean s;

    public static boolean a() {
        return s;
    }

    public static p a(Callable<p> callable) {
        io.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<p>, ? extends p> gVar = f33574c;
        if (gVar == null) {
            return e(callable);
        }
        return a(gVar, callable);
    }

    public static p b(Callable<p> callable) {
        io.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<p>, ? extends p> gVar = f33576e;
        if (gVar == null) {
            return e(callable);
        }
        return a(gVar, callable);
    }

    public static p c(Callable<p> callable) {
        io.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<p>, ? extends p> gVar = f33577f;
        if (gVar == null) {
            return e(callable);
        }
        return a(gVar, callable);
    }

    public static p d(Callable<p> callable) {
        io.b.e.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<p>, ? extends p> gVar = f33575d;
        if (gVar == null) {
            return e(callable);
        }
        return a(gVar, callable);
    }

    public static p a(p pVar) {
        g<? super p, ? extends p> gVar = f33578g;
        if (gVar == null) {
            return pVar;
        }
        return (p) a(gVar, pVar);
    }

    public static void a(Throwable th) {
        f<? super Throwable> fVar = f33572a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!b(th)) {
            th = new io.b.c.f(th);
        }
        if (fVar != null) {
            try {
                fVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static boolean b(Throwable th) {
        if (!(th instanceof d) && !(th instanceof io.b.c.c) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof io.b.c.a)) {
            return false;
        }
        return true;
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static p b(p pVar) {
        g<? super p, ? extends p> gVar = h;
        if (gVar == null) {
            return pVar;
        }
        return (p) a(gVar, pVar);
    }

    public static Runnable a(Runnable runnable) {
        io.b.e.b.b.a(runnable, "run is null");
        g<? super Runnable, ? extends Runnable> gVar = f33573b;
        if (gVar == null) {
            return runnable;
        }
        return (Runnable) a(gVar, runnable);
    }

    public static <T> o<? super T> a(j<T> jVar, o<? super T> oVar) {
        c<? super j, ? super o, ? extends o> cVar = o;
        return cVar != null ? (o) a(cVar, jVar, oVar) : oVar;
    }

    public static <T> s<? super T> a(q<T> qVar, s<? super T> sVar) {
        c<? super q, ? super s, ? extends s> cVar = p;
        return cVar != null ? (s) a(cVar, qVar, sVar) : sVar;
    }

    public static io.b.c a(b bVar, io.b.c cVar) {
        c<? super b, ? super io.b.c, ? extends io.b.c> cVar2 = q;
        return cVar2 != null ? (io.b.c) a(cVar2, bVar, cVar) : cVar;
    }

    public static <T> h<? super T> a(io.b.g<T> gVar, h<? super T> hVar) {
        c<? super io.b.g, ? super h, ? extends h> cVar = n;
        return cVar != null ? (h) a(cVar, gVar, hVar) : hVar;
    }

    public static <T> io.b.g<T> a(io.b.g<T> gVar) {
        g<? super io.b.g, ? extends io.b.g> gVar2 = k;
        return gVar2 != null ? (io.b.g) a(gVar2, gVar) : gVar;
    }

    public static <T> io.b.f<T> a(io.b.f<T> fVar) {
        g<? super io.b.f, ? extends io.b.f> gVar = i;
        return gVar != null ? (io.b.f) a(gVar, fVar) : fVar;
    }

    public static <T> j<T> a(j<T> jVar) {
        g<? super j, ? extends j> gVar = j;
        return gVar != null ? (j) a(gVar, jVar) : jVar;
    }

    public static <T> q<T> a(q<T> qVar) {
        g<? super q, ? extends q> gVar = l;
        return gVar != null ? (q) a(gVar, qVar) : qVar;
    }

    public static b a(b bVar) {
        g<? super b, ? extends b> gVar = m;
        return gVar != null ? (b) a(gVar, bVar) : bVar;
    }

    public static boolean b() {
        e eVar = r;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.a();
        } catch (Throwable th) {
            throw io.b.e.h.f.a(th);
        }
    }

    static <T, R> R a(g<T, R> gVar, T t) {
        try {
            return gVar.apply(t);
        } catch (Throwable th) {
            throw io.b.e.h.f.a(th);
        }
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
            return cVar.a(t, u);
        } catch (Throwable th) {
            throw io.b.e.h.f.a(th);
        }
    }

    static p e(Callable<p> callable) {
        try {
            return (p) io.b.e.b.b.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw io.b.e.h.f.a(th);
        }
    }

    static p a(g<? super Callable<p>, ? extends p> gVar, Callable<p> callable) {
        return (p) io.b.e.b.b.a(a(gVar, callable), "Scheduler Callable result can't be null");
    }
}
