package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.m.s;
import com.google.android.exoplayer2.source.a.f;
import com.google.android.exoplayer2.source.aa;
import com.google.android.exoplayer2.source.ac;
import com.google.android.exoplayer2.source.ad;
import com.google.android.exoplayer2.source.dash.g;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

final class h implements aa.a<f<g>>, x {

    /* renamed from: a  reason: collision with root package name */
    final int f11944a;

    /* renamed from: b  reason: collision with root package name */
    private final g.a f11945b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11946c;

    /* renamed from: d  reason: collision with root package name */
    private final r.a f11947d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11948e;

    /* renamed from: f  reason: collision with root package name */
    private final s f11949f;

    /* renamed from: g  reason: collision with root package name */
    private final b f11950g;
    private final ad h;
    private final a[] i;
    private x.a j;
    private f<g>[] k = a(0);
    private t l = new t(this.k);
    private com.google.android.exoplayer2.source.dash.a.b m;
    private int n;
    private List<com.google.android.exoplayer2.source.dash.a.a> o;

    public long d() {
        return -9223372036854775807L;
    }

    public h(int i2, com.google.android.exoplayer2.source.dash.a.b bVar, int i3, g.a aVar, int i4, r.a aVar2, long j2, s sVar, b bVar2) {
        this.f11944a = i2;
        this.m = bVar;
        this.n = i3;
        this.f11945b = aVar;
        this.f11946c = i4;
        this.f11947d = aVar2;
        this.f11948e = j2;
        this.f11949f = sVar;
        this.f11950g = bVar2;
        this.o = bVar.a(i3).f11861c;
        Pair<ad, a[]> a2 = a(this.o);
        this.h = (ad) a2.first;
        this.i = (a[]) a2.second;
    }

    public void a(com.google.android.exoplayer2.source.dash.a.b bVar, int i2) {
        this.m = bVar;
        this.n = i2;
        this.o = bVar.a(i2).f11861c;
        f<g>[] fVarArr = this.k;
        if (fVarArr != null) {
            for (f<g> a2 : fVarArr) {
                a2.a().a(bVar, i2);
            }
            this.j.a(this);
        }
    }

    public void a() {
        for (f<g> c2 : this.k) {
            c2.c();
        }
    }

    public void a(x.a aVar) {
        this.j = aVar;
        aVar.a(this);
    }

    public void b() throws IOException {
        this.f11949f.d();
    }

    public ad c() {
        return this.h;
    }

