package io.b.e.g;

import io.b.b.b;
import io.b.e.a.c;
import io.b.p;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class k extends p {

    /* renamed from: d  reason: collision with root package name */
    static final g f33532d = new g("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: e  reason: collision with root package name */
    static final ScheduledExecutorService f33533e = Executors.newScheduledThreadPool(0);

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f33534b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f33535c;

    static {
        f33533e.shutdown();
    }

    public k() {
        this(f33532d);
    }

    public k(ThreadFactory threadFactory) {
        this.f33535c = new AtomicReference<>();
        this.f33534b = threadFactory;
        this.f33535c.lazySet(a(threadFactory));
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return j.a(threadFactory);
    }

    public void b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f33535c.get();
            if (scheduledExecutorService != f33533e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = a(this.f33534b);
            }
        } while (!this.f33535c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    public p.b a() {
        return new a(this.f33535c.get());
    }

    public b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        h hVar = new h(io.b.g.a.a(runnable));
        if (j <= 0) {
            try {
                future = this.f33535c.get().submit(hVar);
            } catch (RejectedExecutionException e2) {
                io.b.g.a.a((Throwable) e2);
                return c.INSTANCE;
            }
        } else {
            future = this.f33535c.get().schedule(hVar, j, timeUnit);
        }
        hVar.a(future);
        return hVar;
    }

    static final class a extends p.b {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f33536a;

        /* renamed from: b  reason: collision with root package name */
        final io.b.b.a f33537b = new io.b.b.a();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f33538c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f33536a = scheduledExecutorService;
        }

        public b a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.f33538c) {
                return c.INSTANCE;
            }
            i iVar = new i(io.b.g.a.a(runnable), this.f33537b);
            this.f33537b.a((b) iVar);
            if (j <= 0) {
                try {
                    future = this.f33536a.submit(iVar);
                } catch (RejectedExecutionException e2) {
                    dispose();
                    io.b.g.a.a((Throwable) e2);
                    return c.INSTANCE;
                }
            } else {
                future = this.f33536a.schedule(iVar, j, timeUnit);
            }
            iVar.a(future);
            return iVar;
        }

        public void dispose() {
            if (!this.f33538c) {
                this.f33538c = true;
                this.f33537b.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f33538c;
        }
    }
}
