package io.b.a.b;

import android.os.Handler;
import android.os.Message;
import io.b.b.c;
import io.b.p;
import java.util.concurrent.TimeUnit;

final class b extends p {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f33315b;

    b(Handler handler) {
        this.f33315b = handler;
    }

    public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C0514b bVar = new C0514b(this.f33315b, io.b.g.a.a(runnable));
            this.f33315b.postDelayed(bVar, Math.max(0, timeUnit.toMillis(j)));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public p.b a() {
        return new a(this.f33315b);
    }

    private static final class a extends p.b {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f33316a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f33317b;

        a(Handler handler) {
            this.f33316a = handler;
        }

        public io.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f33317b) {
                return c.b();
            } else {
                C0514b bVar = new C0514b(this.f33316a, io.b.g.a.a(runnable));
                Message obtain = Message.obtain(this.f33316a, bVar);
                obtain.obj = this;
                this.f33316a.sendMessageDelayed(obtain, Math.max(0, timeUnit.toMillis(j)));
                if (!this.f33317b) {
                    return bVar;
                }
                this.f33316a.removeCallbacks(bVar);
                return c.b();
            }
        }

        public void dispose() {
            this.f33317b = true;
            this.f33316a.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.f33317b;
        }
    }

    /* renamed from: io.b.a.b.b$b  reason: collision with other inner class name */
    private static final class C0514b implements io.b.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f33318a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f33319b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f33320c;

        C0514b(Handler handler, Runnable runnable) {
            this.f33318a = handler;
            this.f33319b = runnable;
        }

        public void run() {
            try {
                this.f33319b.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                io.b.g.a.a((Throwable) illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        public void dispose() {
            this.f33320c = true;
            this.f33318a.removeCallbacks(this);
        }

        public boolean isDisposed() {
            return this.f33320c;
        }
    }
}
