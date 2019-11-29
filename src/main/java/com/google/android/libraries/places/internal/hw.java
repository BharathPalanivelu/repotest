package com.google.android.libraries.places.internal;

import java.io.IOException;

public abstract class hw {

    /* renamed from: a  reason: collision with root package name */
    public static final hw f6736a = new hy("base16()", "0123456789ABCDEF");

    hw() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(int i);

    /* access modifiers changed from: package-private */
    public abstract void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    public final String a(byte[] bArr, int i, int i2) {
        go.a(0, i2 + 0, bArr.length);
        StringBuilder sb = new StringBuilder(a(i2));
        try {
            a(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    static {
        new hz("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        new hz("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new ia("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new ia("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    }
}
