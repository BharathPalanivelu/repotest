package com.google.zxing.d;

import cn.tongdun.android.BuildConfig;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.y;
import com.tencent.imsdk.protocol.im_common;
import java.util.Arrays;
import java.util.Map;
import twitter4j.HttpResponseCode;

public final class g extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14599a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14600b = {276, 328, 324, BuildConfig.VERSION_CODE, 296, 292, 290, 336, TiffUtil.TIFF_TAG_ORIENTATION, 266, 424, HttpResponseCode.ENHANCE_YOUR_CLAIM, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, HttpResponseCode.UNPROCESSABLE_ENTITY, HttpResponseCode.NOT_ACCEPTABLE, 410, 364, 358, im_common.NEARBY_PEOPLE_TMP_DATE_MSG, 314, 302, 468, 466, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 366, 374, 430, 294, 474, 470, im_common.BUSINESS_MB_WPA_C2C_TMP_MSG, 350};

    /* renamed from: c  reason: collision with root package name */
    private static final int f14601c = f14600b[47];

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f14602d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private final int[] f14603e = new int[6];

    public w a(int i, a aVar, Map<j, ?> map) throws q, com.google.zxing.g, m {
        int[] a2 = a(aVar);
        int c2 = aVar.c(a2[1]);
        int a3 = aVar.a();
        int[] iArr = this.f14603e;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f14602d;
        sb.setLength(0);
        while (true) {
            a(aVar, c2, iArr);
            int a4 = a(iArr);
            if (a4 >= 0) {
                char a5 = a(a4);
                sb.append(a5);
                int i2 = c2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int c3 = aVar.c(i2);
                if (a5 == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    if (c3 == a3 || !aVar.a(c3)) {
                        throw q.a();
                    } else if (sb.length() >= 2) {
                        b(sb);
                        sb.setLength(sb.length() - 2);
                        float f2 = (float) i;
                        return new w(a((CharSequence) sb), (byte[]) null, new y[]{new y(((float) (a2[1] + a2[0])) / 2.0f, f2), new y(((float) c2) + (((float) i4) / 2.0f), f2)}, c.CODE_93);
                    } else {
                        throw q.a();
                    }
                } else {
                    c2 = c3;
                }
            } else {
                throw q.a();
            }
        }
    }

    private int[] a(a aVar) throws q {
        int a2 = aVar.a();
        int c2 = aVar.c(0);
        Arrays.fill(this.f14603e, 0);
        int[] iArr = this.f14603e;
        int length = iArr.length;
        int i = c2;
        boolean z = false;
        int i2 = 0;
        while (c2 < a2) {
            if (aVar.a(c2) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 != i3) {
                    i2++;
                } else if (a(iArr) == f14601c) {
                    return new int[]{i, c2};
                } else {
                    i += iArr[0] + iArr[1];
                    int i4 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
            c2++;
        }
        throw q.a();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((((float) iArr[i4]) * 9.0f) / ((float) i));
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < round; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    private static char a(int i) throws q {
        int i2 = 0;
        while (true) {
            int[] iArr = f14600b;
            if (i2 >= iArr.length) {
                throw q.a();
            } else if (iArr[i2] == i) {
                return f14599a[i2];
            } else {
                i2++;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.CharSequence r8) throws com.google.zxing.m {
        /*
            int r0 = r8.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        L_0x000b:
            if (r3 >= r0) goto L_0x0080
            char r4 = r8.charAt(r3)
            r5 = 97
            if (r4 < r5) goto L_0x007a
            r5 = 100
            if (r4 > r5) goto L_0x007a
            int r5 = r0 + -1
            if (r3 >= r5) goto L_0x0075
            int r3 = r3 + 1
            char r5 = r8.charAt(r3)
            r6 = 90
            r7 = 65
            switch(r4) {
                case 97: goto L_0x0064;
                case 98: goto L_0x004b;
                case 99: goto L_0x0038;
                case 100: goto L_0x002c;
                default: goto L_0x002a;
            }
        L_0x002a:
            r4 = 0
            goto L_0x0071
        L_0x002c:
            if (r5 < r7) goto L_0x0033
            if (r5 > r6) goto L_0x0033
            int r5 = r5 + 32
            goto L_0x006a
        L_0x0033:
            com.google.zxing.m r8 = com.google.zxing.m.a()
            throw r8
        L_0x0038:
            if (r5 < r7) goto L_0x0041
            r4 = 79
            if (r5 > r4) goto L_0x0041
            int r5 = r5 + -32
            goto L_0x006a
        L_0x0041:
            if (r5 != r6) goto L_0x0046
            r4 = 58
            goto L_0x0071
        L_0x0046:
            com.google.zxing.m r8 = com.google.zxing.m.a()
            throw r8
        L_0x004b:
            if (r5 < r7) goto L_0x0054
            r4 = 69
            if (r5 > r4) goto L_0x0054
            int r5 = r5 + -38
            goto L_0x006a
        L_0x0054:
            r4 = 70
            if (r5 < r4) goto L_0x005f
            r4 = 87
            if (r5 > r4) goto L_0x005f
            int r5 = r5 + -11
            goto L_0x006a
        L_0x005f:
            com.google.zxing.m r8 = com.google.zxing.m.a()
            throw r8
        L_0x0064:
            if (r5 < r7) goto L_0x006c
            if (r5 > r6) goto L_0x006c
            int r5 = r5 + -64
        L_0x006a:
            char r4 = (char) r5
            goto L_0x0071
        L_0x006c:
            com.google.zxing.m r8 = com.google.zxing.m.a()
            throw r8
        L_0x0071:
            r1.append(r4)
            goto L_0x007d
        L_0x0075:
            com.google.zxing.m r8 = com.google.zxing.m.a()
            throw r8
        L_0x007a:
            r1.append(r4)
        L_0x007d:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x0080:
            java.lang.String r8 = r1.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.d.g.a(java.lang.CharSequence):java.lang.String");
    }

    private static void b(CharSequence charSequence) throws com.google.zxing.g {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i, int i2) throws com.google.zxing.g {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != f14599a[i3 % 47]) {
            throw com.google.zxing.g.a();
        }
    }
}
