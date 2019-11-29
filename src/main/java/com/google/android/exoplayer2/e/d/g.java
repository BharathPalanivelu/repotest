package com.google.android.exoplayer2.e.d;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.d.a;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.j;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class g implements f, m {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9476a = new i() {
        public f[] a() {
            return new f[]{new g()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f9477b = t.g("qt  ");

    /* renamed from: c  reason: collision with root package name */
    private final k f9478c = new k(com.google.android.exoplayer2.n.i.f10930a);

    /* renamed from: d  reason: collision with root package name */
    private final k f9479d = new k(4);

    /* renamed from: e  reason: collision with root package name */
    private final k f9480e = new k(16);

    /* renamed from: f  reason: collision with root package name */
    private final Stack<a.C0162a> f9481f = new Stack<>();

    /* renamed from: g  reason: collision with root package name */
    private int f9482g;
    private int h;
    private long i;
    private int j;
    private k k;
    private int l;
    private int m;
    private h n;
    private a[] o;
    private long p;
    private boolean q;

    public boolean a() {
        return true;
    }

    public void c() {
    }

    public boolean a(com.google.android.exoplayer2.e.g gVar) throws IOException, InterruptedException {
        return i.b(gVar);
    }

    public void a(h hVar) {
        this.n = hVar;
    }

    public void a(long j2, long j3) {
        this.f9481f.clear();
        this.j = 0;
        this.l = 0;
        this.m = 0;
        if (j2 == 0) {
            d();
        } else if (this.o != null) {
            c(j3);
        }
    }

    public int a(com.google.android.exoplayer2.e.g gVar, l lVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f9482g;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return c(gVar, lVar);
                    }
                    throw new IllegalStateException();
                } else if (b(gVar, lVar)) {
                    return 1;
                }
            } else if (!b(gVar)) {
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
            m mVar = aVar.f9484b;
            int a2 = mVar.a(j2);
            if (a2 == -1) {
                a2 = mVar.b(j2);
            }
            long j4 = mVar.f9506b[a2];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    private void d() {
        this.f9482g = 0;
        this.j = 0;
    }

    private boolean b(com.google.android.exoplayer2.e.g gVar) throws IOException, InterruptedException {
        if (this.j == 0) {
            if (!gVar.a(this.f9480e.f10948a, 0, 8, true)) {
                return false;
            }
            this.j = 8;
            this.f9480e.c(0);
            this.i = this.f9480e.l();
            this.h = this.f9480e.n();
        }
        if (this.i == 1) {
            gVar.b(this.f9480e.f10948a, 8, 8);
            this.j += 8;
            this.i = this.f9480e.v();
        }
        if (b(this.h)) {
            long c2 = (gVar.c() + this.i) - ((long) this.j);
            this.f9481f.add(new a.C0162a(this.h, c2));
            if (this.i == ((long) this.j)) {
                a(c2);
            } else {
                d();
            }
        } else if (a(this.h)) {
            com.google.android.exoplayer2.n.a.b(this.j == 8);
            com.google.android.exoplayer2.n.a.b(this.i <= 2147483647L);
            this.k = new k((int) this.i);
            System.arraycopy(this.f9480e.f10948a, 0, this.k.f10948a, 0, 8);
            this.f9482g = 1;
        } else {
            this.k = null;
            this.f9482g = 1;
        }
        return true;
    }

    private boolean b(com.google.android.exoplayer2.e.g gVar, l lVar) throws IOException, InterruptedException {
        boolean z;
        long j2 = this.i - ((long) this.j);
        long c2 = gVar.c() + j2;
        k kVar = this.k;
        if (kVar != null) {
            gVar.b(kVar.f10948a, this.j, (int) j2);
            if (this.h == a.f9401a) {
                this.q = a(this.k);
            } else if (!this.f9481f.isEmpty()) {
                this.f9481f.peek().a(new a.b(this.h, this.k));
            }
        } else if (j2 < 262144) {
            gVar.b((int) j2);
        } else {
            lVar.f9779a = gVar.c() + j2;
            z = true;
            a(c2);
            if (z || this.f9482g == 2) {
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

    private void a(long j2) throws ak {
        while (!this.f9481f.isEmpty() && this.f9481f.peek().aQ == j2) {
            a.C0162a pop = this.f9481f.pop();
            if (pop.aP == a.B) {
                a(pop);
                this.f9481f.clear();
                this.f9482g = 2;
            } else if (!this.f9481f.isEmpty()) {
                this.f9481f.peek().a(pop);
            }
        }
        if (this.f9482g != 2) {
            d();
        }
    }

    private static boolean a(k kVar) {
        kVar.c(8);
        if (kVar.n() == f9477b) {
            return true;
        }
        kVar.d(4);
        while (kVar.b() > 0) {
            if (kVar.n() == f9477b) {
                return true;
            }
        }
        return false;
    }

    private void a(a.C0162a aVar) throws ak {
        com.google.android.exoplayer2.f.a aVar2;
        a.C0162a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        j jVar = new j();
        a.b d2 = aVar3.d(a.aA);
        if (d2 != null) {
            aVar2 = b.a(d2, this.q);
            if (aVar2 != null) {
                jVar.a(aVar2);
            }
        } else {
            aVar2 = null;
        }
        long j2 = Long.MAX_VALUE;
        long j3 = -9223372036854775807L;
        for (int i2 = 0; i2 < aVar3.aS.size(); i2++) {
            a.C0162a aVar4 = aVar3.aS.get(i2);
            if (aVar4.aP == a.D) {
                j a2 = b.a(aVar4, aVar3.d(a.C), -9223372036854775807L, (com.google.android.exoplayer2.c.a) null, this.q);
                if (a2 != null) {
                    m a3 = b.a(a2, aVar4.e(a.E).e(a.F).e(a.G), jVar);
                    if (a3.f9505a != 0) {
                        a aVar5 = new a(a2, a3, this.n.a(i2, a2.f9489b));
                        com.google.android.exoplayer2.j a4 = a2.f9493f.a(a3.f9508d + 30);
                        if (a2.f9489b == 1) {
                            if (jVar.a()) {
                                a4 = a4.a(jVar.f9770b, jVar.f9771c);
                            }
                            if (aVar2 != null) {
                                a4 = a4.a(aVar2);
                            }
                        }
                        aVar5.f9485c.a(a4);
                        j3 = Math.max(j3, a2.f9492e);
                        arrayList.add(aVar5);
                        long j4 = a3.f9506b[0];
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

    private int c(com.google.android.exoplayer2.e.g gVar, l lVar) throws IOException, InterruptedException {
        int e2 = e();
        if (e2 == -1) {
            return -1;
        }
        a aVar = this.o[e2];
        n nVar = aVar.f9485c;
        int i2 = aVar.f9486d;
        long j2 = aVar.f9484b.f9506b[i2];
        int i3 = aVar.f9484b.f9507c[i2];
        if (aVar.f9483a.f9494g == 1) {
            j2 += 8;
            i3 -= 8;
        }
        long c2 = (j2 - gVar.c()) + ((long) this.l);
        if (c2 < 0 || c2 >= 262144) {
            lVar.f9779a = j2;
            return 1;
        }
        gVar.b((int) c2);
        if (aVar.f9483a.k == 0) {
            while (true) {
                int i4 = this.l;
                if (i4 >= i3) {
                    break;
                }
                int a2 = nVar.a(gVar, i3 - i4, false);
                this.l += a2;
                this.m -= a2;
            }
        } else {
            byte[] bArr = this.f9479d.f10948a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i5 = aVar.f9483a.k;
            int i6 = 4 - aVar.f9483a.k;
            while (this.l < i3) {
                int i7 = this.m;
                if (i7 == 0) {
                    gVar.b(this.f9479d.f10948a, i6, i5);
                    this.f9479d.c(0);
                    this.m = this.f9479d.t();
                    this.f9478c.c(0);
                    nVar.a(this.f9478c, 4);
                    this.l += 4;
                    i3 += i6;
                } else {
                    int a3 = nVar.a(gVar, i7, false);
                    this.l += a3;
                    this.m -= a3;
                }
            }
        }
        nVar.a(aVar.f9484b.f9509e[i2], aVar.f9484b.f9510f[i2], i3, 0, (byte[]) null);
        aVar.f9486d++;
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
            int i4 = aVar.f9486d;
            if (i4 != aVar.f9484b.f9505a) {
                long j3 = aVar.f9484b.f9506b[i4];
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
            m mVar = aVar.f9484b;
            int a2 = mVar.a(j2);
            if (a2 == -1) {
                a2 = mVar.b(j2);
            }
            aVar.f9486d = a2;
        }
    }

    private static boolean a(int i2) {
        return i2 == a.R || i2 == a.C || i2 == a.S || i2 == a.T || i2 == a.am || i2 == a.an || i2 == a.ao || i2 == a.Q || i2 == a.ap || i2 == a.aq || i2 == a.ar || i2 == a.as || i2 == a.at || i2 == a.O || i2 == a.f9401a || i2 == a.aA;
    }

    private static boolean b(int i2) {
        return i2 == a.B || i2 == a.D || i2 == a.E || i2 == a.F || i2 == a.G || i2 == a.P;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j f9483a;

        /* renamed from: b  reason: collision with root package name */
        public final m f9484b;

        /* renamed from: c  reason: collision with root package name */
        public final n f9485c;

        /* renamed from: d  reason: collision with root package name */
        public int f9486d;

        public a(j jVar, m mVar, n nVar) {
            this.f9483a = jVar;
            this.f9484b = mVar;
            this.f9485c = nVar;
        }
    }
}
