package com.google.zxing.c;

import com.google.zxing.d;
import com.google.zxing.n;
import com.google.zxing.q;

public class h extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f14509a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private byte[] f14510b = f14509a;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f14511c = new int[32];

    public h(n nVar) {
        super(nVar);
    }

    public a a(int i, a aVar) throws q {
        n a2 = a();
        int b2 = a2.b();
        if (aVar == null || aVar.a() < b2) {
            aVar = new a(b2);
        } else {
            aVar.c();
        }
        a(b2);
        byte[] a3 = a2.a(i, this.f14510b);
        int[] iArr = this.f14511c;
        for (int i2 = 0; i2 < b2; i2++) {
            int i3 = (a3[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int a4 = a(iArr);
        byte b3 = a3[1] & 255;
        byte b4 = a3[0] & 255;
        int i4 = 1;
        while (i4 < b2 - 1) {
            int i5 = i4 + 1;
            byte b5 = a3[i5] & 255;
            if ((((b3 * 4) - b4) - b5) / 2 < a4) {
                aVar.b(i4);
            }
            b4 = b3;
            i4 = i5;
            b3 = b5;
        }
        return aVar;
    }

    public b b() throws q {
        n a2 = a();
        int b2 = a2.b();
        int c2 = a2.c();
        b bVar = new b(b2, c2);
        a(b2);
        int[] iArr = this.f14511c;
        for (int i = 1; i < 5; i++) {
            byte[] a3 = a2.a((c2 * i) / 5, this.f14510b);
            int i2 = (b2 * 4) / 5;
            for (int i3 = b2 / 5; i3 < i2; i3++) {
                int i4 = (a3[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a4 = a(iArr);
        byte[] a5 = a2.a();
        for (int i5 = 0; i5 < c2; i5++) {
            int i6 = i5 * b2;
            for (int i7 = 0; i7 < b2; i7++) {
                if ((a5[i6 + i7] & 255) < a4) {
                    bVar.b(i7, i5);
                }
            }
        }
        return bVar;
    }

    public d a(n nVar) {
        return new h(nVar);
    }

    private void a(int i) {
        if (this.f14510b.length < i) {
            this.f14510b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f14511c[i2] = 0;
        }
    }

    private static int a(int[] iArr) throws q {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 > i5) {
            int i10 = i3;
            i3 = i5;
            i5 = i10;
        }
        if (i5 - i3 > length / 16) {
            int i11 = i5 - 1;
            int i12 = i11;
            int i13 = -1;
            while (i11 > i3) {
                int i14 = i11 - i3;
                int i15 = i14 * i14 * (i5 - i11) * (i2 - iArr[i11]);
                if (i15 > i13) {
                    i12 = i11;
                    i13 = i15;
                }
                i11--;
            }
            return i12 << 3;
        }
        throw q.a();
    }
}
