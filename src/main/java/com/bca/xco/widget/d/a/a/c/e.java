package com.bca.xco.widget.d.a.a.c;

import com.bca.xco.widget.d.b.c;
import com.bca.xco.widget.d.b.g;
import com.bca.xco.widget.d.b.s;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class e implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f4818a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f4819b = (!e.class.desiredAssertionStatus());
    private static final c p = new c() {
        public void close() {
        }

        public void flush() {
        }

        public void a_(g gVar, long j) {
            gVar.d(j);
        }

        public s a() {
            return s.f5255b;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.bca.xco.widget.d.a.a.h.a f4820c;

    /* renamed from: d  reason: collision with root package name */
    private long f4821d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f4822e;

    /* renamed from: f  reason: collision with root package name */
    private long f4823f;

    /* renamed from: g  reason: collision with root package name */
    private com.bca.xco.widget.d.b.a f4824g;
    private final LinkedHashMap<String, b> h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private final Executor n;
    private final Runnable o;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0111, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bca.xco.widget.d.a.a.c.e.a r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bca.xco.widget.d.a.a.c.e$b r0 = r10.f4826b     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.a.a.c.e$a r1 = r0.f4834f     // Catch:{ all -> 0x0118 }
            if (r1 != r10) goto L_0x0112
            r1 = 0
            if (r11 == 0) goto L_0x0051
            boolean r2 = r0.f4833e     // Catch:{ all -> 0x0118 }
            if (r2 != 0) goto L_0x0051
            r2 = 0
        L_0x0015:
            int r3 = r9.f4822e     // Catch:{ all -> 0x0118 }
            if (r2 >= r3) goto L_0x0051
            boolean[] r3 = r10.f4827c     // Catch:{ all -> 0x0118 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0037
            com.bca.xco.widget.d.a.a.h.a r3 = r9.f4820c     // Catch:{ all -> 0x0118 }
            java.io.File[] r4 = r0.f4832d     // Catch:{ all -> 0x0118 }
            r4 = r4[r2]     // Catch:{ all -> 0x0118 }
            boolean r3 = r3.b(r4)     // Catch:{ all -> 0x0118 }
            if (r3 != 0) goto L_0x0034
            r10.b()     // Catch:{ all -> 0x0118 }
            monitor-exit(r9)
            return
        L_0x0034:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0037:
            r10.b()     // Catch:{ all -> 0x0118 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0118 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r11.<init>()     // Catch:{ all -> 0x0118 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0118 }
            r11.append(r2)     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0118 }
            r10.<init>(r11)     // Catch:{ all -> 0x0118 }
            throw r10     // Catch:{ all -> 0x0118 }
        L_0x0051:
            int r10 = r9.f4822e     // Catch:{ all -> 0x0118 }
            if (r1 >= r10) goto L_0x0091
            java.io.File[] r10 = r0.f4832d     // Catch:{ all -> 0x0118 }
            r10 = r10[r1]     // Catch:{ all -> 0x0118 }
            if (r11 == 0) goto L_0x0089
            com.bca.xco.widget.d.a.a.h.a r2 = r9.f4820c     // Catch:{ all -> 0x0118 }
            boolean r2 = r2.b(r10)     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x008e
            java.io.File[] r2 = r0.f4831c     // Catch:{ all -> 0x0118 }
            r2 = r2[r1]     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.a.a.h.a r3 = r9.f4820c     // Catch:{ all -> 0x0118 }
            r3.a(r10, r2)     // Catch:{ all -> 0x0118 }
            long[] r10 = r0.f4830b     // Catch:{ all -> 0x0118 }
            r3 = r10[r1]     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.a.a.h.a r10 = r9.f4820c     // Catch:{ all -> 0x0118 }
            long r5 = r10.c(r2)     // Catch:{ all -> 0x0118 }
            long[] r10 = r0.f4830b     // Catch:{ all -> 0x0118 }
            r10[r1] = r5     // Catch:{ all -> 0x0118 }
            long r7 = r9.f4823f     // Catch:{ all -> 0x0118 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f4823f = r7     // Catch:{ all -> 0x0118 }
            goto L_0x008e
        L_0x0089:
            com.bca.xco.widget.d.a.a.h.a r2 = r9.f4820c     // Catch:{ all -> 0x0118 }
            r2.a(r10)     // Catch:{ all -> 0x0118 }
        L_0x008e:
            int r1 = r1 + 1
            goto L_0x0051
        L_0x0091:
            int r10 = r9.i     // Catch:{ all -> 0x0118 }
            r1 = 1
            int r10 = r10 + r1
            r9.i = r10     // Catch:{ all -> 0x0118 }
            r10 = 0
            com.bca.xco.widget.d.a.a.c.e.a unused = r0.f4834f = r10     // Catch:{ all -> 0x0118 }
            boolean r10 = r0.f4833e     // Catch:{ all -> 0x0118 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00d4
            boolean unused = r0.f4833e = r1     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = "CLEAN"
            com.bca.xco.widget.d.b.a r10 = r10.a((java.lang.String) r1)     // Catch:{ all -> 0x0118 }
            r10.a((int) r3)     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            java.lang.String r1 = r0.f4829a     // Catch:{ all -> 0x0118 }
            r10.a((java.lang.String) r1)     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            r0.a((com.bca.xco.widget.d.b.a) r10)     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            r10.a((int) r2)     // Catch:{ all -> 0x0118 }
            if (r11 == 0) goto L_0x00f6
            long r10 = r9.m     // Catch:{ all -> 0x0118 }
            r1 = 1
            long r1 = r1 + r10
            r9.m = r1     // Catch:{ all -> 0x0118 }
            long unused = r0.f4835g = r10     // Catch:{ all -> 0x0118 }
            goto L_0x00f6
        L_0x00d4:
            java.util.LinkedHashMap<java.lang.String, com.bca.xco.widget.d.a.a.c.e$b> r10 = r9.h     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = r0.f4829a     // Catch:{ all -> 0x0118 }
            r10.remove(r11)     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = "REMOVE"
            com.bca.xco.widget.d.b.a r10 = r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0118 }
            r10.a((int) r3)     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            java.lang.String r11 = r0.f4829a     // Catch:{ all -> 0x0118 }
            r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0118 }
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            r10.a((int) r2)     // Catch:{ all -> 0x0118 }
        L_0x00f6:
            com.bca.xco.widget.d.b.a r10 = r9.f4824g     // Catch:{ all -> 0x0118 }
            r10.flush()     // Catch:{ all -> 0x0118 }
            long r10 = r9.f4823f     // Catch:{ all -> 0x0118 }
            long r0 = r9.f4821d     // Catch:{ all -> 0x0118 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0109
            boolean r10 = r9.b()     // Catch:{ all -> 0x0118 }
            if (r10 == 0) goto L_0x0110
        L_0x0109:
            java.util.concurrent.Executor r10 = r9.n     // Catch:{ all -> 0x0118 }
            java.lang.Runnable r11 = r9.o     // Catch:{ all -> 0x0118 }
            r10.execute(r11)     // Catch:{ all -> 0x0118 }
        L_0x0110:
            monitor-exit(r9)
            return
        L_0x0112:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0118 }
            r10.<init>()     // Catch:{ all -> 0x0118 }
            throw r10     // Catch:{ all -> 0x0118 }
        L_0x0118:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x011c
        L_0x011b:
            throw r10
        L_0x011c:
            goto L_0x011b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.c.e.a(com.bca.xco.widget.d.a.a.c.e$a, boolean):void");
    }

    private boolean b() {
        int i2 = this.i;
        return i2 >= 2000 && i2 >= this.h.size();
    }

    private boolean a(b bVar) {
        if (bVar.f4834f != null) {
            bVar.f4834f.a();
        }
        for (int i2 = 0; i2 < this.f4822e; i2++) {
            this.f4820c.a(bVar.f4831c[i2]);
            this.f4823f -= bVar.f4830b[i2];
            bVar.f4830b[i2] = 0;
        }
        this.i++;
        this.f4824g.a("REMOVE").a(32).a(bVar.f4829a).a(10);
        this.h.remove(bVar.f4829a);
        if (b()) {
            this.n.execute(this.o);
        }
        return true;
    }

    public synchronized boolean a() {
        return this.k;
    }

    private synchronized void c() {
        if (a()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() {
        if (this.j) {
            c();
            d();
            this.f4824g.flush();
        }
    }

    public synchronized void close() {
        if (this.j) {
            if (!this.k) {
                for (b bVar : (b[]) this.h.values().toArray(new b[this.h.size()])) {
                    if (bVar.f4834f != null) {
                        bVar.f4834f.b();
                    }
                }
                d();
                this.f4824g.close();
                this.f4824g = null;
                this.k = true;
                return;
            }
        }
        this.k = true;
    }

    private void d() {
        while (this.f4823f > this.f4821d) {
            a(this.h.values().iterator().next());
        }
        this.l = false;
    }

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f4825a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final b f4826b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f4827c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4828d;

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f4826b.f4834f == this) {
                for (int i = 0; i < this.f4825a.f4822e; i++) {
                    try {
                        this.f4825a.f4820c.a(this.f4826b.f4832d[i]);
                    } catch (IOException unused) {
                    }
                }
                a unused2 = this.f4826b.f4834f = null;
            }
        }

        public void b() {
            synchronized (this.f4825a) {
                if (!this.f4828d) {
                    if (this.f4826b.f4834f == this) {
                        this.f4825a.a(this, false);
                    }
                    this.f4828d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    private final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f4829a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long[] f4830b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final File[] f4831c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final File[] f4832d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f4833e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public a f4834f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f4835g;

        /* access modifiers changed from: package-private */
        public void a(com.bca.xco.widget.d.b.a aVar) {
            for (long a2 : this.f4830b) {
                aVar.a(32).a(a2);
            }
        }
    }
}
