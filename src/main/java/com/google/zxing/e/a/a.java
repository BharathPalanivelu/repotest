package com.google.zxing.e.a;

import com.google.zxing.c.b;
import com.google.zxing.m;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f14642a;

    /* renamed from: b  reason: collision with root package name */
    private j f14643b;

    /* renamed from: c  reason: collision with root package name */
    private g f14644c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14645d;

    a(b bVar) throws m {
        int d2 = bVar.d();
        if (d2 < 21 || (d2 & 3) != 1) {
            throw m.a();
        }
        this.f14642a = bVar;
    }

    /* access modifiers changed from: package-private */
    public g a() throws m {
        g gVar = this.f14644c;
        if (gVar != null) {
            return gVar;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int d2 = this.f14642a.d();
        int i5 = d2 - 7;
        for (int i6 = d2 - 1; i6 >= i5; i6--) {
            i = a(8, i6, i);
        }
        for (int i7 = d2 - 8; i7 < d2; i7++) {
            i = a(i7, 8, i);
        }
        this.f14644c = g.b(a2, i);
        g gVar2 = this.f14644c;
        if (gVar2 != null) {
            return gVar2;
        }
        throw m.a();
    }

    /* access modifiers changed from: package-private */
    public j b() throws m {
        j jVar = this.f14643b;
        if (jVar != null) {
            return jVar;
        }
        int d2 = this.f14642a.d();
        int i = (d2 - 17) / 4;
        if (i <= 6) {
            return j.b(i);
        }
        int i2 = d2 - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = d2 - 9; i6 >= i2; i6--) {
                i4 = a(i6, i5, i4);
            }
        }
        j c2 = j.c(i4);
        if (c2 == null || c2.d() != d2) {
            for (int i7 = 5; i7 >= 0; i7--) {
                for (int i8 = d2 - 9; i8 >= i2; i8--) {
                    i3 = a(i7, i8, i3);
                }
            }
            j c3 = j.c(i3);
            if (c3 == null || c3.d() != d2) {
                throw m.a();
            }
            this.f14643b = c3;
            return c3;
        }
        this.f14643b = c2;
        return c2;
    }

    private int a(int i, int i2, int i3) {
        return this.f14645d ? this.f14642a.a(i2, i) : this.f14642a.a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* access modifiers changed from: package-private */
    public byte[] c() throws m {
        g a2 = a();
        j b2 = b();
        c a3 = c.a(a2.b());
        int d2 = this.f14642a.d();
        a3.a(this.f14642a, d2);
        b e2 = b2.e();
        byte[] bArr = new byte[b2.c()];
        int i = d2 - 1;
        int i2 = i;
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            int i6 = i5;
            int i7 = i4;
            int i8 = i3;
            int i9 = 0;
            while (i9 < d2) {
                int i10 = z ? i - i9 : i9;
                int i11 = i6;
                int i12 = i7;
                int i13 = i8;
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = i2 - i14;
                    if (!e2.a(i15, i10)) {
                        i12++;
                        int i16 = i11 << 1;
                        int i17 = this.f14642a.a(i15, i10) ? i16 | 1 : i16;
                        if (i12 == 8) {
                            bArr[i13] = (byte) i17;
                            i13++;
                            i12 = 0;
                            i11 = 0;
                        } else {
                            i11 = i17;
                        }
                    }
                }
                i9++;
                i8 = i13;
                i7 = i12;
                i6 = i11;
            }
            z = !z;
            i2 -= 2;
            i3 = i8;
            i4 = i7;
            i5 = i6;
        }
        if (i3 == b2.c()) {
            return bArr;
        }
        throw m.a();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        g gVar = this.f14644c;
        if (gVar != null) {
            c.a(gVar.b()).a(this.f14642a, this.f14642a.d());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f14643b = null;
        this.f14644c = null;
        this.f14645d = z;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int i = 0;
        while (i < this.f14642a.c()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f14642a.d(); i3++) {
                if (this.f14642a.a(i, i3) != this.f14642a.a(i3, i)) {
                    this.f14642a.c(i3, i);
                    this.f14642a.c(i, i3);
                }
            }
            i = i2;
        }
    }
}
