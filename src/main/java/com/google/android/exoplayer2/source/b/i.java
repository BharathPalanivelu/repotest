package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.b.d;
import java.io.IOException;

public class i extends a {
    private final int j;
    private final long k;
    private final d l;
    private volatile int m;
    private volatile boolean n;
    private volatile boolean o;

    public i(f fVar, com.google.android.exoplayer2.r.i iVar, Format format, int i, Object obj, long j2, long j3, int i2, int i3, long j4, d dVar) {
        super(fVar, iVar, format, i, obj, j2, j3, i2);
        this.j = i3;
        this.k = j4;
        this.l = dVar;
    }

    public int f() {
        return this.i + this.j;
    }

    public boolean g() {
        return this.o;
    }

    public final long e() {
        return (long) this.m;
    }

    public final void a() {
        this.n = true;
    }

    public final boolean b() {
        return this.n;
    }

    public final void c() throws IOException, InterruptedException {
        b bVar;
        com.google.android.exoplayer2.r.i a2 = this.f11543a.a((long) this.m);
        try {
            bVar = new b(this.h, a2.f11315c, this.h.a(a2));
            if (this.m == 0) {
                b d2 = d();
                d2.a(this.k);
                this.l.a((d.b) d2);
            }
            e eVar = this.l.f11550a;
            boolean z = false;
            int i = 0;
            while (i == 0 && !this.n) {
                i = eVar.a((com.google.android.exoplayer2.i.f) bVar, (k) null);
            }
            if (i != 1) {
                z = true;
            }
            a.b(z);
            this.m = (int) (bVar.c() - this.f11543a.f11315c);
            v.a(this.h);
            this.o = true;
        } catch (Throwable th) {
            v.a(this.h);
            throw th;
        }
    }
}
