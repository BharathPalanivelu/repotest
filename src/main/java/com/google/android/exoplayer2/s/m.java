package com.google.android.exoplayer2.s;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f11425a;

    /* renamed from: b  reason: collision with root package name */
    private int f11426b;

    /* renamed from: c  reason: collision with root package name */
    private int f11427c;

    /* renamed from: d  reason: collision with root package name */
    private int f11428d;

    public m(byte[] bArr, int i, int i2) {
        a(bArr, i, i2);
    }

    public void a(byte[] bArr, int i, int i2) {
        this.f11425a = bArr;
        this.f11427c = i;
        this.f11426b = i2;
        this.f11428d = 0;
        g();
    }

    public void a() {
        int i = 1;
        int i2 = this.f11428d + 1;
        this.f11428d = i2;
        if (i2 == 8) {
            this.f11428d = 0;
            int i3 = this.f11427c;
            if (d(i3 + 1)) {
                i = 2;
            }
            this.f11427c = i3 + i;
        }
        g();
    }

    public void a(int i) {
        int i2 = this.f11427c;
        int i3 = i / 8;
        this.f11427c = i2 + i3;
        this.f11428d += i - (i3 * 8);
        int i4 = this.f11428d;
        if (i4 > 7) {
            this.f11427c++;
            this.f11428d = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f11427c) {
                g();
                return;
            } else if (d(i2)) {
                this.f11427c++;
                i2 += 2;
            }
        }
    }

    public boolean b(int i) {
        int i2 = this.f11427c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.f11428d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f11426b) {
                int i6 = this.f11426b;
            } else if (d(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i62 = this.f11426b;
        if (i4 < i62) {
            return true;
        }
        if (i4 == i62 && i5 == 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        boolean z = (this.f11425a[this.f11427c] & (128 >> this.f11428d)) != 0;
        a();
        return z;
    }

    public int c(int i) {
        int i2;
        int i3;
        this.f11428d += i;
        int i4 = 0;
        while (true) {
            i2 = this.f11428d;
            i3 = 2;
            if (i2 <= 8) {
                break;
            }
            this.f11428d = i2 - 8;
            byte[] bArr = this.f11425a;
            int i5 = this.f11427c;
            i4 |= (bArr[i5] & 255) << this.f11428d;
            if (!d(i5 + 1)) {
                i3 = 1;
            }
            this.f11427c = i5 + i3;
        }
        byte[] bArr2 = this.f11425a;
        int i6 = this.f11427c;
        int i7 = (-1 >>> (32 - i)) & (i4 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f11428d = 0;
            if (!d(i6 + 1)) {
                i3 = 1;
            }
            this.f11427c = i6 + i3;
        }
        g();
        return i7;
    }

    public boolean c() {
        int i = this.f11427c;
        int i2 = this.f11428d;
        int i3 = 0;
        while (this.f11427c < this.f11426b && !b()) {
            i3++;
        }
        boolean z = this.f11427c == this.f11426b;
        this.f11427c = i;
        this.f11428d = i2;
        if (z || !b((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public int d() {
        return f();
    }

    public int e() {
        int f2 = f();
        return (f2 % 2 == 0 ? -1 : 1) * ((f2 + 1) / 2);
    }

    private int f() {
        int i = 0;
        int i2 = 0;
        while (!b()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = c(i2);
        }
        return i3 + i;
    }

    private boolean d(int i) {
        if (2 <= i && i < this.f11426b) {
            byte[] bArr = this.f11425a;
            return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
        }
    }

    private void g() {
        boolean z;
        int i = this.f11427c;
        if (i >= 0) {
            int i2 = this.f11426b;
            if (i < i2 || (i == i2 && this.f11428d == 0)) {
                z = true;
                a.b(z);
            }
        }
        z = false;
        a.b(z);
    }
}
