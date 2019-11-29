package com.appsflyer.internal;

public class ad {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m126(byte[] bArr, byte b2, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b2);
            }
        }
    }
}
