package com.google.android.exoplayer2.e.d;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.d.a;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import com.google.android.exoplayer2.n.t;
import com.path.android.jobqueue.JobManager;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9453a = new i() {
        public f[] a() {
            return new f[]{new e()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f9454b = t.g("seig");

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f9455c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private int A;
    private int B;
    private boolean C;
    private h D;
    private n E;
    private n[] F;
    private boolean G;

    /* renamed from: d  reason: collision with root package name */
    private final int f9456d;

    /* renamed from: e  reason: collision with root package name */
    private final j f9457e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<b> f9458f;

    /* renamed from: g  reason: collision with root package name */
    private final k f9459g;
    private final k h;
    private final k i;
    private final k j;
    private final q k;
    private final k l;
    private final byte[] m;
    private final Stack<a.C0162a> n;
    private final LinkedList<a> o;
    private int p;
    private int q;
    private long r;
    private int s;
    private k t;
    private long u;
    private int v;
    private long w;
    private long x;
    private b y;
    private int z;

    public void c() {
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, (q) null);
    }

    public e(int i2, q qVar) {
        this(i2, qVar, (j) null);
    }

    public e(int i2, q qVar, j jVar) {
        this.f9456d = i2 | (jVar != null ? 16 : 0);
        this.k = qVar;
        this.f9457e = jVar;
        this.l = new k(16);
        this.f9459g = new k(com.google.android.exoplayer2.n.i.f10930a);
        this.h = new k(5);
        this.i = new k();
        this.j = new k(1);
        this.m = new byte[16];
        this.n = new Stack<>();
        this.o = new LinkedList<>();
        this.f9458f = new SparseArray<>();
        this.w = -9223372036854775807L;
        this.x = -9223372036854775807L;
        a();
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return i.a(gVar);
    }

    public void a(h hVar) {
        this.D = hVar;
        j jVar = this.f9457e;
        if (jVar != null) {
            b bVar = new b(hVar.a(0, jVar.f9489b));
            bVar.a(this.f9457e, new c(0, 0, 0, 0));
            this.f9458f.put(0, bVar);
            b();
            this.D.a();
        }
    }

    public void a(long j2, long j3) {
        int size = this.f9458f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f9458f.valueAt(i2).a();
        }
        this.o.clear();
        this.v = 0;
        this.n.clear();
        a();
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.p;
            if (i2 != 0) {
                if (i2 == 1) {
                    c(gVar);
                } else if (i2 == 2) {
                    d(gVar);
                } else if (e(gVar)) {
                    return 0;
                }
            } else if (!b(gVar)) {
                return -1;
            }
        }
    }

    private void a() {
        this.p = 0;
        this.s = 0;
    }

    private boolean b(g gVar) throws IOException, InterruptedException {
        if (this.s == 0) {
            if (!gVar.a(this.l.f10948a, 0, 8, true)) {
                return false;
            }
            this.s = 8;
            this.l.c(0);
            this.r = this.l.l();
            this.q = this.l.n();
        }
        if (this.r == 1) {
            gVar.b(this.l.f10948a, 8, 8);
            this.s += 8;
            this.r = this.l.v();
        }
        if (this.r >= ((long) this.s)) {
            long c2 = gVar.c() - ((long) this.s);
            if (this.q == a.K) {
                int size = this.f9458f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    l lVar = this.f9458f.valueAt(i2).f9462a;
                    lVar.f9499b = c2;
                    lVar.f9501d = c2;
                    lVar.f9500c = c2;
                }
            }
            if (this.q == a.h) {
                this.y = null;
                this.u = c2 + this.r;
                if (!this.G) {
                    this.D.a(new m.a(this.w));
                    this.G = true;
                }
                this.p = 2;
                return true;
            }
            if (b(this.q)) {
                long c3 = (gVar.c() + this.r) - 8;
                this.n.add(new a.C0162a(this.q, c3));
                if (this.r == ((long) this.s)) {
                    a(c3);
                } else {
                    a();
                }
            } else if (a(this.q)) {
                if (this.s == 8) {
                    long j2 = this.r;
                    if (j2 <= 2147483647L) {
                        this.t = new k((int) j2);
                        System.arraycopy(this.l.f10948a, 0, this.t.f10948a, 0, 8);
                        this.p = 1;
                    } else {
                        throw new ak("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new ak("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.r <= 2147483647L) {
                this.t = null;
                this.p = 1;
            } else {
                throw new ak("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new ak("Atom size less than header length (unsupported).");
    }

    private void c(g gVar) throws IOException, InterruptedException {
        int i2 = ((int) this.r) - this.s;
        k kVar = this.t;
        if (kVar != null) {
            gVar.b(kVar.f10948a, 8, i2);
            a(new a.b(this.q, this.t), gVar.c());
        } else {
            gVar.b(i2);
        }
        a(gVar.c());
    }

    private void a(long j2) throws ak {
        while (!this.n.isEmpty() && this.n.peek().aQ == j2) {
            a(this.n.pop());
        }
        a();
    }

    private void a(a.b bVar, long j2) throws ak {
        if (!this.n.isEmpty()) {
            this.n.peek().a(bVar);
        } else if (bVar.aP == a.A) {
            Pair<Long, com.google.android.exoplayer2.e.a> a2 = a(bVar.aQ, j2);
            this.x = ((Long) a2.first).longValue();
            this.D.a((m) a2.second);
            this.G = true;
        } else if (bVar.aP == a.aG) {
            a(bVar.aQ);
        }
    }

    private void a(a.C0162a aVar) throws ak {
        if (aVar.aP == a.B) {
            b(aVar);
        } else if (aVar.aP == a.K) {
            c(aVar);
        } else if (!this.n.isEmpty()) {
            this.n.peek().a(aVar);
        }
    }

    private void b(a.C0162a aVar) throws ak {
        int i2;
        a.C0162a aVar2 = aVar;
        boolean z2 = true;
        int i3 = 0;
        com.google.android.exoplayer2.n.a.b(this.f9457e == null, "Unexpected moov box.");
        com.google.android.exoplayer2.c.a a2 = a(aVar2.aR);
        a.C0162a e2 = aVar2.e(a.M);
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
            a.C0162a aVar3 = aVar2.aS.get(i5);
            if (aVar3.aP == a.D) {
                i2 = i5;
                j a3 = b.a(aVar3, aVar2.d(a.C), j2, a2, false);
                if (a3 != null) {
                    sparseArray2.put(a3.f9488a, a3);
                }
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
        int size3 = sparseArray2.size();
        if (this.f9458f.size() == 0) {
            while (i3 < size3) {
                j jVar = (j) sparseArray2.valueAt(i3);
                b bVar2 = new b(this.D.a(i3, jVar.f9489b));
                bVar2.a(jVar, (c) sparseArray.get(jVar.f9488a));
                this.f9458f.put(jVar.f9488a, bVar2);
                this.w = Math.max(this.w, jVar.f9492e);
                i3++;
            }
            b();
            this.D.a();
            return;
        }
        if (this.f9458f.size() != size3) {
            z2 = false;
        }
        com.google.android.exoplayer2.n.a.b(z2);
        while (i3 < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i3);
            this.f9458f.get(jVar2.f9488a).a(jVar2, (c) sparseArray.get(jVar2.f9488a));
            i3++;
        }
    }

    private void c(a.C0162a aVar) throws ak {
        a(aVar, this.f9458f, this.f9456d, this.m);
        com.google.android.exoplayer2.c.a a2 = a(aVar.aR);
        if (a2 != null) {
            int size = this.f9458f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f9458f.valueAt(i2).a(a2);
            }
        }
    }

    private void b() {
        if ((this.f9456d & 4) != 0 && this.E == null) {
            this.E = this.D.a(this.f9458f.size(), 4);
            this.E.a(j.a((String) null, "application/x-emsg", (long) Clock.MAX_TIME));
        }
        if ((this.f9456d & 8) != 0 && this.F == null) {
            n a2 = this.D.a(this.f9458f.size() + 1, 3);
            a2.a(j.a((String) null, "application/cea-608", (String) null, -1, 0, (String) null, (com.google.android.exoplayer2.c.a) null));
            this.F = new n[]{a2};
        }
    }

    private void a(k kVar) {
        if (this.E != null) {
            kVar.c(12);
            kVar.x();
            kVar.x();
            long a2 = t.a(kVar.l(), (long) JobManager.NS_PER_MS, kVar.l());
            kVar.c(12);
            int b2 = kVar.b();
            this.E.a(kVar, b2);
            long j2 = this.x;
            if (j2 != -9223372036854775807L) {
                this.E.a(a2 + j2, 1, b2, 0, (byte[]) null);
                return;
            }
            this.o.addLast(new a(a2, b2));
            this.v += b2;
        }
    }

    private static Pair<Integer, c> b(k kVar) {
        kVar.c(12);
        return Pair.create(Integer.valueOf(kVar.n()), new c(kVar.t() - 1, kVar.t(), kVar.t(), kVar.n()));
    }

    private static long c(k kVar) {
        kVar.c(8);
        return a.a(kVar.n()) == 0 ? kVar.l() : kVar.v();
    }

    private static void a(a.C0162a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws ak {
        int size = aVar.aS.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.C0162a aVar2 = aVar.aS.get(i3);
            if (aVar2.aP == a.L) {
                b(aVar2, sparseArray, i2, bArr);
            }
        }
    }

    private static void b(a.C0162a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws ak {
        b a2 = a(aVar.d(a.x).aQ, sparseArray, i2);
        if (a2 != null) {
            l lVar = a2.f9462a;
            long j2 = lVar.s;
            a2.a();
            if (aVar.d(a.w) != null && (i2 & 2) == 0) {
                j2 = d(aVar.d(a.w).aQ);
            }
            a(aVar, a2, j2, i2);
            a.b d2 = aVar.d(a.ac);
            if (d2 != null) {
                a(a2.f9464c.h[lVar.f9498a.f9444a], d2.aQ, lVar);
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
                a(d5.aQ, d6.aQ, lVar);
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

    private static void a(a.C0162a aVar, b bVar, long j2, int i2) {
        List<a.b> list = aVar.aR;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar2 = list.get(i5);
            if (bVar2.aP == a.z) {
                k kVar = bVar2.aQ;
                kVar.c(12);
                int t2 = kVar.t();
                if (t2 > 0) {
                    i4 += t2;
                    i3++;
                }
            }
        }
        bVar.f9468g = 0;
        bVar.f9467f = 0;
        bVar.f9466e = 0;
        bVar.f9462a.a(i3, i4);
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

    private static void a(k kVar, k kVar2, l lVar) throws ak {
        int i2;
        int i3 = kVar.f9496b;
        kVar2.c(8);
        boolean z2 = true;
        if ((a.b(kVar2.n()) & 1) == 1) {
            kVar2.d(8);
        }
        int g2 = kVar2.g();
        int t2 = kVar2.t();
        if (t2 == lVar.f9503f) {
            if (g2 == 0) {
                boolean[] zArr = lVar.n;
                i2 = 0;
                for (int i4 = 0; i4 < t2; i4++) {
                    int g3 = kVar2.g();
                    i2 += g3;
                    zArr[i4] = g3 > i3;
                }
            } else {
                if (g2 <= i3) {
                    z2 = false;
                }
                i2 = (g2 * t2) + 0;
                Arrays.fill(lVar.n, 0, t2, z2);
            }
            lVar.a(i2);
            return;
        }
        throw new ak("Length mismatch: " + t2 + ", " + lVar.f9503f);
    }

    private static void a(k kVar, l lVar) throws ak {
        long j2;
        kVar.c(8);
        int n2 = kVar.n();
        if ((a.b(n2) & 1) == 1) {
            kVar.d(8);
        }
        int t2 = kVar.t();
        if (t2 == 1) {
            int a2 = a.a(n2);
            long j3 = lVar.f9501d;
            if (a2 == 0) {
                j2 = kVar.l();
            } else {
                j2 = kVar.v();
            }
            lVar.f9501d = j3 + j2;
            return;
        }
        throw new ak("Unexpected saio entry count: " + t2);
    }

    private static b a(k kVar, SparseArray<b> sparseArray, int i2) {
        kVar.c(8);
        int b2 = a.b(kVar.n());
        int n2 = kVar.n();
        if ((i2 & 16) != 0) {
            n2 = 0;
        }
        b bVar = sparseArray.get(n2);
        if (bVar == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long v2 = kVar.v();
            bVar.f9462a.f9500c = v2;
            bVar.f9462a.f9501d = v2;
        }
        c cVar = bVar.f9465d;
        bVar.f9462a.f9498a = new c((b2 & 2) != 0 ? kVar.t() - 1 : cVar.f9444a, (b2 & 8) != 0 ? kVar.t() : cVar.f9445b, (b2 & 16) != 0 ? kVar.t() : cVar.f9446c, (b2 & 32) != 0 ? kVar.t() : cVar.f9447d);
        return bVar;
    }

    private static long d(k kVar) {
        kVar.c(8);
        return a.a(kVar.n()) == 1 ? kVar.v() : kVar.l();
    }

    private static int a(b bVar, int i2, long j2, int i3, k kVar, int i4) {
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
        kVar.c(8);
        int b2 = a.b(kVar.n());
        j jVar = bVar2.f9464c;
        l lVar = bVar2.f9462a;
        c cVar = lVar.f9498a;
        lVar.h[i2] = kVar.t();
        lVar.f9504g[i2] = lVar.f9500c;
        if ((b2 & 1) != 0) {
            long[] jArr2 = lVar.f9504g;
            jArr2[i2] = jArr2[i2] + ((long) kVar.n());
        }
        boolean z7 = (b2 & 4) != 0;
        int i7 = cVar.f9447d;
        if (z7) {
            i7 = kVar.t();
        }
        boolean z8 = (b2 & 256) != 0;
        boolean z9 = (b2 & 512) != 0;
        boolean z10 = (b2 & 1024) != 0;
        boolean z11 = (b2 & 2048) != 0;
        long j4 = 0;
        if (jVar.i != null && jVar.i.length == 1 && jVar.i[0] == 0) {
            j4 = t.a(jVar.j[0], 1000, jVar.f9490c);
        }
        int[] iArr = lVar.i;
        int[] iArr2 = lVar.j;
        long[] jArr3 = lVar.k;
        boolean[] zArr2 = lVar.l;
        int i8 = i7;
        boolean z12 = jVar.f9489b == 2 && (i3 & 1) != 0;
        int i9 = i4 + lVar.h[i2];
        long j5 = j4;
        boolean[] zArr3 = zArr2;
        long j6 = jVar.f9490c;
        if (i2 > 0) {
            zArr = zArr3;
            jArr = jArr3;
            j3 = lVar.s;
        } else {
            zArr = zArr3;
            jArr = jArr3;
            j3 = j2;
        }
        long j7 = j3;
        int i10 = i4;
        while (i10 < i9) {
            int t2 = z8 ? kVar.t() : cVar.f9445b;
            if (z9) {
                z2 = z8;
                i5 = kVar.t();
            } else {
                z2 = z8;
                i5 = cVar.f9446c;
            }
            if (i10 == 0 && z7) {
                z3 = z7;
                i6 = i8;
            } else if (z10) {
                z3 = z7;
                i6 = kVar.n();
            } else {
                z3 = z7;
                i6 = cVar.f9447d;
            }
            if (z11) {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i10] = (int) (((long) (kVar.n() * 1000)) / j6);
            } else {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i10] = 0;
            }
            jArr[i10] = t.a(j7, 1000, j6) - j5;
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
        lVar.s = j7;
        return i11;
    }

    private static void a(k kVar, l lVar, byte[] bArr) throws ak {
        kVar.c(8);
        kVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, f9455c)) {
            a(kVar, 16, lVar);
        }
    }

    private static void b(k kVar, l lVar) throws ak {
        a(kVar, 0, lVar);
    }

    private static void a(k kVar, int i2, l lVar) throws ak {
        kVar.c(i2 + 8);
        int b2 = a.b(kVar.n());
        if ((b2 & 1) == 0) {
            boolean z2 = (b2 & 2) != 0;
            int t2 = kVar.t();
            if (t2 == lVar.f9503f) {
                Arrays.fill(lVar.n, 0, t2, z2);
                lVar.a(kVar.b());
                lVar.a(kVar);
                return;
            }
            throw new ak("Length mismatch: " + t2 + ", " + lVar.f9503f);
        }
        throw new ak("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static void a(k kVar, k kVar2, l lVar) throws ak {
        kVar.c(8);
        int n2 = kVar.n();
        if (kVar.n() == f9454b) {
            if (a.a(n2) == 1) {
                kVar.d(4);
            }
            if (kVar.n() == 1) {
                kVar2.c(8);
                int n3 = kVar2.n();
                if (kVar2.n() == f9454b) {
                    int a2 = a.a(n3);
                    if (a2 == 1) {
                        if (kVar2.l() == 0) {
                            throw new ak("Variable length decription in sgpd found (unsupported)");
                        }
                    } else if (a2 >= 2) {
                        kVar2.d(4);
                    }
                    if (kVar2.l() == 1) {
                        kVar2.d(2);
                        boolean z2 = kVar2.g() == 1;
                        if (z2) {
                            int g2 = kVar2.g();
                            byte[] bArr = new byte[16];
                            kVar2.a(bArr, 0, bArr.length);
                            lVar.m = true;
                            lVar.o = new k(z2, g2, bArr);
                            return;
                        }
                        return;
                    }
                    throw new ak("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new ak("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.e.a> a(k kVar, long j2) throws ak {
        long j3;
        long j4;
        k kVar2 = kVar;
        kVar2.c(8);
        int a2 = a.a(kVar.n());
        kVar2.d(4);
        long l2 = kVar.l();
        if (a2 == 0) {
            j4 = kVar.l();
            j3 = kVar.l();
        } else {
            j4 = kVar.v();
            j3 = kVar.v();
        }
        long j5 = j4;
        long j6 = j2 + j3;
        long a3 = t.a(j5, (long) JobManager.NS_PER_MS, l2);
        kVar2.d(2);
        int h2 = kVar.h();
        int[] iArr = new int[h2];
        long[] jArr = new long[h2];
        long[] jArr2 = new long[h2];
        long[] jArr3 = new long[h2];
        long j7 = j5;
        long j8 = a3;
        int i2 = 0;
        while (i2 < h2) {
            int n2 = kVar.n();
            if ((n2 & RNCartPanelDataEntity.NULL_VALUE) == 0) {
                long l3 = kVar.l();
                iArr[i2] = n2 & Integer.MAX_VALUE;
                jArr[i2] = j6;
                jArr3[i2] = j8;
                j7 += l3;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i3 = h2;
                int[] iArr2 = iArr;
                j8 = t.a(j7, (long) JobManager.NS_PER_MS, l2);
                jArr4[i2] = j8 - jArr5[i2];
                kVar2.d(4);
                j6 += (long) iArr2[i2];
                i2++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                h2 = i3;
            } else {
                throw new ak("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(a3), new com.google.android.exoplayer2.e.a(iArr, jArr, jArr2, jArr3));
    }

    private void d(g gVar) throws IOException, InterruptedException {
        int size = this.f9458f.size();
        b bVar = null;
        long j2 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.f9458f.valueAt(i2).f9462a;
            if (lVar.r && lVar.f9501d < j2) {
                long j3 = lVar.f9501d;
                bVar = this.f9458f.valueAt(i2);
                j2 = j3;
            }
        }
        if (bVar == null) {
            this.p = 3;
            return;
        }
        int c2 = (int) (j2 - gVar.c());
        if (c2 >= 0) {
            gVar.b(c2);
            bVar.f9462a.a(gVar);
            return;
        }
        throw new ak("Offset to encryption data was negative.");
    }

    private boolean e(g gVar) throws IOException, InterruptedException {
        byte[] bArr;
        int i2;
        g gVar2 = gVar;
        int i3 = 4;
        int i4 = 1;
        int i5 = 0;
        if (this.p == 3) {
            if (this.y == null) {
                b a2 = a(this.f9458f);
                if (a2 == null) {
                    int c2 = (int) (this.u - gVar.c());
                    if (c2 >= 0) {
                        gVar2.b(c2);
                        a();
                        return false;
                    }
                    throw new ak("Offset to end of mdat was negative.");
                }
                int c3 = (int) (a2.f9462a.f9504g[a2.f9468g] - gVar.c());
                if (c3 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    c3 = 0;
                }
                gVar2.b(c3);
                this.y = a2;
            }
            this.z = this.y.f9462a.i[this.y.f9466e];
            if (this.y.f9462a.m) {
                this.A = a(this.y);
                this.z += this.A;
            } else {
                this.A = 0;
            }
            if (this.y.f9464c.f9494g == 1) {
                this.z -= 8;
                gVar2.b(8);
            }
            this.p = 4;
            this.B = 0;
        }
        l lVar = this.y.f9462a;
        j jVar = this.y.f9464c;
        n nVar = this.y.f9463b;
        int i6 = this.y.f9466e;
        if (jVar.k == 0) {
            while (true) {
                int i7 = this.A;
                int i8 = this.z;
                if (i7 >= i8) {
                    break;
                }
                this.A += nVar.a(gVar2, i8 - i7, false);
            }
        } else {
            byte[] bArr2 = this.h.f10948a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i9 = jVar.k + 1;
            int i10 = 4 - jVar.k;
            while (this.A < this.z) {
                int i11 = this.B;
                if (i11 == 0) {
                    gVar2.b(bArr2, i10, i9);
                    this.h.c(i5);
                    this.B = this.h.t() - i4;
                    this.f9459g.c(i5);
                    nVar.a(this.f9459g, i3);
                    nVar.a(this.h, i4);
                    this.C = this.F != null && com.google.android.exoplayer2.n.i.a(jVar.f9493f.f10427f, bArr2[i3]);
                    this.A += 5;
                    this.z += i10;
                } else {
                    if (this.C) {
                        this.i.a(i11);
                        gVar2.b(this.i.f10948a, i5, this.B);
                        nVar.a(this.i, this.B);
                        i2 = this.B;
                        int a3 = com.google.android.exoplayer2.n.i.a(this.i.f10948a, this.i.c());
                        this.i.c("video/hevc".equals(jVar.f9493f.f10427f) ? 1 : 0);
                        this.i.b(a3);
                        com.google.android.exoplayer2.j.a.g.a(lVar.b(i6) * 1000, this.i, this.F);
                    } else {
                        i2 = nVar.a(gVar2, i11, false);
                    }
                    this.A += i2;
                    this.B -= i2;
                    i3 = 4;
                    i4 = 1;
                    i5 = 0;
                }
            }
        }
        long b2 = lVar.b(i6) * 1000;
        boolean z2 = (lVar.m ? IOUtils.DIR_SEPARATOR : 0) | lVar.l[i6];
        int i12 = lVar.f9498a.f9444a;
        if (lVar.m) {
            bArr = (lVar.o != null ? lVar.o : jVar.h[i12]).f9497c;
        } else {
            bArr = null;
        }
        q qVar = this.k;
        if (qVar != null) {
            b2 = qVar.c(b2);
        }
        nVar.a(b2, z2 ? 1 : 0, this.z, 0, bArr);
        while (!this.o.isEmpty()) {
            a removeFirst = this.o.removeFirst();
            this.v -= removeFirst.f9461b;
            this.E.a(removeFirst.f9460a + b2, 1, removeFirst.f9461b, this.v, (byte[]) null);
        }
        this.y.f9466e++;
        this.y.f9467f++;
        if (this.y.f9467f == lVar.h[this.y.f9468g]) {
            this.y.f9468g++;
            this.y.f9467f = 0;
            this.y = null;
        }
        this.p = 3;
        return true;
    }

    private static b a(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j2 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < size; i2++) {
            b valueAt = sparseArray.valueAt(i2);
            if (valueAt.f9468g != valueAt.f9462a.f9502e) {
                long j3 = valueAt.f9462a.f9504g[valueAt.f9468g];
                if (j3 < j2) {
                    bVar = valueAt;
                    j2 = j3;
                }
            }
        }
        return bVar;
    }

    private int a(b bVar) {
        l lVar = bVar.f9462a;
        k kVar = lVar.q;
        int i2 = (lVar.o != null ? lVar.o : bVar.f9464c.h[lVar.f9498a.f9444a]).f9496b;
        boolean z2 = lVar.n[bVar.f9466e];
        this.j.f10948a[0] = (byte) ((z2 ? 128 : 0) | i2);
        this.j.c(0);
        n nVar = bVar.f9463b;
        nVar.a(this.j, 1);
        nVar.a(kVar, i2);
        if (!z2) {
            return i2 + 1;
        }
        int h2 = kVar.h();
        kVar.d(-2);
        int i3 = (h2 * 6) + 2;
        nVar.a(kVar, i3);
        return i2 + 1 + i3;
    }

    private static com.google.android.exoplayer2.c.a a(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = list.get(i2);
            if (bVar.aP == a.U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.aQ.f10948a;
                UUID a2 = h.a(bArr);
                if (a2 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new a.C0159a(a2, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.google.android.exoplayer2.c.a((List<a.C0159a>) arrayList);
    }

    private static boolean a(int i2) {
        return i2 == a.S || i2 == a.R || i2 == a.C || i2 == a.A || i2 == a.T || i2 == a.w || i2 == a.x || i2 == a.O || i2 == a.y || i2 == a.z || i2 == a.U || i2 == a.ac || i2 == a.ad || i2 == a.ah || i2 == a.ag || i2 == a.ae || i2 == a.af || i2 == a.Q || i2 == a.N || i2 == a.aG;
    }

    private static boolean b(int i2) {
        return i2 == a.B || i2 == a.D || i2 == a.E || i2 == a.F || i2 == a.G || i2 == a.K || i2 == a.L || i2 == a.M || i2 == a.P;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f9460a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9461b;

        public a(long j, int i) {
            this.f9460a = j;
            this.f9461b = i;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final l f9462a = new l();

        /* renamed from: b  reason: collision with root package name */
        public final n f9463b;

        /* renamed from: c  reason: collision with root package name */
        public j f9464c;

        /* renamed from: d  reason: collision with root package name */
        public c f9465d;

        /* renamed from: e  reason: collision with root package name */
        public int f9466e;

        /* renamed from: f  reason: collision with root package name */
        public int f9467f;

        /* renamed from: g  reason: collision with root package name */
        public int f9468g;

        public b(n nVar) {
            this.f9463b = nVar;
        }

        public void a(j jVar, c cVar) {
            this.f9464c = (j) com.google.android.exoplayer2.n.a.a(jVar);
            this.f9465d = (c) com.google.android.exoplayer2.n.a.a(cVar);
            this.f9463b.a(jVar.f9493f);
            a();
        }

        public void a() {
            this.f9462a.a();
            this.f9466e = 0;
            this.f9468g = 0;
            this.f9467f = 0;
        }

        public void a(com.google.android.exoplayer2.c.a aVar) {
            this.f9463b.a(this.f9464c.f9493f.a(aVar));
        }
    }
}
