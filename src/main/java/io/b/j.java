package io.b;

import io.b.d.g;
import io.b.d.h;
import io.b.e.b.b;
import io.b.e.e.d.c;
import io.b.e.e.d.d;
import io.b.e.e.d.f;
import io.b.e.e.d.i;
import io.b.e.e.d.k;
import io.b.e.e.d.l;
import io.b.e.e.d.m;
import io.b.e.e.d.n;
import io.b.e.e.d.o;
import io.b.e.e.d.p;
import io.b.e.e.d.q;
import io.b.e.e.d.r;
import io.b.e.e.d.s;
import io.b.e.e.d.t;
import io.b.e.e.d.u;
import io.b.e.e.d.v;
import io.b.e.h.e;
import io.b.g.a;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class j<T> implements m<T> {
    /* access modifiers changed from: protected */
    public abstract void b(o<? super T> oVar);

    public static int b() {
        return f.a();
    }

    public static <T, R> j<R> a(g<? super Object[], ? extends R> gVar, int i, m<? extends T>... mVarArr) {
        return a(mVarArr, gVar, i);
    }

    public static <T, R> j<R> a(Iterable<? extends m<? extends T>> iterable, g<? super Object[], ? extends R> gVar) {
        return a(iterable, gVar, b());
    }

    public static <T, R> j<R> a(Iterable<? extends m<? extends T>> iterable, g<? super Object[], ? extends R> gVar, int i) {
        b.a(iterable, "sources is null");
        b.a(gVar, "combiner is null");
        b.a(i, "bufferSize");
        return a.a(new c((m<? extends T>[]) null, iterable, gVar, i << 1, false));
    }

    public static <T, R> j<R> a(m<? extends T>[] mVarArr, g<? super Object[], ? extends R> gVar, int i) {
        b.a(mVarArr, "sources is null");
        if (mVarArr.length == 0) {
            return c();
        }
        b.a(gVar, "combiner is null");
        b.a(i, "bufferSize");
        return a.a(new c(mVarArr, (Iterable) null, gVar, i << 1, false));
    }

    public static <T1, T2, T3, R> j<R> a(m<? extends T1> mVar, m<? extends T2> mVar2, m<? extends T3> mVar3, h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        b.a(mVar, "source1 is null");
        b.a(mVar2, "source2 is null");
        b.a(mVar3, "source3 is null");
        return a(io.b.e.b.a.a(hVar), b(), (m<? extends T>[]) new m[]{mVar, mVar2, mVar3});
    }

    public static <T> j<T> a(m<? extends m<? extends T>> mVar) {
        return a(mVar, b());
    }

    public static <T> j<T> a(m<? extends m<? extends T>> mVar, int i) {
        b.a(mVar, "sources is null");
        b.a(i, "prefetch");
        return a.a(new d(mVar, io.b.e.b.a.a(), i, e.IMMEDIATE));
    }

    public static <T> j<T> a(l<T> lVar) {
        b.a(lVar, "source is null");
        return a.a(new io.b.e.e.d.e(lVar));
    }

    public static <T> j<T> c() {
        return a.a(io.b.e.e.d.g.f33403a);
    }

    public static <T> j<T> a(T... tArr) {
        b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return c();
        }
        if (tArr.length == 1) {
            return b(tArr[0]);
        }
        return a.a(new io.b.e.e.d.j(tArr));
    }

    public static <T> j<T> a(Iterable<? extends T> iterable) {
        b.a(iterable, "source is null");
        return a.a(new k(iterable));
    }

    public static <T> j<T> b(T t) {
        b.a(t, "The item is null");
        return a.a(new n(t));
    }

    public static <T> j<T> a(m<? extends T> mVar, m<? extends T> mVar2) {
        b.a(mVar, "source1 is null");
        b.a(mVar2, "source2 is null");
        return a((T[]) new m[]{mVar, mVar2}).a(io.b.e.b.a.a(), false, 2);
    }

    public static j<Long> a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, io.b.h.a.a());
    }

    public static j<Long> a(long j, TimeUnit timeUnit, p pVar) {
        b.a(timeUnit, "unit is null");
        b.a(pVar, "scheduler is null");
        return a.a(new u(Math.max(j, 0), timeUnit, pVar));
    }

    public static <T> j<T> b(m<T> mVar) {
        b.a(mVar, "source is null");
        if (mVar instanceof j) {
            return a.a((j) mVar);
        }
        return a.a(new l(mVar));
    }

    public final j<List<T>> a(int i) {
        return a(i, i);
    }

    public final j<List<T>> a(int i, int i2) {
        return a(i, i2, io.b.e.h.b.asCallable());
    }

    public final <U extends Collection<? super T>> j<U> a(int i, int i2, Callable<U> callable) {
        b.a(i, "count");
        b.a(i2, "skip");
        b.a(callable, "bufferSupplier is null");
        return a.a(new io.b.e.e.d.b(this, i, i2, callable));
    }

    public final <R> j<R> a(n<? super T, ? extends R> nVar) {
        return b(((n) b.a(nVar, "composer is null")).a(this));
    }

    public final q<T> a(long j) {
        if (j >= 0) {
            return a.a(new f(this, j, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final j<T> a(io.b.d.j<? super T> jVar) {
        b.a(jVar, "predicate is null");
        return a.a(new io.b.e.e.d.h(this, jVar));
    }

    public final q<T> d() {
        return a(0);
    }

    public final <R> j<R> a(g<? super T, ? extends m<? extends R>> gVar) {
        return a(gVar, false);
    }

    public final <R> j<R> a(g<? super T, ? extends m<? extends R>> gVar, boolean z) {
        return a(gVar, z, Integer.MAX_VALUE);
    }

    public final <R> j<R> a(g<? super T, ? extends m<? extends R>> gVar, boolean z, int i) {
        return a(gVar, z, i, b());
    }

    public final <R> j<R> a(g<? super T, ? extends m<? extends R>> gVar, boolean z, int i, int i2) {
        b.a(gVar, "mapper is null");
        b.a(i, "maxConcurrency");
        b.a(i2, "bufferSize");
        if (!(this instanceof io.b.e.c.c)) {
            return a.a(new i(this, gVar, z, i, i2));
        }
        Object call = ((io.b.e.c.c) this).call();
        if (call == null) {
            return c();
        }
        return q.a(call, gVar);
    }

    public final b e() {
        return a.a((b) new m(this));
    }

    public final <R> j<R> b(g<? super T, ? extends R> gVar) {
        b.a(gVar, "mapper is null");
        return a.a(new o(this, gVar));
    }

    public final j<T> a(p pVar) {
        return a(pVar, false, b());
    }

    public final j<T> a(p pVar, boolean z, int i) {
        b.a(pVar, "scheduler is null");
        b.a(i, "bufferSize");
        return a.a(new p(this, pVar, z, i));
    }

    public final g<T> f() {
        return a.a(new r(this));
    }

    public final q<T> g() {
        return a.a(new s(this, null));
    }

    public final io.b.b.b h() {
        return a(io.b.e.b.a.b(), (io.b.d.f<? super Throwable>) io.b.e.b.a.f33332f, io.b.e.b.a.f33329c, (io.b.d.f<? super io.b.b.b>) io.b.e.b.a.b());
    }

    public final io.b.b.b a(io.b.d.f<? super T> fVar) {
        return a(fVar, (io.b.d.f<? super Throwable>) io.b.e.b.a.f33332f, io.b.e.b.a.f33329c, (io.b.d.f<? super io.b.b.b>) io.b.e.b.a.b());
    }

    public final io.b.b.b a(io.b.d.f<? super T> fVar, io.b.d.f<? super Throwable> fVar2) {
        return a(fVar, fVar2, io.b.e.b.a.f33329c, (io.b.d.f<? super io.b.b.b>) io.b.e.b.a.b());
    }

    public final io.b.b.b a(io.b.d.f<? super T> fVar, io.b.d.f<? super Throwable> fVar2, io.b.d.a aVar, io.b.d.f<? super io.b.b.b> fVar3) {
        b.a(fVar, "onNext is null");
        b.a(fVar2, "onError is null");
        b.a(aVar, "onComplete is null");
        b.a(fVar3, "onSubscribe is null");
        io.b.e.d.h hVar = new io.b.e.d.h(fVar, fVar2, aVar, fVar3);
        a(hVar);
        return hVar;
    }

    public final void a(o<? super T> oVar) {
        b.a(oVar, "observer is null");
        try {
            o<? super Object> a2 = a.a(this, oVar);
            b.a(a2, "Plugin returned null Observer");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.b.c.b.b(th);
            a.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final j<T> b(p pVar) {
        b.a(pVar, "scheduler is null");
        return a.a(new t(this, pVar));
    }

    public final q<List<T>> i() {
        return b(16);
    }

    public final q<List<T>> b(int i) {
        b.a(i, "capacityHint");
        return a.a(new v(this, i));
    }

    public final f<T> a(a aVar) {
        io.b.e.e.b.b bVar = new io.b.e.e.b.b(this);
        int i = AnonymousClass1.f33606a[aVar.ordinal()];
        if (i == 1) {
            return bVar.c();
        }
        if (i == 2) {
            return bVar.d();
        }
        if (i == 3) {
            return bVar;
        }
        if (i != 4) {
            return bVar.b();
        }
        return a.a(new io.b.e.e.b.e(bVar));
    }

    /* renamed from: io.b.j$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33606a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                io.b.a[] r0 = io.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33606a = r0
                int[] r0 = f33606a     // Catch:{ NoSuchFieldError -> 0x0014 }
                io.b.a r1 = io.b.a.DROP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f33606a     // Catch:{ NoSuchFieldError -> 0x001f }
                io.b.a r1 = io.b.a.LATEST     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f33606a     // Catch:{ NoSuchFieldError -> 0x002a }
                io.b.a r1 = io.b.a.MISSING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f33606a     // Catch:{ NoSuchFieldError -> 0x0035 }
                io.b.a r1 = io.b.a.ERROR     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.j.AnonymousClass1.<clinit>():void");
        }
    }
}
