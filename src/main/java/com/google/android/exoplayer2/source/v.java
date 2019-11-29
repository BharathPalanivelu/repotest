package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.e.d;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.m.r;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.tencent.imsdk.BaseConstants;
import java.io.EOFException;
import java.io.IOException;

final class v implements d.c, h, r.a<a>, x {
    private boolean A;
    private long B;
    private long C;
    private long D;
    private int E;
    private boolean F;
    /* access modifiers changed from: private */
    public boolean G;

    /* renamed from: a  reason: collision with root package name */
    private final Uri f12159a;

    /* renamed from: b  reason: collision with root package name */
    private final f f12160b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12161c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f12162d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final w.a f12163e;

    /* renamed from: f  reason: collision with root package name */
    private final y.a f12164f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.m.b f12165g;
    /* access modifiers changed from: private */
    public final String h;
    private final r i = new r("Loader:ExtractorMediaPeriod");
    private final b j;
    private final com.google.android.exoplayer2.n.d k;
    private final Runnable l;
    /* access modifiers changed from: private */
    public final Runnable m;
    /* access modifiers changed from: private */
    public final Handler n;
    /* access modifiers changed from: private */
    public final SparseArray<d> o;
    /* access modifiers changed from: private */
    public x.a p;
    private m q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private ad w;
    private long x;
    private boolean[] y;
    private boolean[] z;

    public void a(long j2) {
    }

    public v(Uri uri, f fVar, com.google.android.exoplayer2.e.f[] fVarArr, int i2, Handler handler, w.a aVar, y.a aVar2, com.google.android.exoplayer2.m.b bVar, String str) {
        this.f12159a = uri;
        this.f12160b = fVar;
        this.f12161c = i2;
        this.f12162d = handler;
        this.f12163e = aVar;
        this.f12164f = aVar2;
        this.f12165g = bVar;
        this.h = str;
        this.j = new b(fVarArr, this);
        this.k = new com.google.android.exoplayer2.n.d();
        this.l = new Runnable() {
            public void run() {
                v.this.i();
            }
        };
        this.m = new Runnable() {
            public void run() {
                if (!v.this.G) {
                    v.this.p.a(v.this);
                }
            }
        };
        this.n = new Handler();
        this.D = -9223372036854775807L;
        this.o = new SparseArray<>();
        this.B = -1;
    }

    public void g() {
        final b bVar = this.j;
        this.i.a((Runnable) new Runnable() {
            public void run() {
                bVar.a();
                int size = v.this.o.size();
                for (int i = 0; i < size; i++) {
                    ((d) v.this.o.valueAt(i)).c();
                }
            }
        });
        this.n.removeCallbacksAndMessages((Object) null);
        this.G = true;
    }

    public void a(x.a aVar) {
        this.p = aVar;
        this.k.a();
        j();
    }

    public void b() throws IOException {
        h();
    }

    public ad c() {
        return this.w;
    }

