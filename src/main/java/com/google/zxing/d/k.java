package com.google.zxing.d;

import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.c.b;
import com.google.zxing.l;
import java.util.Map;

public final class k extends y {
    public b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        if (cVar == c.EAN_8) {
            return super.a(str, cVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + cVar);
    }

    public boolean[] a(String str) {
        if (str.length() == 8) {
            boolean[] zArr = new boolean[67];
            int a2 = a(zArr, 0, x.f14628b, true) + 0;
            int i = 0;
            while (i <= 3) {
                int i2 = i + 1;
                a2 += a(zArr, a2, x.f14630d[Integer.parseInt(str.substring(i, i2))], false);
                i = i2;
            }
            int a3 = a2 + a(zArr, a2, x.f14629c, false);
            int i3 = 4;
            while (i3 <= 7) {
                int i4 = i3 + 1;
                a3 += a(zArr, a3, x.f14630d[Integer.parseInt(str.substring(i3, i4))], true);
                i3 = i4;
            }
            a(zArr, a3, x.f14628b, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
