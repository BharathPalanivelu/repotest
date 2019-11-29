package com.g.a.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7288a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f7289b;

    public static boolean a(byte b2, byte b3) {
        return b2 == b3;
    }

    public static boolean a(int i, int i2) {
        return i == i2;
    }

    public static boolean a(long j, long j2) {
        return j == j2;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        f7288a = bArr2;
        f7289b = bArr3;
    }
}
