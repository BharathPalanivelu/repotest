package com.google.android.exoplayer2.i.g;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import java.util.Collections;
import java.util.List;

public final class k implements h {

    /* renamed from: a  reason: collision with root package name */
    private final s f10300a;

    /* renamed from: b  reason: collision with root package name */
    private String f10301b;

    /* renamed from: c  reason: collision with root package name */
    private m f10302c;

    /* renamed from: d  reason: collision with root package name */
    private a f10303d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10304e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f10305f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final n f10306g = new n(32, 128);
    private final n h = new n(33, 128);
    private final n i = new n(34, 128);
    private final n j = new n(39, 128);
    private final n k = new n(40, 128);
    private long l;
    private long m;
    private final l n = new l();

    public void b() {
    }

    public k(s sVar) {
        this.f10300a = sVar;
    }

    public void a() {
        j.a(this.f10305f);
        this.f10306g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        this.f10303d.a();
        this.l = 0;
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.f10301b = dVar.c();
        this.f10302c = gVar.a(dVar.b(), 2);
        this.f10303d = new a(this.f10302c);
        this.f10300a.a(gVar, dVar);
    }

    public void a(long j2, boolean z) {
        this.m = j2;
    }

    public void a(l lVar) {
        l lVar2 = lVar;
        while (lVar.b() > 0) {
            int d2 = lVar.d();
            int c2 = lVar.c();
            byte[] bArr = lVar2.f11422a;
            this.l += (long) lVar.b();
            this.f10302c.a(lVar2, lVar.b());
            while (true) {
                if (d2 < c2) {
                    int a2 = j.a(bArr, d2, c2, this.f10305f);
                    if (a2 == c2) {
                        a(bArr, d2, c2);
                        return;
                    }
                    int c3 = j.c(bArr, a2);
                    int i2 = a2 - d2;
                    if (i2 > 0) {
                        a(bArr, d2, a2);
                    }
                    int i3 = c2 - a2;
                    long j2 = this.l - ((long) i3);
                    int i4 = i2 < 0 ? -i2 : 0;
                    long j3 = j2;
                    int i5 = i3;
                    b(j3, i5, i4, this.m);
                    a(j3, i5, c3, this.m);
                    d2 = a2 + 3;
                }
            }
        }
    }

