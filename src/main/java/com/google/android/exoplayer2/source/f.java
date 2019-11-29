package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.r.r;
import com.google.android.exoplayer2.s.e;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.k;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

final class f implements g, r.a<a>, r.d, h, k.b {
    private boolean[] A;
    private boolean[] B;
    private boolean C;
    private long D;
    private long E;
    private long F;
    private int G;
    private boolean H;
    /* access modifiers changed from: private */
    public boolean I;

    /* renamed from: a  reason: collision with root package name */
    private final Uri f12052a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.r.f f12053b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12054c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f12055d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final g.a f12056e;

    /* renamed from: f  reason: collision with root package name */
    private final c f12057f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.r.b f12058g;
    /* access modifiers changed from: private */
    public final String h;
    /* access modifiers changed from: private */
    public final long i;
    private final r j = new r("Loader:ExtractorMediaPeriod");
    private final b k;
    private final e l;
    private final Runnable m;
    /* access modifiers changed from: private */
    public final Runnable n;
    /* access modifiers changed from: private */
    public final Handler o;
    /* access modifiers changed from: private */
    public h.a p;
    private l q;
    private k[] r;
    private int[] s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private p y;
    private long z;

    interface c {
        void a(long j, boolean z);
    }

    public f(Uri uri, com.google.android.exoplayer2.r.f fVar, com.google.android.exoplayer2.i.e[] eVarArr, int i2, Handler handler, g.a aVar, c cVar, com.google.android.exoplayer2.r.b bVar, String str, int i3) {
        this.f12052a = uri;
        this.f12053b = fVar;
        this.f12054c = i2;
        this.f12055d = handler;
        this.f12056e = aVar;
        this.f12057f = cVar;
        this.f12058g = bVar;
        this.h = str;
        this.i = (long) i3;
        this.k = new b(eVarArr, this);
        this.l = new e();
        this.m = new Runnable() {
            public void run() {
                f.this.i();
            }
        };
        this.n = new Runnable() {
            public void run() {
                if (!f.this.I) {
                    f.this.p.a(f.this);
                }
            }
        };
        this.o = new Handler();
        this.s = new int[0];
        this.r = new k[0];
        this.F = -9223372036854775807L;
        this.D = -1;
    }

    public void f() {
        boolean a2 = this.j.a((r.d) this);
        if (this.u && !a2) {
            for (k k2 : this.r) {
                k2.k();
            }
        }
        this.o.removeCallbacksAndMessages((Object) null);
        this.I = true;
    }

    public void g() {
        this.k.a();
        for (k a2 : this.r) {
            a2.a();
        }
    }

    public void a(h.a aVar, long j2) {
        this.p = aVar;
        this.l.a();
        j();
    }

    public void j_() throws IOException {
        h();
    }

    public p b() {
        return this.y;
    }

