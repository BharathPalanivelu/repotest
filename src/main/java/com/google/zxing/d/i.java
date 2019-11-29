package com.google.zxing.d;

import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.c.b;
import com.google.zxing.l;
import com.google.zxing.m;
import java.util.Map;

public final class i extends y {
    public b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        if (cVar == c.EAN_13) {
            return super.a(str, cVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + cVar);
    }

    public boolean[] a(String str) {
        if (str.length() == 13) {
            try {
                if (x.a((CharSequence) str)) {
                    int i = h.f14604a[Integer.parseInt(str.substring(0, 1))];
                    boolean[] zArr = new boolean[95];
                    int a2 = a(zArr, 0, x.f14628b, true) + 0;
                    int i2 = 1;
                    while (i2 <= 6) {
                        int i3 = i2 + 1;
                        int parseInt = Integer.parseInt(str.substring(i2, i3));
                        if (((i >> (6 - i2)) & 1) == 1) {
                            parseInt += 10;
                        }
                        a2 += a(zArr, a2, x.f14631e[parseInt], false);
                        i2 = i3;
                    }
                    int a3 = a2 + a(zArr, a2, x.f14629c, false);
                    int i4 = 7;
                    while (i4 <= 12) {
                        int i5 = i4 + 1;
                        a3 += a(zArr, a3, x.f14630d[Integer.parseInt(str.substring(i4, i5))], true);
                        i4 = i5;
                    }
                    a(zArr, a3, x.f14628b, true);
                    return zArr;
                }
                throw new IllegalArgumentException("Contents do not pass checksum");
            } catch (m unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
        }
    }
}
