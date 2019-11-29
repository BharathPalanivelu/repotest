package io.b.e.g;

import io.b.p;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class l extends p {

    /* renamed from: b  reason: collision with root package name */
    private static final l f33539b = new l();

    public static l c() {
        return f33539b;
    }

    public p.b a() {
        return new c();
    }

    l() {
    }

    public io.b.b.b a(Runnable runnable) {
        io.b.g.a.a(runnable).run();
        return io.b.e.a.c.INSTANCE;
    }

    public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.b.g.a.a(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            io.b.g.a.a((Throwable) e2);
        }
        return io.b.e.a.c.INSTANCE;
    }

    static final class c extends p.b implements io.b.b.b {

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f33547a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        final AtomicInteger f33548b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f33549c;

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f33550d = new AtomicInteger();

        c() {
        }

        public io.b.b.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }

        /* access modifiers changed from: package-private */
        public io.b.b.b a(Runnable runnable, long j) {
            if (this.f33549c) {
                return io.b.e.a.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f33548b.incrementAndGet());
            this.f33547a.add(bVar);
            if (this.f33550d.getAndIncrement() != 0) {
                return io.b.b.c.a(new a(bVar));
            }
            int i = 1;
            while (!this.f33549c) {
                b poll = this.f33547a.poll();
                if (poll == null) {
                    i = this.f33550d.addAndGet(-i);
                    if (i == 0) {
                        return io.b.e.a.c.INSTANCE;
                    }
                } else if (!poll.f33546d) {
                    poll.f33543a.run();
                }
            }
            this.f33547a.clear();
            return io.b.e.a.c.INSTANCE;
        }

        public void dispose() {
            this.f33549c = true;
        }

        public boolean isDisposed() {
            return this.f33549c;
        }

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f33551a;

            a(b bVar) {
                this.f33551a = bVar;
            }

            public void run() {
                this.f33551a.f33546d = true;
                c.this.f33547a.remove(this.f33551a);
            }
        }
    }

    static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f33543a;

        /* renamed from: b  reason: collision with root package name */
        final long f33544b;

        /* renamed from: c  reason: collision with root package name */
        final int f33545c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f33546d;

        b(Runnable runnable, Long l, int i) {
            this.f33543a = runnable;
            this.f33544b = l.longValue();
            this.f33545c = i;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int a2 = io.b.e.b.b.a(this.f33544b, bVar.f33544b);
            return a2 == 0 ? io.b.e.b.b.a(this.f33545c, bVar.f33545c) : a2;
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f33540a;

        /* renamed from: b  reason: collision with root package name */
        private final c f33541b;

        /* renamed from: c  reason: collision with root package name */
        private final long f33542c;

        a(Runnable runnable, c cVar, long j) {
            this.f33540a = runnable;
            this.f33541b = cVar;
            this.f33542c = j;
        }

        public void run() {
            if (!this.f33541b.f33549c) {
                long a2 = this.f33541b.a(TimeUnit.MILLISECONDS);
                long j = this.f33542c;
                if (j > a2) {
                    try {
                        Thread.sleep(j - a2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        io.b.g.a.a((Throwable) e2);
                        return;
                    }
                }
                if (!this.f33541b.f33549c) {
                    this.f33540a.run();
                }
            }
        }
    }
}
