package com.google.zxing.c.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f14492a;

    public c(a aVar) {
        this.f14492a = aVar;
    }

    public void a(int[] iArr, int i) throws e {
        b bVar = new b(this.f14492a, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < i; i3++) {
            a aVar = this.f14492a;
            int b2 = bVar.b(aVar.a(aVar.d() + i3));
            iArr2[(iArr2.length - 1) - i3] = b2;
            if (b2 != 0) {
                z = false;
            }
        }
        if (!z) {
            b[] a2 = a(this.f14492a.a(i, 1), new b(this.f14492a, iArr2), i);
            b bVar2 = a2[0];
            b bVar3 = a2[1];
            int[] a3 = a(bVar2);
            int[] a4 = a(bVar3, a3);
            while (i2 < a3.length) {
                int length = (iArr.length - 1) - this.f14492a.b(a3[i2]);
                if (length >= 0) {
                    iArr[length] = a.b(iArr[length], a4[i2]);
                    i2++;
                } else {
                    throw new e("Bad error location");
                }
            }
        }
    }

    private b[] a(b bVar, b bVar2, int i) throws e {
        if (bVar.b() < bVar2.b()) {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
        }
        b a2 = this.f14492a.a();
        b b2 = this.f14492a.b();
        do {
            b bVar4 = r11;
            r11 = bVar;
            bVar = bVar4;
            b bVar5 = b2;
            b bVar6 = a2;
            a2 = bVar5;
            if (bVar.b() < i / 2) {
                int a3 = a2.a(0);
                if (a3 != 0) {
                    int c2 = this.f14492a.c(a3);
                    return new b[]{a2.c(c2), bVar.c(c2)};
                }
                throw new e("sigmaTilde(0) was zero");
            } else if (!bVar.c()) {
                b a4 = this.f14492a.a();
                int c3 = this.f14492a.c(bVar.a(bVar.b()));
                while (r11.b() >= bVar.b() && !r11.c()) {
                    int b3 = r11.b() - bVar.b();
                    int c4 = this.f14492a.c(r11.a(r11.b()), c3);
                    a4 = a4.a(this.f14492a.a(b3, c4));
                    r11 = r11.a(bVar.a(b3, c4));
                }
                b2 = a4.b(a2).a(bVar6);
            } else {
                throw new e("r_{i-1} was zero");
            }
        } while (r11.b() < bVar.b());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    private int[] a(b bVar) throws e {
        int b2 = bVar.b();
        int i = 0;
        if (b2 == 1) {
            return new int[]{bVar.a(1)};
        }
        int[] iArr = new int[b2];
        for (int i2 = 1; i2 < this.f14492a.c() && i < b2; i2++) {
            if (bVar.b(i2) == 0) {
                iArr[i] = this.f14492a.c(i2);
                i++;
            }
        }
        if (i == b2) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] a(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c2 = this.f14492a.c(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int c3 = this.f14492a.c(iArr[i3], c2);
                    i2 = this.f14492a.c(i2, (c3 & 1) == 0 ? c3 | 1 : c3 & -2);
                }
            }
            iArr2[i] = this.f14492a.c(bVar.b(c2), this.f14492a.c(i2));
            if (this.f14492a.d() != 0) {
                iArr2[i] = this.f14492a.c(iArr2[i], c2);
            }
        }
        return iArr2;
    }
}
