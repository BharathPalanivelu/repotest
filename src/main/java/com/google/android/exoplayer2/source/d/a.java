package com.google.android.exoplayer2.source.d;

import android.net.Uri;
import com.google.android.exoplayer2.e.d.e;
import com.google.android.exoplayer2.e.d.k;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.s;
import com.google.android.exoplayer2.n.q;
import com.google.android.exoplayer2.source.a.c;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.a.i;
import com.google.android.exoplayer2.source.a.l;
import com.google.android.exoplayer2.source.d.a.a;
import com.google.android.exoplayer2.source.d.b;
import java.io.IOException;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final s f11776a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11777b;

    /* renamed from: c  reason: collision with root package name */
    private final f f11778c;

    /* renamed from: d  reason: collision with root package name */
    private final d[] f11779d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.m.f f11780e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.exoplayer2.source.d.a.a f11781f;

    /* renamed from: g  reason: collision with root package name */
    private int f11782g;
    private IOException h;

    public void a(c cVar) {
    }

    /* renamed from: com.google.android.exoplayer2.source.d.a$a  reason: collision with other inner class name */
    public static final class C0190a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final f.a f11790a;

        public C0190a(f.a aVar) {
            this.f11790a = aVar;
        }

        public b a(s sVar, com.google.android.exoplayer2.source.d.a.a aVar, int i, com.google.android.exoplayer2.l.f fVar, k[] kVarArr) {
            return new a(sVar, aVar, i, fVar, this.f11790a.a(), kVarArr);
        }
    }

    public a(s sVar, com.google.android.exoplayer2.source.d.a.a aVar, int i, com.google.android.exoplayer2.l.f fVar, com.google.android.exoplayer2.m.f fVar2, k[] kVarArr) {
        com.google.android.exoplayer2.source.d.a.a aVar2 = aVar;
        int i2 = i;
        com.google.android.exoplayer2.l.f fVar3 = fVar;
        this.f11776a = sVar;
        this.f11781f = aVar2;
        this.f11777b = i2;
        this.f11778c = fVar3;
        this.f11780e = fVar2;
        a.b bVar = aVar2.f11788f[i2];
        this.f11779d = new d[fVar.e()];
        int i3 = 0;
        while (i3 < this.f11779d.length) {
            int b2 = fVar3.b(i3);
            j jVar = bVar.j[b2];
            int i4 = i3;
            com.google.android.exoplayer2.e.d.j jVar2 = r7;
            com.google.android.exoplayer2.e.d.j jVar3 = new com.google.android.exoplayer2.e.d.j(b2, bVar.f11793a, bVar.f11795c, -9223372036854775807L, aVar2.f11789g, jVar, 0, kVarArr, bVar.f11793a == 2 ? 4 : 0, (long[]) null, (long[]) null);
            this.f11779d[i4] = new d(new e(3, (q) null, jVar2), jVar);
            i3 = i4 + 1;
        }
    }

    public void a(com.google.android.exoplayer2.source.d.a.a aVar) {
        a.b bVar = this.f11781f.f11788f[this.f11777b];
        int i = bVar.k;
        a.b bVar2 = aVar.f11788f[this.f11777b];
        if (i == 0 || bVar2.k == 0) {
            this.f11782g += i;
        } else {
            int i2 = i - 1;
            long a2 = bVar2.a(0);
            if (bVar.a(i2) + bVar.b(i2) <= a2) {
                this.f11782g += i;
            } else {
                this.f11782g += bVar.a(a2);
            }
        }
        this.f11781f = aVar;
    }

    public void a() throws IOException {
        IOException iOException = this.h;
        if (iOException == null) {
            this.f11776a.d();
            return;
        }
        throw iOException;
    }

    public final void a(l lVar, long j, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        l lVar2 = lVar;
        long j2 = j;
        com.google.android.exoplayer2.source.a.e eVar2 = eVar;
        if (this.h == null) {
            this.f11778c.a(lVar2 != null ? lVar2.f11502g - j2 : 0);
            a.b bVar = this.f11781f.f11788f[this.f11777b];
            if (bVar.k == 0) {
                eVar2.f11516b = !this.f11781f.f11786d;
                return;
            }
            if (lVar2 == null) {
                i = bVar.a(j2);
            } else {
                i = lVar.f() - this.f11782g;
                if (i < 0) {
                    this.h = new com.google.android.exoplayer2.source.s();
                    return;
                }
            }
            if (i >= bVar.k) {
                eVar2.f11516b = !this.f11781f.f11786d;
                return;
            }
            long a2 = bVar.a(i);
            long b2 = a2 + bVar.b(i);
            int i2 = i + this.f11782g;
            int a3 = this.f11778c.a();
            eVar2.f11515a = a(this.f11778c.f(), this.f11780e, bVar.a(this.f11778c.b(a3), i), (String) null, i2, a2, b2, this.f11778c.b(), this.f11778c.c(), this.f11779d[a3]);
        }
    }

    public boolean a(c cVar, boolean z, Exception exc) {
        if (z) {
            com.google.android.exoplayer2.l.f fVar = this.f11778c;
            if (h.a(fVar, fVar.a(cVar.f11498c), exc)) {
                return true;
            }
        }
        return false;
    }

    private static l a(j jVar, com.google.android.exoplayer2.m.f fVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, d dVar) {
        return new i(fVar, new com.google.android.exoplayer2.m.i(uri, 0, -1, str), jVar, i2, obj, j, j2, i, 1, j, dVar);
    }
}
