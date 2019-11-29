package com.google.zxing.c;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14495a;

    /* renamed from: b  reason: collision with root package name */
    private int f14496b;

    /* renamed from: c  reason: collision with root package name */
    private int f14497c;

    public c(byte[] bArr) {
        this.f14495a = bArr;
    }

    public int a(int i) {
        byte b2;
        if (i < 1 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.f14497c;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            byte[] bArr = this.f14495a;
            int i6 = this.f14496b;
            b2 = (((255 >> (8 - i4)) << i5) & bArr[i6]) >> i5;
            i -= i4;
            this.f14497c += i4;
            if (this.f14497c == 8) {
                this.f14497c = 0;
                this.f14496b = i6 + 1;
            }
        } else {
            b2 = 0;
        }
        if (i <= 0) {
            return b2;
        }
        while (i >= 8) {
            byte[] bArr2 = this.f14495a;
            int i7 = this.f14496b;
            b2 = (b2 << 8) | (bArr2[i7] & 255);
            this.f14496b = i7 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return b2;
        }
        int i8 = 8 - i;
        int i9 = (b2 << i) | ((((255 >> i8) << i8) & this.f14495a[this.f14496b]) >> i8);
        this.f14497c += i;
        return i9;
    }

    public int a() {
        return ((this.f14495a.length - this.f14496b) * 8) - this.f14497c;
    }
}
