package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.q;

public final class h extends x {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f14604a = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: f  reason: collision with root package name */
    private final int[] f14605f = new int[4];

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws q {
        int[] iArr2 = this.f14605f;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < a2) {
            int a3 = a(aVar, iArr2, i, f14631e);
            sb.append((char) ((a3 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a3 >= 10) {
                i3 = (1 << (5 - i2)) | i3;
            }
            i2++;
            i = i4;
        }
        a(sb, i3);
        int i6 = a(aVar, i, true, f14629c)[1];
        int i7 = 0;
        while (i7 < 6 && i6 < a2) {
            sb.append((char) (a(aVar, iArr2, i6, f14630d) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public c b() {
        return c.EAN_13;
    }

    private static void a(StringBuilder sb, int i) throws q {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f14604a[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw q.a();
    }
}
