package com.c.a.g;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.c.a.c.b.o;
import com.c.a.g.a.d;
import com.c.a.i.i;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class e<R> implements b<R>, f<R>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final b f6187a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6188b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6189c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6190d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6191e;

    /* renamed from: f  reason: collision with root package name */
    private final b f6192f;

    /* renamed from: g  reason: collision with root package name */
    private R f6193g;
    private c h;
    private boolean i;
    private boolean j;
    private boolean k;
    private o l;

    public void a(Drawable drawable) {
    }

    public void b(Drawable drawable) {
    }

    public void b(d dVar) {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public e(Handler handler, int i2, int i3) {
        this(handler, i2, i3, true, f6187a);
    }

    e(Handler handler, int i2, int i3, boolean z, b bVar) {
        this.f6188b = handler;
        this.f6189c = i2;
        this.f6190d = i3;
        this.f6191e = z;
        this.f6192f = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000a
            r3 = 0
            monitor-exit(r2)
            return r3
        L_0x000a:
            r0 = 1
            r2.i = r0     // Catch:{ all -> 0x0019 }
            com.c.a.g.e$b r1 = r2.f6192f     // Catch:{ all -> 0x0019 }
            r1.a(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0017
            r2.b()     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r2)
            return r0
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.g.e.cancel(boolean):boolean");
    }

    public synchronized boolean isCancelled() {
        return this.i;
    }

    public synchronized boolean isDone() {
        return this.i || this.j || this.k;
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public R get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    public void a(d dVar) {
        dVar.a(this.f6189c, this.f6190d);
    }

    public void a(c cVar) {
        this.h = cVar;
    }

    public c a() {
        return this.h;
    }

    public synchronized void c(Drawable drawable) {
    }

    public synchronized void a(R r, com.c.a.g.b.b<? super R> bVar) {
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f6191e && !isDone()) {
            i.b();
        }
        if (this.i) {
            throw new CancellationException();
        } else if (this.k) {
            throw new ExecutionException(this.l);
        } else if (this.j) {
            return this.f6193g;
        } else {
            if (l2 == null) {
                this.f6192f.a(this, 0);
            } else if (l2.longValue() > 0) {
                this.f6192f.a(this, l2.longValue());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.k) {
                throw new a(this.l);
            } else if (this.i) {
                throw new CancellationException();
            } else if (this.j) {
                return this.f6193g;
            } else {
                throw new TimeoutException();
            }
        }
    }

    public void run() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.c();
            this.h = null;
        }
    }

    private void b() {
        this.f6188b.post(this);
    }

    public synchronized boolean onLoadFailed(o oVar, Object obj, com.c.a.g.a.e<R> eVar, boolean z) {
        this.k = true;
        this.l = oVar;
        this.f6192f.a(this);
        return false;
    }

    public synchronized boolean onResourceReady(R r, Object obj, com.c.a.g.a.e<R> eVar, com.c.a.c.a aVar, boolean z) {
        this.j = true;
        this.f6193g = r;
        this.f6192f.a(this);
        return false;
    }

    static class b {
        b() {
        }

        public void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        public void a(Object obj) {
            obj.notifyAll();
        }
    }

    private static class a extends ExecutionException {
        private final o cause;

        a(o oVar) {
            this.cause = oVar;
        }

        public void printStackTrace() {
            printStackTrace(System.err);
        }

        public void printStackTrace(PrintStream printStream) {
            super.printStackTrace(printStream);
            printStream.print("Caused by: ");
            this.cause.printStackTrace(printStream);
        }

        public void printStackTrace(PrintWriter printWriter) {
            super.printStackTrace(printWriter);
            printWriter.print("Caused by: ");
            this.cause.printStackTrace(printWriter);
        }
    }
}
