package com.google.android.exoplayer2.s;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f11418a;

    /* renamed from: b  reason: collision with root package name */
    private int f11419b;

    /* renamed from: c  reason: collision with root package name */
    private int f11420c;

    /* renamed from: d  reason: collision with root package name */
    private int f11421d;

    public k() {
    }

    public k(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public k(byte[] bArr, int i) {
        this.f11418a = bArr;
        this.f11421d = i;
    }

    public void a(byte[] bArr, int i) {
        this.f11418a = bArr;
        this.f11419b = 0;
        this.f11420c = 0;
        this.f11421d = i;
    }

    public int a() {
        return ((this.f11421d - this.f11419b) * 8) - this.f11420c;
    }

    public int b() {
        return (this.f11419b * 8) + this.f11420c;
    }

    public int c() {
        a.b(this.f11420c == 0);
        return this.f11419b;
    }

    public void a(int i) {
        this.f11419b = i / 8;
        this.f11420c = i - (this.f11419b * 8);
        g();
    }

    public void d() {
        int i = this.f11420c + 1;
        this.f11420c = i;
        if (i == 8) {
            this.f11420c = 0;
            this.f11419b++;
        }
        g();
    }

    public void b(int i) {
        int i2 = i / 8;
        this.f11419b += i2;
        this.f11420c += i - (i2 * 8);
        int i3 = this.f11420c;
        if (i3 > 7) {
            this.f11419b++;
            this.f11420c = i3 - 8;
        }
        g();
    }

    public boolean e() {
        boolean z = (this.f11418a[this.f11419b] & (128 >> this.f11420c)) != 0;
        d();
        return z;
    }

    public int c(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.f11420c += i;
        int i3 = 0;
        while (true) {
            i2 = this.f11420c;
            if (i2 <= 8) {
                break;
            }
            this.f11420c = i2 - 8;
            byte[] bArr = this.f11418a;
            int i4 = this.f11419b;
            this.f11419b = i4 + 1;
            i3 |= (bArr[i4] & 255) << this.f11420c;
        }
        byte[] bArr2 = this.f11418a;
        int i5 = this.f11419b;
        int i6 = (-1 >>> (32 - i)) & (i3 | ((bArr2[i5] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f11420c = 0;
            this.f11419b = i5 + 1;
        }
        g();
        return i6;
    }

    public void f() {
        if (this.f11420c != 0) {
            this.f11420c = 0;
            this.f11419b++;
            g();
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        a.b(this.f11420c == 0);
        System.arraycopy(this.f11418a, this.f11419b, bArr, i, i2);
        this.f11419b += i2;
        g();
    }

    public void d(int i) {
        a.b(this.f11420c == 0);
        this.f11419b += i;
        g();
    }

    private void g() {
        boolean z;
        int i = this.f11419b;
        if (i >= 0) {
            int i2 = this.f11421d;
            if (i < i2 || (i == i2 && this.f11420c == 0)) {
                z = true;
                a.b(z);
            }
        }
        z = false;
        a.b(z);
    }
}
