package com.g.a.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f7277a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f7278b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte a(char c2) {
        int i;
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return 0;
                }
            }
            i = (c2 - c3) + 10;
        } else {
            i = c2 - '0';
        }
        return (byte) i;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f7278b;
            cArr[i2 + 1] = cArr2[b2 & 15];
            cArr[i2 + 0] = cArr2[((byte) (b2 >>> 4)) & 15];
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return f7277a;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) * 16) + a(str.charAt(i2 + 1)));
        }
        return bArr;
    }
}
