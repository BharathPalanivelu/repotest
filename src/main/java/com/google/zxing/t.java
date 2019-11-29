package com.google.zxing;

public final class t extends n {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14782a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14783b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14784c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14785d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f14786e = 0;

    public t(int i, int i2, int[] iArr) {
        super(i, i2);
        this.f14783b = i;
        this.f14784c = i2;
        this.f14782a = new byte[(i * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + i5;
                int i7 = iArr[i6];
                int i8 = (i7 >> 16) & 255;
                int i9 = (i7 >> 8) & 255;
                int i10 = i7 & 255;
                if (i8 == i9 && i9 == i10) {
                    this.f14782a[i6] = (byte) i8;
                } else {
                    this.f14782a[i6] = (byte) (((i8 + (i9 * 2)) + i10) / 4);
                }
            }
        }
    }

    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b2 = b();
        if (bArr == null || bArr.length < b2) {
            bArr = new byte[b2];
        }
        System.arraycopy(this.f14782a, ((i + this.f14786e) * this.f14783b) + this.f14785d, bArr, 0, b2);
        return bArr;
    }

    public byte[] a() {
        int b2 = b();
        int c2 = c();
        if (b2 == this.f14783b && c2 == this.f14784c) {
            return this.f14782a;
        }
        int i = b2 * c2;
        byte[] bArr = new byte[i];
        int i2 = this.f14786e;
        int i3 = this.f14783b;
        int i4 = (i2 * i3) + this.f14785d;
        if (b2 == i3) {
            System.arraycopy(this.f14782a, i4, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f14782a;
        for (int i5 = 0; i5 < c2; i5++) {
            System.arraycopy(bArr2, i4, bArr, i5 * b2, b2);
            i4 += this.f14783b;
        }
        return bArr;
    }
}
