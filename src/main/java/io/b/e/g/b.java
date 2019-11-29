package io.b.e.g;

import io.b.e.a.d;
import io.b.p;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends p {

    /* renamed from: b  reason: collision with root package name */
    static final C0521b f33487b = new C0521b(0, f33488c);

    /* renamed from: c  reason: collision with root package name */
    static final g f33488c = new g("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);

    /* renamed from: d  reason: collision with root package name */
    static final int f33489d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e  reason: collision with root package name */
    static final c f33490e = new c(new g("RxComputationShutdown"));

    /* renamed from: f  reason: collision with root package name */
    final ThreadFactory f33491f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<C0521b> f33492g;

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        f33490e.dispose();
        f33487b.b();
    }

    /* renamed from: io.b.e.g.b$b  reason: collision with other inner class name */
    static final class C0521b {

        /* renamed from: a  reason: collision with root package name */
        final int f33498a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f33499b;

        /* renamed from: c  reason: collision with root package name */
        long f33500c;

        C0521b(int i, ThreadFactory threadFactory) {
            this.f33498a = i;
            this.f33499b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f33499b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f33498a;
            if (i == 0) {
                return b.f33490e;
            }
            c[] cVarArr = this.f33499b;
            long j = this.f33500c;
            this.f33500c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        public void b() {
            for (c dispose : this.f33499b) {
                dispose.dispose();
            }
        }
    }

    public b() {
        this(f33488c);
    }

    public b(ThreadFactory threadFactory) {
        this.f33491f = threadFactory;
        this.f33492g = new AtomicReference<>(f33487b);
        b();
    }

    public p.b a() {
        return new a(this.f33492g.get().a());
    }

    public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f33492g.get().a().b(runnable, j, timeUnit);
    }

    public void b() {
        C0521b bVar = new C0521b(f33489d, this.f33491f);
        if (!this.f33492g.compareAndSet(f33487b, bVar)) {
            bVar.b();
        }
    }

    static final class a extends p.b {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f33493a;

        /* renamed from: b  reason: collision with root package name */
        private final d f33494b = new d();

        /* renamed from: c  reason: collision with root package name */
        private final io.b.b.a f33495c = new io.b.b.a();

        /* renamed from: d  reason: collision with root package name */
        private final d f33496d = new d();

        /* renamed from: e  reason: collision with root package name */
        private final c f33497e;

        a(c cVar) {
            this.f33497e = cVar;
            this.f33496d.a((io.b.b.b) this.f33494b);
            this.f33496d.a((io.b.b.b) this.f33495c);
        }

        public void dispose() {
            if (!this.f33493a) {
                this.f33493a = true;
                this.f33496d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f33493a;
        }

        public io.b.b.b a(Runnable runnable) {
            if (this.f33493a) {
                return io.b.e.a.c.INSTANCE;
            }
            return this.f33497e.a(runnable, 0, TimeUnit.MILLISECONDS, this.f33494b);
        }

        public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f33493a) {
                return io.b.e.a.c.INSTANCE;
            }
            return this.f33497e.a(runnable, j, timeUnit, this.f33495c);
        }
    }

    static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
