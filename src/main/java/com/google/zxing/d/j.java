package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.q;

public final class j extends x {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f14606a = new int[4];

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws q {
        int[] iArr2 = this.f14606a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        while (i2 < 4 && i < a2) {
            sb.append((char) (a(aVar, iArr2, i, f14630d) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        int i5 = a(aVar, i, true, f14629c)[1];
        int i6 = 0;
        while (i6 < 4 && i5 < a2) {
            sb.append((char) (a(aVar, iArr2, i5, f14630d) + 48));
            int i7 = i5;
            for (int i8 : iArr2) {
                i7 += i8;
            }
            i6++;
            i5 = i7;
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public c b() {
        return c.EAN_8;
    }
}
