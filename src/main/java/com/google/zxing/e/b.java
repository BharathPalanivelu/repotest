package com.google.zxing.e;

import com.google.zxing.ab;
import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.e.a.f;
import com.google.zxing.l;
import java.util.Map;

public final class b implements ab {
    public com.google.zxing.c.b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (cVar != c.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + cVar);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            f fVar = f.L;
            int i3 = 4;
            if (map != null) {
                f fVar2 = (f) map.get(l.ERROR_CORRECTION);
                if (fVar2 != null) {
                    fVar = fVar2;
                }
                Integer num = (Integer) map.get(l.MARGIN);
                if (num != null) {
                    i3 = num.intValue();
                }
            }
            return a(com.google.zxing.e.c.c.a(str, fVar, map), i, i2, i3);
        }
    }

    private static com.google.zxing.c.b a(com.google.zxing.e.c.f fVar, int i, int i2, int i3) {
        com.google.zxing.e.c.b a2 = fVar.a();
        if (a2 != null) {
            int b2 = a2.b();
            int a3 = a2.a();
            int i4 = i3 * 2;
            int i5 = b2 + i4;
            int i6 = i4 + a3;
            int max = Math.max(i, i5);
            int max2 = Math.max(i2, i6);
            int min = Math.min(max / i5, max2 / i6);
            int i7 = (max - (b2 * min)) / 2;
            int i8 = (max2 - (a3 * min)) / 2;
            com.google.zxing.c.b bVar = new com.google.zxing.c.b(max, max2);
            int i9 = 0;
            while (i9 < a3) {
                int i10 = i7;
                int i11 = 0;
                while (i11 < b2) {
                    if (a2.a(i11, i9) == 1) {
                        bVar.a(i10, i8, min, min);
                    }
                    i11++;
                    i10 += min;
                }
                i9++;
                i8 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
