package com.google.android.exoplayer2.e.g;

import android.util.Log;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.i;
import com.google.android.exoplayer2.n.l;
import java.util.Collections;
import java.util.List;

public final class k implements h {

    /* renamed from: a  reason: collision with root package name */
    private final s f9665a;

    /* renamed from: b  reason: collision with root package name */
    private String f9666b;

    /* renamed from: c  reason: collision with root package name */
    private n f9667c;

    /* renamed from: d  reason: collision with root package name */
    private a f9668d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9669e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f9670f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final n f9671g = new n(32, 128);
    private final n h = new n(33, 128);
    private final n i = new n(34, 128);
    private final n j = new n(39, 128);
    private final n k = new n(40, 128);
    private long l;
    private long m;
    private final com.google.android.exoplayer2.n.k n = new com.google.android.exoplayer2.n.k();

    public void b() {
    }

    public k(s sVar) {
        this.f9665a = sVar;
    }

    public void a() {
        i.a(this.f9670f);
        this.f9671g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        this.f9668d.a();
        this.l = 0;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.f9666b = dVar.c();
        this.f9667c = hVar.a(dVar.b(), 2);
        this.f9668d = new a(this.f9667c);
        this.f9665a.a(hVar, dVar);
    }

    public void a(long j2, boolean z) {
        this.m = j2;
    }

    public void a(com.google.android.exoplayer2.n.k kVar) {
        com.google.android.exoplayer2.n.k kVar2 = kVar;
        while (kVar.b() > 0) {
            int d2 = kVar.d();
            int c2 = kVar.c();
            byte[] bArr = kVar2.f10948a;
            this.l += (long) kVar.b();
            this.f9667c.a(kVar2, kVar.b());
            while (true) {
                if (d2 < c2) {
                    int a2 = i.a(bArr, d2, c2, this.f9670f);
                    if (a2 == c2) {
                        a(bArr, d2, c2);
                        return;
                    }
                    int c3 = i.c(bArr, a2);
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
        if (this.f9669e) {
            this.f9668d.a(j2, i2, i3, j3);
        } else {
            this.f9671g.a(i3);
            this.h.a(i3);
            this.i.a(i3);
        }
        this.j.a(i3);
        this.k.a(i3);
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (this.f9669e) {
            this.f9668d.a(bArr, i2, i3);
        } else {
            this.f9671g.a(bArr, i2, i3);
            this.h.a(bArr, i2, i3);
            this.i.a(bArr, i2, i3);
        }
        this.j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    private void b(long j2, int i2, int i3, long j3) {
        if (this.f9669e) {
            this.f9668d.a(j2, i2);
        } else {
            this.f9671g.b(i3);
            this.h.b(i3);
            this.i.b(i3);
            if (this.f9671g.b() && this.h.b() && this.i.b()) {
                this.f9667c.a(a(this.f9666b, this.f9671g, this.h, this.i));
                this.f9669e = true;
            }
        }
        if (this.j.b(i3)) {
            this.n.a(this.j.f9692a, i.a(this.j.f9692a, this.j.f9693b));
            this.n.d(5);
            this.f9665a.a(j3, this.n);
        }
        if (this.k.b(i3)) {
            this.n.a(this.k.f9692a, i.a(this.k.f9692a, this.k.f9693b));
            this.n.d(5);
            this.f9665a.a(j3, this.n);
        }
    }

    private static j a(String str, n nVar, n nVar2, n nVar3) {
        float f2;
        n nVar4 = nVar;
        n nVar5 = nVar2;
        n nVar6 = nVar3;
        byte[] bArr = new byte[(nVar4.f9693b + nVar5.f9693b + nVar6.f9693b)];
        System.arraycopy(nVar4.f9692a, 0, bArr, 0, nVar4.f9693b);
        System.arraycopy(nVar5.f9692a, 0, bArr, nVar4.f9693b, nVar5.f9693b);
        System.arraycopy(nVar6.f9692a, 0, bArr, nVar4.f9693b + nVar5.f9693b, nVar6.f9693b);
        l lVar = new l(nVar5.f9692a, 0, nVar5.f9693b);
        lVar.a(44);
        int c2 = lVar.c(3);
        lVar.a(1);
        lVar.a(88);
        lVar.a(8);
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            if (lVar.a()) {
                i2 += 89;
            }
            if (lVar.a()) {
                i2 += 8;
            }
        }
        lVar.a(i2);
        if (c2 > 0) {
            lVar.a((8 - c2) * 2);
        }
        lVar.c();
        int c3 = lVar.c();
        if (c3 == 3) {
            lVar.a(1);
        }
        int c4 = lVar.c();
        int c5 = lVar.c();
        if (lVar.a()) {
            int c6 = lVar.c();
            int c7 = lVar.c();
            int c8 = lVar.c();
            int c9 = lVar.c();
            c4 -= ((c3 == 1 || c3 == 2) ? 2 : 1) * (c6 + c7);
            c5 -= (c3 == 1 ? 2 : 1) * (c8 + c9);
        }
        int i4 = c4;
        int i5 = c5;
        lVar.c();
        lVar.c();
        int c10 = lVar.c();
        for (int i6 = lVar.a() ? 0 : c2; i6 <= c2; i6++) {
            lVar.c();
            lVar.c();
            lVar.c();
        }
        lVar.c();
        lVar.c();
        lVar.c();
        lVar.c();
        lVar.c();
        lVar.c();
        if (lVar.a() && lVar.a()) {
            a(lVar);
        }
        lVar.a(2);
        if (lVar.a()) {
            lVar.a(8);
            lVar.c();
            lVar.c();
            lVar.a(1);
        }
        b(lVar);
        if (lVar.a()) {
            for (int i7 = 0; i7 < lVar.c(); i7++) {
                lVar.a(c10 + 4 + 1);
            }
        }
        lVar.a(2);
        float f3 = 1.0f;
        if (lVar.a() && lVar.a()) {
            int c11 = lVar.c(8);
            if (c11 == 255) {
                int c12 = lVar.c(16);
                int c13 = lVar.c(16);
                if (!(c12 == 0 || c13 == 0)) {
                    f3 = ((float) c12) / ((float) c13);
                }
                f2 = f3;
            } else if (c11 < i.f10931b.length) {
                f2 = i.f10931b[c11];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + c11);
            }
            return j.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (com.google.android.exoplayer2.c.a) null);
        }
        f2 = 1.0f;
        return j.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, (List<byte[]>) Collections.singletonList(bArr), -1, f2, (com.google.android.exoplayer2.c.a) null);
    }

