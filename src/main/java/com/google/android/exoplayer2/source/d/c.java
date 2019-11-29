package com.google.android.exoplayer2.source.d;

import android.util.Base64;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.e.d.k;
import com.google.android.exoplayer2.m.s;
import com.google.android.exoplayer2.source.a.f;
import com.google.android.exoplayer2.source.aa;
import com.google.android.exoplayer2.source.ac;
import com.google.android.exoplayer2.source.ad;
import com.google.android.exoplayer2.source.d.a.a;
import com.google.android.exoplayer2.source.d.b;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.ArrayList;

final class c implements aa.a<f<b>>, x {

    /* renamed from: a  reason: collision with root package name */
    private final b.a f11823a;

    /* renamed from: b  reason: collision with root package name */
    private final s f11824b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11825c;

    /* renamed from: d  reason: collision with root package name */
    private final r.a f11826d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.m.b f11827e;

    /* renamed from: f  reason: collision with root package name */
    private final ad f11828f;

    /* renamed from: g  reason: collision with root package name */
    private final k[] f11829g;
    private x.a h;
    private a i;
    private f<b>[] j;
    private t k;

    public void a(long j2) {
    }

    public long d() {
        return -9223372036854775807L;
    }

    public c(a aVar, b.a aVar2, int i2, r.a aVar3, s sVar, com.google.android.exoplayer2.m.b bVar) {
        this.f11823a = aVar2;
        this.f11824b = sVar;
        this.f11825c = i2;
        this.f11826d = aVar3;
        this.f11827e = bVar;
        this.f11828f = b(aVar);
        a.C0191a aVar4 = aVar.f11787e;
        if (aVar4 != null) {
            this.f11829g = new k[]{new k(true, 8, a(aVar4.f11792b))};
        } else {
            this.f11829g = null;
        }
        this.i = aVar;
        this.j = a(0);
        this.k = new t(this.j);
    }

    public void a(a aVar) {
        this.i = aVar;
        for (f<b> a2 : this.j) {
            a2.a().a(aVar);
        }
        this.h.a(this);
    }

    public void a() {
        for (f<b> c2 : this.j) {
            c2.c();
        }
    }

    public void a(x.a aVar) {
        this.h = aVar;
        aVar.a(this);
    }

    public void b() throws IOException {
        this.f11824b.d();
    }

    public ad c() {
        return this.f11828f;
    }

    public long a(com.google.android.exoplayer2.l.f[] fVarArr, boolean[] zArr, z[] zVarArr, boolean[] zArr2, long j2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            if (zVarArr[i2] != null) {
                f fVar = zVarArr[i2];
                if (fVarArr[i2] == null || !zArr[i2]) {
                    fVar.c();
                    zVarArr[i2] = null;
                } else {
                    arrayList.add(fVar);
                }
            }
            if (zVarArr[i2] == null && fVarArr[i2] != null) {
                f<b> a2 = a(fVarArr[i2], j2);
                arrayList.add(a2);
                zVarArr[i2] = a2;
                zArr2[i2] = true;
            }
        }
        this.j = a(arrayList.size());
        arrayList.toArray(this.j);
        this.k = new t(this.j);
        return j2;
    }

    public boolean d(long j2) {
        return this.k.d(j2);
    }

    public long f() {
        return this.k.f();
    }

    public long e() {
        long j2 = Long.MAX_VALUE;
        for (f<b> b2 : this.j) {
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
        for (f<b> b2 : this.j) {
            b2.b(j2);
        }
        return j2;
    }

    public void a(f<b> fVar) {
        this.h.a(this);
    }

    private f<b> a(com.google.android.exoplayer2.l.f fVar, long j2) {
        int a2 = this.f11828f.a(fVar.d());
        return new f(this.i.f11788f[a2].f11793a, (int[]) null, this.f11823a.a(this.f11824b, this.i, a2, fVar, this.f11829g), this, this.f11827e, j2, this.f11825c, this.f11826d);
    }

    private static ad b(a aVar) {
        ac[] acVarArr = new ac[aVar.f11788f.length];
        for (int i2 = 0; i2 < aVar.f11788f.length; i2++) {
            acVarArr[i2] = new ac(aVar.f11788f[i2].j);
        }
        return new ad(acVarArr);
    }

    private static f<b>[] a(int i2) {
        return new f[i2];
    }

    private static byte[] a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            sb.append((char) bArr[i2]);
        }
        String sb2 = sb.toString();
        byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
        a(decode, 0, 3);
        a(decode, 1, 2);
        a(decode, 4, 5);
        a(decode, 6, 7);
        return decode;
    }

    private static void a(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2];
        bArr[i2] = bArr[i3];
        bArr[i3] = b2;
    }
}
