package com.google.zxing.d;

import com.google.zxing.ab;
import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.c.b;
import com.google.zxing.l;
import java.util.Map;

public final class t implements ab {

    /* renamed from: a  reason: collision with root package name */
    private final i f14619a = new i();

    public b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        if (cVar == c.UPC_A) {
            return this.f14619a.a(a(str), c.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + cVar);
    }

    private static String a(String str) {
        int length = str.length();
        if (length == 11) {
            int i = 0;
            for (int i2 = 0; i2 < 11; i2++) {
                i += (str.charAt(i2) - '0') * (i2 % 2 == 0 ? 3 : 1);
            }
            str = str + ((1000 - i) % 10);
        } else if (length != 12) {
            throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return '0' + str;
    }
}
