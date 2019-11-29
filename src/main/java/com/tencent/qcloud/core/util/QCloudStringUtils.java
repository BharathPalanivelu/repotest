package com.tencent.qcloud.core.util;

import java.nio.charset.Charset;

public class QCloudStringUtils {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean equals(java.lang.CharSequence r6, java.lang.CharSequence r7) {
        /*
            if (r6 == r7) goto L_0x002f
            if (r6 == 0) goto L_0x002d
            if (r7 == 0) goto L_0x002d
            boolean r0 = r6 instanceof java.lang.String
            if (r0 == 0) goto L_0x0015
            boolean r0 = r7 instanceof java.lang.String
            if (r0 == 0) goto L_0x0015
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x002d
            goto L_0x002f
        L_0x0015:
            r1 = 0
            r2 = 0
            r4 = 0
            int r0 = r6.length()
            int r3 = r7.length()
            int r5 = java.lang.Math.max(r0, r3)
            r0 = r6
            r3 = r7
            boolean r6 = regionMatches(r0, r1, r2, r3, r4, r5)
            if (r6 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r6 = 0
            goto L_0x0030
        L_0x002f:
            r6 = 1
        L_0x0030:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.util.QCloudStringUtils.equals(java.lang.CharSequence, java.lang.CharSequence):boolean");
    }

    public static byte[] getBytesUTF8(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static String newStringUTF8(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return true;
                }
                int i5 = i + 1;
                char charAt = charSequence.charAt(i);
                int i6 = i2 + 1;
                char charAt2 = charSequence2.charAt(i2);
                if (charAt != charAt2) {
                    if (!z) {
                        return false;
                    }
                    if (!(Character.toUpperCase(charAt) == Character.toUpperCase(charAt2) || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2))) {
                        return false;
                    }
                }
                i = i5;
                i3 = i4;
                i2 = i6;
            }
        } else {
            return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
        }
    }
}
