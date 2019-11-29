package com.google.zxing;

public final class r extends n {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14777a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14778b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14779c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14780d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14781e;

    public r(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f14777a = bArr;
        this.f14778b = i;
        this.f14779c = i2;
        this.f14780d = i3;
        this.f14781e = i4;
        if (z) {
            a(i5, i6);
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
        System.arraycopy(this.f14777a, ((i + this.f14781e) * this.f14778b) + this.f14780d, bArr, 0, b2);
        return bArr;
    }

    public byte[] a() {
        int b2 = b();
        int c2 = c();
        if (b2 == this.f14778b && c2 == this.f14779c) {
            return this.f14777a;
        }
        int i = b2 * c2;
        byte[] bArr = new byte[i];
        int i2 = this.f14781e;
        int i3 = this.f14778b;
        int i4 = (i2 * i3) + this.f14780d;
        if (b2 == i3) {
            System.arraycopy(this.f14777a, i4, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f14777a;
        for (int i5 = 0; i5 < c2; i5++) {
            System.arraycopy(bArr2, i4, bArr, i5 * b2, b2);
            i4 += this.f14778b;
        }
        return bArr;
    }

    private void a(int i, int i2) {
        byte[] bArr = this.f14777a;
        int i3 = (this.f14781e * this.f14778b) + this.f14780d;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b2 = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b2;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.f14778b;
        }
    }
}
