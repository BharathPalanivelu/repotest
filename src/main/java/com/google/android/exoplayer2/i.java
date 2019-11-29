package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.q.g;
import com.google.android.exoplayer2.q.h;
import com.google.android.exoplayer2.s.q;
import com.google.android.exoplayer2.s.t;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;

final class i implements Handler.Callback, h.a, h.a, i.a {
    private long A;
    private int B;
    private c C;
    private long D;
    private a E;
    private a F;
    private a G;
    private x H;

    /* renamed from: a  reason: collision with root package name */
    private final s[] f9926a;

    /* renamed from: b  reason: collision with root package name */
    private final t[] f9927b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.q.h f9928c;

    /* renamed from: d  reason: collision with root package name */
    private final n f9929d;

    /* renamed from: e  reason: collision with root package name */
    private final q f9930e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f9931f;

    /* renamed from: g  reason: collision with root package name */
    private final HandlerThread f9932g;
    private final Handler h;
    private final f i;
    private final x.b j;
    private final x.a k;
    private final o l;
    private b m;
    private q n;
    private s o;
    private com.google.android.exoplayer2.s.h p;
    private com.google.android.exoplayer2.source.i q;
    private s[] r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w = 1;
    private int x;
    private int y;
    private int z;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final i.b f9964a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9965b;

        /* renamed from: c  reason: collision with root package name */
        public final long f9966c;

        /* renamed from: d  reason: collision with root package name */
        public volatile long f9967d;

        /* renamed from: e  reason: collision with root package name */
        public volatile long f9968e;

        public b(int i, long j) {
            this(new i.b(i), j);
        }

        public b(i.b bVar, long j) {
            this(bVar, j, -9223372036854775807L);
        }

        public b(i.b bVar, long j, long j2) {
            this.f9964a = bVar;
            this.f9965b = j;
            this.f9966c = j2;
            this.f9967d = j;
            this.f9968e = j;
        }

        public b a(int i) {
            b bVar = new b(this.f9964a.a(i), this.f9965b, this.f9966c);
            bVar.f9967d = this.f9967d;
            bVar.f9968e = this.f9968e;
            return bVar;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final x f10034a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f10035b;

        /* renamed from: c  reason: collision with root package name */
        public final b f10036c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10037d;

        public d(x xVar, Object obj, b bVar, int i) {
            this.f10034a = xVar;
            this.f10035b = obj;
            this.f10036c = bVar;
            this.f10037d = i;
        }
    }

    public i(s[] sVarArr, com.google.android.exoplayer2.q.h hVar, n nVar, boolean z2, int i2, Handler handler, b bVar, f fVar) {
        this.f9926a = sVarArr;
        this.f9928c = hVar;
        this.f9929d = nVar;
        this.t = z2;
        this.x = i2;
        this.h = handler;
        this.m = bVar;
        this.i = fVar;
        this.f9927b = new t[sVarArr.length];
        for (int i3 = 0; i3 < sVarArr.length; i3++) {
            sVarArr[i3].a(i3);
            this.f9927b[i3] = sVarArr[i3].b();
        }
        this.f9930e = new q();
        this.r = new s[0];
        this.j = new x.b();
        this.k = new x.a();
        this.l = new o();
        hVar.a((h.a) this);
        this.n = q.f11236a;
        this.f9932g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f9932g.start();
        this.f9931f = new Handler(this.f9932g.getLooper(), this);
    }

    public void a(com.google.android.exoplayer2.source.i iVar, boolean z2) {
        this.f9931f.obtainMessage(0, z2 ? 1 : 0, 0, iVar).sendToTarget();
    }

    public void a(boolean z2) {
        this.f9931f.obtainMessage(1, z2 ? 1 : 0, 0).sendToTarget();
    }

    public void a(x xVar, int i2, long j2) {
        this.f9931f.obtainMessage(3, new c(xVar, i2, j2)).sendToTarget();
    }

