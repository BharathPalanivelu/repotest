package com.google.zxing.d;

import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.c.b;
import com.google.zxing.l;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.util.ArrayList;
import java.util.Map;

public final class d extends r {
    public b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        if (cVar == c.CODE_128) {
            return super.a(str, cVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + cVar);
    }

    public boolean[] a(String str) {
        int i;
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i4 < length) {
            int i8 = 99;
            int i9 = 100;
            if (!a(str, i4, i6 == 99 ? 2 : 4)) {
                i8 = 100;
            }
            if (i8 == i6) {
                switch (str.charAt(i4)) {
                    case 241:
                        i9 = 102;
                        break;
                    case 242:
                        i9 = 97;
                        break;
                    case 243:
                        i9 = 96;
                        break;
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
                        break;
                    default:
                        if (i6 != 100) {
                            i9 = Integer.parseInt(str.substring(i4, i4 + 2));
                            i4++;
                            break;
                        } else {
                            i9 = str.charAt(i4) - ' ';
                            break;
                        }
                }
                i4++;
            } else {
                i = i6 == 0 ? i8 == 100 ? 104 : 105 : i8;
                i6 = i8;
            }
            arrayList.add(c.f14591a[i]);
            i5 += i * i7;
            if (i4 != 0) {
                i7++;
            }
        }
        arrayList.add(c.f14591a[i5 % 103]);
        arrayList.add(c.f14591a[106]);
        int i10 = 0;
        for (int[] iArr : arrayList) {
            int i11 = i10;
            for (int i12 : (int[]) r13.next()) {
                i11 += i12;
            }
            i10 = i11;
        }
        boolean[] zArr = new boolean[i10];
        for (int[] a2 : arrayList) {
            i2 += a(zArr, i2, a2, true);
        }
        return zArr;
    }

    private static boolean a(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        int length = charSequence.length();
        while (i < i3 && i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (charAt != 241) {
                    return false;
                }
                i3++;
            }
            i++;
        }
        if (i3 <= length) {
            return true;
        }
        return false;
    }
}
