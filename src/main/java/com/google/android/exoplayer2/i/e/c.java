package com.google.android.exoplayer2.i.e;

import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import java.io.IOException;

public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10158a = new h() {
        public e[] a() {
            return new e[]{new c()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private g f10159b;

    /* renamed from: c  reason: collision with root package name */
    private h f10160c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10161d;

    public void c() {
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        try {
            return b(fVar);
        } catch (p unused) {
            return false;
        }
    }

    public void a(g gVar) {
        this.f10159b = gVar;
    }

    public void a(long j, long j2) {
        h hVar = this.f10160c;
        if (hVar != null) {
            hVar.a(j, j2);
        }
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.f10160c == null) {
            if (b(fVar)) {
                fVar.a();
            } else {
                throw new p("Failed to determine bitstream type");
            }
        }
        if (!this.f10161d) {
            m a2 = this.f10159b.a(0, 1);
            this.f10159b.a();
            this.f10160c.a(this.f10159b, a2);
            this.f10161d = true;
        }
        return this.f10160c.a(fVar, kVar);
    }

    private boolean b(f fVar) throws IOException, InterruptedException {
        e eVar = new e();
        if (eVar.a(fVar, true) && (eVar.f10168b & 2) == 2) {
            int min = Math.min(eVar.i, 8);
            l lVar = new l(min);
            fVar.c(lVar.f11422a, 0, min);
            if (b.a(a(lVar))) {
                this.f10160c = new b();
            } else if (j.a(a(lVar))) {
                this.f10160c = new j();
            } else if (g.a(a(lVar))) {
                this.f10160c = new g();
            }
            return true;
        }
        return false;
    }

    private static l a(l lVar) {
        lVar.c(0);
        return lVar;
    }
}
