package com.google.android.exoplayer2.n;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f10944a;

    /* renamed from: b  reason: collision with root package name */
    private int f10945b;

    /* renamed from: c  reason: collision with root package name */
    private int f10946c;

    /* renamed from: d  reason: collision with root package name */
    private int f10947d;

    public j() {
    }

    public j(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public j(byte[] bArr, int i) {
        this.f10944a = bArr;
        this.f10947d = i;
    }

    public void a(byte[] bArr, int i) {
        this.f10944a = bArr;
        this.f10945b = 0;
        this.f10946c = 0;
        this.f10947d = i;
    }

    public int a() {
        return ((this.f10947d - this.f10945b) * 8) - this.f10946c;
    }

    public int b() {
        return (this.f10945b * 8) + this.f10946c;
    }

    public int c() {
        a.b(this.f10946c == 0);
        return this.f10945b;
    }

    public void a(int i) {
        this.f10945b = i / 8;
        this.f10946c = i - (this.f10945b * 8);
        f();
    }

    public void b(int i) {
        this.f10945b += i / 8;
        this.f10946c += i % 8;
        int i2 = this.f10946c;
        if (i2 > 7) {
            this.f10945b++;
            this.f10946c = i2 - 8;
        }
        f();
    }

    public boolean d() {
        return c(1) == 1;
    }

    public int c(int i) {
        byte b2;
        byte b3;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b4 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f10946c;
            if (i4 != 0) {
                byte[] bArr = this.f10944a;
                int i5 = this.f10945b;
                b3 = ((bArr[i5 + 1] & 255) >>> (8 - i4)) | ((bArr[i5] & 255) << i4);
            } else {
                b3 = this.f10944a[this.f10945b];
            }
            i -= 8;
            b4 |= (255 & b3) << i;
            this.f10945b++;
        }
        if (i > 0) {
            int i6 = this.f10946c + i;
            byte b5 = (byte) (255 >> (8 - i));
            if (i6 > 8) {
                byte[] bArr2 = this.f10944a;
                int i7 = this.f10945b;
                b2 = (b5 & (((bArr2[i7 + 1] & 255) >> (16 - i6)) | ((bArr2[i7] & 255) << (i6 - 8)))) | b4;
                this.f10945b = i7 + 1;
            } else {
                byte[] bArr3 = this.f10944a;
                int i8 = this.f10945b;
                b2 = (b5 & ((bArr3[i8] & 255) >> (8 - i6))) | b4;
                if (i6 == 8) {
                    this.f10945b = i8 + 1;
                }
            }
            b4 = b2;
            this.f10946c = i6 % 8;
        }
        f();
        return b4;
    }

    public void e() {
        if (this.f10946c != 0) {
            this.f10946c = 0;
            this.f10945b++;
            f();
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        a.b(this.f10946c == 0);
        System.arraycopy(this.f10944a, this.f10945b, bArr, i, i2);
        this.f10945b += i2;
        f();
    }

    public void d(int i) {
        a.b(this.f10946c == 0);
        this.f10945b += i;
        f();
    }

    private void f() {
        boolean z;
        int i = this.f10945b;
        if (i >= 0) {
            int i2 = this.f10946c;
            if (i2 >= 0 && i2 < 8) {
                int i3 = this.f10947d;
                if (i < i3 || (i == i3 && i2 == 0)) {
                    z = true;
                    a.b(z);
                }
            }
        }
        z = false;
        a.b(z);
    }
}
