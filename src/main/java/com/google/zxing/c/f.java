package com.google.zxing.c;

import com.google.zxing.q;

public final class f extends i {
    public b a(b bVar, int i, int i2, k kVar) throws q {
        if (i <= 0 || i2 <= 0) {
            throw q.a();
        }
        b bVar2 = new b(i, i2);
        float[] fArr = new float[(i * 2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int length = fArr.length;
            float f2 = ((float) i3) + 0.5f;
            for (int i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = ((float) (i4 / 2)) + 0.5f;
                fArr[i4 + 1] = f2;
            }
            kVar.a(fArr);
            a(bVar, fArr);
            int i5 = 0;
            while (i5 < length) {
                try {
                    if (bVar.a((int) fArr[i5], (int) fArr[i5 + 1])) {
                        bVar2.b(i5 / 2, i3);
                    }
                    i5 += 2;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw q.a();
                }
            }
        }
        return bVar2;
    }
}
