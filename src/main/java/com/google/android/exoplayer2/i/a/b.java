package com.google.android.exoplayer2.i.a;

import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;

public final class b implements e, l {

    /* renamed from: a  reason: collision with root package name */
    public static final h f9950a = new h() {
        public e[] a() {
            return new e[]{new b()};
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final int f9951e = v.g("FLV");

    /* renamed from: b  reason: collision with root package name */
    public int f9952b;

    /* renamed from: c  reason: collision with root package name */
    public int f9953c;

    /* renamed from: d  reason: collision with root package name */
    public long f9954d;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.s.l f9955f = new com.google.android.exoplayer2.s.l(4);

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.s.l f9956g = new com.google.android.exoplayer2.s.l(9);
    private final com.google.android.exoplayer2.s.l h = new com.google.android.exoplayer2.s.l(11);
    private final com.google.android.exoplayer2.s.l i = new com.google.android.exoplayer2.s.l();
    private g j;
    private int k = 1;
    private int l;
    private a m;
    private e n;
    private c o;

    public boolean a() {
        return false;
    }

    public long b(long j2) {
        return 0;
    }

    public void c() {
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.c(this.f9955f.f11422a, 0, 3);
        this.f9955f.c(0);
        if (this.f9955f.k() != f9951e) {
            return false;
        }
        fVar.c(this.f9955f.f11422a, 0, 2);
        this.f9955f.c(0);
        if ((this.f9955f.h() & 250) != 0) {
            return false;
        }
        fVar.c(this.f9955f.f11422a, 0, 4);
        this.f9955f.c(0);
        int n2 = this.f9955f.n();
        fVar.a();
        fVar.c(n2);
        fVar.c(this.f9955f.f11422a, 0, 4);
        this.f9955f.c(0);
        if (this.f9955f.n() == 0) {
            return true;
        }
        return false;
    }

    public void a(g gVar) {
        this.j = gVar;
    }

    public void a(long j2, long j3) {
        this.k = 1;
        this.l = 0;
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.k;
            if (i2 != 1) {
                if (i2 == 2) {
                    c(fVar);
                } else if (i2 != 3) {
                    if (i2 == 4 && e(fVar)) {
                        return 0;
                    }
                } else if (!d(fVar)) {
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    private boolean b(f fVar) throws IOException, InterruptedException {
        boolean z = false;
        if (!fVar.a(this.f9956g.f11422a, 0, 9, true)) {
            return false;
        }
        this.f9956g.c(0);
        this.f9956g.d(4);
        int g2 = this.f9956g.g();
        boolean z2 = (g2 & 4) != 0;
        if ((g2 & 1) != 0) {
            z = true;
        }
        if (z2 && this.m == null) {
            this.m = new a(this.j.a(8, 1));
        }
        if (z && this.n == null) {
            this.n = new e(this.j.a(9, 2));
        }
        if (this.o == null) {
            this.o = new c((m) null);
        }
        this.j.a();
        this.j.a(this);
        this.l = (this.f9956g.n() - 9) + 4;
        this.k = 2;
        return true;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.b(this.l);
        this.l = 0;
        this.k = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (!fVar.a(this.h.f11422a, 0, 11, true)) {
            return false;
        }
        this.h.c(0);
        this.f9952b = this.h.g();
        this.f9953c = this.h.k();
        this.f9954d = (long) this.h.k();
        this.f9954d = (((long) (this.h.g() << 24)) | this.f9954d) * 1000;
        this.h.d(3);
        this.k = 4;
        return true;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z;
        if (this.f9952b == 8) {
            a aVar = this.m;
            if (aVar != null) {
                aVar.b(f(fVar), this.f9954d);
                z = true;
                this.l = 4;
                this.k = 2;
                return z;
            }
        }
        if (this.f9952b == 9) {
            e eVar = this.n;
            if (eVar != null) {
                eVar.b(f(fVar), this.f9954d);
                z = true;
                this.l = 4;
                this.k = 2;
                return z;
            }
        }
        if (this.f9952b == 18) {
            c cVar = this.o;
            if (cVar != null) {
                cVar.b(f(fVar), this.f9954d);
                z = true;
                this.l = 4;
                this.k = 2;
                return z;
            }
        }
        fVar.b(this.f9953c);
        z = false;
        this.l = 4;
        this.k = 2;
        return z;
    }

    private com.google.android.exoplayer2.s.l f(f fVar) throws IOException, InterruptedException {
        if (this.f9953c > this.i.e()) {
            com.google.android.exoplayer2.s.l lVar = this.i;
            lVar.a(new byte[Math.max(lVar.e() * 2, this.f9953c)], 0);
        } else {
            this.i.c(0);
        }
        this.i.b(this.f9953c);
        fVar.b(this.i.f11422a, 0, this.f9953c);
        return this.i;
    }

    public long b() {
        return this.o.a();
    }
}
