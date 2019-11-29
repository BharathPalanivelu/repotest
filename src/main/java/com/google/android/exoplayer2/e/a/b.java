package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;

public final class b implements f, m {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9314a = new i() {
        public f[] a() {
            return new f[]{new b()};
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final int f9315e = t.g("FLV");

    /* renamed from: b  reason: collision with root package name */
    public int f9316b;

    /* renamed from: c  reason: collision with root package name */
    public int f9317c;

    /* renamed from: d  reason: collision with root package name */
    public long f9318d;

    /* renamed from: f  reason: collision with root package name */
    private final k f9319f = new k(4);

    /* renamed from: g  reason: collision with root package name */
    private final k f9320g = new k(9);
    private final k h = new k(11);
    private final k i = new k();
    private h j;
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

    public boolean a(g gVar) throws IOException, InterruptedException {
        gVar.c(this.f9319f.f10948a, 0, 3);
        this.f9319f.c(0);
        if (this.f9319f.k() != f9315e) {
            return false;
        }
        gVar.c(this.f9319f.f10948a, 0, 2);
        this.f9319f.c(0);
        if ((this.f9319f.h() & 250) != 0) {
            return false;
        }
        gVar.c(this.f9319f.f10948a, 0, 4);
        this.f9319f.c(0);
        int n2 = this.f9319f.n();
        gVar.a();
        gVar.c(n2);
        gVar.c(this.f9319f.f10948a, 0, 4);
        this.f9319f.c(0);
        if (this.f9319f.n() == 0) {
            return true;
        }
        return false;
    }

    public void a(h hVar) {
        this.j = hVar;
    }

    public void a(long j2, long j3) {
        this.k = 1;
        this.l = 0;
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.k;
            if (i2 != 1) {
                if (i2 == 2) {
                    c(gVar);
                } else if (i2 != 3) {
                    if (i2 == 4 && e(gVar)) {
                        return 0;
                    }
                } else if (!d(gVar)) {
                    return -1;
                }
            } else if (!b(gVar)) {
                return -1;
            }
        }
    }

    private boolean b(g gVar) throws IOException, InterruptedException {
        boolean z = false;
        if (!gVar.a(this.f9320g.f10948a, 0, 9, true)) {
            return false;
        }
        this.f9320g.c(0);
        this.f9320g.d(4);
        int g2 = this.f9320g.g();
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
            this.o = new c((n) null);
        }
        this.j.a();
        this.j.a(this);
        this.l = (this.f9320g.n() - 9) + 4;
        this.k = 2;
        return true;
    }

    private void c(g gVar) throws IOException, InterruptedException {
        gVar.b(this.l);
        this.l = 0;
        this.k = 3;
    }

    private boolean d(g gVar) throws IOException, InterruptedException {
        if (!gVar.a(this.h.f10948a, 0, 11, true)) {
            return false;
        }
        this.h.c(0);
        this.f9316b = this.h.g();
        this.f9317c = this.h.k();
        this.f9318d = (long) this.h.k();
        this.f9318d = (((long) (this.h.g() << 24)) | this.f9318d) * 1000;
        this.h.d(3);
        this.k = 4;
        return true;
    }

    private boolean e(g gVar) throws IOException, InterruptedException {
        boolean z;
        if (this.f9316b == 8) {
            a aVar = this.m;
            if (aVar != null) {
                aVar.b(f(gVar), this.f9318d);
                z = true;
                this.l = 4;
                this.k = 2;
                return z;
            }
        }
        if (this.f9316b == 9) {
            e eVar = this.n;
            if (eVar != null) {
                eVar.b(f(gVar), this.f9318d);
                z = true;
                this.l = 4;
                this.k = 2;
                return z;
            }
        }
        if (this.f9316b == 18) {
            c cVar = this.o;
            if (cVar != null) {
                cVar.b(f(gVar), this.f9318d);
                z = true;
                this.l = 4;
                this.k = 2;
                return z;
            }
        }
        gVar.b(this.f9317c);
        z = false;
        this.l = 4;
        this.k = 2;
        return z;
    }

    private k f(g gVar) throws IOException, InterruptedException {
        if (this.f9317c > this.i.e()) {
            k kVar = this.i;
            kVar.a(new byte[Math.max(kVar.e() * 2, this.f9317c)], 0);
        } else {
            this.i.c(0);
        }
        this.i.b(this.f9317c);
        gVar.b(this.i.f10948a, 0, this.f9317c);
        return this.i;
    }

    public long b() {
        return this.o.a();
    }
}
