package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.ar;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.l.h;
import com.google.android.exoplayer2.l.i;
import com.google.android.exoplayer2.n.g;
import com.google.android.exoplayer2.n.p;
import com.google.android.exoplayer2.n.r;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;

final class ag implements Handler.Callback, h.a, x.a, y.a {
    private c A;
    private long B;
    private a C;
    private a D;
    private a E;
    private ar F;

    /* renamed from: a  reason: collision with root package name */
    private final am[] f9082a;

    /* renamed from: b  reason: collision with root package name */
    private final an[] f9083b;

    /* renamed from: c  reason: collision with root package name */
    private final h f9084c;

    /* renamed from: d  reason: collision with root package name */
    private final aj f9085d;

    /* renamed from: e  reason: collision with root package name */
    private final p f9086e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f9087f;

    /* renamed from: g  reason: collision with root package name */
    private final HandlerThread f9088g;
    private final Handler h;
    private final ad i;
    private final ar.b j;
    private final ar.a k;
    private b l;
    private al m;
    private am n;
    private g o;
    private y p;
    private am[] q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v = 1;
    private int w;
    private int x;
    private long y;
    private int z;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f9096a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9097b;

        /* renamed from: c  reason: collision with root package name */
        public volatile long f9098c;

        /* renamed from: d  reason: collision with root package name */
        public volatile long f9099d;

        public b(int i, long j) {
            this.f9096a = i;
            this.f9097b = j;
            this.f9098c = j;
            this.f9099d = j;
        }

        public b a(int i) {
            b bVar = new b(i, this.f9097b);
            bVar.f9098c = this.f9098c;
            bVar.f9099d = this.f9099d;
            return bVar;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final ar f9103a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f9104b;

        /* renamed from: c  reason: collision with root package name */
        public final b f9105c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9106d;

        public d(ar arVar, Object obj, b bVar, int i) {
            this.f9103a = arVar;
            this.f9104b = obj;
            this.f9105c = bVar;
            this.f9106d = i;
        }
    }

    public ag(am[] amVarArr, h hVar, aj ajVar, boolean z2, Handler handler, b bVar, ad adVar) {
        this.f9082a = amVarArr;
        this.f9084c = hVar;
        this.f9085d = ajVar;
        this.s = z2;
        this.h = handler;
        this.l = bVar;
        this.i = adVar;
        this.f9083b = new an[amVarArr.length];
        for (int i2 = 0; i2 < amVarArr.length; i2++) {
            amVarArr[i2].a(i2);
            this.f9083b[i2] = amVarArr[i2].b();
        }
        this.f9086e = new p();
        this.q = new am[0];
        this.j = new ar.b();
        this.k = new ar.a();
        hVar.a((h.a) this);
        this.m = al.f9108a;
        this.f9088g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f9088g.start();
        this.f9087f = new Handler(this.f9088g.getLooper(), this);
    }

    public void a(y yVar, boolean z2) {
        this.f9087f.obtainMessage(0, z2 ? 1 : 0, 0, yVar).sendToTarget();
    }

    public void a(boolean z2) {
        this.f9087f.obtainMessage(1, z2 ? 1 : 0, 0).sendToTarget();
    }

    public void a(ar arVar, int i2, long j2) {
        this.f9087f.obtainMessage(3, new c(arVar, i2, j2)).sendToTarget();
    }

    public void a(al alVar) {
        this.f9087f.obtainMessage(4, alVar).sendToTarget();
    }

