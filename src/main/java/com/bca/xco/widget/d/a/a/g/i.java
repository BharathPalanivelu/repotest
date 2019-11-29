package com.bca.xco.widget.d.a.a.g;

import com.bca.xco.widget.d.b.d;
import com.bca.xco.widget.d.b.e;
import com.bca.xco.widget.d.b.g;
import com.bca.xco.widget.d.b.s;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class i {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f4992d = (!i.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    long f4993a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f4994b;

    /* renamed from: c  reason: collision with root package name */
    final a f4995c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f4996e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final h f4997f;

    /* renamed from: g  reason: collision with root package name */
    private final List<d> f4998g;
    private List<d> h;
    private final b i;
    /* access modifiers changed from: private */
    public final c j = new c();
    /* access modifiers changed from: private */
    public final c k = new c();
    /* access modifiers changed from: private */
    public c l = null;

    i(int i2, h hVar, boolean z, boolean z2, List<d> list) {
        if (hVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f4996e = i2;
            this.f4997f = hVar;
            this.f4994b = (long) hVar.f4949e.d();
            this.i = new b((long) hVar.f4948d.d());
            this.f4995c = new a();
            boolean unused = this.i.f5010g = z2;
            boolean unused2 = this.f4995c.f5003e = z;
            this.f4998g = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    public int a() {
        return this.f4996e;
    }

    public synchronized boolean b() {
        if (this.l != null) {
            return false;
        }
        if ((this.i.f5010g || this.i.f5009f) && ((this.f4995c.f5003e || this.f4995c.f5002d) && this.h != null)) {
            return false;
        }
        return true;
    }

    public boolean c() {
        if (this.f4997f.f4945a == ((this.f4996e & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r2.j.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.bca.xco.widget.d.a.a.g.d> d() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.bca.xco.widget.d.a.a.g.i$c r0 = r2.j     // Catch:{ all -> 0x002e }
            r0.c()     // Catch:{ all -> 0x002e }
        L_0x0006:
            java.util.List<com.bca.xco.widget.d.a.a.g.d> r0 = r2.h     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0012
            com.bca.xco.widget.d.a.a.g.c r0 = r2.l     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0012
            r2.l()     // Catch:{ all -> 0x0027 }
            goto L_0x0006
        L_0x0012:
            com.bca.xco.widget.d.a.a.g.i$c r0 = r2.j     // Catch:{ all -> 0x002e }
            r0.b()     // Catch:{ all -> 0x002e }
            java.util.List<com.bca.xco.widget.d.a.a.g.d> r0 = r2.h     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x001f
            java.util.List<com.bca.xco.widget.d.a.a.g.d> r0 = r2.h     // Catch:{ all -> 0x002e }
            monitor-exit(r2)
            return r0
        L_0x001f:
            com.bca.xco.widget.d.a.a.g.n r0 = new com.bca.xco.widget.d.a.a.g.n     // Catch:{ all -> 0x002e }
            com.bca.xco.widget.d.a.a.g.c r1 = r2.l     // Catch:{ all -> 0x002e }
            r0.<init>(r1)     // Catch:{ all -> 0x002e }
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0027:
            r0 = move-exception
            com.bca.xco.widget.d.a.a.g.i$c r1 = r2.j     // Catch:{ all -> 0x002e }
            r1.b()     // Catch:{ all -> 0x002e }
            throw r0     // Catch:{ all -> 0x002e }
        L_0x002e:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0032
        L_0x0031:
            throw r0
        L_0x0032:
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.i.d():java.util.List");
    }

    public s e() {
        return this.j;
    }

    public s f() {
        return this.k;
    }

    public d g() {
        return this.i;
    }

    public com.bca.xco.widget.d.b.c h() {
        synchronized (this) {
            if (this.h == null) {
                if (!c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f4995c;
    }

    public void a(c cVar) {
        if (d(cVar)) {
            this.f4997f.b(this.f4996e, cVar);
        }
    }

    public void b(c cVar) {
        if (d(cVar)) {
            this.f4997f.a(this.f4996e, cVar);
        }
    }

    private boolean d(c cVar) {
        if (f4992d || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.l != null) {
                    return false;
                }
                if (this.i.f5010g && this.f4995c.f5003e) {
                    return false;
                }
                this.l = cVar;
                notifyAll();
                this.f4997f.b(this.f4996e);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void a(List<d> list) {
        if (f4992d || !Thread.holdsLock(this)) {
            boolean z = true;
            synchronized (this) {
                if (this.h == null) {
                    this.h = list;
                    z = b();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.h);
                    arrayList.addAll(list);
                    this.h = arrayList;
                }
            }
            if (!z) {
                this.f4997f.b(this.f4996e);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void a(com.bca.xco.widget.d.b.b bVar, int i2) {
        if (f4992d || !Thread.holdsLock(this)) {
            this.i.a(bVar, (long) i2);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (f4992d || !Thread.holdsLock(this)) {
            synchronized (this) {
                boolean unused = this.i.f5010g = true;
                b2 = b();
                notifyAll();
            }
            if (!b2) {
                this.f4997f.b(this.f4996e);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public synchronized void c(c cVar) {
        if (this.l == null) {
            this.l = cVar;
            notifyAll();
        }
    }

    private final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f5004a = (!i.class.desiredAssertionStatus());

        /* renamed from: c  reason: collision with root package name */
        private final g f5006c;

        /* renamed from: d  reason: collision with root package name */
        private final g f5007d;

        /* renamed from: e  reason: collision with root package name */
        private final long f5008e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f5009f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f5010g;

        private b(long j) {
            this.f5006c = new g();
            this.f5007d = new g();
            this.f5008e = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
            r10 = com.bca.xco.widget.d.a.a.g.i.a(r7.f5005b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            com.bca.xco.widget.d.a.a.g.i.a(r7.f5005b).f4946b += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008e, code lost:
            if (com.bca.xco.widget.d.a.a.g.i.a(r7.f5005b).f4946b < ((long) (com.bca.xco.widget.d.a.a.g.i.a(r7.f5005b).f4948d.d() / 2))) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0090, code lost:
            com.bca.xco.widget.d.a.a.g.i.a(r7.f5005b).a(0, com.bca.xco.widget.d.a.a.g.i.a(r7.f5005b).f4946b);
            com.bca.xco.widget.d.a.a.g.i.a(r7.f5005b).f4946b = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00aa, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ab, code lost:
            return r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long a(com.bca.xco.widget.d.b.g r8, long r9) {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x00b2
                com.bca.xco.widget.d.a.a.g.i r2 = com.bca.xco.widget.d.a.a.g.i.this
                monitor-enter(r2)
                r7.b()     // Catch:{ all -> 0x00af }
                r7.c()     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.b.g r3 = r7.f5007d     // Catch:{ all -> 0x00af }
                long r3 = r3.m()     // Catch:{ all -> 0x00af }
                int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r5 != 0) goto L_0x001d
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x00af }
                return r8
            L_0x001d:
                com.bca.xco.widget.d.b.g r3 = r7.f5007d     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.b.g r4 = r7.f5007d     // Catch:{ all -> 0x00af }
                long r4 = r4.m()     // Catch:{ all -> 0x00af }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x00af }
                long r8 = r3.a((com.bca.xco.widget.d.b.g) r8, (long) r9)     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.i r10 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00af }
                long r3 = r10.f4993a     // Catch:{ all -> 0x00af }
                long r3 = r3 + r8
                r10.f4993a = r3     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.i r10 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00af }
                long r3 = r10.f4993a     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.i r10 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.h r10 = r10.f4997f     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.m r10 = r10.f4948d     // Catch:{ all -> 0x00af }
                int r10 = r10.d()     // Catch:{ all -> 0x00af }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x00af }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x0062
                com.bca.xco.widget.d.a.a.g.i r10 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.h r10 = r10.f4997f     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.i r3 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00af }
                int r3 = r3.f4996e     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.i r4 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00af }
                long r4 = r4.f4993a     // Catch:{ all -> 0x00af }
                r10.a((int) r3, (long) r4)     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.i r10 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00af }
                r10.f4993a = r0     // Catch:{ all -> 0x00af }
            L_0x0062:
                monitor-exit(r2)     // Catch:{ all -> 0x00af }
                com.bca.xco.widget.d.a.a.g.i r10 = com.bca.xco.widget.d.a.a.g.i.this
                com.bca.xco.widget.d.a.a.g.h r10 = r10.f4997f
                monitor-enter(r10)
                com.bca.xco.widget.d.a.a.g.i r2 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.h r2 = r2.f4997f     // Catch:{ all -> 0x00ac }
                long r3 = r2.f4946b     // Catch:{ all -> 0x00ac }
                long r3 = r3 + r8
                r2.f4946b = r3     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.i r2 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.h r2 = r2.f4997f     // Catch:{ all -> 0x00ac }
                long r2 = r2.f4946b     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.i r4 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.h r4 = r4.f4997f     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.m r4 = r4.f4948d     // Catch:{ all -> 0x00ac }
                int r4 = r4.d()     // Catch:{ all -> 0x00ac }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x00ac }
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x00aa
                com.bca.xco.widget.d.a.a.g.i r2 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.h r2 = r2.f4997f     // Catch:{ all -> 0x00ac }
                r3 = 0
                com.bca.xco.widget.d.a.a.g.i r4 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.h r4 = r4.f4997f     // Catch:{ all -> 0x00ac }
                long r4 = r4.f4946b     // Catch:{ all -> 0x00ac }
                r2.a((int) r3, (long) r4)     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.i r2 = com.bca.xco.widget.d.a.a.g.i.this     // Catch:{ all -> 0x00ac }
                com.bca.xco.widget.d.a.a.g.h r2 = r2.f4997f     // Catch:{ all -> 0x00ac }
                r2.f4946b = r0     // Catch:{ all -> 0x00ac }
            L_0x00aa:
                monitor-exit(r10)     // Catch:{ all -> 0x00ac }
                return r8
            L_0x00ac:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00ac }
                throw r8
            L_0x00af:
                r8 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00af }
                throw r8
            L_0x00b2:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.i.b.a(com.bca.xco.widget.d.b.g, long):long");
        }

        private void b() {
            i.this.j.c();
            while (this.f5007d.m() == 0 && !this.f5010g && !this.f5009f && i.this.l == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.j.b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(com.bca.xco.widget.d.b.b bVar, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            if (f5004a || !Thread.holdsLock(i.this)) {
                while (j > 0) {
                    synchronized (i.this) {
                        z = this.f5010g;
                        z2 = true;
                        z3 = this.f5007d.m() + j > this.f5008e;
                    }
                    if (z3) {
                        bVar.d(j);
                        i.this.b(c.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bVar.d(j);
                        return;
                    } else {
                        long a2 = bVar.a(this.f5006c, j);
                        if (a2 != -1) {
                            j -= a2;
                            synchronized (i.this) {
                                if (this.f5007d.m() != 0) {
                                    z2 = false;
                                }
                                this.f5007d.a((d) this.f5006c);
                                if (z2) {
                                    i.this.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public s a() {
            return i.this.j;
        }

        public void close() {
            synchronized (i.this) {
                this.f5009f = true;
                this.f5007d.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        private void c() {
            if (this.f5009f) {
                throw new IOException("stream closed");
            } else if (i.this.l != null) {
                throw new n(i.this.l);
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        boolean z;
        boolean b2;
        if (f4992d || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.i.f5010g && this.i.f5009f && (this.f4995c.f5003e || this.f4995c.f5002d);
                b2 = b();
            }
            if (z) {
                a(c.CANCEL);
            } else if (!b2) {
                this.f4997f.b(this.f4996e);
            }
        } else {
            throw new AssertionError();
        }
    }

    final class a implements com.bca.xco.widget.d.b.c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f4999a = (!i.class.desiredAssertionStatus());

        /* renamed from: c  reason: collision with root package name */
        private final g f5001c = new g();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f5002d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f5003e;

        a() {
        }

        public void a_(g gVar, long j) {
            if (f4999a || !Thread.holdsLock(i.this)) {
                this.f5001c.a_(gVar, j);
                while (this.f5001c.m() >= IjkMediaMeta.AV_CH_TOP_FRONT_RIGHT) {
                    a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        private void a(boolean z) {
            long min;
            synchronized (i.this) {
                i.this.k.c();
                while (i.this.f4994b <= 0 && !this.f5003e && !this.f5002d && i.this.l == null) {
                    try {
                        i.this.l();
                    } catch (Throwable th) {
                        i.this.k.b();
                        throw th;
                    }
                }
                i.this.k.b();
                i.this.k();
                min = Math.min(i.this.f4994b, this.f5001c.m());
                i.this.f4994b -= min;
            }
            i.this.k.c();
            try {
                i.this.f4997f.a(i.this.f4996e, z && min == this.f5001c.m(), this.f5001c, min);
            } finally {
                i.this.k.b();
            }
        }

        public void flush() {
            if (f4999a || !Thread.holdsLock(i.this)) {
                synchronized (i.this) {
                    i.this.k();
                }
                while (this.f5001c.m() > 0) {
                    a(false);
                    i.this.f4997f.b();
                }
                return;
            }
            throw new AssertionError();
        }

        public s a() {
            return i.this.k;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f5000b.f4995c.f5003e != false) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
            if (r8.f5001c.m() <= 0) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r8.f5001c.m() <= 0) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            com.bca.xco.widget.d.a.a.g.i.a(r8.f5000b).a(com.bca.xco.widget.d.a.a.g.i.b(r8.f5000b), true, (com.bca.xco.widget.d.b.g) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
            r2 = r8.f5000b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f5002d = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
            com.bca.xco.widget.d.a.a.g.i.a(r8.f5000b).b();
            com.bca.xco.widget.d.a.a.g.i.f(r8.f5000b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r8 = this;
                boolean r0 = f4999a
                if (r0 != 0) goto L_0x0013
                com.bca.xco.widget.d.a.a.g.i r0 = com.bca.xco.widget.d.a.a.g.i.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 != 0) goto L_0x000d
                goto L_0x0013
            L_0x000d:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0013:
                com.bca.xco.widget.d.a.a.g.i r0 = com.bca.xco.widget.d.a.a.g.i.this
                monitor-enter(r0)
                boolean r1 = r8.f5002d     // Catch:{ all -> 0x006b }
                if (r1 == 0) goto L_0x001c
                monitor-exit(r0)     // Catch:{ all -> 0x006b }
                return
            L_0x001c:
                monitor-exit(r0)     // Catch:{ all -> 0x006b }
                com.bca.xco.widget.d.a.a.g.i r0 = com.bca.xco.widget.d.a.a.g.i.this
                com.bca.xco.widget.d.a.a.g.i$a r0 = r0.f4995c
                boolean r0 = r0.f5003e
                r1 = 1
                if (r0 != 0) goto L_0x0053
                com.bca.xco.widget.d.b.g r0 = r8.f5001c
                long r2 = r0.m()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0040
            L_0x0032:
                com.bca.xco.widget.d.b.g r0 = r8.f5001c
                long r2 = r0.m()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0053
                r8.a((boolean) r1)
                goto L_0x0032
            L_0x0040:
                com.bca.xco.widget.d.a.a.g.i r0 = com.bca.xco.widget.d.a.a.g.i.this
                com.bca.xco.widget.d.a.a.g.h r2 = r0.f4997f
                com.bca.xco.widget.d.a.a.g.i r0 = com.bca.xco.widget.d.a.a.g.i.this
                int r3 = r0.f4996e
                r4 = 1
                r5 = 0
                r6 = 0
                r2.a((int) r3, (boolean) r4, (com.bca.xco.widget.d.b.g) r5, (long) r6)
            L_0x0053:
                com.bca.xco.widget.d.a.a.g.i r2 = com.bca.xco.widget.d.a.a.g.i.this
                monitor-enter(r2)
                r8.f5002d = r1     // Catch:{ all -> 0x0068 }
                monitor-exit(r2)     // Catch:{ all -> 0x0068 }
                com.bca.xco.widget.d.a.a.g.i r0 = com.bca.xco.widget.d.a.a.g.i.this
                com.bca.xco.widget.d.a.a.g.h r0 = r0.f4997f
                r0.b()
                com.bca.xco.widget.d.a.a.g.i r0 = com.bca.xco.widget.d.a.a.g.i.this
                r0.j()
                return
            L_0x0068:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0068 }
                throw r0
            L_0x006b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x006b }
                goto L_0x006f
            L_0x006e:
                throw r1
            L_0x006f:
                goto L_0x006e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.i.a.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.f4994b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        if (this.f4995c.f5002d) {
            throw new IOException("stream closed");
        } else if (!this.f4995c.f5003e) {
            c cVar = this.l;
            if (cVar != null) {
                throw new n(cVar);
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class c extends e {
        c() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            i.this.b(c.CANCEL);
        }

        /* access modifiers changed from: protected */
        public IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void b() {
            if (d()) {
                throw a((IOException) null);
            }
        }
    }
}
