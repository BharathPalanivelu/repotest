package com.crashlytics.android.c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f6457a = new c(new byte[0]);

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6458b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f6459c = 0;

    private c(byte[] bArr) {
        this.f6458b = bArr;
    }

    public int a() {
        return this.f6458b.length;
    }

    public static c a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new c(bArr2);
    }

    public static c a(String str) {
        try {
            return new c(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported.", e2);
        }
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f6458b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        byte[] bArr = this.f6458b;
        int length = bArr.length;
        byte[] bArr2 = ((c) obj).f6458b;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f6459c;
        if (i == 0) {
            int i2 = r1;
            for (byte b2 : this.f6458b) {
                i2 = (i2 * 31) + b2;
            }
            i = i2 == 0 ? 1 : i2;
            this.f6459c = i;
        }
        return i;
    }

    public InputStream b() {
        return new ByteArrayInputStream(this.f6458b);
    }
}
