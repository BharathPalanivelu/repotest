package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;

public final class m extends a {
    private final int j;
    private final j k;
    private volatile int l;
    private volatile boolean m;
    private volatile boolean n;

    public m(f fVar, i iVar, j jVar, int i, Object obj, long j2, long j3, int i2, int i3, j jVar2) {
        super(fVar, iVar, jVar, i, obj, j2, j3, i2);
        this.j = i3;
        this.k = jVar2;
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
            long a2 = this.h.a(t.a(this.f11496a, this.l));
            if (a2 != -1) {
                a2 += (long) this.l;
            }
            b bVar = new b(this.h, (long) this.l, a2);
            b d2 = d();
            d2.a(0);
            n a3 = d2.a(0, this.j);
            a3.a(this.k);
            for (int i = 0; i != -1; i = a3.a(bVar, Integer.MAX_VALUE, true)) {
                this.l += i;
            }
            a3.a(this.f11501f, 1, this.l, 0, (byte[]) null);
            t.a(this.h);
            this.n = true;
        } catch (Throwable th) {
            t.a(this.h);
            throw th;
        }
    }
}