    public long a(com.google.android.exoplayer2.l.f[] fVarArr, boolean[] zArr, z[] zVarArr, boolean[] zArr2, long j2) {
        z zVar;
        com.google.android.exoplayer2.l.f[] fVarArr2 = fVarArr;
        long j3 = j2;
        int size = this.o.size();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < fVarArr2.length; i2++) {
            if (zVarArr[i2] instanceof f) {
                f fVar = zVarArr[i2];
                if (fVarArr2[i2] == null || !zArr[i2]) {
                    fVar.c();
                    zVarArr[i2] = null;
                } else {
                    hashMap.put(Integer.valueOf(this.h.a(fVarArr2[i2].d())), fVar);
                }
            }
            if (zVarArr[i2] == null && fVarArr2[i2] != null) {
                int a2 = this.h.a(fVarArr2[i2].d());
                if (a2 < size) {
                    f<g> a3 = a(a2, fVarArr2[i2], j3);
                    hashMap.put(Integer.valueOf(a2), a3);
                    zVarArr[i2] = a3;
                    zArr2[i2] = true;
                }
            }
        }
        for (int i3 = 0; i3 < fVarArr2.length; i3++) {
            if (((zVarArr[i3] instanceof f.a) || (zVarArr[i3] instanceof u)) && (fVarArr2[i3] == null || !zArr[i3])) {
                a(zVarArr[i3]);
                zVarArr[i3] = null;
            }
            if (fVarArr2[i3] != null) {
                int a4 = this.h.a(fVarArr2[i3].d());
                if (a4 >= size) {
                    a aVar = this.i[a4 - size];
                    f<T> fVar2 = (f) hashMap.get(Integer.valueOf(aVar.f11951a));
                    f.a aVar2 = zVarArr[i3];
                    if (!(fVar2 == null ? aVar2 instanceof u : (aVar2 instanceof f.a) && aVar2.f11524a == fVar2)) {
                        a((z) aVar2);
                        if (fVar2 == null) {
                            zVar = new u();
                        } else {
                            zVar = fVar2.a(j3, aVar.f11952b);
                        }
                        zVarArr[i3] = zVar;
                        zArr2[i3] = true;
                    }
                }
            }
        }
        this.k = a(hashMap.size());
        hashMap.values().toArray(this.k);
        this.l = new t(this.k);
        return j3;
    }

    public void a(long j2) {
        for (f<g> a2 : this.k) {
            a2.a(j2);
        }
    }

    public boolean d(long j2) {
        return this.l.d(j2);
    }

    public long f() {
        return this.l.f();
    }

    public long e() {
        long j2 = Long.MAX_VALUE;
        for (f<g> b2 : this.k) {
            long b3 = b2.b();
            if (b3 != Long.MIN_VALUE) {
                j2 = Math.min(j2, b3);
            }
        }
        if (j2 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public long b(long j2) {
        for (f<g> b2 : this.k) {
            b2.b(j2);
        }
        return j2;
    }

    public void a(f<g> fVar) {
        this.j.a(this);
    }

    private static Pair<ad, a[]> a(List<com.google.android.exoplayer2.source.dash.a.a> list) {
        int size = list.size();
        int b2 = b(list);
        ac[] acVarArr = new ac[(size + b2)];
        a[] aVarArr = new a[b2];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.exoplayer2.source.dash.a.a aVar = list.get(i3);
            List<com.google.android.exoplayer2.source.dash.a.f> list2 = aVar.f11840c;
            j[] jVarArr = new j[list2.size()];
            for (int i4 = 0; i4 < jVarArr.length; i4++) {
                jVarArr[i4] = list2.get(i4).f11868c;
            }
            acVarArr[i3] = new ac(jVarArr);
            if (a(aVar)) {
                acVarArr[size + i2] = new ac(j.a(aVar.f11838a + ":emsg", "application/x-emsg", (String) null, -1, (com.google.android.exoplayer2.c.a) null));
                aVarArr[i2] = new a(i3, 4);
                i2++;
            }
            if (b(aVar)) {
                acVarArr[size + i2] = new ac(j.a(aVar.f11838a + ":cea608", "application/cea-608", (String) null, -1, 0, (String) null, (com.google.android.exoplayer2.c.a) null));
                aVarArr[i2] = new a(i3, 3);
                i2++;
            }
        }
        return Pair.create(new ad(acVarArr), aVarArr);
    }

    private f<g> a(int i2, com.google.android.exoplayer2.l.f fVar, long j2) {
        com.google.android.exoplayer2.source.dash.a.a aVar = this.o.get(i2);
        int[] iArr = new int[2];
        boolean a2 = a(aVar);
        int i3 = 0;
        if (a2) {
            iArr[0] = 4;
            i3 = 1;
        }
        boolean b2 = b(aVar);
        if (b2) {
            iArr[i3] = 3;
            i3++;
        }
        if (i3 < iArr.length) {
            iArr = Arrays.copyOf(iArr, i3);
        }
        return new f(aVar.f11839b, iArr, this.f11945b.a(this.f11949f, this.m, this.n, i2, fVar, this.f11948e, a2, b2), this, this.f11950g, j2, this.f11946c, this.f11947d);
    }

    private static int b(List<com.google.android.exoplayer2.source.dash.a.a> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.google.android.exoplayer2.source.dash.a.a aVar = list.get(i3);
            if (a(aVar)) {
                i2++;
            }
            if (b(aVar)) {
                i2++;
            }
        }
        return i2;
    }

    private static boolean a(com.google.android.exoplayer2.source.dash.a.a aVar) {
        List<com.google.android.exoplayer2.source.dash.a.f> list = aVar.f11840c;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!list.get(i2).f11871f.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(com.google.android.exoplayer2.source.dash.a.a aVar) {
        List<com.google.android.exoplayer2.source.dash.a.g> list = aVar.f11841d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if ("urn:scte:dash:cc:cea-608:2015".equals(list.get(i2).f11875a)) {
                return true;
            }
        }
        return false;
    }

    private static f<g>[] a(int i2) {
        return new f[i2];
    }

    private static void a(z zVar) {
        if (zVar instanceof f.a) {
            ((f.a) zVar).a();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11951a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11952b;

        public a(int i, int i2) {
            this.f11951a = i;
            this.f11952b = i2;
        }
    }
}
