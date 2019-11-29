package com.google.zxing.d;

import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.c.b;
import com.google.zxing.l;
import java.util.Map;

public final class f extends r {
    public b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        if (cVar == c.CODE_39) {
            return super.a(str, cVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + cVar);
    }

    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i = length + 25;
            int i2 = 0;
            while (i2 < length) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
                if (indexOf >= 0) {
                    a(e.f14592a[indexOf], iArr);
                    int i3 = i;
                    for (int i4 : iArr) {
                        i3 += i4;
                    }
                    i2++;
                    i = i3;
                } else {
                    throw new IllegalArgumentException("Bad contents: " + str);
                }
            }
            boolean[] zArr = new boolean[i];
            a(e.f14592a[39], iArr);
            int a2 = a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int a3 = a2 + a(zArr, a2, iArr2, false);
            for (int i5 = 0; i5 < length; i5++) {
                a(e.f14592a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i5))], iArr);
                int a4 = a3 + a(zArr, a3, iArr, true);
                a3 = a4 + a(zArr, a4, iArr2, false);
            }
            a(e.f14592a[39], iArr);
            a(zArr, a3, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }
}
