package io.b.e.g;

import io.b.p;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class c extends p {

    /* renamed from: b  reason: collision with root package name */
    static final g f33501b;

    /* renamed from: c  reason: collision with root package name */
    static final g f33502c;

    /* renamed from: d  reason: collision with root package name */
    static final C0522c f33503d = new C0522c(new g("RxCachedThreadSchedulerShutdown"));

    /* renamed from: g  reason: collision with root package name */
    static final a f33504g = new a(0, (TimeUnit) null, f33501b);
    private static final TimeUnit h = TimeUnit.SECONDS;

    /* renamed from: e  reason: collision with root package name */
    final ThreadFactory f33505e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a> f33506f;

    static {
        f33503d.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f33501b = new g("RxCachedThreadScheduler", max);
        f33502c = new g("RxCachedWorkerPoolEvictor", max);
        f33504g.d();
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final io.b.b.a f33507a;

        /* renamed from: b  reason: collision with root package name */
        private final long f33508b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0522c> f33509c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f33510d;

        /* renamed from: e  reason: collision with root package name */
        private final Future<?> f33511e;

        /* renamed from: f  reason: collision with root package name */
        private final ThreadFactory f33512f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f33508b = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f33509c = new ConcurrentLinkedQueue<>();
            this.f33507a = new io.b.b.a();
            this.f33512f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, c.f33502c);
                long j2 = this.f33508b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f33510d = scheduledExecutorService;
            this.f33511e = scheduledFuture;
        }

        public void run() {
            b();
        }

        /* access modifiers changed from: package-private */
        public C0522c a() {
            if (this.f33507a.isDisposed()) {
                return c.f33503d;
            }
            while (!this.f33509c.isEmpty()) {
                C0522c poll = this.f33509c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C0522c cVar = new C0522c(this.f33512f);
            this.f33507a.a((io.b.b.b) cVar);
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(C0522c cVar) {
            cVar.a(c() + this.f33508b);
            this.f33509c.offer(cVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!this.f33509c.isEmpty()) {
                long c2 = c();
                Iterator<C0522c> it = this.f33509c.iterator();
                while (it.hasNext()) {
                    C0522c next = it.next();
                    if (next.a() > c2) {
                        return;
                    }
                    if (this.f33509c.remove(next)) {
                        this.f33507a.b(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f33507a.dispose();
            Future<?> future = this.f33511e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f33510d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public c() {
        this(f33501b);
    }

    public c(ThreadFactory threadFactory) {
        this.f33505e = threadFactory;
        this.f33506f = new AtomicReference<>(f33504g);
        b();
    }

    public void b() {
        a aVar = new a(60, h, this.f33505e);
        if (!this.f33506f.compareAndSet(f33504g, aVar)) {
            aVar.d();
        }
    }

    public p.b a() {
        return new b(this.f33506f.get());
    }

    static final class b extends p.b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f33513a = new AtomicBoolean();

        /* renamed from: b  reason: collision with root package name */
        private final io.b.b.a f33514b;

        /* renamed from: c  reason: collision with root package name */
        private final a f33515c;

        /* renamed from: d  reason: collision with root package name */
        private final C0522c f33516d;

        b(a aVar) {
            this.f33515c = aVar;
            this.f33514b = new io.b.b.a();
            this.f33516d = aVar.a();
        }

        public void dispose() {
            if (this.f33513a.compareAndSet(false, true)) {
                this.f33514b.dispose();
                this.f33515c.a(this.f33516d);
            }
        }

        public boolean isDisposed() {
            return this.f33513a.get();
        }

        public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f33514b.isDisposed()) {
                return io.b.e.a.c.INSTANCE;
            }
            return this.f33516d.a(runnable, j, timeUnit, this.f33514b);
        }
    }

    /* renamed from: io.b.e.g.c$c  reason: collision with other inner class name */
    static final class C0522c extends e {

        /* renamed from: b  reason: collision with root package name */
        private long f33517b = 0;

        C0522c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long a() {
            return this.f33517b;
        }

        public void a(long j) {
            this.f33517b = j;
        }
    }
}
