package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;
import java.io.IOException;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9526a = new i() {
        public f[] a() {
            return new f[]{new c()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private h f9527b;

    public void c() {
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        try {
            e eVar = new e();
            if (eVar.a(gVar, true)) {
                if ((eVar.f9534b & 2) == 2) {
                    int min = Math.min(eVar.i, 8);
                    k kVar = new k(min);
                    gVar.c(kVar.f10948a, 0, min);
                    if (b.a(a(kVar))) {
                        this.f9527b = new b();
                    } else if (j.a(a(kVar))) {
                        this.f9527b = new j();
                    } else if (g.a(a(kVar))) {
                        this.f9527b = new g();
                    }
                    return true;
                }
            }
        } catch (ak unused) {
        }
        return false;
    }

    public void a(h hVar) {
        n a2 = hVar.a(0, 1);
        hVar.a();
        this.f9527b.a(hVar, a2);
    }

    public void a(long j, long j2) {
        this.f9527b.a(j, j2);
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        return this.f9527b.a(gVar, lVar);
    }

    private static k a(k kVar) {
        kVar.c(0);
        return kVar;
    }
}