    public void a(ad.c... cVarArr) {
        if (this.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.w++;
        this.f9087f.obtainMessage(11, cVarArr).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.google.android.exoplayer2.ad.c... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.r     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.w     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.w = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.f9087f     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.x     // Catch:{ all -> 0x0031 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ag.b(com.google.android.exoplayer2.ad$c[]):void");
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
            boolean r0 = r2.r     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.f9087f     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.r     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.f9088g     // Catch:{ all -> 0x0024 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ag.a():void");
    }

    public void a(ar arVar, Object obj) {
        this.f9087f.obtainMessage(7, Pair.create(arVar, obj)).sendToTarget();
    }

    public void a(x xVar) {
        this.f9087f.obtainMessage(8, xVar).sendToTarget();
    }

    /* renamed from: b */
    public void a(x xVar) {
        this.f9087f.obtainMessage(9, xVar).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        try {
            boolean z2 = false;
            switch (message.what) {
                case 0:
                    y yVar = (y) message.obj;
                    if (message.arg1 != 0) {
                        z2 = true;
                    }
                    b(yVar, z2);
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
                    b((al) message.obj);
                    return true;
                case 5:
                    f();
                    return true;
                case 6:
                    g();
                    return true;
                case 7:
                    a((Pair<ar, Object>) (Pair) message.obj);
                    return true;
                case 8:
                    c((x) message.obj);
                    return true;
                case 9:
                    d((x) message.obj);
                    return true;
                case 10:
                    h();
                    return true;
                case 11:
                    c((ad.c[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (ac e2) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e2);
            this.h.obtainMessage(8, e2).sendToTarget();
            f();
            return true;
        } catch (IOException e3) {
            Log.e("ExoPlayerImplInternal", "Source error.", e3);
            this.h.obtainMessage(8, ac.a(e3)).sendToTarget();
            f();
            return true;
        } catch (RuntimeException e4) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e4);
            this.h.obtainMessage(8, ac.a(e4)).sendToTarget();
            f();
            return true;
        }
    }

    private void a(int i2) {
        if (this.v != i2) {
            this.v = i2;
            this.h.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    private void b(boolean z2) {
        if (this.u != z2) {
            this.u = z2;
            this.h.obtainMessage(2, z2 ? 1 : 0, 0).sendToTarget();
        }
    }

    private void b(y yVar, boolean z2) {
        this.h.sendEmptyMessage(0);
        d(true);
        this.f9085d.a();
        if (z2) {
            this.l = new b(0, -9223372036854775807L);
        }
        this.p = yVar;
        yVar.a(this.i, true, (y.a) this);
        a(2);
        this.f9087f.sendEmptyMessage(2);
    }

    private void c(boolean z2) throws ac {
        this.t = false;
        this.s = z2;
        if (!z2) {
            c();
            d();
            return;
        }
        int i2 = this.v;
        if (i2 == 3) {
            b();
            this.f9087f.sendEmptyMessage(2);
        } else if (i2 == 2) {
            this.f9087f.sendEmptyMessage(2);
        }
    }

    private void b() throws ac {
        this.t = false;
        this.f9086e.a();
        for (am e2 : this.q) {
            e2.e();
        }
    }

    private void c() throws ac {
        this.f9086e.b();
        for (am a2 : this.q) {
            a(a2);
        }
    }

    private void d() throws ac {
        long j2;
        a aVar = this.E;
        if (aVar != null) {
            long d2 = aVar.f9089a.d();
            if (d2 != -9223372036854775807L) {
                a(d2);
            } else {
                am amVar = this.n;
                if (amVar == null || amVar.u()) {
                    this.B = this.f9086e.w();
                } else {
                    this.B = this.o.w();
                    this.f9086e.a(this.B);
                }
                d2 = this.E.b(this.B);
            }
            this.l.f9098c = d2;
            this.y = SystemClock.elapsedRealtime() * 1000;
            if (this.q.length == 0) {
                j2 = Long.MIN_VALUE;
            } else {
                j2 = this.E.f9089a.e();
            }
            b bVar = this.l;
            if (j2 == Long.MIN_VALUE) {
                j2 = this.F.a(this.E.f9094f, this.k).b();
            }
            bVar.f9099d = j2;
        }
    }

    private void e() throws ac, IOException {
        boolean z2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        j();
        if (this.E == null) {
            i();
            a(elapsedRealtime, 10);
            return;
        }
        r.a("doSomeWork");
        d();
        this.E.f9089a.a(this.l.f9098c);
        boolean z3 = true;
        boolean z4 = true;
        for (am amVar : this.q) {
            amVar.a(this.B, this.y);
            z4 = z4 && amVar.u();
            boolean z5 = amVar.v() || amVar.u();
            if (!z5) {
                amVar.j();
            }
            z3 = z3 && z5;
        }
        if (!z3) {
            i();
        }
        g gVar = this.o;
        if (gVar != null) {
            al x2 = gVar.x();
            if (!x2.equals(this.m)) {
                this.m = x2;
                this.f9086e.a(this.o);
                this.h.obtainMessage(7, x2).sendToTarget();
            }
        }
        long b2 = this.F.a(this.E.f9094f, this.k).b();
        if (!z4 || ((b2 != -9223372036854775807L && b2 > this.l.f9098c) || !this.E.h)) {
            int i2 = this.v;
            if (i2 == 2) {
                if (this.q.length > 0) {
                    z2 = z3 && e(this.t);
                } else {
                    z2 = b(b2);
                }
                if (z2) {
                    a(3);
                    if (this.s) {
                        b();
                    }
                }
            } else if (i2 == 3) {
                if (this.q.length <= 0) {
                    z3 = b(b2);
                }
                if (!z3) {
                    this.t = this.s;
                    a(2);
                    c();
                }
            }
        } else {
            a(4);
            c();
        }
        if (this.v == 2) {
            for (am j2 : this.q) {
                j2.j();
            }
        }
        if ((this.s && this.v == 3) || this.v == 2) {
            a(elapsedRealtime, 10);
        } else if (this.q.length != 0) {
            a(elapsedRealtime, 1000);
        } else {
            this.f9087f.removeMessages(2);
        }
        r.a();
    }

    private void a(long j2, long j3) {
        this.f9087f.removeMessages(2);
        long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f9087f.sendEmptyMessage(2);
        } else {
            this.f9087f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private void a(c cVar) throws ac {
        int i2 = 1;
        if (this.F == null) {
            this.z++;
            this.A = cVar;
            return;
        }
        Pair<Integer, Long> b2 = b(cVar);
        if (b2 == null) {
            this.l = new b(0, 0);
            this.h.obtainMessage(4, 1, 0, this.l).sendToTarget();
            this.l = new b(0, -9223372036854775807L);
            a(4);
            d(false);
            return;
        }
        int i3 = cVar.f9102c == -9223372036854775807L ? 1 : 0;
        int intValue = ((Integer) b2.first).intValue();
        long longValue = ((Long) b2.second).longValue();
        try {
            if (intValue != this.l.f9096a || longValue / 1000 != this.l.f9098c / 1000) {
                long a2 = a(intValue, longValue);
                int i4 = i3 | (longValue != a2 ? 1 : 0);
                this.l = new b(intValue, a2);
                Handler handler = this.h;
                if (i4 == 0) {
                    i2 = 0;
                }
                handler.obtainMessage(4, i2, 0, this.l).sendToTarget();
            }
        } finally {
            this.l = new b(intValue, longValue);
            this.h.obtainMessage(4, i3, 0, this.l).sendToTarget();
        }
    }

    private long a(int i2, long j2) throws ac {
        a aVar;
        c();
        this.t = false;
        a(2);
        a aVar2 = this.E;
        if (aVar2 == null) {
            a aVar3 = this.C;
            if (aVar3 != null) {
                aVar3.e();
            }
            aVar = null;
        } else {
            aVar = null;
            while (aVar2 != null) {
                if (aVar2.f9094f != i2 || !aVar2.i) {
                    aVar2.e();
                } else {
                    aVar = aVar2;
                }
                aVar2 = aVar2.k;
            }
        }
        a aVar4 = this.E;
        if (!(aVar4 == aVar && aVar4 == this.D)) {
            for (am l2 : this.q) {
                l2.l();
            }
            this.q = new am[0];
            this.o = null;
            this.n = null;
            this.E = null;
        }
        if (aVar != null) {
            aVar.k = null;
            this.C = aVar;
            this.D = aVar;
            b(aVar);
            if (this.E.j) {
                j2 = this.E.f9089a.b(j2);
            }
            a(j2);
            l();
        } else {
            this.C = null;
            this.D = null;
            this.E = null;
            a(j2);
        }
        this.f9087f.sendEmptyMessage(2);
        return j2;
    }

    private void a(long j2) throws ac {
        long j3;
        a aVar = this.E;
        if (aVar == null) {
            j3 = j2 + 60000000;
        } else {
            j3 = aVar.a(j2);
        }
        this.B = j3;
        this.f9086e.a(this.B);
        for (am a2 : this.q) {
            a2.a(this.B);
        }
    }

    private void b(al alVar) {
        al alVar2;
        g gVar = this.o;
        if (gVar != null) {
            alVar2 = gVar.a(alVar);
        } else {
            alVar2 = this.f9086e.a(alVar);
        }
        this.m = alVar2;
        this.h.obtainMessage(7, alVar2).sendToTarget();
    }

    private void f() {
        d(true);
        this.f9085d.b();
        a(1);
    }

    private void g() {
        d(true);
        this.f9085d.c();
        a(1);
        synchronized (this) {
            this.r = true;
            notifyAll();
        }
    }

    private void d(boolean z2) {
        this.f9087f.removeMessages(2);
        this.t = false;
        this.f9086e.b();
        this.o = null;
        this.n = null;
        this.B = 60000000;
        for (am amVar : this.q) {
            try {
                a(amVar);
                amVar.l();
            } catch (ac | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.q = new am[0];
        a aVar = this.E;
        if (aVar == null) {
            aVar = this.C;
        }
        a(aVar);
        this.C = null;
        this.D = null;
        this.E = null;
        b(false);
        if (z2) {
            y yVar = this.p;
            if (yVar != null) {
                yVar.b();
                this.p = null;
            }
            this.F = null;
        }
    }

    private void c(ad.c[] cVarArr) throws ac {
        try {
            for (ad.c cVar : cVarArr) {
                cVar.f9071a.a(cVar.f9072b, cVar.f9073c);
            }
            if (this.p != null) {
                this.f9087f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.x++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.x++;
                notifyAll();
                throw th;
            }
        }
    }

    private void a(am amVar) throws ac {
        if (amVar.d() == 2) {
            amVar.k();
        }
    }

    private void h() throws ac {
        a aVar = this.E;
        if (aVar != null) {
            boolean z2 = true;
            while (aVar != null && aVar.i) {
                if (aVar.d()) {
                    if (z2) {
                        boolean z3 = this.D != this.E;
                        a(this.E.k);
                        a aVar2 = this.E;
                        aVar2.k = null;
                        this.C = aVar2;
                        this.D = aVar2;
                        boolean[] zArr = new boolean[this.f9082a.length];
                        long a2 = aVar2.a(this.l.f9098c, z3, zArr);
                        if (a2 != this.l.f9098c) {
                            this.l.f9098c = a2;
                            a(a2);
                        }
                        boolean[] zArr2 = new boolean[this.f9082a.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            am[] amVarArr = this.f9082a;
                            if (i2 >= amVarArr.length) {
                                break;
                            }
                            am amVar = amVarArr[i2];
                            zArr2[i2] = amVar.d() != 0;
                            z zVar = this.E.f9091c[i2];
                            if (zVar != null) {
                                i3++;
                            }
                            if (zArr2[i2]) {
                                if (zVar != amVar.f()) {
                                    if (amVar == this.n) {
                                        if (zVar == null) {
                                            this.f9086e.a(this.o);
                                        }
                                        this.o = null;
                                        this.n = null;
                                    }
                                    a(amVar);
                                    amVar.l();
                                } else if (zArr[i2]) {
                                    amVar.a(this.B);
                                }
                            }
                            i2++;
                        }
                        this.h.obtainMessage(3, aVar.m).sendToTarget();
                        a(zArr2, i3);
                    } else {
                        this.C = aVar;
                        for (a aVar3 = this.C.k; aVar3 != null; aVar3 = aVar3.k) {
                            aVar3.e();
                        }
                        a aVar4 = this.C;
                        aVar4.k = null;
                        if (aVar4.i) {
                            this.C.a(Math.max(this.C.f9095g, this.C.b(this.B)), false);
                        }
                    }
                    l();
                    d();
                    this.f9087f.sendEmptyMessage(2);
                    return;
                }
                if (aVar == this.D) {
                    z2 = false;
                }
                aVar = aVar.k;
            }
        }
    }

    private boolean b(long j2) {
        return j2 == -9223372036854775807L || this.l.f9098c < j2 || (this.E.k != null && this.E.k.i);
    }

    private boolean e(boolean z2) {
        long j2;
        if (!this.C.i) {
            j2 = this.C.f9095g;
        } else {
            j2 = this.C.f9089a.e();
        }
        if (j2 == Long.MIN_VALUE) {
            if (this.C.h) {
                return true;
            }
            j2 = this.F.a(this.C.f9094f, this.k).b();
        }
        return this.f9085d.a(j2 - this.C.b(this.B), z2);
    }

    private void i() throws IOException {
        a aVar = this.C;
        if (aVar != null && !aVar.i) {
            a aVar2 = this.D;
            if (aVar2 == null || aVar2.k == this.C) {
                am[] amVarArr = this.q;
                int length = amVarArr.length;
                int i2 = 0;
                while (i2 < length) {
                    if (amVarArr[i2].g()) {
                        i2++;
                    } else {
                        return;
                    }
                }
                this.C.f9089a.b();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.util.Pair<com.google.android.exoplayer2.ar, java.lang.Object> r12) throws com.google.android.exoplayer2.ac {
        /*
            r11 = this;
            com.google.android.exoplayer2.ar r0 = r11.F
            java.lang.Object r1 = r12.first
            com.google.android.exoplayer2.ar r1 = (com.google.android.exoplayer2.ar) r1
            r11.F = r1
            java.lang.Object r12 = r12.second
            r1 = 0
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 0
            if (r0 != 0) goto L_0x0070
            int r5 = r11.z
            if (r5 <= 0) goto L_0x0041
            com.google.android.exoplayer2.ag$c r5 = r11.A
            android.util.Pair r5 = r11.b((com.google.android.exoplayer2.ag.c) r5)
            int r6 = r11.z
            r11.z = r4
            r11.A = r1
            if (r5 != 0) goto L_0x0029
            r11.a((java.lang.Object) r12, (int) r6)
            return
        L_0x0029:
            com.google.android.exoplayer2.ag$b r7 = new com.google.android.exoplayer2.ag$b
            java.lang.Object r8 = r5.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r5 = r5.second
            java.lang.Long r5 = (java.lang.Long) r5
            long r9 = r5.longValue()
            r7.<init>(r8, r9)
            r11.l = r7
            goto L_0x0071
        L_0x0041:
            com.google.android.exoplayer2.ag$b r5 = r11.l
            long r5 = r5.f9097b
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0070
            com.google.android.exoplayer2.ar r5 = r11.F
            boolean r5 = r5.c()
            if (r5 == 0) goto L_0x0055
            r11.a((java.lang.Object) r12, (int) r4)
            return
        L_0x0055:
            android.util.Pair r5 = r11.b((int) r4, (long) r2)
            com.google.android.exoplayer2.ag$b r6 = new com.google.android.exoplayer2.ag$b
            java.lang.Object r7 = r5.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r5 = r5.second
            java.lang.Long r5 = (java.lang.Long) r5
            long r8 = r5.longValue()
            r6.<init>(r7, r8)
            r11.l = r6
        L_0x0070:
            r6 = 0
        L_0x0071:
            com.google.android.exoplayer2.ag$a r5 = r11.E
            if (r5 == 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            com.google.android.exoplayer2.ag$a r5 = r11.C
        L_0x0078:
            if (r5 != 0) goto L_0x007e
            r11.b((java.lang.Object) r12, (int) r6)
            return
        L_0x007e:
            com.google.android.exoplayer2.ar r7 = r11.F
            java.lang.Object r8 = r5.f9090b
            int r7 = r7.a(r8)
            r8 = -1
            r9 = 1
            if (r7 != r8) goto L_0x00e6
            int r1 = r5.f9094f
            com.google.android.exoplayer2.ar r4 = r11.F
            int r0 = r11.a((int) r1, (com.google.android.exoplayer2.ar) r0, (com.google.android.exoplayer2.ar) r4)
            if (r0 != r8) goto L_0x0098
            r11.a((java.lang.Object) r12, (int) r6)
            return
        L_0x0098:
            com.google.android.exoplayer2.ar r1 = r11.F
            com.google.android.exoplayer2.ar$a r4 = r11.k
            com.google.android.exoplayer2.ar$a r0 = r1.a((int) r0, (com.google.android.exoplayer2.ar.a) r4)
            int r0 = r0.f9125c
            android.util.Pair r0 = r11.b((int) r0, (long) r2)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            com.google.android.exoplayer2.ar r0 = r11.F
            com.google.android.exoplayer2.ar$a r4 = r11.k
            r0.a((int) r1, (com.google.android.exoplayer2.ar.a) r4, (boolean) r9)
            com.google.android.exoplayer2.ar$a r0 = r11.k
            java.lang.Object r0 = r0.f9124b
            r5.f9094f = r8
        L_0x00c3:
            com.google.android.exoplayer2.ag$a r4 = r5.k
            if (r4 == 0) goto L_0x00d7
            com.google.android.exoplayer2.ag$a r5 = r5.k
            java.lang.Object r4 = r5.f9090b
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00d3
            r4 = r1
            goto L_0x00d4
        L_0x00d3:
            r4 = -1
        L_0x00d4:
            r5.f9094f = r4
            goto L_0x00c3
        L_0x00d7:
            long r2 = r11.a((int) r1, (long) r2)
            com.google.android.exoplayer2.ag$b r0 = new com.google.android.exoplayer2.ag$b
            r0.<init>(r1, r2)
            r11.l = r0
            r11.b((java.lang.Object) r12, (int) r6)
            return
        L_0x00e6:
            com.google.android.exoplayer2.ar r0 = r11.F
            com.google.android.exoplayer2.ar$a r2 = r11.k
            r0.a((int) r7, (com.google.android.exoplayer2.ar.a) r2)
            com.google.android.exoplayer2.ar r0 = r11.F
            int r0 = r0.a()
            int r0 = r0 - r9
            if (r7 != r0) goto L_0x0108
            com.google.android.exoplayer2.ar r0 = r11.F
            com.google.android.exoplayer2.ar$a r2 = r11.k
            int r2 = r2.f9125c
            com.google.android.exoplayer2.ar$b r3 = r11.j
            com.google.android.exoplayer2.ar$b r0 = r0.a((int) r2, (com.google.android.exoplayer2.ar.b) r3)
            boolean r0 = r0.f9133e
            if (r0 != 0) goto L_0x0108
            r0 = 1
            goto L_0x0109
        L_0x0108:
            r0 = 0
        L_0x0109:
            r5.a((int) r7, (boolean) r0)
            com.google.android.exoplayer2.ag$a r0 = r11.D
            if (r5 != r0) goto L_0x0112
            r0 = 1
            goto L_0x0113
        L_0x0112:
            r0 = 0
        L_0x0113:
            com.google.android.exoplayer2.ag$b r2 = r11.l
            int r2 = r2.f9096a
            if (r7 == r2) goto L_0x0121
            com.google.android.exoplayer2.ag$b r2 = r11.l
            com.google.android.exoplayer2.ag$b r2 = r2.a(r7)
            r11.l = r2
        L_0x0121:
            com.google.android.exoplayer2.ag$a r2 = r5.k
            if (r2 == 0) goto L_0x0183
            com.google.android.exoplayer2.ag$a r2 = r5.k
            int r7 = r7 + r9
            com.google.android.exoplayer2.ar r3 = r11.F
            com.google.android.exoplayer2.ar$a r8 = r11.k
            r3.a((int) r7, (com.google.android.exoplayer2.ar.a) r8, (boolean) r9)
            com.google.android.exoplayer2.ar r3 = r11.F
            int r3 = r3.a()
            int r3 = r3 - r9
            if (r7 != r3) goto L_0x014a
            com.google.android.exoplayer2.ar r3 = r11.F
            com.google.android.exoplayer2.ar$a r8 = r11.k
            int r8 = r8.f9125c
            com.google.android.exoplayer2.ar$b r10 = r11.j
            com.google.android.exoplayer2.ar$b r3 = r3.a((int) r8, (com.google.android.exoplayer2.ar.b) r10)
            boolean r3 = r3.f9133e
            if (r3 != 0) goto L_0x014a
            r3 = 1
            goto L_0x014b
        L_0x014a:
            r3 = 0
        L_0x014b:
            java.lang.Object r8 = r2.f9090b
            com.google.android.exoplayer2.ar$a r10 = r11.k
            java.lang.Object r10 = r10.f9124b
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0164
            r2.a((int) r7, (boolean) r3)
            com.google.android.exoplayer2.ag$a r3 = r11.D
            if (r2 != r3) goto L_0x0160
            r3 = 1
            goto L_0x0161
        L_0x0160:
            r3 = 0
        L_0x0161:
            r0 = r0 | r3
            r5 = r2
            goto L_0x0121
        L_0x0164:
            if (r0 != 0) goto L_0x017a
            com.google.android.exoplayer2.ag$a r0 = r11.E
            int r0 = r0.f9094f
            com.google.android.exoplayer2.ag$b r1 = r11.l
            long r1 = r1.f9098c
            long r1 = r11.a((int) r0, (long) r1)
            com.google.android.exoplayer2.ag$b r3 = new com.google.android.exoplayer2.ag$b
            r3.<init>(r0, r1)
            r11.l = r3
            goto L_0x0183
        L_0x017a:
            r11.C = r5
            com.google.android.exoplayer2.ag$a r0 = r11.C
            r0.k = r1
            r11.a((com.google.android.exoplayer2.ag.a) r2)
        L_0x0183:
            r11.b((java.lang.Object) r12, (int) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ag.a(android.util.Pair):void");
    }

    private void a(Object obj, int i2) {
        this.l = new b(0, 0);
        b(obj, i2);
        this.l = new b(0, -9223372036854775807L);
        a(4);
        d(false);
    }

    private void b(Object obj, int i2) {
        this.h.obtainMessage(6, new d(this.F, obj, this.l, i2)).sendToTarget();
    }

    private int a(int i2, ar arVar, ar arVar2) {
        int i3 = i2;
        int i4 = -1;
        while (i4 == -1 && i3 < arVar.a() - 1) {
            i3++;
            i4 = arVar2.a(arVar.a(i3, this.k, true).f9124b);
        }
        return i4;
    }

    private Pair<Integer, Long> b(c cVar) {
        ar arVar = cVar.f9100a;
        if (arVar.c()) {
            arVar = this.F;
        }
        try {
            Pair<Integer, Long> b2 = b(arVar, cVar.f9101b, cVar.f9102c);
            ar arVar2 = this.F;
            if (arVar2 == arVar) {
                return b2;
            }
            int a2 = arVar2.a(arVar.a(((Integer) b2.first).intValue(), this.k, true).f9124b);
            if (a2 != -1) {
                return Pair.create(Integer.valueOf(a2), b2.second);
            }
            int a3 = a(((Integer) b2.first).intValue(), arVar, this.F);
            if (a3 != -1) {
                return b(this.F.a(a3, this.k).f9125c, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new ai(this.F, cVar.f9101b, cVar.f9102c);
        }
    }

    private Pair<Integer, Long> b(int i2, long j2) {
        return b(this.F, i2, j2);
    }

    private Pair<Integer, Long> b(ar arVar, int i2, long j2) {
        return a(arVar, i2, j2, 0);
    }

    private Pair<Integer, Long> a(ar arVar, int i2, long j2, long j3) {
        com.google.android.exoplayer2.n.a.a(i2, 0, arVar.b());
        arVar.a(i2, this.j, false, j3);
        if (j2 == -9223372036854775807L) {
            j2 = this.j.a();
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = this.j.f9134f;
        long c2 = this.j.c() + j2;
        long b2 = arVar.a(i3, this.k).b();
        while (b2 != -9223372036854775807L && c2 >= b2 && i3 < this.j.f9135g) {
            c2 -= b2;
            i3++;
            b2 = arVar.a(i3, this.k).b();
        }
        return Pair.create(Integer.valueOf(i3), Long.valueOf(c2));
    }

    private void j() throws ac, IOException {
        if (this.F == null) {
            this.p.a();
            return;
        }
        k();
        a aVar = this.C;
        int i2 = 0;
        if (aVar == null || aVar.b()) {
            b(false);
        } else {
            a aVar2 = this.C;
            if (aVar2 != null && aVar2.l) {
                l();
            }
        }
        if (this.E != null) {
            while (true) {
                a aVar3 = this.E;
                if (aVar3 != this.D && this.B >= aVar3.k.f9093e) {
                    this.E.e();
                    b(this.E.k);
                    this.l = new b(this.E.f9094f, this.E.f9095g);
                    d();
                    this.h.obtainMessage(5, this.l).sendToTarget();
                }
            }
            if (this.D.h) {
                while (true) {
                    am[] amVarArr = this.f9082a;
                    if (i2 < amVarArr.length) {
                        am amVar = amVarArr[i2];
                        z zVar = this.D.f9091c[i2];
                        if (zVar != null && amVar.f() == zVar && amVar.g()) {
                            amVar.h();
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } else {
                int i3 = 0;
                while (true) {
                    am[] amVarArr2 = this.f9082a;
                    if (i3 < amVarArr2.length) {
                        am amVar2 = amVarArr2[i3];
                        z zVar2 = this.D.f9091c[i3];
                        if (amVar2.f() != zVar2) {
                            return;
                        }
                        if (zVar2 == null || amVar2.g()) {
                            i3++;
                        } else {
                            return;
                        }
                    } else if (this.D.k != null && this.D.k.i) {
                        i iVar = this.D.m;
                        this.D = this.D.k;
                        i iVar2 = this.D.m;
                        boolean z2 = this.D.f9089a.d() != -9223372036854775807L;
                        int i4 = 0;
                        while (true) {
                            am[] amVarArr3 = this.f9082a;
                            if (i4 < amVarArr3.length) {
                                am amVar3 = amVarArr3[i4];
                                if (iVar.f10740b.a(i4) != null) {
                                    if (z2) {
                                        amVar3.h();
                                    } else if (!amVar3.i()) {
                                        f a2 = iVar2.f10740b.a(i4);
                                        ao aoVar = iVar.f10742d[i4];
                                        ao aoVar2 = iVar2.f10742d[i4];
                                        if (a2 == null || !aoVar2.equals(aoVar)) {
                                            amVar3.h();
                                        } else {
                                            j[] jVarArr = new j[a2.e()];
                                            for (int i5 = 0; i5 < jVarArr.length; i5++) {
                                                jVarArr[i5] = a2.a(i5);
                                            }
                                            amVar3.a(jVarArr, this.D.f9091c[i4], this.D.a());
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
        int i2;
        long j2;
        a aVar = this.C;
        if (aVar == null) {
            i2 = this.l.f9096a;
        } else {
            int i3 = aVar.f9094f;
            if (!this.C.h && this.C.b() && this.F.a(i3, this.k).b() != -9223372036854775807L) {
                a aVar2 = this.E;
                if (aVar2 == null || i3 - aVar2.f9094f != 100) {
                    i2 = this.C.f9094f + 1;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        if (i2 >= this.F.a()) {
            this.p.a();
            return;
        }
        long j3 = 0;
        if (this.C == null) {
            j3 = this.l.f9098c;
        } else {
            int i4 = this.F.a(i2, this.k).f9125c;
            if (i2 == this.F.a(i4, this.j).f9134f) {
                Pair<Integer, Long> a2 = a(this.F, i4, -9223372036854775807L, Math.max(0, (this.C.a() + this.F.a(this.C.f9094f, this.k).b()) - this.B));
                if (a2 != null) {
                    int intValue = ((Integer) a2.first).intValue();
                    j3 = ((Long) a2.second).longValue();
                    i2 = intValue;
                } else {
                    return;
                }
            }
        }
        long j4 = j3;
        a aVar3 = this.C;
        if (aVar3 == null) {
            j2 = j4 + 60000000;
        } else {
            j2 = aVar3.a() + this.F.a(this.C.f9094f, this.k).b();
        }
        long j5 = j2;
        this.F.a(i2, this.k, true);
        a aVar4 = new a(this.f9082a, this.f9083b, j5, this.f9084c, this.f9085d, this.p, this.k.f9124b, i2, i2 == this.F.a() - 1 && !this.F.a(this.k.f9125c, this.j).f9133e, j4);
        a aVar5 = this.C;
        if (aVar5 != null) {
            aVar5.k = aVar4;
        }
        this.C = aVar4;
        this.C.f9089a.a((x.a) this);
        b(true);
    }

    private void c(x xVar) throws ac {
        a aVar = this.C;
        if (aVar != null && aVar.f9089a == xVar) {
            this.C.c();
            if (this.E == null) {
                this.D = this.C;
                a(this.D.f9095g);
                b(this.D);
            }
            l();
        }
    }

    private void d(x xVar) {
        a aVar = this.C;
        if (aVar != null && aVar.f9089a == xVar) {
            l();
        }
    }

    private void l() {
        long j2;
        if (!this.C.i) {
            j2 = 0;
        } else {
            j2 = this.C.f9089a.f();
        }
        if (j2 == Long.MIN_VALUE) {
            b(false);
            return;
        }
        long b2 = this.C.b(this.B);
        boolean a2 = this.f9085d.a(j2 - b2);
        b(a2);
        if (a2) {
            a aVar = this.C;
            aVar.l = false;
            aVar.f9089a.d(b2);
            return;
        }
        this.C.l = true;
    }

    private void a(a aVar) {
        while (aVar != null) {
            aVar.e();
            aVar = aVar.k;
        }
    }

    private void b(a aVar) throws ac {
        if (this.E != aVar) {
            boolean[] zArr = new boolean[this.f9082a.length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                am[] amVarArr = this.f9082a;
                if (i2 < amVarArr.length) {
                    am amVar = amVarArr[i2];
                    zArr[i2] = amVar.d() != 0;
                    f a2 = aVar.m.f10740b.a(i2);
                    if (a2 != null) {
                        i3++;
                    }
                    if (zArr[i2] && (a2 == null || (amVar.i() && amVar.f() == this.E.f9091c[i2]))) {
                        if (amVar == this.n) {
                            this.f9086e.a(this.o);
                            this.o = null;
                            this.n = null;
                        }
                        a(amVar);
                        amVar.l();
                    }
                    i2++;
                } else {
                    this.E = aVar;
                    this.h.obtainMessage(3, aVar.m).sendToTarget();
                    a(zArr, i3);
                    return;
                }
            }
        }
    }

    private void a(boolean[] zArr, int i2) throws ac {
        this.q = new am[i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            am[] amVarArr = this.f9082a;
            if (i3 < amVarArr.length) {
                am amVar = amVarArr[i3];
                f a2 = this.E.m.f10740b.a(i3);
                if (a2 != null) {
                    int i5 = i4 + 1;
                    this.q[i4] = amVar;
                    if (amVar.d() == 0) {
                        ao aoVar = this.E.m.f10742d[i3];
                        boolean z2 = this.s && this.v == 3;
                        boolean z3 = !zArr[i3] && z2;
                        j[] jVarArr = new j[a2.e()];
                        for (int i6 = 0; i6 < jVarArr.length; i6++) {
                            jVarArr[i6] = a2.a(i6);
                        }
                        amVar.a(aoVar, jVarArr, this.E.f9091c[i3], this.B, z3, this.E.a());
                        g c2 = amVar.c();
                        if (c2 != null) {
                            if (this.o == null) {
                                this.o = c2;
                                this.n = amVar;
                                this.o.a(this.m);
                            } else {
                                throw ac.a((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z2) {
                            amVar.e();
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
        public final x f9089a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f9090b;

        /* renamed from: c  reason: collision with root package name */
        public final z[] f9091c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f9092d;

        /* renamed from: e  reason: collision with root package name */
        public final long f9093e;

        /* renamed from: f  reason: collision with root package name */
        public int f9094f;

        /* renamed from: g  reason: collision with root package name */
        public long f9095g;
        public boolean h;
        public boolean i;
        public boolean j;
        public a k;
        public boolean l;
        public i m;
        private final am[] n;
        private final an[] o;
        private final h p;
        private final aj q;
        private final y r;
        private i s;

        public a(am[] amVarArr, an[] anVarArr, long j2, h hVar, aj ajVar, y yVar, Object obj, int i2, boolean z, long j3) {
            this.n = amVarArr;
            this.o = anVarArr;
            this.f9093e = j2;
            this.p = hVar;
            this.q = ajVar;
            this.r = yVar;
            this.f9090b = com.google.android.exoplayer2.n.a.a(obj);
            this.f9094f = i2;
            this.h = z;
            this.f9095g = j3;
            this.f9091c = new z[amVarArr.length];
            this.f9092d = new boolean[amVarArr.length];
            this.f9089a = yVar.a(i2, ajVar.d(), j3);
        }

        public long a(long j2) {
            return j2 + a();
        }

        public long b(long j2) {
            return j2 - a();
        }

        public long a() {
            return this.f9093e - this.f9095g;
        }

        public void a(int i2, boolean z) {
            this.f9094f = i2;
            this.h = z;
        }

        public boolean b() {
            return this.i && (!this.j || this.f9089a.e() == Long.MIN_VALUE);
        }

        public void c() throws ac {
            this.i = true;
            d();
            this.f9095g = a(this.f9095g, false);
        }

        public boolean d() throws ac {
            i a2 = this.p.a(this.o, this.f9089a.c());
            if (a2.a(this.s)) {
                return false;
            }
            this.m = a2;
            return true;
        }

        public long a(long j2, boolean z) {
            return a(j2, z, new boolean[this.n.length]);
        }

        public long a(long j2, boolean z, boolean[] zArr) {
            com.google.android.exoplayer2.l.g gVar = this.m.f10740b;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= gVar.f10735a) {
                    break;
                }
                boolean[] zArr2 = this.f9092d;
                if (z || !this.m.a(this.s, i2)) {
                    z2 = false;
                }
                zArr2[i2] = z2;
                i2++;
            }
            long a2 = this.f9089a.a(gVar.a(), this.f9092d, this.f9091c, zArr, j2);
            this.s = this.m;
            this.j = false;
            int i3 = 0;
            while (true) {
                z[] zVarArr = this.f9091c;
                if (i3 < zVarArr.length) {
                    if (zVarArr[i3] != null) {
                        com.google.android.exoplayer2.n.a.b(gVar.a(i3) != null);
                        this.j = true;
                    } else {
                        com.google.android.exoplayer2.n.a.b(gVar.a(i3) == null);
                    }
                    i3++;
                } else {
                    this.q.a(this.n, this.m.f10739a, gVar);
                    return a2;
                }
            }
        }

        public void e() {
            try {
                this.r.a(this.f9089a);
            } catch (RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
            }
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final ar f9100a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9101b;

        /* renamed from: c  reason: collision with root package name */
        public final long f9102c;

        public c(ar arVar, int i, long j) {
            this.f9100a = arVar;
            this.f9101b = i;
            this.f9102c = j;
        }
    }
}
