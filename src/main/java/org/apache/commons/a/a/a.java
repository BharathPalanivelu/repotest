package org.apache.commons.a.a;

import java.nio.charset.Charset;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f14312a = org.apache.commons.a.a.f7176f;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f14313b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f14314c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d  reason: collision with root package name */
    private final Charset f14315d;

    public static char[] a(byte[] bArr) {
        return a(bArr, true);
    }

    public static char[] a(byte[] bArr, boolean z) {
        return a(bArr, z ? f14313b : f14314c);
    }

    protected static char[] a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.f14315d + "]";
    }
}
