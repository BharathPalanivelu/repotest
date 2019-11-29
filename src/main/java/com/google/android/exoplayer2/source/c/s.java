package com.google.android.exoplayer2.source.c;

import android.os.Handler;
import android.text.TextUtils;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.source.ac;
import com.google.android.exoplayer2.source.ad;
import com.google.android.exoplayer2.source.c.a.a;
import com.google.android.exoplayer2.source.c.a.e;
import com.google.android.exoplayer2.source.c.v;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class s implements e.b, v.a, x {

    /* renamed from: a  reason: collision with root package name */
    private final e f11744a;

    /* renamed from: b  reason: collision with root package name */
    private final p f11745b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11746c;

    /* renamed from: d  reason: collision with root package name */
    private final r.a f11747d;

    /* renamed from: e  reason: collision with root package name */
    private final b f11748e;

    /* renamed from: f  reason: collision with root package name */
    private final IdentityHashMap<z, Integer> f11749f = new IdentityHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final w f11750g = new w();
    private final Handler h = new Handler();
    private final long i;
    private x.a j;
    private int k;
    private boolean l;
    private ad m;
    private v[] n;
    private v[] o;
    private t p;

    public void a(long j2) {
    }

    public long d() {
        return -9223372036854775807L;
    }

    public s(e eVar, p pVar, int i2, r.a aVar, b bVar, long j2) {
        this.f11744a = eVar;
        this.f11745b = pVar;
        this.f11746c = i2;
        this.f11747d = aVar;
        this.f11748e = bVar;
        this.i = j2;
    }

    public void g() {
        this.f11744a.b((e.b) this);
        this.h.removeCallbacksAndMessages((Object) null);
        v[] vVarArr = this.n;
        if (vVarArr != null) {
            for (v g2 : vVarArr) {
                g2.g();
            }
        }
    }

    public void a(x.a aVar) {
        this.f11744a.a((e.b) this);
        this.j = aVar;
        i();
    }

    public void b() throws IOException {
        v[] vVarArr = this.n;
        if (vVarArr != null) {
            for (v c2 : vVarArr) {
                c2.c();
            }
        }
    }

    public ad c() {
        return this.m;
    }

    public long a(f[] fVarArr, boolean[] zArr, z[] zVarArr, boolean[] zArr2, long j2) {
        boolean z;
        long j3;
        int i2;
        f[] fVarArr2 = fVarArr;
        z[] zVarArr2 = zVarArr;
        long j4 = j2;
        int[] iArr = new int[fVarArr2.length];
        int[] iArr2 = new int[fVarArr2.length];
        for (int i3 = 0; i3 < fVarArr2.length; i3++) {
            if (zVarArr2[i3] == null) {
                i2 = -1;
            } else {
                i2 = this.f11749f.get(zVarArr2[i3]).intValue();
            }
            iArr[i3] = i2;
            iArr2[i3] = -1;
            if (fVarArr2[i3] != null) {
                ac d2 = fVarArr2[i3].d();
                int i4 = 0;
                while (true) {
                    v[] vVarArr = this.n;
                    if (i4 >= vVarArr.length) {
                        break;
                    } else if (vVarArr[i4].d().a(d2) != -1) {
                        iArr2[i3] = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        this.f11749f.clear();
        z[] zVarArr3 = new z[fVarArr2.length];
        z[] zVarArr4 = new z[fVarArr2.length];
        f[] fVarArr3 = new f[fVarArr2.length];
        ArrayList arrayList = new ArrayList(this.n.length);
        int i5 = 0;
        boolean z2 = false;
        while (i5 < this.n.length) {
            for (int i6 = 0; i6 < fVarArr2.length; i6++) {
                f fVar = null;
                zVarArr4[i6] = iArr[i6] == i5 ? zVarArr2[i6] : null;
                if (iArr2[i6] == i5) {
                    fVar = fVarArr2[i6];
                }
                fVarArr3[i6] = fVar;
            }
            int i7 = i5;
            ArrayList arrayList2 = arrayList;
            f[] fVarArr4 = fVarArr3;
            z2 |= this.n[i5].a(fVarArr3, zArr, zVarArr4, zArr2, !this.l);
            boolean z3 = false;
            for (int i8 = 0; i8 < fVarArr2.length; i8++) {
                if (iArr2[i8] == i7) {
                    a.b(zVarArr4[i8] != null);
                    zVarArr3[i8] = zVarArr4[i8];
                    this.f11749f.put(zVarArr4[i8], Integer.valueOf(i7));
                    z3 = true;
                } else if (iArr[i8] == i7) {
                    a.b(zVarArr4[i8] == null);
                }
            }
            if (z3) {
                arrayList2.add(this.n[i7]);
            }
            i5 = i7 + 1;
            arrayList = arrayList2;
            fVarArr3 = fVarArr4;
            long j5 = j2;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zVarArr3, 0, zVarArr2, 0, zVarArr3.length);
        this.o = new v[arrayList3.size()];
        arrayList3.toArray(this.o);
        v[] vVarArr2 = this.o;
        if (vVarArr2.length > 0) {
            z = true;
            vVarArr2[0].a(true);
            int i9 = 1;
            while (true) {
                v[] vVarArr3 = this.o;
                if (i9 >= vVarArr3.length) {
                    break;
                }
                vVarArr3[i9].a(false);
                i9++;
            }
        } else {
            z = true;
        }
        this.p = new t(this.o);
        if (!this.l || !z2) {
            j3 = j2;
        } else {
            j3 = j2;
            b(j3);
            for (int i10 = 0; i10 < fVarArr2.length; i10++) {
                if (zVarArr2[i10] != null) {
                    zArr2[i10] = z;
                }
            }
        }
        this.l = z;
        return j3;
    }

    public boolean d(long j2) {
        return this.p.d(j2);
    }

    public long f() {
        return this.p.f();
    }

    public long e() {
        long j2 = Long.MAX_VALUE;
        for (v e2 : this.o) {
            long e3 = e2.e();
            if (e3 != Long.MIN_VALUE) {
                j2 = Math.min(j2, e3);
            }
        }
        if (j2 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public long b(long j2) {
        this.f11750g.a();
        for (v a2 : this.o) {
            a2.a(j2);
        }
        return j2;
    }

    public void h() {
        int i2 = this.k - 1;
        this.k = i2;
        if (i2 <= 0) {
            int i3 = 0;
            for (v d2 : this.n) {
                i3 += d2.d().f11538b;
            }
            ac[] acVarArr = new ac[i3];
            v[] vVarArr = this.n;
            int length = vVarArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                v vVar = vVarArr[i4];
                int i6 = vVar.d().f11538b;
                int i7 = i5;
                int i8 = 0;
                while (i8 < i6) {
                    acVarArr[i7] = vVar.d().a(i8);
                    i8++;
                    i7++;
                }
                i4++;
                i5 = i7;
            }
            this.m = new ad(acVarArr);
            this.j.a(this);
        }
    }

    public void a(a.C0186a aVar) {
        this.f11744a.d(aVar);
    }

    public void a(v vVar) {
        if (this.m != null) {
            this.j.a(this);
        }
    }

    public void a() {
        j();
    }

    public void a(a.C0186a aVar, long j2) {
        for (v a2 : this.n) {
            a2.a(aVar, j2);
        }
        j();
    }

    private void i() {
        com.google.android.exoplayer2.source.c.a.a b2 = this.f11744a.b();
        ArrayList arrayList = new ArrayList(b2.f11591a);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a.C0186a aVar = (a.C0186a) arrayList.get(i2);
            if (aVar.f11597b.k > 0 || a(aVar, "avc")) {
                arrayList2.add(aVar);
            } else if (a(aVar, "mp4a")) {
                arrayList3.add(aVar);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List<a.C0186a> list = b2.f11592b;
        List<a.C0186a> list2 = b2.f11593c;
        this.n = new v[(list.size() + 1 + list2.size())];
        this.k = this.n.length;
        com.google.android.exoplayer2.n.a.a(!arrayList.isEmpty());
        a.C0186a[] aVarArr = new a.C0186a[arrayList.size()];
        arrayList.toArray(aVarArr);
        v a2 = a(0, aVarArr, b2.f11594d, b2.f11595e);
        this.n[0] = a2;
        a2.a(true);
        a2.b();
        int i3 = 0;
        int i4 = 1;
        while (i3 < list.size()) {
            v a3 = a(1, new a.C0186a[]{list.get(i3)}, (j) null, Collections.emptyList());
            this.n[i4] = a3;
            a3.b();
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i5 < list2.size()) {
            a.C0186a aVar2 = list2.get(i5);
            v a4 = a(3, new a.C0186a[]{aVar2}, (j) null, Collections.emptyList());
            a4.b(aVar2.f11597b);
            this.n[i4] = a4;
            i5++;
            i4++;
        }
    }

    private v a(int i2, a.C0186a[] aVarArr, j jVar, List<j> list) {
        o oVar = new o(this.f11744a, aVarArr, this.f11745b, this.f11750g, list);
        b bVar = this.f11748e;
        long j2 = this.i;
        return new v(i2, this, oVar, bVar, j2, jVar, this.f11746c, this.f11747d);
    }

    private void j() {
        if (this.m != null) {
            this.j.a(this);
            return;
        }
        for (v b2 : this.n) {
            b2.b();
        }
    }

    private static boolean a(a.C0186a aVar, String str) {
        String str2 = aVar.f11597b.f10424c;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String startsWith : str2.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