    private void a(long j2, int i2, int i3, long j3) {
        if (this.f10304e) {
            this.f10303d.a(j2, i2, i3, j3);
        } else {
            this.f10306g.a(i3);
            this.h.a(i3);
            this.i.a(i3);
        }
        this.j.a(i3);
        this.k.a(i3);
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (this.f10304e) {
            this.f10303d.a(bArr, i2, i3);
        } else {
            this.f10306g.a(bArr, i2, i3);
            this.h.a(bArr, i2, i3);
            this.i.a(bArr, i2, i3);
        }
        this.j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    private void b(long j2, int i2, int i3, long j3) {
        if (this.f10304e) {
            this.f10303d.a(j2, i2);
        } else {
            this.f10306g.b(i3);
            this.h.b(i3);
            this.i.b(i3);
            if (this.f10306g.b() && this.h.b() && this.i.b()) {
                this.f10302c.a(a(this.f10301b, this.f10306g, this.h, this.i));
                this.f10304e = true;
            }
        }
        if (this.j.b(i3)) {
            this.n.a(this.j.f10327a, j.a(this.j.f10327a, this.j.f10328b));
            this.n.d(5);
            this.f10300a.a(j3, this.n);
        }
        if (this.k.b(i3)) {
            this.n.a(this.k.f10327a, j.a(this.k.f10327a, this.k.f10328b));
            this.n.d(5);
            this.f10300a.a(j3, this.n);
        }
    }

    private static Format a(String str, n nVar, n nVar2, n nVar3) {
        float f2;
        n nVar4 = nVar;
        n nVar5 = nVar2;
        n nVar6 = nVar3;
        byte[] bArr = new byte[(nVar4.f10328b + nVar5.f10328b + nVar6.f10328b)];
        System.arraycopy(nVar4.f10327a, 0, bArr, 0, nVar4.f10328b);
        System.arraycopy(nVar5.f10327a, 0, bArr, nVar4.f10328b, nVar5.f10328b);
        System.arraycopy(nVar6.f10327a, 0, bArr, nVar4.f10328b + nVar5.f10328b, nVar6.f10328b);
        com.google.android.exoplayer2.s.m mVar = new com.google.android.exoplayer2.s.m(nVar5.f10327a, 0, nVar5.f10328b);
        mVar.a(44);
        int c2 = mVar.c(3);
        mVar.a();
        mVar.a(88);
        mVar.a(8);
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            if (mVar.b()) {
                i2 += 89;
            }
            if (mVar.b()) {
                i2 += 8;
            }
        }
        mVar.a(i2);
        if (c2 > 0) {
            mVar.a((8 - c2) * 2);
        }
        mVar.d();
        int d2 = mVar.d();
        if (d2 == 3) {
            mVar.a();
        }
        int d3 = mVar.d();
        int d4 = mVar.d();
        if (mVar.b()) {
            int d5 = mVar.d();
            int d6 = mVar.d();
            int d7 = mVar.d();
            int d8 = mVar.d();
            d3 -= ((d2 == 1 || d2 == 2) ? 2 : 1) * (d5 + d6);
            d4 -= (d2 == 1 ? 2 : 1) * (d7 + d8);
        }
        int i4 = d3;
        int i5 = d4;
        mVar.d();
        mVar.d();
        int d9 = mVar.d();
        for (int i6 = mVar.b() ? 0 : c2; i6 <= c2; i6++) {
            mVar.d();
            mVar.d();
            mVar.d();
        }
        mVar.d();
        mVar.d();
        mVar.d();
        mVar.d();
        mVar.d();
        mVar.d();
        if (mVar.b() && mVar.b()) {
            a(mVar);
        }
        mVar.a(2);
        if (mVar.b()) {
            mVar.a(8);
            mVar.d();
            mVar.d();
            mVar.a();
        }
        b(mVar);
        if (mVar.b()) {
            for (int i7 = 0; i7 < mVar.d(); i7++) {
                mVar.a(d9 + 4 + 1);
            }
        }
        mVar.a(2);
        float f3 = 1.0f;
        if (mVar.b() && mVar.b()) {
            int c3 = mVar.c(8);
            if (c3 == 255) {
                int c4 = mVar.c(16);
                int c5 = mVar.c(16);
                if (!(c4 == 0 || c5 == 0)) {
                    f3 = ((float) c4) / ((float) c5);
                }
                f2 = f3;
            } else if (c3 < j.f11405b.length) {
                f2 = j.f11405b[c3];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + c3);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (DrmInitData) null);
        }
        f2 = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (DrmInitData) null);
    }

    private static void a(com.google.android.exoplayer2.s.m mVar) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                if (!mVar.b()) {
                    mVar.d();
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        mVar.e();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        mVar.e();
                    }
                }
                int i5 = 3;
                if (i2 != 3) {
                    i5 = 1;
                }
                i3 += i5;
            }
        }
    }

    private static void b(com.google.android.exoplayer2.s.m mVar) {
        int d2 = mVar.d();
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            if (i3 != 0) {
                z = mVar.b();
            }
            if (z) {
                mVar.a();
                mVar.d();
                for (int i4 = 0; i4 <= i2; i4++) {
                    if (mVar.b()) {
                        mVar.a();
                    }
                }
            } else {
                int d3 = mVar.d();
                int d4 = mVar.d();
                int i5 = d3 + d4;
                for (int i6 = 0; i6 < d3; i6++) {
                    mVar.d();
                    mVar.a();
                }
                for (int i7 = 0; i7 < d4; i7++) {
                    mVar.d();
                    mVar.a();
                }
                i2 = i5;
            }
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final m f10307a;

        /* renamed from: b  reason: collision with root package name */
        private long f10308b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10309c;

        /* renamed from: d  reason: collision with root package name */
        private int f10310d;

        /* renamed from: e  reason: collision with root package name */
        private long f10311e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10312f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f10313g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(m mVar) {
            this.f10307a = mVar;
        }

        public void a() {
            this.f10312f = false;
            this.f10313g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void a(long j2, int i2, int i3, long j3) {
            this.f10313g = false;
            this.h = false;
            this.f10311e = j3;
            this.f10310d = 0;
            this.f10308b = j2;
            boolean z = true;
            if (i3 >= 32) {
                if (!this.j && this.i) {
                    a(i2);
                    this.i = false;
                }
                if (i3 <= 34) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            this.f10309c = i3 >= 16 && i3 <= 21;
            if (!this.f10309c && i3 > 9) {
                z = false;
            }
            this.f10312f = z;
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f10312f) {
                int i4 = this.f10310d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f10313g = (bArr[i5] & 128) != 0;
                    this.f10312f = false;
                    return;
                }
                this.f10310d = i4 + (i3 - i2);
            }
        }

        public void a(long j2, int i2) {
            if (this.j && this.f10313g) {
                this.m = this.f10309c;
                this.j = false;
            } else if (this.h || this.f10313g) {
                if (this.i) {
                    a(i2 + ((int) (j2 - this.f10308b)));
                }
                this.k = this.f10308b;
                this.l = this.f10311e;
                this.i = true;
                this.m = this.f10309c;
            }
        }

        private void a(int i2) {
            boolean z = this.m;
            int i3 = (int) (this.f10308b - this.k);
            this.f10307a.a(this.l, z ? 1 : 0, i3, i2, (m.a) null);
        }
    }
}
