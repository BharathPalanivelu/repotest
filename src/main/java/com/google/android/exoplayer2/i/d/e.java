package com.google.android.exoplayer2.i.d;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.d.a;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;
import com.google.android.exoplayer2.s.v;
import com.path.android.jobqueue.JobManager;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class e implements com.google.android.exoplayer2.i.e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10083a = new h() {
        public com.google.android.exoplayer2.i.e[] a() {
            return new com.google.android.exoplayer2.i.e[]{new e()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f10084b = v.g("seig");

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f10085c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private int A;
    private int B;
    private int C;
    private boolean D;
    private g E;
    private m F;
    private m[] G;
    private boolean H;

    /* renamed from: d  reason: collision with root package name */
    private final int f10086d;

    /* renamed from: e  reason: collision with root package name */
    private final j f10087e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<b> f10088f;

    /* renamed from: g  reason: collision with root package name */
    private final l f10089g;
    private final l h;
    private final l i;
    private final l j;
    private final l k;
    private final s l;
    private final l m;
    private final byte[] n;
    private final Stack<a.C0169a> o;
    private final LinkedList<a> p;
    private int q;
    private int r;
    private long s;
    private int t;
    private l u;
    private long v;
    private int w;
    private long x;
    private long y;
    private b z;

    public void c() {
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, (s) null);
    }

    public e(int i2, s sVar) {
        this(i2, sVar, (j) null);
    }

    public e(int i2, s sVar, j jVar) {
        this.f10086d = i2 | (jVar != null ? 16 : 0);
        this.l = sVar;
        this.f10087e = jVar;
        this.m = new l(16);
        this.f10089g = new l(j.f11404a);
        this.h = new l(5);
        this.i = new l();
        this.j = new l(1);
        this.k = new l();
        this.n = new byte[16];
        this.o = new Stack<>();
        this.p = new LinkedList<>();
        this.f10088f = new SparseArray<>();
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        a();
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        return i.a(fVar);
    }

    public void a(g gVar) {
        this.E = gVar;
        j jVar = this.f10087e;
        if (jVar != null) {
            b bVar = new b(gVar.a(0, jVar.f10119b));
            bVar.a(this.f10087e, new c(0, 0, 0, 0));
            this.f10088f.put(0, bVar);
            b();
            this.E.a();
        }
    }

    public void a(long j2, long j3) {
        int size = this.f10088f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f10088f.valueAt(i2).a();
        }
        this.p.clear();
        this.w = 0;
        this.o.clear();
        a();
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.q;
            if (i2 != 0) {
                if (i2 == 1) {
                    c(fVar);
                } else if (i2 == 2) {
                    d(fVar);
                } else if (e(fVar)) {
                    return 0;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    private void a() {
        this.q = 0;
        this.t = 0;
    }

    private boolean b(f fVar) throws IOException, InterruptedException {
        if (this.t == 0) {
            if (!fVar.a(this.m.f11422a, 0, 8, true)) {
                return false;
            }
            this.t = 8;
            this.m.c(0);
            this.s = this.m.l();
            this.r = this.m.n();
        }
        if (this.s == 1) {
            fVar.b(this.m.f11422a, 8, 8);
            this.t += 8;
            this.s = this.m.v();
        }
        if (this.s >= ((long) this.t)) {
            long c2 = fVar.c() - ((long) this.t);
            if (this.r == a.K) {
                int size = this.f10088f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    l lVar = this.f10088f.valueAt(i2).f10092a;
                    lVar.f10131b = c2;
                    lVar.f10133d = c2;
                    lVar.f10132c = c2;
                }
            }
            if (this.r == a.h) {
                this.z = null;
                this.v = c2 + this.s;
                if (!this.H) {
                    this.E.a(new l.a(this.x));
                    this.H = true;
                }
                this.q = 2;
                return true;
            }
            if (b(this.r)) {
                long c3 = (fVar.c() + this.s) - 8;
                this.o.add(new a.C0169a(this.r, c3));
                if (this.s == ((long) this.t)) {
                    a(c3);
                } else {
                    a();
                }
            } else if (a(this.r)) {
                if (this.t == 8) {
                    long j2 = this.s;
                    if (j2 <= 2147483647L) {
                        this.u = new com.google.android.exoplayer2.s.l((int) j2);
                        System.arraycopy(this.m.f11422a, 0, this.u.f11422a, 0, 8);
                        this.q = 1;
                    } else {
                        throw new p("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new p("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.s <= 2147483647L) {
                this.u = null;
                this.q = 1;
            } else {
                throw new p("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new p("Atom size less than header length (unsupported).");
    }

    private void c(f fVar) throws IOException, InterruptedException {
        int i2 = ((int) this.s) - this.t;
        com.google.android.exoplayer2.s.l lVar = this.u;
        if (lVar != null) {
            fVar.b(lVar.f11422a, 8, i2);
            a(new a.b(this.r, this.u), fVar.c());
        } else {
            fVar.b(i2);
        }
        a(fVar.c());
    }

    private void a(long j2) throws p {
        while (!this.o.isEmpty() && this.o.peek().aQ == j2) {
            a(this.o.pop());
        }
        a();
    }

    private void a(a.b bVar, long j2) throws p {
        if (!this.o.isEmpty()) {
            this.o.peek().a(bVar);
        } else if (bVar.aP == a.A) {
            Pair<Long, com.google.android.exoplayer2.i.a> a2 = a(bVar.aQ, j2);
            this.y = ((Long) a2.first).longValue();
            this.E.a((com.google.android.exoplayer2.i.l) a2.second);
            this.H = true;
        } else if (bVar.aP == a.aG) {
            a(bVar.aQ);
        }
    }

    private void a(a.C0169a aVar) throws p {
        if (aVar.aP == a.B) {
            b(aVar);
        } else if (aVar.aP == a.K) {
            c(aVar);
        } else if (!this.o.isEmpty()) {
            this.o.peek().a(aVar);
        }
    }

    private void b(a.C0169a aVar) throws p {
        int i2;
        a.C0169a aVar2 = aVar;
        boolean z2 = true;
        int i3 = 0;
        com.google.android.exoplayer2.s.a.b(this.f10087e == null, "Unexpected moov box.");
        DrmInitData a2 = a(aVar2.aR);
        a.C0169a e2 = aVar2.e(a.M);
        SparseArray sparseArray = new SparseArray();
        int size = e2.aR.size();
        long j2 = -9223372036854775807L;
        for (int i4 = 0; i4 < size; i4++) {
            a.b bVar = e2.aR.get(i4);
            if (bVar.aP == a.y) {
                Pair<Integer, c> b2 = b(bVar.aQ);
                sparseArray.put(((Integer) b2.first).intValue(), b2.second);
            } else if (bVar.aP == a.N) {
                j2 = c(bVar.aQ);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar2.aS.size();
        int i5 = 0;
        while (i5 < size2) {
            a.C0169a aVar3 = aVar2.aS.get(i5);
            if (aVar3.aP == a.D) {
                i2 = i5;
                j a3 = b.a(aVar3, aVar2.d(a.C), j2, a2, false);
                if (a3 != null) {
                    sparseArray2.put(a3.f10118a, a3);
                }
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
        int size3 = sparseArray2.size();
        if (this.f10088f.size() == 0) {
            while (i3 < size3) {
                j jVar = (j) sparseArray2.valueAt(i3);
                b bVar2 = new b(this.E.a(i3, jVar.f10119b));
                bVar2.a(jVar, (c) sparseArray.get(jVar.f10118a));
                this.f10088f.put(jVar.f10118a, bVar2);
                this.x = Math.max(this.x, jVar.f10122e);
                i3++;
            }
            b();
            this.E.a();
            return;
        }
        if (this.f10088f.size() != size3) {
            z2 = false;
        }
        com.google.android.exoplayer2.s.a.b(z2);
        while (i3 < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i3);
            this.f10088f.get(jVar2.f10118a).a(jVar2, (c) sparseArray.get(jVar2.f10118a));
            i3++;
        }
    }

    private void c(a.C0169a aVar) throws p {
        a(aVar, this.f10088f, this.f10086d, this.n);
        DrmInitData a2 = a(aVar.aR);
        if (a2 != null) {
            int size = this.f10088f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f10088f.valueAt(i2).a(a2);
            }
        }
    }

    private void b() {
        if ((this.f10086d & 4) != 0 && this.F == null) {
            this.F = this.E.a(this.f10088f.size(), 4);
            this.F.a(Format.a((String) null, "application/x-emsg", (long) Clock.MAX_TIME));
        }
        if ((this.f10086d & 8) != 0 && this.G == null) {
            m a2 = this.E.a(this.f10088f.size() + 1, 3);
            a2.a(Format.a((String) null, "application/cea-608", 0, (String) null));
            this.G = new m[]{a2};
        }
    }

    private void a(com.google.android.exoplayer2.s.l lVar) {
        if (this.F != null) {
            lVar.c(12);
            lVar.x();
            lVar.x();
            long b2 = v.b(lVar.l(), JobManager.NS_PER_MS, lVar.l());
            lVar.c(12);
            int b3 = lVar.b();
            this.F.a(lVar, b3);
            long j2 = this.y;
            if (j2 != -9223372036854775807L) {
                this.F.a(b2 + j2, 1, b3, 0, (m.a) null);
                return;
            }
            this.p.addLast(new a(b2, b3));
            this.w += b3;
        }
    }

    private static Pair<Integer, c> b(com.google.android.exoplayer2.s.l lVar) {
        lVar.c(12);
        return Pair.create(Integer.valueOf(lVar.n()), new c(lVar.t() - 1, lVar.t(), lVar.t(), lVar.n()));
    }

    private static long c(com.google.android.exoplayer2.s.l lVar) {
        lVar.c(8);
        return a.a(lVar.n()) == 0 ? lVar.l() : lVar.v();
    }

    private static void a(a.C0169a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws p {
        int size = aVar.aS.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.C0169a aVar2 = aVar.aS.get(i3);
            if (aVar2.aP == a.L) {
                b(aVar2, sparseArray, i2, bArr);
            }
        }
    }

    private static void b(a.C0169a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws p {
        b a2 = a(aVar.d(a.x).aQ, sparseArray, i2);
        if (a2 != null) {
            l lVar = a2.f10092a;
            long j2 = lVar.s;
            a2.a();
            if (aVar.d(a.w) != null && (i2 & 2) == 0) {
                j2 = d(aVar.d(a.w).aQ);
            }
            a(aVar, a2, j2, i2);
            k a3 = a2.f10094c.a(lVar.f10130a.f10074a);
            a.b d2 = aVar.d(a.ac);
            if (d2 != null) {
                a(a3, d2.aQ, lVar);
            }
            a.b d3 = aVar.d(a.ad);
            if (d3 != null) {
                a(d3.aQ, lVar);
            }
            a.b d4 = aVar.d(a.ah);
            if (d4 != null) {
                b(d4.aQ, lVar);
            }
            a.b d5 = aVar.d(a.ae);
            a.b d6 = aVar.d(a.af);
            if (!(d5 == null || d6 == null)) {
                a(d5.aQ, d6.aQ, a3 != null ? a3.f10126b : null, lVar);
            }
            int size = aVar.aR.size();
            for (int i3 = 0; i3 < size; i3++) {
                a.b bVar = aVar.aR.get(i3);
                if (bVar.aP == a.ag) {
                    a(bVar.aQ, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0169a aVar, b bVar, long j2, int i2) {
        List<a.b> list = aVar.aR;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar2 = list.get(i5);
            if (bVar2.aP == a.z) {
                com.google.android.exoplayer2.s.l lVar = bVar2.aQ;
                lVar.c(12);
                int t2 = lVar.t();
                if (t2 > 0) {
                    i4 += t2;
                    i3++;
                }
            }
        }
        bVar.f10098g = 0;
        bVar.f10097f = 0;
        bVar.f10096e = 0;
        bVar.f10092a.a(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            a.b bVar3 = list.get(i8);
            if (bVar3.aP == a.z) {
                i7 = a(bVar, i6, j2, i2, bVar3.aQ, i7);
                i6++;
            }
        }
    }

    private static void a(k kVar, com.google.android.exoplayer2.s.l lVar, l lVar2) throws p {
        int i2;
        int i3 = kVar.f10128d;
        lVar.c(8);
        boolean z2 = true;
        if ((a.b(lVar.n()) & 1) == 1) {
            lVar.d(8);
        }
        int g2 = lVar.g();
        int t2 = lVar.t();
        if (t2 == lVar2.f10135f) {
            if (g2 == 0) {
                boolean[] zArr = lVar2.n;
                i2 = 0;
                for (int i4 = 0; i4 < t2; i4++) {
                    int g3 = lVar.g();
                    i2 += g3;
                    zArr[i4] = g3 > i3;
                }
            } else {
                if (g2 <= i3) {
                    z2 = false;
                }
                i2 = (g2 * t2) + 0;
                Arrays.fill(lVar2.n, 0, t2, z2);
            }
            lVar2.a(i2);
            return;
        }
        throw new p("Length mismatch: " + t2 + ", " + lVar2.f10135f);
    }

    private static void a(com.google.android.exoplayer2.s.l lVar, l lVar2) throws p {
        long j2;
        lVar.c(8);
        int n2 = lVar.n();
        if ((a.b(n2) & 1) == 1) {
            lVar.d(8);
        }
        int t2 = lVar.t();
        if (t2 == 1) {
            int a2 = a.a(n2);
            long j3 = lVar2.f10133d;
            if (a2 == 0) {
                j2 = lVar.l();
            } else {
                j2 = lVar.v();
            }
            lVar2.f10133d = j3 + j2;
            return;
        }
        throw new p("Unexpected saio entry count: " + t2);
    }

    private static b a(com.google.android.exoplayer2.s.l lVar, SparseArray<b> sparseArray, int i2) {
        lVar.c(8);
        int b2 = a.b(lVar.n());
        int n2 = lVar.n();
        if ((i2 & 16) != 0) {
            n2 = 0;
        }
        b bVar = sparseArray.get(n2);
        if (bVar == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long v2 = lVar.v();
            bVar.f10092a.f10132c = v2;
            bVar.f10092a.f10133d = v2;
        }
        c cVar = bVar.f10095d;
        bVar.f10092a.f10130a = new c((b2 & 2) != 0 ? lVar.t() - 1 : cVar.f10074a, (b2 & 8) != 0 ? lVar.t() : cVar.f10075b, (b2 & 16) != 0 ? lVar.t() : cVar.f10076c, (b2 & 32) != 0 ? lVar.t() : cVar.f10077d);
        return bVar;
    }

    private static long d(com.google.android.exoplayer2.s.l lVar) {
        lVar.c(8);
        return a.a(lVar.n()) == 1 ? lVar.v() : lVar.l();
    }

    private static int a(b bVar, int i2, long j2, int i3, com.google.android.exoplayer2.s.l lVar, int i4) {
        boolean[] zArr;
        long j3;
        long[] jArr;
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        boolean z6;
        b bVar2 = bVar;
        lVar.c(8);
        int b2 = a.b(lVar.n());
        j jVar = bVar2.f10094c;
        l lVar2 = bVar2.f10092a;
        c cVar = lVar2.f10130a;
        lVar2.h[i2] = lVar.t();
        lVar2.f10136g[i2] = lVar2.f10132c;
        if ((b2 & 1) != 0) {
            long[] jArr2 = lVar2.f10136g;
            jArr2[i2] = jArr2[i2] + ((long) lVar.n());
        }
        boolean z7 = (b2 & 4) != 0;
        int i7 = cVar.f10077d;
        if (z7) {
            i7 = lVar.t();
        }
        boolean z8 = (b2 & 256) != 0;
        boolean z9 = (b2 & 512) != 0;
        boolean z10 = (b2 & 1024) != 0;
        boolean z11 = (b2 & 2048) != 0;
        long j4 = 0;
        if (jVar.h != null && jVar.h.length == 1 && jVar.h[0] == 0) {
            j4 = v.b(jVar.i[0], 1000, jVar.f10120c);
        }
        int[] iArr = lVar2.i;
        int[] iArr2 = lVar2.j;
        long[] jArr3 = lVar2.k;
        boolean[] zArr2 = lVar2.l;
        int i8 = i7;
        boolean z12 = jVar.f10119b == 2 && (i3 & 1) != 0;
        int i9 = i4 + lVar2.h[i2];
        long j5 = j4;
        boolean[] zArr3 = zArr2;
        long j6 = jVar.f10120c;
        if (i2 > 0) {
            zArr = zArr3;
            jArr = jArr3;
            j3 = lVar2.s;
        } else {
            zArr = zArr3;
            jArr = jArr3;
            j3 = j2;
        }
        long j7 = j3;
        int i10 = i4;
        while (i10 < i9) {
            int t2 = z8 ? lVar.t() : cVar.f10075b;
            if (z9) {
                z2 = z8;
                i5 = lVar.t();
            } else {
                z2 = z8;
                i5 = cVar.f10076c;
            }
            if (i10 == 0 && z7) {
                z3 = z7;
                i6 = i8;
            } else if (z10) {
                z3 = z7;
                i6 = lVar.n();
            } else {
                z3 = z7;
                i6 = cVar.f10077d;
            }
            if (z11) {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i10] = (int) ((((long) lVar.n()) * 1000) / j6);
            } else {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i10] = 0;
            }
            jArr[i10] = v.b(j7, 1000, j6) - j5;
            iArr[i10] = i5;
            zArr[i10] = ((i6 >> 16) & 1) == 0 && (!z12 || i10 == 0);
            i10++;
            j7 += (long) t2;
            z8 = z2;
            z7 = z3;
            z11 = z6;
            z9 = z5;
            z10 = z4;
            i9 = i9;
        }
        int i11 = i9;
        lVar2.s = j7;
        return i11;
    }

    private static void a(com.google.android.exoplayer2.s.l lVar, l lVar2, byte[] bArr) throws p {
        lVar.c(8);
        lVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, f10085c)) {
            a(lVar, 16, lVar2);
        }
    }

    private static void b(com.google.android.exoplayer2.s.l lVar, l lVar2) throws p {
        a(lVar, 0, lVar2);
    }

    private static void a(com.google.android.exoplayer2.s.l lVar, int i2, l lVar2) throws p {
        lVar.c(i2 + 8);
        int b2 = a.b(lVar.n());
        if ((b2 & 1) == 0) {
            boolean z2 = (b2 & 2) != 0;
            int t2 = lVar.t();
            if (t2 == lVar2.f10135f) {
                Arrays.fill(lVar2.n, 0, t2, z2);
                lVar2.a(lVar.b());
                lVar2.a(lVar);
                return;
            }
            throw new p("Length mismatch: " + t2 + ", " + lVar2.f10135f);
        }
        throw new p("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static void a(com.google.android.exoplayer2.s.l lVar, com.google.android.exoplayer2.s.l lVar2, String str, l lVar3) throws p {
        byte[] bArr;
        lVar.c(8);
        int n2 = lVar.n();
        if (lVar.n() == f10084b) {
            if (a.a(n2) == 1) {
                lVar.d(4);
            }
            if (lVar.n() == 1) {
                lVar2.c(8);
                int n3 = lVar2.n();
                if (lVar2.n() == f10084b) {
                    int a2 = a.a(n3);
                    if (a2 == 1) {
                        if (lVar2.l() == 0) {
                            throw new p("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (a2 >= 2) {
                        lVar2.d(4);
                    }
                    if (lVar2.l() == 1) {
                        lVar2.d(1);
                        int g2 = lVar2.g();
                        int i2 = (g2 & 240) >> 4;
                        int i3 = g2 & 15;
                        boolean z2 = lVar2.g() == 1;
                        if (z2) {
                            int g3 = lVar2.g();
                            byte[] bArr2 = new byte[16];
                            lVar2.a(bArr2, 0, bArr2.length);
                            if (!z2 || g3 != 0) {
                                bArr = null;
                            } else {
                                int g4 = lVar2.g();
                                byte[] bArr3 = new byte[g4];
                                lVar2.a(bArr3, 0, g4);
                                bArr = bArr3;
                            }
                            lVar3.m = true;
                            lVar3.o = new k(z2, str, g3, bArr2, i2, i3, bArr);
                            return;
                        }
                        return;
                    }
                    throw new p("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new p("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.i.a> a(com.google.android.exoplayer2.s.l lVar, long j2) throws p {
        long j3;
        long j4;
        com.google.android.exoplayer2.s.l lVar2 = lVar;
        lVar2.c(8);
        int a2 = a.a(lVar.n());
        lVar2.d(4);
        long l2 = lVar.l();
        if (a2 == 0) {
            j4 = lVar.l();
            j3 = lVar.l();
        } else {
            j4 = lVar.v();
            j3 = lVar.v();
        }
        long j5 = j4;
        long j6 = j2 + j3;
        long b2 = v.b(j5, JobManager.NS_PER_MS, l2);
        lVar2.d(2);
        int h2 = lVar.h();
        int[] iArr = new int[h2];
        long[] jArr = new long[h2];
        long[] jArr2 = new long[h2];
        long[] jArr3 = new long[h2];
        long j7 = j5;
        long j8 = b2;
        int i2 = 0;
        while (i2 < h2) {
            int n2 = lVar.n();
            if ((n2 & RNCartPanelDataEntity.NULL_VALUE) == 0) {
                long l3 = lVar.l();
                iArr[i2] = n2 & Integer.MAX_VALUE;
                jArr[i2] = j6;
                jArr3[i2] = j8;
                j7 += l3;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i3 = h2;
                int[] iArr2 = iArr;
                j8 = v.b(j7, JobManager.NS_PER_MS, l2);
                jArr4[i2] = j8 - jArr5[i2];
                lVar2.d(4);
                j6 += (long) iArr2[i2];
                i2++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                h2 = i3;
            } else {
                throw new p("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(b2), new com.google.android.exoplayer2.i.a(iArr, jArr, jArr2, jArr3));
    }

    private void d(f fVar) throws IOException, InterruptedException {
        int size = this.f10088f.size();
        b bVar = null;
        long j2 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.f10088f.valueAt(i2).f10092a;
            if (lVar.r && lVar.f10133d < j2) {
                long j3 = lVar.f10133d;
                bVar = this.f10088f.valueAt(i2);
                j2 = j3;
            }
        }
        if (bVar == null) {
            this.q = 3;
            return;
        }
        int c2 = (int) (j2 - fVar.c());
        if (c2 >= 0) {
            fVar.b(c2);
            bVar.f10092a.a(fVar);
            return;
        }
        throw new p("Offset to encryption data was negative.");
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        m.a aVar;
        boolean z2;
        k kVar;
        int i2;
        f fVar2 = fVar;
        int i3 = 4;
        int i4 = 1;
        int i5 = 0;
        if (this.q == 3) {
            if (this.z == null) {
                b a2 = a(this.f10088f);
                if (a2 == null) {
                    int c2 = (int) (this.v - fVar.c());
                    if (c2 >= 0) {
                        fVar2.b(c2);
                        a();
                        return false;
                    }
                    throw new p("Offset to end of mdat was negative.");
                }
                int c3 = (int) (a2.f10092a.f10136g[a2.f10098g] - fVar.c());
                if (c3 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    c3 = 0;
                }
                fVar2.b(c3);
                this.z = a2;
            }
            this.A = this.z.f10092a.i[this.z.f10096e];
            if (this.z.f10092a.m) {
                this.B = a(this.z);
                this.A += this.B;
            } else {
                this.B = 0;
            }
            if (this.z.f10094c.f10124g == 1) {
                this.A -= 8;
                fVar2.b(8);
            }
            this.q = 4;
            this.C = 0;
        }
        l lVar = this.z.f10092a;
        j jVar = this.z.f10094c;
        m mVar = this.z.f10093b;
        int i6 = this.z.f10096e;
        if (jVar.j == 0) {
            while (true) {
                int i7 = this.B;
                int i8 = this.A;
                if (i7 >= i8) {
                    break;
                }
                this.B += mVar.a(fVar2, i8 - i7, false);
            }
        } else {
            byte[] bArr = this.h.f11422a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i9 = jVar.j + 1;
            int i10 = 4 - jVar.j;
            while (this.B < this.A) {
                int i11 = this.C;
                if (i11 == 0) {
                    fVar2.b(bArr, i10, i9);
                    this.h.c(i5);
                    this.C = this.h.t() - i4;
                    this.f10089g.c(i5);
                    mVar.a(this.f10089g, i3);
                    mVar.a(this.h, i4);
                    this.D = this.G != null && j.a(jVar.f10123f.f8958f, bArr[i3]);
                    this.B += 5;
                    this.A += i10;
                } else {
                    if (this.D) {
                        this.i.a(i11);
                        fVar2.b(this.i.f11422a, i5, this.C);
                        mVar.a(this.i, this.C);
                        i2 = this.C;
                        int a3 = j.a(this.i.f11422a, this.i.c());
                        this.i.c("video/hevc".equals(jVar.f10123f.f8958f) ? 1 : 0);
                        this.i.b(a3);
                        com.google.android.exoplayer2.p.a.g.a(lVar.b(i6) * 1000, this.i, this.G);
                    } else {
                        i2 = mVar.a(fVar2, i11, false);
                    }
                    this.B += i2;
                    this.C -= i2;
                    i3 = 4;
                    i4 = 1;
                    i5 = 0;
                }
            }
        }
        long b2 = lVar.b(i6) * 1000;
        s sVar = this.l;
        if (sVar != null) {
            b2 = sVar.c(b2);
        }
        boolean z3 = lVar.l[i6];
        if (lVar.m) {
            boolean z4 = z3 | true;
            if (lVar.o != null) {
                kVar = lVar.o;
            } else {
                kVar = jVar.a(lVar.f10130a.f10074a);
            }
            z2 = z4;
            aVar = kVar.f10127c;
        } else {
            z2 = z3;
            aVar = null;
        }
        mVar.a(b2, z2 ? 1 : 0, this.A, 0, aVar);
        while (!this.p.isEmpty()) {
            a removeFirst = this.p.removeFirst();
            this.w -= removeFirst.f10091b;
            this.F.a(removeFirst.f10090a + b2, 1, removeFirst.f10091b, this.w, (m.a) null);
        }
        this.z.f10096e++;
        this.z.f10097f++;
        if (this.z.f10097f == lVar.h[this.z.f10098g]) {
            this.z.f10098g++;
            this.z.f10097f = 0;
            this.z = null;
        }
        this.q = 3;
        return true;
    }

    private static b a(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j2 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < size; i2++) {
            b valueAt = sparseArray.valueAt(i2);
            if (valueAt.f10098g != valueAt.f10092a.f10134e) {
                long j3 = valueAt.f10092a.f10136g[valueAt.f10098g];
                if (j3 < j2) {
                    bVar = valueAt;
                    j2 = j3;
                }
            }
        }
        return bVar;
    }

    private int a(b bVar) {
        k kVar;
        com.google.android.exoplayer2.s.l lVar;
        int i2;
        l lVar2 = bVar.f10092a;
        int i3 = lVar2.f10130a.f10074a;
        if (lVar2.o != null) {
            kVar = lVar2.o;
        } else {
            kVar = bVar.f10094c.a(i3);
        }
        if (kVar.f10128d != 0) {
            lVar = lVar2.q;
            i2 = kVar.f10128d;
        } else {
            byte[] bArr = kVar.f10129e;
            this.k.a(bArr, bArr.length);
            lVar = this.k;
            i2 = bArr.length;
        }
        boolean z2 = lVar2.n[bVar.f10096e];
        this.j.f11422a[0] = (byte) ((z2 ? 128 : 0) | i2);
        this.j.c(0);
        m mVar = bVar.f10093b;
        mVar.a(this.j, 1);
        mVar.a(lVar, i2);
        if (!z2) {
            return i2 + 1;
        }
        com.google.android.exoplayer2.s.l lVar3 = lVar2.q;
        int h2 = lVar3.h();
        lVar3.d(-2);
        int i4 = (h2 * 6) + 2;
        mVar.a(lVar3, i4);
        return i2 + 1 + i4;
    }

    private static DrmInitData a(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = list.get(i2);
            if (bVar.aP == a.U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.aQ.f11422a;
                UUID a2 = h.a(bArr);
                if (a2 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(a2, (String) null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    private static boolean a(int i2) {
        return i2 == a.S || i2 == a.R || i2 == a.C || i2 == a.A || i2 == a.T || i2 == a.w || i2 == a.x || i2 == a.O || i2 == a.y || i2 == a.z || i2 == a.U || i2 == a.ac || i2 == a.ad || i2 == a.ah || i2 == a.ag || i2 == a.ae || i2 == a.af || i2 == a.Q || i2 == a.N || i2 == a.aG;
    }

    private static boolean b(int i2) {
        return i2 == a.B || i2 == a.D || i2 == a.E || i2 == a.F || i2 == a.G || i2 == a.K || i2 == a.L || i2 == a.M || i2 == a.P;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f10090a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10091b;

        public a(long j, int i) {
            this.f10090a = j;
            this.f10091b = i;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final l f10092a = new l();

        /* renamed from: b  reason: collision with root package name */
        public final m f10093b;

        /* renamed from: c  reason: collision with root package name */
        public j f10094c;

        /* renamed from: d  reason: collision with root package name */
        public c f10095d;

        /* renamed from: e  reason: collision with root package name */
        public int f10096e;

        /* renamed from: f  reason: collision with root package name */
        public int f10097f;

        /* renamed from: g  reason: collision with root package name */
        public int f10098g;

        public b(m mVar) {
            this.f10093b = mVar;
        }

        public void a(j jVar, c cVar) {
            this.f10094c = (j) com.google.android.exoplayer2.s.a.a(jVar);
            this.f10095d = (c) com.google.android.exoplayer2.s.a.a(cVar);
            this.f10093b.a(jVar.f10123f);
            a();
        }

        public void a() {
            this.f10092a.a();
            this.f10096e = 0;
            this.f10098g = 0;
            this.f10097f = 0;
        }

        public void a(DrmInitData drmInitData) {
            k a2 = this.f10094c.a(this.f10092a.f10130a.f10074a);
            this.f10093b.a(this.f10094c.f10123f.a(drmInitData.a(a2 != null ? a2.f10126b : null)));
        }
    }
}
