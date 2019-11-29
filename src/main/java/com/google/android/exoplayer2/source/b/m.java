package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;

public final class m extends a {
    private final int j;
    private final Format k;
    private volatile int l;
    private volatile boolean m;
    private volatile boolean n;

    public m(f fVar, i iVar, Format format, int i, Object obj, long j2, long j3, int i2, int i3, Format format2) {
        super(fVar, iVar, format, i, obj, j2, j3, i2);
        this.j = i3;
        this.k = format2;
    }

    public boolean g() {
        return this.n;
    }

    public long e() {
        return (long) this.l;
    }

    public void a() {
        this.m = true;
    }

    public boolean b() {
        return this.m;
    }

    /* JADX INFO: finally extract failed */
    public void c() throws IOException, InterruptedException {
        try {
            long a2 = this.h.a(this.f11543a.a((long) this.l));
            if (a2 != -1) {
                a2 += (long) this.l;
            }
            b bVar = new b(this.h, (long) this.l, a2);
            b d2 = d();
            d2.a(0);
            com.google.android.exoplayer2.i.m a3 = d2.a(0, this.j);
            a3.a(this.k);
            for (int i = 0; i != -1; i = a3.a(bVar, Integer.MAX_VALUE, true)) {
                this.l += i;
            }
            a3.a(this.f11548f, 1, this.l, 0, (m.a) null);
            v.a(this.h);
            this.n = true;
        } catch (Throwable th) {
            v.a(this.h);
            throw th;
        }
    }
}