    public long a(com.google.android.exoplayer2.q.f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j2) {
        com.google.android.exoplayer2.s.a.b(this.u);
        int i2 = this.x;
        int i3 = 0;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            if (lVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                int a2 = lVarArr[i4].f12074b;
                com.google.android.exoplayer2.s.a.b(this.A[a2]);
                this.x--;
                this.A[a2] = false;
                lVarArr[i4] = null;
            }
        }
        boolean z2 = !this.v ? j2 != 0 : i2 == 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (lVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.q.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.s.a.b(fVar.e() == 1);
                com.google.android.exoplayer2.s.a.b(fVar.b(0) == 0);
                int a3 = this.y.a(fVar.d());
                com.google.android.exoplayer2.s.a.b(!this.A[a3]);
                this.x++;
                this.A[a3] = true;
                lVarArr[i5] = new d(a3);
                zArr2[i5] = true;
                if (!z2) {
                    k kVar = this.r[a3];
                    kVar.i();
                    z2 = !kVar.b(j2, true, true) && kVar.e() != 0;
                }
            }
        }
        if (this.x == 0) {
            this.w = false;
            if (this.j.a()) {
                k[] kVarArr = this.r;
                int length = kVarArr.length;
                while (i3 < length) {
                    kVarArr[i3].k();
                    i3++;
                }
                this.j.b();
            } else {
                k[] kVarArr2 = this.r;
                int length2 = kVarArr2.length;
                while (i3 < length2) {
                    kVarArr2[i3].a();
                    i3++;
                }
            }
        } else if (z2) {
            j2 = b(j2);
            while (i3 < lVarArr.length) {
                if (lVarArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.v = true;
        return j2;
    }

    public void a(long j2) {
        int length = this.r.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.r[i2].a(j2, false, this.A[i2]);
        }
    }

    public boolean c(long j2) {
        if (this.H) {
            return false;
        }
        if (this.u && this.x == 0) {
            return false;
        }
        boolean a2 = this.l.a();
        if (this.j.a()) {
            return a2;
        }
        j();
        return true;
    }

    public long e() {
        if (this.x == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public long c() {
        if (!this.w) {
            return -9223372036854775807L;
        }
        this.w = false;
        return this.E;
    }

    public long d() {
        long j2;
        if (this.H) {
            return Long.MIN_VALUE;
        }
        if (m()) {
            return this.F;
        }
        if (this.C) {
            j2 = Clock.MAX_TIME;
            int length = this.r.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.B[i2]) {
                    j2 = Math.min(j2, this.r[i2].h());
                }
            }
        } else {
            j2 = l();
        }
        return j2 == Long.MIN_VALUE ? this.E : j2;
    }

    public long b(long j2) {
        if (!this.q.a()) {
            j2 = 0;
        }
        this.E = j2;
        this.w = false;
        if (!m() && d(j2)) {
            return j2;
        }
        this.F = j2;
        this.H = false;
        if (this.j.a()) {
            this.j.b();
        } else {
            for (k a2 : this.r) {
                a2.a();
            }
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return this.H || (!m() && this.r[i2].d());
    }

    /* access modifiers changed from: package-private */
    public void h() throws IOException {
        this.j.d();
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, com.google.android.exoplayer2.l lVar, com.google.android.exoplayer2.g.e eVar, boolean z2) {
        if (this.w || m()) {
            return -3;
        }
        return this.r[i2].a(lVar, eVar, z2, this.H, this.E);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        k kVar = this.r[i2];
        if (!this.H || j2 <= kVar.h()) {
            kVar.b(j2, true, true);
        } else {
            kVar.l();
        }
    }

    public void a(a aVar, long j2, long j3) {
        a(aVar);
        this.H = true;
        if (this.z == -9223372036854775807L) {
            long l2 = l();
            this.z = l2 == Long.MIN_VALUE ? 0 : l2 + 10000;
            this.f12057f.a(this.z, this.q.a());
        }
        this.p.a(this);
    }

    public void a(a aVar, long j2, long j3, boolean z2) {
        if (!z2) {
            a(aVar);
            for (k a2 : this.r) {
                a2.a();
            }
            if (this.x > 0) {
                this.p.a(this);
            }
        }
    }

    public int a(a aVar, long j2, long j3, IOException iOException) {
        a(aVar);
        b(iOException);
        if (a(iOException)) {
            return 3;
        }
        int i2 = k() > this.G ? 1 : 0;
        b(aVar);
        this.G = k();
        return i2;
    }

    public m a(int i2, int i3) {
        int length = this.r.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.s[i4] == i2) {
                return this.r[i4];
            }
        }
        k kVar = new k(this.f12058g);
        kVar.a((k.b) this);
        int i5 = length + 1;
        this.s = Arrays.copyOf(this.s, i5);
        this.s[length] = i2;
        this.r = (k[]) Arrays.copyOf(this.r, i5);
        this.r[length] = kVar;
        return kVar;
    }

    public void a() {
        this.t = true;
        this.o.post(this.m);
    }

    public void a(l lVar) {
        this.q = lVar;
        this.o.post(this.m);
    }

    public void a(Format format) {
        this.o.post(this.m);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v1 ?, r4v3 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public void i() {
        /*
            r8 = this;
            boolean r0 = r8.I
            if (r0 != 0) goto L_0x008d
            boolean r0 = r8.u
            if (r0 != 0) goto L_0x008d
            com.google.android.exoplayer2.i.l r0 = r8.q
            if (r0 == 0) goto L_0x008d
            boolean r0 = r8.t
            if (r0 != 0) goto L_0x0012
            goto L_0x008d
        L_0x0012:
            com.google.android.exoplayer2.source.k[] r0 = r8.r
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0017:
            if (r3 >= r1) goto L_0x0025
            r4 = r0[r3]
            com.google.android.exoplayer2.Format r4 = r4.g()
            if (r4 != 0) goto L_0x0022
            return
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0025:
            com.google.android.exoplayer2.s.e r0 = r8.l
            r0.b()
            com.google.android.exoplayer2.source.k[] r0 = r8.r
            int r0 = r0.length
            com.google.android.exoplayer2.source.o[] r1 = new com.google.android.exoplayer2.source.o[r0]
            boolean[] r3 = new boolean[r0]
            r8.B = r3
            boolean[] r3 = new boolean[r0]
            r8.A = r3
            com.google.android.exoplayer2.i.l r3 = r8.q
            long r3 = r3.b()
            r8.z = r3
            r3 = 0
        L_0x0040:
            r4 = 1
            if (r3 >= r0) goto L_0x0072
            com.google.android.exoplayer2.source.k[] r5 = r8.r
            r5 = r5[r3]
            com.google.android.exoplayer2.Format r5 = r5.g()
            com.google.android.exoplayer2.source.o r6 = new com.google.android.exoplayer2.source.o
            com.google.android.exoplayer2.Format[] r7 = new com.google.android.exoplayer2.Format[r4]
            r7[r2] = r5
            r6.<init>(r7)
            r1[r3] = r6
            java.lang.String r5 = r5.f8958f
            boolean r6 = com.google.android.exoplayer2.s.i.b(r5)
            if (r6 != 0) goto L_0x0066
            boolean r5 = com.google.android.exoplayer2.s.i.a(r5)
            if (r5 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            boolean[] r5 = r8.B
            r5[r3] = r4
            boolean r5 = r8.C
            r4 = r4 | r5
            r8.C = r4
            int r3 = r3 + 1
            goto L_0x0040
        L_0x0072:
            com.google.android.exoplayer2.source.p r0 = new com.google.android.exoplayer2.source.p
            r0.<init>(r1)
            r8.y = r0
            r8.u = r4
            com.google.android.exoplayer2.source.f$c r0 = r8.f12057f
            long r1 = r8.z
            com.google.android.exoplayer2.i.l r3 = r8.q
            boolean r3 = r3.a()
            r0.a(r1, r3)
            com.google.android.exoplayer2.source.h$a r0 = r8.p
            r0.a(r8)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.f.i():void");
    }

    private void a(a aVar) {
        if (this.D == -1) {
            this.D = aVar.j;
        }
    }

    private void j() {
        a aVar = new a(this.f12052a, this.f12053b, this.k, this.l);
        if (this.u) {
            com.google.android.exoplayer2.s.a.b(m());
            long j2 = this.z;
            if (j2 == -9223372036854775807L || this.F < j2) {
                aVar.a(this.q.b(this.F), this.F);
                this.F = -9223372036854775807L;
            } else {
                this.H = true;
                this.F = -9223372036854775807L;
                return;
            }
        }
        this.G = k();
        int i2 = this.f12054c;
        if (i2 == -1) {
            if (this.u && this.D == -1) {
                l lVar = this.q;
                if (lVar == null || lVar.b() == -9223372036854775807L) {
                    i2 = 6;
                }
            }
            i2 = 3;
        }
        this.j.a(aVar, this, i2);
    }

    private void b(a aVar) {
        if (this.D == -1) {
            l lVar = this.q;
            if (lVar == null || lVar.b() == -9223372036854775807L) {
                this.E = 0;
                this.w = this.u;
                for (k a2 : this.r) {
                    a2.a();
                }
                aVar.a(0, 0);
            }
        }
    }

    private boolean d(long j2) {
        int length = this.r.length;
        for (int i2 = 0; i2 < length; i2++) {
            k kVar = this.r[i2];
            kVar.i();
            if (!kVar.b(j2, true, false) && (this.B[i2] || !this.C)) {
                return false;
            }
            kVar.j();
        }
        return true;
    }

    private int k() {
        int i2 = 0;
        for (k c2 : this.r) {
            i2 += c2.c();
        }
        return i2;
    }

    private long l() {
        long j2 = Long.MIN_VALUE;
        for (k h2 : this.r) {
            j2 = Math.max(j2, h2.h());
        }
        return j2;
    }

    private boolean m() {
        return this.F != -9223372036854775807L;
    }

    private boolean a(IOException iOException) {
        return iOException instanceof q;
    }

    private void b(final IOException iOException) {
        Handler handler = this.f12055d;
        if (handler != null && this.f12056e != null) {
            handler.post(new Runnable() {
                public void run() {
                    f.this.f12056e.a(iOException);
                }
            });
        }
    }

    private final class d implements l {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f12074b;

        public d(int i) {
            this.f12074b = i;
        }

        public boolean c() {
            return f.this.a(this.f12074b);
        }

        public void k_() throws IOException {
            f.this.h();
        }

        public int a(com.google.android.exoplayer2.l lVar, com.google.android.exoplayer2.g.e eVar, boolean z) {
            return f.this.a(this.f12074b, lVar, eVar, z);
        }

        public void a(long j) {
            f.this.a(this.f12074b, j);
        }
    }

    final class a implements r.c {

        /* renamed from: b  reason: collision with root package name */
        private final Uri f12064b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.android.exoplayer2.r.f f12065c;

        /* renamed from: d  reason: collision with root package name */
        private final b f12066d;

        /* renamed from: e  reason: collision with root package name */
        private final e f12067e;

        /* renamed from: f  reason: collision with root package name */
        private final com.google.android.exoplayer2.i.k f12068f = new com.google.android.exoplayer2.i.k();

        /* renamed from: g  reason: collision with root package name */
        private volatile boolean f12069g;
        private boolean h = true;
        private long i;
        /* access modifiers changed from: private */
        public long j = -1;

        public a(Uri uri, com.google.android.exoplayer2.r.f fVar, b bVar, e eVar) {
            this.f12064b = (Uri) com.google.android.exoplayer2.s.a.a(uri);
            this.f12065c = (com.google.android.exoplayer2.r.f) com.google.android.exoplayer2.s.a.a(fVar);
            this.f12066d = (b) com.google.android.exoplayer2.s.a.a(bVar);
            this.f12067e = eVar;
        }

        public void a(long j2, long j3) {
            this.f12068f.f10416a = j2;
            this.i = j3;
            this.h = true;
        }

        public void a() {
            this.f12069g = true;
        }

        public boolean b() {
            return this.f12069g;
        }

        public void c() throws IOException, InterruptedException {
            com.google.android.exoplayer2.i.b bVar;
            int i2 = 0;
            while (i2 == 0 && !this.f12069g) {
                try {
                    long j2 = this.f12068f.f10416a;
                    this.j = this.f12065c.a(new i(this.f12064b, j2, -1, f.this.h));
                    if (this.j != -1) {
                        this.j += j2;
                    }
                    bVar = new com.google.android.exoplayer2.i.b(this.f12065c, j2, this.j);
                    try {
                        com.google.android.exoplayer2.i.e a2 = this.f12066d.a(bVar, this.f12065c.b());
                        if (this.h) {
                            a2.a(j2, this.i);
                            this.h = false;
                        }
                        while (i2 == 0 && !this.f12069g) {
                            this.f12067e.c();
                            i2 = a2.a((com.google.android.exoplayer2.i.f) bVar, this.f12068f);
                            if (bVar.c() > f.this.i + j2) {
                                j2 = bVar.c();
                                this.f12067e.b();
                                f.this.o.post(f.this.n);
                            }
                        }
                        if (i2 == 1) {
                            i2 = 0;
                        } else {
                            this.f12068f.f10416a = bVar.c();
                        }
                        v.a(this.f12065c);
                    } catch (Throwable th) {
                        th = th;
                        if (!(i2 == 1 || bVar == null)) {
                            this.f12068f.f10416a = bVar.c();
                        }
                        v.a(this.f12065c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                    this.f12068f.f10416a = bVar.c();
                    v.a(this.f12065c);
                    throw th;
                }
            }
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.i.e[] f12070a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.exoplayer2.i.g f12071b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.exoplayer2.i.e f12072c;

        public b(com.google.android.exoplayer2.i.e[] eVarArr, com.google.android.exoplayer2.i.g gVar) {
            this.f12070a = eVarArr;
            this.f12071b = gVar;
        }

        public com.google.android.exoplayer2.i.e a(com.google.android.exoplayer2.i.f fVar, Uri uri) throws IOException, InterruptedException {
            com.google.android.exoplayer2.i.e eVar = this.f12072c;
            if (eVar != null) {
                return eVar;
            }
            com.google.android.exoplayer2.i.e[] eVarArr = this.f12070a;
            int length = eVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.google.android.exoplayer2.i.e eVar2 = eVarArr[i];
                try {
                    if (eVar2.a(fVar)) {
                        this.f12072c = eVar2;
                        fVar.a();
                        break;
                    }
                    fVar.a();
                    i++;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
            }
            com.google.android.exoplayer2.i.e eVar3 = this.f12072c;
            if (eVar3 != null) {
                eVar3.a(this.f12071b);
                return this.f12072c;
            }
            throw new q("None of the available extractors (" + v.a((Object[]) this.f12070a) + ") could read the stream.", uri);
        }

        public void a() {
            com.google.android.exoplayer2.i.e eVar = this.f12072c;
            if (eVar != null) {
                eVar.c();
                this.f12072c = null;
            }
        }
    }
}
