package com.google.zxing.d;

import com.facebook.appevents.AppEventsConstants;
import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.x;
import com.google.zxing.y;
import java.util.EnumMap;
import java.util.Map;

final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14622a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14623b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f14624c = new StringBuilder();

    v() {
    }

    /* access modifiers changed from: package-private */
    public w a(int i, a aVar, int[] iArr) throws q {
        StringBuilder sb = this.f14624c;
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
        int[] iArr2 = this.f14623b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5 && i < a2) {
            int a3 = x.a(aVar, iArr2, i, x.f14631e);
            sb.append((char) ((a3 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a3 >= 10) {
                i3 |= 1 << (4 - i2);
            }
            i = i2 != 4 ? aVar.d(aVar.c(i4)) : i4;
            i2++;
        }
        if (sb.length() == 5) {
            if (a((CharSequence) sb.toString()) == a(i3)) {
                return i;
            }
            throw q.a();
        }
        throw q.a();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    private static int a(int i) throws q {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f14622a[i2]) {
                return i2;
            }
        }
        throw q.a();
    }

    private static Map<x, Object> a(String str) {
        if (str.length() != 5) {
            return null;
        }
        String b2 = b(str);
        if (b2 == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(x.class);
        enumMap.put(x.SUGGESTED_PRICE, b2);
        return enumMap;
    }

    private static String b(String str) {
        String str2;
        char charAt = str.charAt(0);
        String str3 = "";
        if (charAt == '0') {
            str3 = "£";
        } else if (charAt == '5') {
            str3 = "$";
        } else if (charAt == '9') {
            if ("90000".equals(str)) {
                return null;
            }
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf = String.valueOf(parseInt / 100);
        int i = parseInt % 100;
        if (i < 10) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO + i;
        } else {
            str2 = String.valueOf(i);
        }
        return str3 + valueOf + '.' + str2;
    }
}