    public long a(com.google.android.exoplayer2.l.f[] fVarArr, boolean[] zArr, z[] zVarArr, boolean[] zArr2, long j2) {
        com.google.android.exoplayer2.n.a.b(this.s);
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            if (zVarArr[i2] != null && (fVarArr[i2] == null || !zArr[i2])) {
                int a2 = zVarArr[i2].f12183b;
                com.google.android.exoplayer2.n.a.b(this.y[a2]);
                this.v--;
                this.y[a2] = false;
                this.o.valueAt(a2).c();
                zVarArr[i2] = null;
            }
        }
        boolean z2 = false;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (zVarArr[i3] == null && fVarArr[i3] != null) {
                com.google.android.exoplayer2.l.f fVar = fVarArr[i3];
                com.google.android.exoplayer2.n.a.b(fVar.e() == 1);
                com.google.android.exoplayer2.n.a.b(fVar.b(0) == 0);
                int a3 = this.w.a(fVar.d());
                com.google.android.exoplayer2.n.a.b(!this.y[a3]);
                this.v++;
                this.y[a3] = true;
                zVarArr[i3] = new c(a3);
                zArr2[i3] = true;
                z2 = true;
            }
        }
        if (!this.t) {
            int size = this.o.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.y[i4]) {
                    this.o.valueAt(i4).c();
                }
            }
        }
        if (this.v == 0) {
            this.u = false;
            if (this.i.a()) {
                this.i.b();
            }
        } else if (!this.t ? j2 != 0 : z2) {
            j2 = b(j2);
            for (int i5 = 0; i5 < zVarArr.length; i5++) {
                if (zVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.t = true;
        return j2;
    }

    public boolean d(long j2) {
        if (this.F) {
            return false;
        }
        if (this.s && this.v == 0) {
            return false;
        }
        boolean a2 = this.k.a();
        if (this.i.a()) {
            return a2;
        }
        j();
        return true;
    }

    public long f() {
        if (this.v == 0) {
            return Long.MIN_VALUE;
        }
        return e();
    }

    public long d() {
        if (!this.u) {
            return -9223372036854775807L;
        }
        this.u = false;
        return this.C;
    }

    public long e() {
        long j2;
        if (this.F) {
            return Long.MIN_VALUE;
        }
        if (m()) {
            return this.D;
        }
        if (this.A) {
            j2 = Clock.MAX_TIME;
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.z[i2]) {
                    j2 = Math.min(j2, this.o.valueAt(i2).h());
                }
            }
        } else {
            j2 = l();
        }
        return j2 == Long.MIN_VALUE ? this.C : j2;
    }

    public long b(long j2) {
        if (!this.q.a()) {
            j2 = 0;
        }
        this.C = j2;
        int size = this.o.size();
        boolean z2 = !m();
        int i2 = 0;
        while (z2 && i2 < size) {
            if (this.y[i2]) {
                z2 = this.o.valueAt(i2).a(j2, false);
            }
            i2++;
        }
        if (!z2) {
            this.D = j2;
            this.F = false;
            if (this.i.a()) {
                this.i.b();
            } else {
                for (int i3 = 0; i3 < size; i3++) {
                    this.o.valueAt(i3).a(this.y[i3]);
                }
            }
        }
        this.u = false;
        return j2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return this.F || (!m() && !this.o.valueAt(i2).d());
    }

    /* access modifiers changed from: package-private */
    public void h() throws IOException {
        this.i.d();
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, ah ahVar, e eVar, boolean z2) {
        if (this.u || m()) {
            return -3;
        }
        return this.o.valueAt(i2).a(ahVar, eVar, z2, this.F, this.C);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        d valueAt = this.o.valueAt(i2);
        if (!this.F || j2 <= valueAt.h()) {
            valueAt.a(j2, true);
        } else {
            valueAt.i();
        }
    }

    public void a(a aVar, long j2, long j3) {
        a(aVar);
        this.F = true;
        if (this.x == -9223372036854775807L) {
            long l2 = l();
            this.x = l2 == Long.MIN_VALUE ? 0 : l2 + 10000;
            this.f12164f.a(new ab(this.x, this.q.a()), (Object) null);
        }
        this.p.a(this);
    }

    public void a(a aVar, long j2, long j3, boolean z2) {
        a(aVar);
        if (!z2 && this.v > 0) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.o.valueAt(i2).a(this.y[i2]);
            }
            this.p.a(this);
        }
    }

    public int a(a aVar, long j2, long j3, IOException iOException) {
        a(aVar);
        b(iOException);
        if (a(iOException)) {
            return 3;
        }
        int i2 = k() > this.E ? 1 : 0;
        b(aVar);
        this.E = k();
        return i2;
    }

    public n a(int i2, int i3) {
        d dVar = this.o.get(i2);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this.f12165g);
        dVar2.a((d.c) this);
        this.o.put(i2, dVar2);
        return dVar2;
    }

    public void a() {
        this.r = true;
        this.n.post(this.l);
    }

    public void a(m mVar) {
        this.q = mVar;
        this.n.post(this.l);
    }

    public void a(j jVar) {
        this.n.post(this.l);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public void i() {
        /*
            r8 = this;
            boolean r0 = r8.G
            if (r0 != 0) goto L_0x009d
            boolean r0 = r8.s
            if (r0 != 0) goto L_0x009d
            com.google.android.exoplayer2.e.m r0 = r8.q
            if (r0 == 0) goto L_0x009d
            boolean r0 = r8.r
            if (r0 != 0) goto L_0x0012
            goto L_0x009d
        L_0x0012:
            android.util.SparseArray<com.google.android.exoplayer2.e.d> r0 = r8.o
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002e
            android.util.SparseArray<com.google.android.exoplayer2.e.d> r3 = r8.o
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.exoplayer2.e.d r3 = (com.google.android.exoplayer2.e.d) r3
            com.google.android.exoplayer2.j r3 = r3.g()
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            com.google.android.exoplayer2.n.d r2 = r8.k
            r2.b()
            com.google.android.exoplayer2.source.ac[] r2 = new com.google.android.exoplayer2.source.ac[r0]
            boolean[] r3 = new boolean[r0]
            r8.z = r3
            boolean[] r3 = new boolean[r0]
            r8.y = r3
            com.google.android.exoplayer2.e.m r3 = r8.q
            long r3 = r3.b()
            r8.x = r3
            r3 = 0
        L_0x0046:
            r4 = 1
            if (r3 >= r0) goto L_0x007c
            android.util.SparseArray<com.google.android.exoplayer2.e.d> r5 = r8.o
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.exoplayer2.e.d r5 = (com.google.android.exoplayer2.e.d) r5
            com.google.android.exoplayer2.j r5 = r5.g()
            com.google.android.exoplayer2.source.ac r6 = new com.google.android.exoplayer2.source.ac
            com.google.android.exoplayer2.j[] r7 = new com.google.android.exoplayer2.j[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.f10427f
            boolean r6 = com.google.android.exoplayer2.n.h.b(r5)
            if (r6 != 0) goto L_0x0070
            boolean r5 = com.google.android.exoplayer2.n.h.a(r5)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean[] r5 = r8.z
            r5[r3] = r4
            boolean r5 = r8.A
            r4 = r4 | r5
            r8.A = r4
            int r3 = r3 + 1
            goto L_0x0046
        L_0x007c:
            com.google.android.exoplayer2.source.ad r0 = new com.google.android.exoplayer2.source.ad
            r0.<init>(r2)
            r8.w = r0
            r8.s = r4
            com.google.android.exoplayer2.source.y$a r0 = r8.f12164f
            com.google.android.exoplayer2.source.ab r1 = new com.google.android.exoplayer2.source.ab
            long r2 = r8.x
            com.google.android.exoplayer2.e.m r4 = r8.q
            boolean r4 = r4.a()
            r1.<init>(r2, r4)
            r2 = 0
            r0.a(r1, r2)
            com.google.android.exoplayer2.source.x$a r0 = r8.p
            r0.a(r8)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.v.i():void");
    }

    private void a(a aVar) {
        if (this.B == -1) {
            this.B = aVar.j;
        }
    }

    private void j() {
        a aVar = new a(this.f12159a, this.f12160b, this.j, this.k);
        if (this.s) {
            com.google.android.exoplayer2.n.a.b(m());
            long j2 = this.x;
            if (j2 == -9223372036854775807L || this.D < j2) {
                aVar.a(this.q.b(this.D), this.D);
                this.D = -9223372036854775807L;
            } else {
                this.F = true;
                this.D = -9223372036854775807L;
                return;
            }
        }
        this.E = k();
        int i2 = this.f12161c;
        if (i2 == -1) {
            if (this.s && this.B == -1) {
                m mVar = this.q;
                if (mVar == null || mVar.b() == -9223372036854775807L) {
                    i2 = 6;
                }
            }
            i2 = 3;
        }
        this.i.a(aVar, this, i2);
    }

    private void b(a aVar) {
        if (this.B == -1) {
            m mVar = this.q;
            if (mVar == null || mVar.b() == -9223372036854775807L) {
                this.C = 0;
                this.u = this.s;
                int size = this.o.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.o.valueAt(i2).a(!this.s || this.y[i2]);
                }
                aVar.a(0, 0);
            }
        }
    }

    private int k() {
        int size = this.o.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.o.valueAt(i3).b();
        }
        return i2;
    }

    private long l() {
        int size = this.o.size();
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.max(j2, this.o.valueAt(i2).h());
        }
        return j2;
    }

    private boolean m() {
        return this.D != -9223372036854775807L;
    }

    private boolean a(IOException iOException) {
        return iOException instanceof ae;
    }

    private void b(final IOException iOException) {
        Handler handler = this.f12162d;
        if (handler != null && this.f12163e != null) {
            handler.post(new Runnable() {
                public void run() {
                    v.this.f12163e.onLoadError(iOException);
                }
            });
        }
    }

    private final class c implements z {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f12183b;

        public c(int i) {
            this.f12183b = i;
        }

        public boolean d() {
            return v.this.a(this.f12183b);
        }

        public void e() throws IOException {
            v.this.h();
        }

        public int a(ah ahVar, e eVar, boolean z) {
            return v.this.a(this.f12183b, ahVar, eVar, z);
        }

        public void c(long j) {
            v.this.a(this.f12183b, j);
        }
    }

    final class a implements r.c {

        /* renamed from: b  reason: collision with root package name */
        private final Uri f12173b;

        /* renamed from: c  reason: collision with root package name */
        private final f f12174c;

        /* renamed from: d  reason: collision with root package name */
        private final b f12175d;

        /* renamed from: e  reason: collision with root package name */
        private final com.google.android.exoplayer2.n.d f12176e;

        /* renamed from: f  reason: collision with root package name */
        private final l f12177f = new l();

        /* renamed from: g  reason: collision with root package name */
        private volatile boolean f12178g;
        private boolean h = true;
        private long i;
        /* access modifiers changed from: private */
        public long j = -1;

        public a(Uri uri, f fVar, b bVar, com.google.android.exoplayer2.n.d dVar) {
            this.f12173b = (Uri) com.google.android.exoplayer2.n.a.a(uri);
            this.f12174c = (f) com.google.android.exoplayer2.n.a.a(fVar);
            this.f12175d = (b) com.google.android.exoplayer2.n.a.a(bVar);
            this.f12176e = dVar;
        }

        public void a(long j2, long j3) {
            this.f12177f.f9779a = j2;
            this.i = j3;
            this.h = true;
        }

        public void a() {
            this.f12178g = true;
        }

        public boolean b() {
            return this.f12178g;
        }

        public void c() throws IOException, InterruptedException {
            com.google.android.exoplayer2.e.b bVar;
            int i2 = 0;
            while (i2 == 0 && !this.f12178g) {
                try {
                    long j2 = this.f12177f.f9779a;
                    this.j = this.f12174c.a(new i(this.f12173b, j2, -1, v.this.h));
                    if (this.j != -1) {
                        this.j += j2;
                    }
                    bVar = new com.google.android.exoplayer2.e.b(this.f12174c, j2, this.j);
                    try {
                        com.google.android.exoplayer2.e.f a2 = this.f12175d.a(bVar, this.f12174c.a());
                        if (this.h) {
                            a2.a(j2, this.i);
                            this.h = false;
                        }
                        while (i2 == 0 && !this.f12178g) {
                            this.f12176e.c();
                            i2 = a2.a((g) bVar, this.f12177f);
                            if (bVar.c() > BaseConstants.MEGA + j2) {
                                j2 = bVar.c();
                                this.f12176e.b();
                                v.this.n.post(v.this.m);
                            }
                        }
                        if (i2 == 1) {
                            i2 = 0;
                        } else {
                            this.f12177f.f9779a = bVar.c();
                        }
                        t.a(this.f12174c);
                    } catch (Throwable th) {
                        th = th;
                        this.f12177f.f9779a = bVar.c();
                        t.a(this.f12174c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                    if (!(i2 == 1 || bVar == null)) {
                        this.f12177f.f9779a = bVar.c();
                    }
                    t.a(this.f12174c);
                    throw th;
                }
            }
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.e.f[] f12179a;

        /* renamed from: b  reason: collision with root package name */
        private final h f12180b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.exoplayer2.e.f f12181c;

        public b(com.google.android.exoplayer2.e.f[] fVarArr, h hVar) {
            this.f12179a = fVarArr;
            this.f12180b = hVar;
        }

        public com.google.android.exoplayer2.e.f a(g gVar, Uri uri) throws IOException, InterruptedException {
            com.google.android.exoplayer2.e.f fVar = this.f12181c;
            if (fVar != null) {
                return fVar;
            }
            com.google.android.exoplayer2.e.f[] fVarArr = this.f12179a;
            int length = fVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.google.android.exoplayer2.e.f fVar2 = fVarArr[i];
                try {
                    if (fVar2.a(gVar)) {
                        this.f12181c = fVar2;
                        gVar.a();
                        break;
                    }
                    gVar.a();
                    i++;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    gVar.a();
                    throw th;
                }
            }
            com.google.android.exoplayer2.e.f fVar3 = this.f12181c;
            if (fVar3 != null) {
                fVar3.a(this.f12180b);
                return this.f12181c;
            }
            throw new ae("None of the available extractors (" + t.a((Object[]) this.f12179a) + ") could read the stream.", uri);
        }

        public void a() {
            com.google.android.exoplayer2.e.f fVar = this.f12181c;
            if (fVar != null) {
                fVar.c();
                this.f12181c = null;
            }
        }
    }
}
