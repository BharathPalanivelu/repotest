package io.b;

import io.b.e.g.e;
import java.util.concurrent.TimeUnit;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    static final long f33607a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract b a();

    public void b() {
    }

    public io.b.b.b a(Runnable runnable) {
        return a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        b a2 = a();
        a aVar = new a(io.b.g.a.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }

    public static abstract class b implements io.b.b.b {
        public abstract io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public io.b.b.b a(Runnable runnable) {
            return a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    static final class a implements io.b.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f33608a;

        /* renamed from: b  reason: collision with root package name */
        final b f33609b;

        /* renamed from: c  reason: collision with root package name */
        Thread f33610c;

        a(Runnable runnable, b bVar) {
            this.f33608a = runnable;
            this.f33609b = bVar;
        }

        public void run() {
            this.f33610c = Thread.currentThread();
            try {
                this.f33608a.run();
            } finally {
                dispose();
                this.f33610c = null;
            }
        }

        public void dispose() {
            if (this.f33610c == Thread.currentThread()) {
                b bVar = this.f33609b;
                if (bVar instanceof e) {
                    ((e) bVar).b();
                    return;
                }
            }
            this.f33609b.dispose();
        }

        public boolean isDisposed() {
            return this.f33609b.isDisposed();
        }
    }
}
