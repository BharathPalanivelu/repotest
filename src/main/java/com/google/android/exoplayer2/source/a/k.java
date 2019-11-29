package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.a.d;
import java.io.IOException;

public final class k extends c {
    private final d i;
    private volatile int j;
    private volatile boolean k;

    public k(f fVar, i iVar, j jVar, int i2, Object obj, d dVar) {
        super(fVar, iVar, 2, jVar, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.i = dVar;
    }

    public long e() {
        return (long) this.j;
    }

    public void a() {
        this.k = true;
    }

    public boolean b() {
        return this.k;
    }

    public void c() throws IOException, InterruptedException {
        b bVar;
        i a2 = t.a(this.f11496a, this.j);
        try {
            bVar = new b(this.h, a2.f10766c, this.h.a(a2));
            if (this.j == 0) {
                this.i.a((d.b) null);
            }
            com.google.android.exoplayer2.e.f fVar = this.i.f11503a;
            int i2 = 0;
            while (i2 == 0 && !this.k) {
                i2 = fVar.a((g) bVar, (l) null);
            }
            boolean z = true;
            if (i2 == 1) {
                z = false;
            }
            a.b(z);
            this.j = (int) (bVar.c() - this.f11496a.f10766c);
            t.a(this.h);
        } catch (Throwable th) {
            t.a(this.h);
            throw th;
        }
    }
}