    private static void a(l lVar) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                if (!lVar.a()) {
                    lVar.c();
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        lVar.d();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        lVar.d();
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

    private static void b(l lVar) {
        int c2 = lVar.c();
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            if (i3 != 0) {
                z = lVar.a();
            }
            if (z) {
                lVar.a(1);
                lVar.c();
                for (int i4 = 0; i4 <= i2; i4++) {
                    if (lVar.a()) {
                        lVar.a(1);
                    }
                }
            } else {
                int c3 = lVar.c();
                int c4 = lVar.c();
                int i5 = c3 + c4;
                for (int i6 = 0; i6 < c3; i6++) {
                    lVar.c();
                    lVar.a(1);
                }
                for (int i7 = 0; i7 < c4; i7++) {
                    lVar.c();
                    lVar.a(1);
                }
                i2 = i5;
            }
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f9672a;

        /* renamed from: b  reason: collision with root package name */
        private long f9673b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9674c;

        /* renamed from: d  reason: collision with root package name */
        private int f9675d;

        /* renamed from: e  reason: collision with root package name */
        private long f9676e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9677f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f9678g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(n nVar) {
            this.f9672a = nVar;
        }

        public void a() {
            this.f9677f = false;
            this.f9678g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void a(long j2, int i2, int i3, long j3) {
            this.f9678g = false;
            this.h = false;
            this.f9676e = j3;
            this.f9675d = 0;
            this.f9673b = j2;
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
            this.f9674c = i3 >= 16 && i3 <= 21;
            if (!this.f9674c && i3 > 9) {
                z = false;
            }
            this.f9677f = z;
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f9677f) {
                int i4 = this.f9675d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f9678g = (bArr[i5] & 128) != 0;
                    this.f9677f = false;
                    return;
                }
                this.f9675d = i4 + (i3 - i2);
            }
        }

        public void a(long j2, int i2) {
            if (this.j && this.f9678g) {
                this.m = this.f9674c;
                this.j = false;
            } else if (this.h || this.f9678g) {
                if (this.i) {
                    a(i2 + ((int) (j2 - this.f9673b)));
                }
                this.k = this.f9673b;
                this.l = this.f9676e;
                this.i = true;
                this.m = this.f9674c;
            }
        }

        private void a(int i2) {
            boolean z = this.m;
            int i3 = (int) (this.f9673b - this.k);
            this.f9672a.a(this.l, z ? 1 : 0, i3, i2, (byte[]) null);
        }
    }
}
