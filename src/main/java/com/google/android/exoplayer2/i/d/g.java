package com.google.android.exoplayer2.i.d;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.d.a;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class g implements e, l {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10106a = new h() {
        public e[] a() {
            return new e[]{new g()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f10107b = v.g("qt  ");

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.s.l f10108c = new com.google.android.exoplayer2.s.l(j.f11404a);

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.s.l f10109d = new com.google.android.exoplayer2.s.l(4);

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.s.l f10110e = new com.google.android.exoplayer2.s.l(16);

    /* renamed from: f  reason: collision with root package name */
    private final Stack<a.C0169a> f10111f = new Stack<>();

    /* renamed from: g  reason: collision with root package name */
    private int f10112g;
    private int h;
    private long i;
    private int j;
    private com.google.android.exoplayer2.s.l k;
    private int l;
    private int m;
    private com.google.android.exoplayer2.i.g n;
    private a[] o;
    private long p;
    private boolean q;

    public boolean a() {
        return true;
    }

    public void c() {
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        return i.b(fVar);
    }

    public void a(com.google.android.exoplayer2.i.g gVar) {
        this.n = gVar;
    }

    public void a(long j2, long j3) {
        this.f10111f.clear();
        this.j = 0;
        this.l = 0;
        this.m = 0;
        if (j2 == 0) {
            d();
        } else if (this.o != null) {
            c(j3);
        }
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f10112g;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return c(fVar, kVar);
                    }
                    throw new IllegalStateException();
                } else if (b(fVar, kVar)) {
                    return 1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    public long b() {
        return this.p;
    }

    public long b(long j2) {
        long j3 = Clock.MAX_TIME;
        for (a aVar : this.o) {
            m mVar = aVar.f10114b;
            int a2 = mVar.a(j2);
            if (a2 == -1) {
                a2 = mVar.b(j2);
            }
            long j4 = mVar.f10138b[a2];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    private void d() {
        this.f10112g = 0;
        this.j = 0;
    }

    private boolean b(f fVar) throws IOException, InterruptedException {
        if (this.j == 0) {
            if (!fVar.a(this.f10110e.f11422a, 0, 8, true)) {
                return false;
            }
            this.j = 8;
            this.f10110e.c(0);
            this.i = this.f10110e.l();
            this.h = this.f10110e.n();
        }
        if (this.i == 1) {
            fVar.b(this.f10110e.f11422a, 8, 8);
            this.j += 8;
            this.i = this.f10110e.v();
        }
        if (b(this.h)) {
            long c2 = (fVar.c() + this.i) - ((long) this.j);
            this.f10111f.add(new a.C0169a(this.h, c2));
            if (this.i == ((long) this.j)) {
                a(c2);
            } else {
                d();
            }
        } else if (a(this.h)) {
            com.google.android.exoplayer2.s.a.b(this.j == 8);
            com.google.android.exoplayer2.s.a.b(this.i <= 2147483647L);
            this.k = new com.google.android.exoplayer2.s.l((int) this.i);
            System.arraycopy(this.f10110e.f11422a, 0, this.k.f11422a, 0, 8);
            this.f10112g = 1;
        } else {
            this.k = null;
            this.f10112g = 1;
        }
        return true;
    }

    private boolean b(f fVar, k kVar) throws IOException, InterruptedException {
        boolean z;
        long j2 = this.i - ((long) this.j);
        long c2 = fVar.c() + j2;
        com.google.android.exoplayer2.s.l lVar = this.k;
        if (lVar != null) {
            fVar.b(lVar.f11422a, this.j, (int) j2);
            if (this.h == a.f10038a) {
                this.q = a(this.k);
            } else if (!this.f10111f.isEmpty()) {
                this.f10111f.peek().a(new a.b(this.h, this.k));
            }
        } else if (j2 < 262144) {
            fVar.b((int) j2);
        } else {
            kVar.f10416a = fVar.c() + j2;
            z = true;
            a(c2);
            if (z || this.f10112g == 2) {
                return false;
            }
            return true;
        }
        z = false;
        a(c2);
        if (z) {
        }
        return false;
    }

    private void a(long j2) throws p {
        while (!this.f10111f.isEmpty() && this.f10111f.peek().aQ == j2) {
            a.C0169a pop = this.f10111f.pop();
            if (pop.aP == a.B) {
                a(pop);
                this.f10111f.clear();
                this.f10112g = 2;
            } else if (!this.f10111f.isEmpty()) {
                this.f10111f.peek().a(pop);
            }
        }
        if (this.f10112g != 2) {
            d();
        }
    }

    private static boolean a(com.google.android.exoplayer2.s.l lVar) {
        lVar.c(8);
        if (lVar.n() == f10107b) {
            return true;
        }
        lVar.d(4);
        while (lVar.b() > 0) {
            if (lVar.n() == f10107b) {
                return true;
            }
        }
        return false;
    }

    private void a(a.C0169a aVar) throws p {
        Metadata metadata;
        a.C0169a aVar2 = aVar;
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        a.b d2 = aVar2.d(a.aA);
        if (d2 != null) {
            metadata = b.a(d2, this.q);
            if (metadata != null) {
                iVar.a(metadata);
            }
        } else {
            metadata = null;
        }
        long j2 = Long.MAX_VALUE;
        long j3 = -9223372036854775807L;
        for (int i2 = 0; i2 < aVar2.aS.size(); i2++) {
            a.C0169a aVar3 = aVar2.aS.get(i2);
            if (aVar3.aP == a.D) {
                j a2 = b.a(aVar3, aVar2.d(a.C), -9223372036854775807L, (DrmInitData) null, this.q);
                if (a2 != null) {
                    m a3 = b.a(a2, aVar3.e(a.E).e(a.F).e(a.G), iVar);
                    if (a3.f10137a != 0) {
                        a aVar4 = new a(a2, a3, this.n.a(i2, a2.f10119b));
                        Format a4 = a2.f10123f.a(a3.f10140d + 30);
                        if (a2.f10119b == 1) {
                            if (iVar.a()) {
                                a4 = a4.a(iVar.f10407b, iVar.f10408c);
                            }
                            if (metadata != null) {
                                a4 = a4.a(metadata);
                            }
                        }
                        aVar4.f10115c.a(a4);
                        j3 = Math.max(j3, a2.f10122e);
                        arrayList.add(aVar4);
                        long j4 = a3.f10138b[0];
                        if (j4 < j2) {
                            j2 = j4;
                        }
                    }
                }
            }
        }
        this.p = j3;
        this.o = (a[]) arrayList.toArray(new a[arrayList.size()]);
        this.n.a();
        this.n.a(this);
    }

    private int c(f fVar, k kVar) throws IOException, InterruptedException {
        int e2 = e();
        if (e2 == -1) {
            return -1;
        }
        a aVar = this.o[e2];
        m mVar = aVar.f10115c;
        int i2 = aVar.f10116d;
        long j2 = aVar.f10114b.f10138b[i2];
        int i3 = aVar.f10114b.f10139c[i2];
        if (aVar.f10113a.f10124g == 1) {
            j2 += 8;
            i3 -= 8;
        }
        long c2 = (j2 - fVar.c()) + ((long) this.l);
        if (c2 < 0 || c2 >= 262144) {
            kVar.f10416a = j2;
            return 1;
        }
        fVar.b((int) c2);
        if (aVar.f10113a.j == 0) {
            while (true) {
                int i4 = this.l;
                if (i4 >= i3) {
                    break;
                }
                int a2 = mVar.a(fVar, i3 - i4, false);
                this.l += a2;
                this.m -= a2;
            }
        } else {
            byte[] bArr = this.f10109d.f11422a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i5 = aVar.f10113a.j;
            int i6 = 4 - aVar.f10113a.j;
            while (this.l < i3) {
                int i7 = this.m;
                if (i7 == 0) {
                    fVar.b(this.f10109d.f11422a, i6, i5);
                    this.f10109d.c(0);
                    this.m = this.f10109d.t();
                    this.f10108c.c(0);
                    mVar.a(this.f10108c, 4);
                    this.l += 4;
                    i3 += i6;
                } else {
                    int a3 = mVar.a(fVar, i7, false);
                    this.l += a3;
                    this.m -= a3;
                }
            }
        }
        mVar.a(aVar.f10114b.f10141e[i2], aVar.f10114b.f10142f[i2], i3, 0, (m.a) null);
        aVar.f10116d++;
        this.l = 0;
        this.m = 0;
        return 0;
    }

    private int e() {
        int i2 = -1;
        long j2 = Clock.MAX_TIME;
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.o;
            if (i3 >= aVarArr.length) {
                return i2;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.f10116d;
            if (i4 != aVar.f10114b.f10137a) {
                long j3 = aVar.f10114b.f10138b[i4];
                if (j3 < j2) {
                    i2 = i3;
                    j2 = j3;
                }
            }
            i3++;
        }
    }

    private void c(long j2) {
        for (a aVar : this.o) {
            m mVar = aVar.f10114b;
            int a2 = mVar.a(j2);
            if (a2 == -1) {
                a2 = mVar.b(j2);
            }
            aVar.f10116d = a2;
        }
    }

    private static boolean a(int i2) {
        return i2 == a.R || i2 == a.C || i2 == a.S || i2 == a.T || i2 == a.am || i2 == a.an || i2 == a.ao || i2 == a.Q || i2 == a.ap || i2 == a.aq || i2 == a.ar || i2 == a.as || i2 == a.at || i2 == a.O || i2 == a.f10038a || i2 == a.aA;
    }

    private static boolean b(int i2) {
        return i2 == a.B || i2 == a.D || i2 == a.E || i2 == a.F || i2 == a.G || i2 == a.P;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j f10113a;

        /* renamed from: b  reason: collision with root package name */
        public final m f10114b;

        /* renamed from: c  reason: collision with root package name */
        public final m f10115c;

        /* renamed from: d  reason: collision with root package name */
        public int f10116d;

        public a(j jVar, m mVar, m mVar2) {
            this.f10113a = jVar;
            this.f10114b = mVar;
            this.f10115c = mVar2;
        }
    }
}
