package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.n.a;

final class i {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f9552a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9553b;

    /* renamed from: c  reason: collision with root package name */
    private int f9554c;

    /* renamed from: d  reason: collision with root package name */
    private int f9555d;

    public i(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public i(byte[] bArr, int i) {
        this.f9552a = bArr;
        this.f9553b = i * 8;
    }

    public boolean a() {
        return a(1) == 1;
    }

    public int a(int i) {
        int i2;
        int i3;
        a.b(b() + i <= this.f9553b);
        if (i == 0) {
            return 0;
        }
        int i4 = this.f9555d;
        if (i4 != 0) {
            i3 = Math.min(i, 8 - i4);
            byte[] bArr = this.f9552a;
            int i5 = this.f9554c;
            byte b2 = bArr[i5];
            int i6 = this.f9555d;
            i2 = (255 >>> (8 - i3)) & (b2 >>> i6);
            this.f9555d = i6 + i3;
            if (this.f9555d == 8) {
                this.f9554c = i5 + 1;
                this.f9555d = 0;
            }
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i7 = i - i3;
        if (i7 > 7) {
            int i8 = i7 / 8;
            for (int i9 = 0; i9 < i8; i9++) {
                byte[] bArr2 = this.f9552a;
                int i10 = this.f9554c;
                this.f9554c = i10 + 1;
                i2 = (int) (((long) i2) | ((((long) bArr2[i10]) & 255) << i3));
                i3 += 8;
            }
        }
        if (i <= i3) {
            return i2;
        }
        int i11 = i - i3;
        int i12 = i2 | (((255 >>> (8 - i11)) & this.f9552a[this.f9554c]) << i3);
        this.f9555d += i11;
        return i12;
    }

    public void b(int i) {
        a.b(b() + i <= this.f9553b);
        this.f9554c += i / 8;
        this.f9555d += i % 8;
        int i2 = this.f9555d;
        if (i2 > 7) {
            this.f9554c++;
            this.f9555d = i2 - 8;
        }
    }

    public int b() {
        return (this.f9554c * 8) + this.f9555d;
    }
}