    public void a(f.b... bVarArr) {
        if (this.s) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.y++;
        this.f9931f.obtainMessage(11, bVarArr).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.google.android.exoplayer2.f.b... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.s     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.y     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.y = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.f9931f     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.z     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0035
        L_0x0034:
            throw r4
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.b(com.google.android.exoplayer2.f$b[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.s     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.f9931f     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.s     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.f9932g     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0028
        L_0x0027:
            throw r0
        L_0x0028:
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.a():void");
    }

    public void a(x xVar, Object obj) {
        this.f9931f.obtainMessage(7, Pair.create(xVar, obj)).sendToTarget();
    }

    public void a(com.google.android.exoplayer2.source.h hVar) {
        this.f9931f.obtainMessage(8, hVar).sendToTarget();
    }

    /* renamed from: b */
    public void a(com.google.android.exoplayer2.source.h hVar) {
        this.f9931f.obtainMessage(9, hVar).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        try {
            boolean z2 = false;
            switch (message.what) {
                case 0:
                    com.google.android.exoplayer2.source.i iVar = (com.google.android.exoplayer2.source.i) message.obj;
                    if (message.arg1 != 0) {
                        z2 = true;
                    }
                    b(iVar, z2);
                    return true;
                case 1:
                    if (message.arg1 != 0) {
                        z2 = true;
                    }
                    c(z2);
                    return true;
                case 2:
                    e();
                    return true;
                case 3:
                    a((c) message.obj);
                    return true;
                case 4:
                    a((q) message.obj);
                    return true;
                case 5:
                    f();
                    return true;
                case 6:
                    g();
                    return true;
                case 7:
                    a((Pair<x, Object>) (Pair) message.obj);
                    return true;
                case 8:
                    c((com.google.android.exoplayer2.source.h) message.obj);
                    return true;
                case 9:
                    d((com.google.android.exoplayer2.source.h) message.obj);
                    return true;
                case 10:
                    h();
                    return true;
                case 11:
                    c((f.b[]) message.obj);
                    return true;
                case 12:
                    b(message.arg1);
                    return true;
                default:
                    return false;
            }
        } catch (e e2) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e2);
            this.h.obtainMessage(8, e2).sendToTarget();
            f();
            return true;
        } catch (IOException e3) {
            Log.e("ExoPlayerImplInternal", "Source error.", e3);
            this.h.obtainMessage(8, e.a(e3)).sendToTarget();
            f();
            return true;
        } catch (RuntimeException e4) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e4);
            this.h.obtainMessage(8, e.a(e4)).sendToTarget();
            f();
            return true;
        }
    }

    private void a(int i2) {
        if (this.w != i2) {
            this.w = i2;
            this.h.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    private void b(boolean z2) {
        if (this.v != z2) {
            this.v = z2;
            this.h.obtainMessage(2, z2 ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(com.google.android.exoplayer2.source.i iVar, boolean z2) {
        this.h.sendEmptyMessage(0);
        d(true);
        this.f9929d.a();
        if (z2) {
            this.m = new b(0, -9223372036854775807L);
        }
        this.q = iVar;
        iVar.a(this.i, true, this);
        a(2);
        this.f9931f.sendEmptyMessage(2);
    }

    private void c(boolean z2) throws e {
        this.u = false;
        this.t = z2;
        if (!z2) {
            c();
            d();
            return;
        }
        int i2 = this.w;
        if (i2 == 3) {
            b();
            this.f9931f.sendEmptyMessage(2);
        } else if (i2 == 2) {
            this.f9931f.sendEmptyMessage(2);
        }
    }

    private void b(int i2) throws e {
        this.x = i2;
        this.l.a(i2);
        a aVar = this.G;
        if (aVar == null) {
            aVar = this.E;
        }
        if (aVar != null) {
            while (true) {
                int a2 = this.H.a(aVar.f9939g.f10987a.f12083b, this.k, this.j, i2);
                while (aVar.j != null && !aVar.f9939g.f10992f) {
                    aVar = aVar.j;
                }
                if (a2 == -1 || aVar.j == null || aVar.j.f9939g.f10987a.f12083b != a2) {
                    int i3 = this.E.f9935c;
                    a aVar2 = this.F;
                } else {
                    aVar = aVar.j;
                }
            }
            int i32 = this.E.f9935c;
            a aVar22 = this.F;
            int i4 = aVar22 != null ? aVar22.f9935c : -1;
            if (aVar.j != null) {
                a(aVar.j);
                aVar.j = null;
            }
            aVar.f9939g = this.l.a(aVar.f9939g);
            boolean z2 = true;
            if (!(i32 <= aVar.f9935c)) {
                this.E = aVar;
            }
            if (i4 == -1 || i4 > aVar.f9935c) {
                z2 = false;
            }
            if (!z2) {
                a aVar3 = this.G;
                if (aVar3 != null) {
                    i.b bVar = aVar3.f9939g.f10987a;
                    this.m = new b(bVar, a(bVar, this.m.f9967d), this.m.f9966c);
                }
            }
        }
    }

    private void b() throws e {
        this.u = false;
        this.f9930e.a();
        for (s e2 : this.r) {
            e2.e();
        }
    }

    private void c() throws e {
        this.f9930e.b();
        for (s a2 : this.r) {
            a(a2);
        }
    }

    private void d() throws e {
        long j2;
        a aVar = this.G;
        if (aVar != null) {
            long c2 = aVar.f9933a.c();
            if (c2 != -9223372036854775807L) {
                a(c2);
            } else {
                s sVar = this.o;
                if (sVar == null || sVar.u()) {
                    this.D = this.f9930e.w();
                } else {
                    this.D = this.p.w();
                    this.f9930e.a(this.D);
                }
                c2 = this.G.b(this.D);
            }
            this.m.f9967d = c2;
            this.A = SystemClock.elapsedRealtime() * 1000;
            if (this.r.length == 0) {
                j2 = Long.MIN_VALUE;
            } else {
                j2 = this.G.f9933a.d();
            }
            b bVar = this.m;
            if (j2 == Long.MIN_VALUE) {
                j2 = this.G.f9939g.f10991e;
            }
            bVar.f9968e = j2;
        }
    }

    private void e() throws e, IOException {
        boolean z2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        j();
        if (this.G == null) {
            i();
            a(elapsedRealtime, 10);
            return;
        }
        t.a("doSomeWork");
        d();
        this.G.f9933a.a(this.m.f9967d);
        boolean z3 = true;
        boolean z4 = true;
        for (s sVar : this.r) {
            sVar.a(this.D, this.A);
            z4 = z4 && sVar.u();
            boolean z5 = sVar.t() || sVar.u();
            if (!z5) {
                sVar.j();
            }
            z3 = z3 && z5;
        }
        if (!z3) {
            i();
        }
        com.google.android.exoplayer2.s.h hVar = this.p;
        if (hVar != null) {
            q x2 = hVar.x();
            if (!x2.equals(this.n)) {
                this.n = x2;
                this.f9930e.a(this.p);
                this.h.obtainMessage(7, x2).sendToTarget();
            }
        }
        long j2 = this.G.f9939g.f10991e;
        if (!z4 || ((j2 != -9223372036854775807L && j2 > this.m.f9967d) || !this.G.f9939g.f10993g)) {
            int i2 = this.w;
            if (i2 == 2) {
                if (this.r.length > 0) {
                    z2 = z3 && this.E.a(this.u, this.D);
                } else {
                    z2 = b(j2);
                }
                if (z2) {
                    a(3);
                    if (this.t) {
                        b();
                    }
                }
            } else if (i2 == 3) {
                if (this.r.length <= 0) {
                    z3 = b(j2);
                }
                if (!z3) {
                    this.u = this.t;
                    a(2);
                    c();
                }
            }
        } else {
            a(4);
            c();
        }
        if (this.w == 2) {
            for (s j3 : this.r) {
                j3.j();
            }
        }
        if (!this.t || this.w != 3) {
            int i3 = this.w;
            if (i3 != 2) {
                if (this.r.length == 0 || i3 == 4) {
                    this.f9931f.removeMessages(2);
                } else {
                    a(elapsedRealtime, 1000);
                }
                t.a();
            }
        }
        a(elapsedRealtime, 10);
        t.a();
    }

    private void a(long j2, long j3) {
        this.f9931f.removeMessages(2);
        long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f9931f.sendEmptyMessage(2);
        } else {
            this.f9931f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private void a(c cVar) throws e {
        long j2;
        int i2;
        c cVar2 = cVar;
        int i3 = 1;
        if (this.H == null) {
            this.B++;
            this.C = cVar2;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            this.m = new b(0, 0);
            this.h.obtainMessage(4, 1, 0, this.m).sendToTarget();
            this.m = new b(0, -9223372036854775807L);
            a(4);
            d(false);
            return;
        }
        int i4 = cVar2.f10008c == -9223372036854775807L ? 1 : 0;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        i.b a2 = this.l.a(intValue, longValue);
        if (a2.a()) {
            j2 = 0;
            i2 = 1;
        } else {
            i2 = i4;
            j2 = longValue;
        }
        try {
            if (!a2.equals(this.m.f9964a) || j2 / 1000 != this.m.f9967d / 1000) {
                long a3 = a(a2, j2);
                int i5 = (j2 != a3 ? 1 : 0) | i2;
                this.m = new b(a2, a3, longValue);
                Handler handler = this.h;
                if (i5 == 0) {
                    i3 = 0;
                }
                handler.obtainMessage(4, i3, 0, this.m).sendToTarget();
            }
        } finally {
            this.m = new b(a2, j2, longValue);
            this.h.obtainMessage(4, i2, 0, this.m).sendToTarget();
        }
    }

    private long a(i.b bVar, long j2) throws e {
        a aVar;
        c();
        this.u = false;
        a(2);
        a aVar2 = this.G;
        if (aVar2 == null) {
            a aVar3 = this.E;
            if (aVar3 != null) {
                aVar3.e();
            }
            aVar = null;
        } else {
            aVar = null;
            while (aVar2 != null) {
                if (a(bVar, j2, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.e();
                }
                aVar2 = aVar2.j;
            }
        }
        a aVar4 = this.G;
        if (!(aVar4 == aVar && aVar4 == this.F)) {
            for (s l2 : this.r) {
                l2.l();
            }
            this.r = new s[0];
            this.p = null;
            this.o = null;
            this.G = null;
        }
        if (aVar != null) {
            aVar.j = null;
            this.E = aVar;
            this.F = aVar;
            b(aVar);
            if (this.G.i) {
                j2 = this.G.f9933a.b(j2);
            }
            a(j2);
            l();
        } else {
            this.E = null;
            this.F = null;
            this.G = null;
            a(j2);
        }
        this.f9931f.sendEmptyMessage(2);
        return j2;
    }

    private boolean a(i.b bVar, long j2, a aVar) {
        if (!bVar.equals(aVar.f9939g.f10987a) || !aVar.h) {
            return false;
        }
        this.H.a(aVar.f9939g.f10987a.f12083b, this.k);
        int b2 = this.k.b(j2);
        return b2 == -1 || this.k.a(b2) == aVar.f9939g.f10989c;
    }

    private void a(long j2) throws e {
        long j3;
        a aVar = this.G;
        if (aVar == null) {
            j3 = j2 + 60000000;
        } else {
            j3 = aVar.a(j2);
        }
        this.D = j3;
        this.f9930e.a(this.D);
        for (s a2 : this.r) {
            a2.a(this.D);
        }
    }

    private void a(q qVar) {
        q qVar2;
        com.google.android.exoplayer2.s.h hVar = this.p;
        if (hVar != null) {
            qVar2 = hVar.a(qVar);
        } else {
            qVar2 = this.f9930e.a(qVar);
        }
        this.n = qVar2;
        this.h.obtainMessage(7, qVar2).sendToTarget();
    }

    private void f() {
        d(true);
        this.f9929d.b();
        a(1);
    }

    private void g() {
        d(true);
        this.f9929d.c();
        a(1);
        synchronized (this) {
            this.s = true;
            notifyAll();
        }
    }

    private void d(boolean z2) {
        this.f9931f.removeMessages(2);
        this.u = false;
        this.f9930e.b();
        this.p = null;
        this.o = null;
        this.D = 60000000;
        for (s sVar : this.r) {
            try {
                a(sVar);
                sVar.l();
            } catch (e | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.r = new s[0];
        a aVar = this.G;
        if (aVar == null) {
            aVar = this.E;
        }
        a(aVar);
        this.E = null;
        this.F = null;
        this.G = null;
        b(false);
        if (z2) {
            com.google.android.exoplayer2.source.i iVar = this.q;
            if (iVar != null) {
                iVar.b();
                this.q = null;
            }
            this.l.a((x) null);
            this.H = null;
        }
    }

    private void c(f.b[] bVarArr) throws e {
        try {
            for (f.b bVar : bVarArr) {
                bVar.f9788a.a(bVar.f9789b, bVar.f9790c);
            }
            if (this.w == 3 || this.w == 2) {
                this.f9931f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.z++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.z++;
                notifyAll();
                throw th;
            }
        }
    }

    private void a(s sVar) throws e {
        if (sVar.d() == 2) {
            sVar.k();
        }
    }

    private void h() throws e {
        a aVar = this.G;
        if (aVar != null) {
            boolean z2 = true;
            while (aVar != null && aVar.h) {
                if (aVar.d()) {
                    if (z2) {
                        boolean z3 = this.F != this.G;
                        a(this.G.j);
                        a aVar2 = this.G;
                        aVar2.j = null;
                        this.E = aVar2;
                        this.F = aVar2;
                        boolean[] zArr = new boolean[this.f9926a.length];
                        long a2 = aVar2.a(this.m.f9967d, z3, zArr);
                        if (a2 != this.m.f9967d) {
                            this.m.f9967d = a2;
                            a(a2);
                        }
                        boolean[] zArr2 = new boolean[this.f9926a.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            s[] sVarArr = this.f9926a;
                            if (i2 >= sVarArr.length) {
                                break;
                            }
                            s sVar = sVarArr[i2];
                            zArr2[i2] = sVar.d() != 0;
                            l lVar = this.G.f9936d[i2];
                            if (lVar != null) {
                                i3++;
                            }
                            if (zArr2[i2]) {
                                if (lVar != sVar.f()) {
                                    if (sVar == this.o) {
                                        if (lVar == null) {
                                            this.f9930e.a(this.p);
                                        }
                                        this.p = null;
                                        this.o = null;
                                    }
                                    a(sVar);
                                    sVar.l();
                                } else if (zArr[i2]) {
                                    sVar.a(this.D);
                                }
                            }
                            i2++;
                        }
                        this.h.obtainMessage(3, aVar.k).sendToTarget();
                        a(zArr2, i3);
                    } else {
                        this.E = aVar;
                        for (a aVar3 = this.E.j; aVar3 != null; aVar3 = aVar3.j) {
                            aVar3.e();
                        }
                        a aVar4 = this.E;
                        aVar4.j = null;
                        if (aVar4.h) {
                            this.E.a(Math.max(this.E.f9939g.f10988b, this.E.b(this.D)), false);
                        }
                    }
                    l();
                    d();
                    this.f9931f.sendEmptyMessage(2);
                    return;
                }
                if (aVar == this.F) {
                    z2 = false;
                }
                aVar = aVar.j;
            }
        }
    }

    private boolean b(long j2) {
        return j2 == -9223372036854775807L || this.m.f9967d < j2 || (this.G.j != null && (this.G.j.h || this.G.j.f9939g.f10987a.a()));
    }

    private void i() throws IOException {
        a aVar = this.E;
        if (aVar != null && !aVar.h) {
            a aVar2 = this.F;
            if (aVar2 == null || aVar2.j == this.E) {
                s[] sVarArr = this.r;
                int length = sVarArr.length;
                int i2 = 0;
                while (i2 < length) {
                    if (sVarArr[i2].g()) {
                        i2++;
                    } else {
                        return;
                    }
                }
                this.E.f9933a.j_();
            }
        }
    }

    private void a(Pair<x, Object> pair) throws e {
        a aVar;
        Pair<x, Object> pair2 = pair;
        x xVar = this.H;
        this.H = (x) pair2.first;
        this.l.a(this.H);
        Object obj = pair2.second;
        boolean z2 = false;
        long j2 = -9223372036854775807L;
        if (xVar != null) {
            int i2 = this.m.f9964a.f12083b;
            a aVar2 = this.G;
            if (aVar2 == null) {
                aVar2 = this.E;
            }
            if (aVar2 != null || i2 < xVar.c()) {
                int a2 = this.H.a(aVar2 == null ? xVar.a(i2, this.k, true).f12295b : aVar2.f9934b);
                if (a2 == -1) {
                    int a3 = a(i2, xVar, this.H);
                    if (a3 == -1) {
                        a(obj);
                        return;
                    }
                    Pair<Integer, Long> a4 = a(this.H.a(a3, this.k).f12296c, -9223372036854775807L);
                    int intValue = ((Integer) a4.first).intValue();
                    long longValue = ((Long) a4.second).longValue();
                    this.H.a(intValue, this.k, true);
                    if (aVar2 != null) {
                        Object obj2 = this.k.f12295b;
                        aVar2.f9939g = aVar2.f9939g.a(-1);
                        while (aVar2.j != null) {
                            aVar2 = aVar2.j;
                            if (aVar2.f9934b.equals(obj2)) {
                                aVar2.f9939g = this.l.a(aVar2.f9939g, intValue);
                            } else {
                                aVar2.f9939g = aVar2.f9939g.a(-1);
                            }
                        }
                    }
                    i.b bVar = new i.b(intValue);
                    this.m = new b(bVar, a(bVar, longValue));
                    b(obj);
                    return;
                }
                if (a2 != i2) {
                    this.m = this.m.a(a2);
                }
                if (this.m.f9964a.a()) {
                    i.b a5 = this.l.a(a2, this.m.f9966c);
                    if (!a5.a() || a5.f12085d != this.m.f9964a.f12085d) {
                        long a6 = a(a5, this.m.f9966c);
                        if (a5.a()) {
                            j2 = this.m.f9966c;
                        }
                        this.m = new b(a5, a6, j2);
                        b(obj);
                        return;
                    }
                }
                if (aVar2 == null) {
                    b(obj);
                    return;
                }
                a a7 = a(aVar2, a2);
                while (true) {
                    if (a7.j == null) {
                        break;
                    }
                    aVar = a7.j;
                    a2 = this.H.a(a2, this.k, this.j, this.x);
                    if (a2 == -1 || !aVar.f9934b.equals(this.H.a(a2, this.k, true).f12295b)) {
                        a aVar3 = this.F;
                    } else {
                        a7 = a(aVar, a2);
                    }
                }
                a aVar32 = this.F;
                if (aVar32 != null && aVar32.f9935c < aVar.f9935c) {
                    z2 = true;
                }
                if (!z2) {
                    this.m = new b(this.G.f9939g.f10987a, a(this.G.f9939g.f10987a, this.m.f9967d), this.m.f9966c);
                } else {
                    this.E = a7;
                    this.E.j = null;
                    a(aVar);
                }
                b(obj);
                return;
            }
            b(obj);
        } else if (this.B > 0) {
            Pair<Integer, Long> b2 = b(this.C);
            int i3 = this.B;
            this.B = 0;
            this.C = null;
            if (b2 == null) {
                a(obj, i3);
                return;
            }
            int intValue2 = ((Integer) b2.first).intValue();
            long longValue2 = ((Long) b2.second).longValue();
            i.b a8 = this.l.a(intValue2, longValue2);
            this.m = new b(a8, a8.a() ? 0 : longValue2, longValue2);
            b(obj, i3);
        } else if (this.m.f9965b != -9223372036854775807L) {
            b(obj);
        } else if (this.H.a()) {
            a(obj);
        } else {
            Pair<Integer, Long> a9 = a(0, -9223372036854775807L);
            int intValue3 = ((Integer) a9.first).intValue();
            long longValue3 = ((Long) a9.second).longValue();
            i.b a10 = this.l.a(intValue3, longValue3);
            this.m = new b(a10, a10.a() ? 0 : longValue3, longValue3);
            b(obj);
        }
    }

    private a a(a aVar, int i2) {
        while (true) {
            aVar.f9939g = this.l.a(aVar.f9939g, i2);
            if (aVar.f9939g.f10992f || aVar.j == null) {
                return aVar;
            }
            aVar = aVar.j;
        }
        return aVar;
    }

    private void a(Object obj) {
        a(obj, 0);
    }

    private void a(Object obj, int i2) {
        this.m = new b(0, 0);
        b(obj, i2);
        this.m = new b(0, -9223372036854775807L);
        a(4);
        d(false);
    }

    private void b(Object obj) {
        b(obj, 0);
    }

    private void b(Object obj, int i2) {
        this.h.obtainMessage(6, new d(this.H, obj, this.m, i2)).sendToTarget();
    }

    private int a(int i2, x xVar, x xVar2) {
        int c2 = xVar.c();
        int i3 = i2;
        int i4 = -1;
        for (int i5 = 0; i5 < c2 && i4 == -1; i5++) {
            i3 = xVar.a(i3, this.k, this.j, this.x);
            if (i3 == -1) {
                break;
            }
            i4 = xVar2.a(xVar.a(i3, this.k, true).f12295b);
        }
        return i4;
    }

    private Pair<Integer, Long> b(c cVar) {
        x xVar = cVar.f10006a;
        if (xVar.a()) {
            xVar = this.H;
        }
        try {
            Pair<Integer, Long> a2 = xVar.a(this.j, this.k, cVar.f10007b, cVar.f10008c);
            x xVar2 = this.H;
            if (xVar2 == xVar) {
                return a2;
            }
            int a3 = xVar2.a(xVar.a(((Integer) a2.first).intValue(), this.k, true).f12295b);
            if (a3 != -1) {
                return Pair.create(Integer.valueOf(a3), a2.second);
            }
            int a4 = a(((Integer) a2.first).intValue(), xVar, this.H);
            if (a4 != -1) {
                return a(this.H.a(a4, this.k).f12296c, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new m(this.H, cVar.f10007b, cVar.f10008c);
        }
    }

    private Pair<Integer, Long> a(int i2, long j2) {
        return this.H.a(this.j, this.k, i2, j2);
    }

    private void j() throws e, IOException {
        if (this.H == null) {
            this.q.a();
            return;
        }
        k();
        a aVar = this.E;
        int i2 = 0;
        if (aVar == null || aVar.b()) {
            b(false);
        } else if (this.E != null && !this.v) {
            l();
        }
        if (this.G != null) {
            while (true) {
                a aVar2 = this.G;
                if (aVar2 != this.F && this.D >= aVar2.j.f9938f) {
                    this.G.e();
                    b(this.G.j);
                    this.m = new b(this.G.f9939g.f10987a, this.G.f9939g.f10988b, this.G.f9939g.f10990d);
                    d();
                    this.h.obtainMessage(5, this.m).sendToTarget();
                }
            }
            if (this.F.f9939g.f10993g) {
                while (true) {
                    s[] sVarArr = this.f9926a;
                    if (i2 < sVarArr.length) {
                        s sVar = sVarArr[i2];
                        l lVar = this.F.f9936d[i2];
                        if (lVar != null && sVar.f() == lVar && sVar.g()) {
                            sVar.h();
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } else {
                int i3 = 0;
                while (true) {
                    s[] sVarArr2 = this.f9926a;
                    if (i3 < sVarArr2.length) {
                        s sVar2 = sVarArr2[i3];
                        l lVar2 = this.F.f9936d[i3];
                        if (sVar2.f() != lVar2) {
                            return;
                        }
                        if (lVar2 == null || sVar2.g()) {
                            i3++;
                        } else {
                            return;
                        }
                    } else if (this.F.j != null && this.F.j.h) {
                        com.google.android.exoplayer2.q.i iVar = this.F.k;
                        this.F = this.F.j;
                        com.google.android.exoplayer2.q.i iVar2 = this.F.k;
                        boolean z2 = this.F.f9933a.c() != -9223372036854775807L;
                        int i4 = 0;
                        while (true) {
                            s[] sVarArr3 = this.f9926a;
                            if (i4 < sVarArr3.length) {
                                s sVar3 = sVarArr3[i4];
                                if (iVar.f11289b.a(i4) != null) {
                                    if (z2) {
                                        sVar3.h();
                                    } else if (!sVar3.i()) {
                                        com.google.android.exoplayer2.q.f a2 = iVar2.f11289b.a(i4);
                                        u uVar = iVar.f11291d[i4];
                                        u uVar2 = iVar2.f11291d[i4];
                                        if (a2 == null || !uVar2.equals(uVar)) {
                                            sVar3.h();
                                        } else {
                                            Format[] formatArr = new Format[a2.e()];
                                            for (int i5 = 0; i5 < formatArr.length; i5++) {
                                                formatArr[i5] = a2.a(i5);
                                            }
                                            sVar3.a(formatArr, this.F.f9936d[i4], this.F.a());
                                        }
                                    }
                                }
                                i4++;
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void k() throws IOException {
        o.a aVar;
        long j2;
        a aVar2 = this.E;
        if (aVar2 == null) {
            aVar = this.l.a(this.m);
        } else if (!aVar2.f9939g.f10993g && this.E.b() && this.E.f9939g.f10991e != -9223372036854775807L) {
            if (this.G == null || this.E.f9935c - this.G.f9935c != 100) {
                aVar = this.l.a(this.E.f9939g, this.E.a(), this.D);
            } else {
                return;
            }
        } else {
            return;
        }
        if (aVar == null) {
            this.q.a();
            return;
        }
        a aVar3 = this.E;
        if (aVar3 == null) {
            j2 = 60000000;
        } else {
            j2 = aVar3.a() + this.E.f9939g.f10991e;
        }
        long j3 = j2;
        a aVar4 = this.E;
        a aVar5 = new a(this.f9926a, this.f9927b, j3, this.f9928c, this.f9929d, this.q, this.H.a(aVar.f10987a.f12083b, this.k, true).f12295b, aVar4 == null ? 0 : aVar4.f9935c + 1, aVar);
        a aVar6 = this.E;
        if (aVar6 != null) {
            aVar6.j = aVar5;
        }
        this.E = aVar5;
        this.E.f9933a.a(this, aVar.f10988b);
        b(true);
    }

    private void c(com.google.android.exoplayer2.source.h hVar) throws e {
        a aVar = this.E;
        if (aVar != null && aVar.f9933a == hVar) {
            this.E.c();
            if (this.G == null) {
                this.F = this.E;
                a(this.F.f9939g.f10988b);
                b(this.F);
            }
            l();
        }
    }

    private void d(com.google.android.exoplayer2.source.h hVar) {
        a aVar = this.E;
        if (aVar != null && aVar.f9933a == hVar) {
            l();
        }
    }

    private void l() {
        boolean c2 = this.E.c(this.D);
        b(c2);
        if (c2) {
            this.E.d(this.D);
        }
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.e();
            aVar = aVar.j;
        }
    }

    private void b(a aVar) throws e {
        if (this.G != aVar) {
            boolean[] zArr = new boolean[this.f9926a.length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                s[] sVarArr = this.f9926a;
                if (i2 < sVarArr.length) {
                    s sVar = sVarArr[i2];
                    zArr[i2] = sVar.d() != 0;
                    com.google.android.exoplayer2.q.f a2 = aVar.k.f11289b.a(i2);
                    if (a2 != null) {
                        i3++;
                    }
                    if (zArr[i2] && (a2 == null || (sVar.i() && sVar.f() == this.G.f9936d[i2]))) {
                        if (sVar == this.o) {
                            this.f9930e.a(this.p);
                            this.p = null;
                            this.o = null;
                        }
                        a(sVar);
                        sVar.l();
                    }
                    i2++;
                } else {
                    this.G = aVar;
                    this.h.obtainMessage(3, aVar.k).sendToTarget();
                    a(zArr, i3);
                    return;
                }
            }
        }
    }

    private void a(boolean[] zArr, int i2) throws e {
        this.r = new s[i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            s[] sVarArr = this.f9926a;
            if (i3 < sVarArr.length) {
                s sVar = sVarArr[i3];
                com.google.android.exoplayer2.q.f a2 = this.G.k.f11289b.a(i3);
                if (a2 != null) {
                    int i5 = i4 + 1;
                    this.r[i4] = sVar;
                    if (sVar.d() == 0) {
                        u uVar = this.G.k.f11291d[i3];
                        boolean z2 = this.t && this.w == 3;
                        boolean z3 = !zArr[i3] && z2;
                        Format[] formatArr = new Format[a2.e()];
                        for (int i6 = 0; i6 < formatArr.length; i6++) {
                            formatArr[i6] = a2.a(i6);
                        }
                        sVar.a(uVar, formatArr, this.G.f9936d[i3], this.D, z3, this.G.a());
                        com.google.android.exoplayer2.s.h c2 = sVar.c();
                        if (c2 != null) {
                            if (this.p == null) {
                                this.p = c2;
                                this.o = sVar;
                                this.p.a(this.n);
                            } else {
                                throw e.a((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z2) {
                            sVar.e();
                        }
                    }
                    i4 = i5;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.google.android.exoplayer2.source.h f9933a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f9934b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9935c;

        /* renamed from: d  reason: collision with root package name */
        public final l[] f9936d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean[] f9937e;

        /* renamed from: f  reason: collision with root package name */
        public final long f9938f;

        /* renamed from: g  reason: collision with root package name */
        public o.a f9939g;
        public boolean h;
        public boolean i;
        public a j;
        public com.google.android.exoplayer2.q.i k;
        private final s[] l;
        private final t[] m;
        private final com.google.android.exoplayer2.q.h n;
        private final n o;
        private final com.google.android.exoplayer2.source.i p;
        private com.google.android.exoplayer2.q.i q;

        public a(s[] sVarArr, t[] tVarArr, long j2, com.google.android.exoplayer2.q.h hVar, n nVar, com.google.android.exoplayer2.source.i iVar, Object obj, int i2, o.a aVar) {
            this.l = sVarArr;
            this.m = tVarArr;
            this.f9938f = j2;
            this.n = hVar;
            this.o = nVar;
            this.p = iVar;
            this.f9934b = com.google.android.exoplayer2.s.a.a(obj);
            this.f9935c = i2;
            this.f9939g = aVar;
            this.f9936d = new l[sVarArr.length];
            this.f9937e = new boolean[sVarArr.length];
            com.google.android.exoplayer2.source.h a2 = iVar.a(aVar.f10987a, nVar.d());
            if (aVar.f10989c != Long.MIN_VALUE) {
                com.google.android.exoplayer2.source.c cVar = new com.google.android.exoplayer2.source.c(a2, true);
                cVar.a(0, aVar.f10989c);
                a2 = cVar;
            }
            this.f9933a = a2;
        }

        public long a(long j2) {
            return j2 + a();
        }

        public long b(long j2) {
            return j2 - a();
        }

        public long a() {
            return this.f9935c == 0 ? this.f9938f : this.f9938f - this.f9939g.f10988b;
        }

        public boolean b() {
            return this.h && (!this.i || this.f9933a.d() == Long.MIN_VALUE);
        }

        public boolean a(boolean z, long j2) {
            long j3;
            if (!this.h) {
                j3 = this.f9939g.f10988b;
            } else {
                j3 = this.f9933a.d();
            }
            if (j3 == Long.MIN_VALUE) {
                if (this.f9939g.f10993g) {
                    return true;
                }
                j3 = this.f9939g.f10991e;
            }
            return this.o.a(j3 - b(j2), z);
        }

        public void c() throws e {
            this.h = true;
            d();
            this.f9939g = this.f9939g.a(a(this.f9939g.f10988b, false));
        }

        public boolean c(long j2) {
            long e2 = !this.h ? 0 : this.f9933a.e();
            if (e2 == Long.MIN_VALUE) {
                return false;
            }
            return this.o.a(e2 - b(j2));
        }

        public void d(long j2) {
            this.f9933a.c(b(j2));
        }

        public boolean d() throws e {
            com.google.android.exoplayer2.q.i a2 = this.n.a(this.m, this.f9933a.b());
            if (a2.a(this.q)) {
                return false;
            }
            this.k = a2;
            return true;
        }

        public long a(long j2, boolean z) {
            return a(j2, z, new boolean[this.l.length]);
        }

        public long a(long j2, boolean z, boolean[] zArr) {
            g gVar = this.k.f11289b;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= gVar.f11284a) {
                    break;
                }
                boolean[] zArr2 = this.f9937e;
                if (z || !this.k.a(this.q, i2)) {
                    z2 = false;
                }
                zArr2[i2] = z2;
                i2++;
            }
            long a2 = this.f9933a.a(gVar.a(), this.f9937e, this.f9936d, zArr, j2);
            this.q = this.k;
            this.i = false;
            int i3 = 0;
            while (true) {
                l[] lVarArr = this.f9936d;
                if (i3 < lVarArr.length) {
                    if (lVarArr[i3] != null) {
                        com.google.android.exoplayer2.s.a.b(gVar.a(i3) != null);
                        this.i = true;
                    } else {
                        com.google.android.exoplayer2.s.a.b(gVar.a(i3) == null);
                    }
                    i3++;
                } else {
                    this.o.a(this.l, this.k.f11288a, gVar);
                    return a2;
                }
            }
        }

        public void e() {
            try {
                if (this.f9939g.f10989c != Long.MIN_VALUE) {
                    this.p.a(((com.google.android.exoplayer2.source.c) this.f9933a).f11575a);
                } else {
                    this.p.a(this.f9933a);
                }
            } catch (RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
            }
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final x f10006a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10007b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10008c;

        public c(x xVar, int i, long j) {
            this.f10006a = xVar;
            this.f10007b = i;
            this.f10008c = j;
        }
    }
}
