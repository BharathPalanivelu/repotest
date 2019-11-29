package com.google.android.exoplayer2.n;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f10951a;

    /* renamed from: b  reason: collision with root package name */
    private int f10952b;

    /* renamed from: c  reason: collision with root package name */
    private int f10953c;

    /* renamed from: d  reason: collision with root package name */
    private int f10954d;

    public l(byte[] bArr, int i, int i2) {
        a(bArr, i, i2);
    }

    public void a(byte[] bArr, int i, int i2) {
        this.f10951a = bArr;
        this.f10953c = i;
        this.f10952b = i2;
        this.f10954d = 0;
        f();
    }

    public void a(int i) {
        int i2 = this.f10953c;
        this.f10953c = (i / 8) + i2;
        this.f10954d += i % 8;
        int i3 = this.f10954d;
        if (i3 > 7) {
            this.f10953c++;
            this.f10954d = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f10953c) {
                f();
                return;
            } else if (d(i2)) {
                this.f10953c++;
                i2 += 2;
            }
        }
    }

    public boolean b(int i) {
        int i2 = this.f10953c;
        int i3 = (i / 8) + i2;
        int i4 = this.f10954d + (i % 8);
        if (i4 > 7) {
            i3++;
            i4 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i3 || i3 >= this.f10952b) {
                int i5 = this.f10952b;
            } else if (d(i2)) {
                i3++;
                i2 += 2;
            }
        }
        int i52 = this.f10952b;
        if (i3 < i52) {
            return true;
        }
        if (i3 == i52 && i4 == 0) {
            return true;
        }
        return false;
    }

    public boolean a() {
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
            int i4 = d(this.f10953c + 1) ? this.f10953c + 2 : this.f10953c + 1;
            int i5 = this.f10954d;
            if (i5 != 0) {
                byte[] bArr = this.f10951a;
                b3 = ((bArr[i4] & 255) >>> (8 - i5)) | ((bArr[this.f10953c] & 255) << i5);
            } else {
                b3 = this.f10951a[this.f10953c];
            }
            i -= 8;
            b4 |= (255 & b3) << i;
            this.f10953c = i4;
        }
        if (i > 0) {
            int i6 = this.f10954d + i;
            byte b5 = (byte) (255 >> (8 - i));
            int i7 = d(this.f10953c + 1) ? this.f10953c + 2 : this.f10953c + 1;
            if (i6 > 8) {
                byte[] bArr2 = this.f10951a;
                b2 = (b5 & (((255 & bArr2[i7]) >> (16 - i6)) | ((bArr2[this.f10953c] & 255) << (i6 - 8)))) | b4;
                this.f10953c = i7;
            } else {
                b2 = (b5 & ((255 & this.f10951a[this.f10953c]) >> (8 - i6))) | b4;
                if (i6 == 8) {
                    this.f10953c = i7;
                }
            }
            b4 = b2;
            this.f10954d = i6 % 8;
        }
        f();
        return b4;
    }

    public boolean b() {
        int i = this.f10953c;
        int i2 = this.f10954d;
        int i3 = 0;
        while (this.f10953c < this.f10952b && !a()) {
            i3++;
        }
        boolean z = this.f10953c == this.f10952b;
        this.f10953c = i;
        this.f10954d = i2;
        if (z || !b((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public int c() {
        return e();
    }

    public int d() {
        int e2 = e();
        return (e2 % 2 == 0 ? -1 : 1) * ((e2 + 1) / 2);
    }

    private int e() {
        int i = 0;
        int i2 = 0;
        while (!a()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = c(i2);
        }
        return i3 + i;
    }

    private boolean d(int i) {
        if (2 <= i && i < this.f10952b) {
            byte[] bArr = this.f10951a;
            return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
        }
    }

    private void f() {
        boolean z;
        int i = this.f10953c;
        if (i >= 0) {
            int i2 = this.f10954d;
            if (i2 >= 0 && i2 < 8) {
                int i3 = this.f10952b;
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
