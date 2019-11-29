package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.a.d;
import java.io.IOException;

public class i extends a {
    private final int j;
    private final long k;
    private final d l;
    private volatile int m;
    private volatile boolean n;
    private volatile boolean o;

    public i(f fVar, com.google.android.exoplayer2.m.i iVar, j jVar, int i, Object obj, long j2, long j3, int i2, int i3, long j4, d dVar) {
        super(fVar, iVar, jVar, i, obj, j2, j3, i2);
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
        com.google.android.exoplayer2.m.i a2 = t.a(this.f11496a, this.m);
        try {
            bVar = new b(this.h, a2.f10766c, this.h.a(a2));
            if (this.m == 0) {
                b d2 = d();
                d2.a(this.k);
                this.l.a((d.b) d2);
            }
            com.google.android.exoplayer2.e.f fVar = this.l.f11503a;
            boolean z = false;
            int i = 0;
            while (i == 0 && !this.n) {
                i = fVar.a((g) bVar, (l) null);
            }
            if (i != 1) {
                z = true;
            }
            a.b(z);
            this.m = (int) (bVar.c() - this.f11496a.f10766c);
            t.a(this.h);
            this.o = true;
        } catch (Throwable th) {
            t.a(this.h);
            throw th;
        }
    }
}
