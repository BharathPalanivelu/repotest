package com.google.zxing.d;

import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.c.b;
import com.google.zxing.l;
import java.util.Map;

public final class n extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14614a = {1, 1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14615b = {3, 1, 1};

    public b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        if (cVar == c.ITF) {
            return super.a(str, cVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + cVar);
    }

    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        } else if (length <= 80) {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a2 = a(zArr, 0, f14614a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    iArr[i3] = m.f14609a[digit][i2];
                    iArr[i3 + 1] = m.f14609a[digit2][i2];
                }
                a2 += a(zArr, a2, iArr, true);
            }
            a(zArr, a2, f14615b, true);
            return zArr;
        } else {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
    }
}
