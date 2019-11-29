package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.b.d;
import java.io.IOException;

public final class k extends c {
    private final d i;
    private volatile int j;
    private volatile boolean k;

    public k(f fVar, i iVar, Format format, int i2, Object obj, d dVar) {
        super(fVar, iVar, 2, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
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
        i a2 = this.f11543a.a((long) this.j);
        try {
            bVar = new b(this.h, a2.f11315c, this.h.a(a2));
            if (this.j == 0) {
                this.i.a((d.b) null);
            }
            e eVar = this.i.f11550a;
            int i2 = 0;
            while (i2 == 0 && !this.k) {
                i2 = eVar.a((com.google.android.exoplayer2.i.f) bVar, (com.google.android.exoplayer2.i.k) null);
            }
            boolean z = true;
            if (i2 == 1) {
                z = false;
            }
            a.b(z);
            this.j = (int) (bVar.c() - this.f11543a.f11315c);
            v.a(this.h);
        } catch (Throwable th) {
            v.a(this.h);
            throw th;
        }
    }
}
