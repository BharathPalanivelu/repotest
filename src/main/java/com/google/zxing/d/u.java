package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.x;
import com.google.zxing.y;
import java.util.EnumMap;
import java.util.Map;

final class u {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f14620a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f14621b = new StringBuilder();

    u() {
    }

    /* access modifiers changed from: package-private */
    public w a(int i, a aVar, int[] iArr) throws q {
        StringBuilder sb = this.f14621b;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<x, Object> a3 = a(sb2);
        float f2 = (float) i;
        w wVar = new w(sb2, (byte[]) null, new y[]{new y(((float) (iArr[0] + iArr[1])) / 2.0f, f2), new y((float) a2, f2)}, c.UPC_EAN_EXTENSION);
        if (a3 != null) {
            wVar.a(a3);
        }
        return wVar;
    }

    /* access modifiers changed from: package-private */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws q {
        int[] iArr2 = this.f14620a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2 && i < a2) {
            int a3 = x.a(aVar, iArr2, i, x.f14631e);
            sb.append((char) ((a3 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a3 >= 10) {
                i3 = (1 << (1 - i2)) | i3;
            }
            i = i2 != 1 ? aVar.d(aVar.c(i4)) : i4;
            i2++;
        }
        if (sb.length() != 2) {
            throw q.a();
        } else if (Integer.parseInt(sb.toString()) % 4 == i3) {
            return i;
        } else {
            throw q.a();
        }
    }

    private static Map<x, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(x.class);
        enumMap.put(x.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}
