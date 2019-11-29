package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.a.d;
import com.bca.xco.widget.d.a.a.a.g;
import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.d.e;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class m {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f5082c = (!m.class.desiredAssertionStatus());

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f5083d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    final d f5084a;

    /* renamed from: b  reason: collision with root package name */
    boolean f5085b;

    /* renamed from: e  reason: collision with root package name */
    private final int f5086e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5087f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f5088g;
    private final Deque<com.bca.xco.widget.d.a.a.a.c> h;

    public m() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public m(int i, long j, TimeUnit timeUnit) {
        this.f5088g = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                L_0x0000:
                    com.bca.xco.widget.d.a.m r0 = com.bca.xco.widget.d.a.m.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.a((long) r1)
                    r2 = -1
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r0 = r0 - r2
                    com.bca.xco.widget.d.a.m r2 = com.bca.xco.widget.d.a.m.this
                    monitor-enter(r2)
                    com.bca.xco.widget.d.a.m r3 = com.bca.xco.widget.d.a.m.this     // Catch:{ InterruptedException -> 0x002b }
                    int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                    r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                    goto L_0x002b
                L_0x0029:
                    r0 = move-exception
                    goto L_0x002d
                L_0x002b:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    goto L_0x0000
                L_0x002d:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    goto L_0x0030
                L_0x002f:
                    throw r0
                L_0x0030:
                    goto L_0x002f
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.m.AnonymousClass1.run():void");
            }
        };
        this.h = new ArrayDeque();
        this.f5084a = new d();
        this.f5086e = i;
        this.f5087f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    /* access modifiers changed from: package-private */
    public com.bca.xco.widget.d.a.a.a.c a(h hVar, g gVar) {
        if (f5082c || Thread.holdsLock(this)) {
            for (com.bca.xco.widget.d.a.a.a.c next : this.h) {
                if (next.f4753g.size() < next.f4752f && hVar.equals(next.a().f5033a) && !next.h) {
                    gVar.a(next);
                    return next;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void a(com.bca.xco.widget.d.a.a.a.c cVar) {
        if (f5082c || Thread.holdsLock(this)) {
            if (!this.f5085b) {
                this.f5085b = true;
                f5083d.execute(this.f5088g);
            }
            this.h.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean b(com.bca.xco.widget.d.a.a.a.c cVar) {
        if (!f5082c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.h || this.f5086e == 0) {
            this.h.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public long a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            com.bca.xco.widget.d.a.a.a.c cVar = null;
            int i = 0;
            int i2 = 0;
            for (com.bca.xco.widget.d.a.a.a.c next : this.h) {
                if (a(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.i;
                    if (j3 > j2) {
                        cVar = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f5087f) {
                if (i <= this.f5086e) {
                    if (i > 0) {
                        long j4 = this.f5087f - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f5087f;
                        return j5;
                    } else {
                        this.f5085b = false;
                        return -1;
                    }
                }
            }
            this.h.remove(cVar);
            c.a(cVar.b());
            return 0;
        }
    }

    private int a(com.bca.xco.widget.d.a.a.a.c cVar, long j) {
        List<Reference<g>> list = cVar.f4753g;
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).get() != null) {
                i++;
            } else {
                e b2 = e.b();
                b2.a(5, "A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", (Throwable) null);
                list.remove(i);
                cVar.h = true;
                if (list.isEmpty()) {
                    cVar.i = j - this.f5087f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
