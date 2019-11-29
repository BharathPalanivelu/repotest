package com.google.android.exoplayer2.s;

import java.nio.charset.Charset;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f11422a;

    /* renamed from: b  reason: collision with root package name */
    private int f11423b;

    /* renamed from: c  reason: collision with root package name */
    private int f11424c;

    public l() {
    }

    public l(int i) {
        this.f11422a = new byte[i];
        this.f11424c = i;
    }

    public l(byte[] bArr) {
        this.f11422a = bArr;
        this.f11424c = bArr.length;
    }

    public l(byte[] bArr, int i) {
        this.f11422a = bArr;
        this.f11424c = i;
    }

    public void a(int i) {
        a(e() < i ? new byte[i] : this.f11422a, i);
    }

    public void a(byte[] bArr, int i) {
        this.f11422a = bArr;
        this.f11424c = i;
        this.f11423b = 0;
    }

    public void a() {
        this.f11423b = 0;
        this.f11424c = 0;
    }

    public int b() {
        return this.f11424c - this.f11423b;
    }

    public int c() {
        return this.f11424c;
    }

    public void b(int i) {
        a.a(i >= 0 && i <= this.f11422a.length);
        this.f11424c = i;
    }

    public int d() {
        return this.f11423b;
    }

    public int e() {
        byte[] bArr = this.f11422a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public void c(int i) {
        a.a(i >= 0 && i <= this.f11424c);
        this.f11423b = i;
    }

    public void d(int i) {
        c(this.f11423b + i);
    }

    public void a(k kVar, int i) {
        a(kVar.f11418a, 0, i);
        kVar.a(0);
    }

    public void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f11422a, this.f11423b, bArr, i, i2);
        this.f11423b += i2;
    }

    public char f() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int g() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        return bArr[i] & 255;
    }

    public int h() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public int i() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
    }

    public short j() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public int k() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        byte b2 = ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
        int i3 = this.f11423b;
        this.f11423b = i3 + 1;
        return (bArr[i3] & 255) | b2;
    }

    public long l() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        long j = ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i2]) & 255) << 16);
        int i3 = this.f11423b;
        this.f11423b = i3 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.f11423b;
        this.f11423b = i4 + 1;
        return j2 | (255 & ((long) bArr[i4]));
    }

    public long m() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.f11423b;
        this.f11423b = i3 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.f11423b;
        this.f11423b = i4 + 1;
        return j2 | ((255 & ((long) bArr[i4])) << 24);
    }

    public int n() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i3 = this.f11423b;
        this.f11423b = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & 255) << 8);
        int i4 = this.f11423b;
        this.f11423b = i4 + 1;
        return (bArr[i4] & 255) | b3;
    }

    public int o() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        byte b2 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i3 = this.f11423b;
        this.f11423b = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & 255) << 16);
        int i4 = this.f11423b;
        this.f11423b = i4 + 1;
        return ((bArr[i4] & 255) << 24) | b3;
    }

    public long p() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i2]) & 255) << 48);
        int i3 = this.f11423b;
        this.f11423b = i3 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 40);
        int i4 = this.f11423b;
        this.f11423b = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 32);
        int i5 = this.f11423b;
        this.f11423b = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.f11423b;
        this.f11423b = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 16);
        int i7 = this.f11423b;
        this.f11423b = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 8);
        int i8 = this.f11423b;
        this.f11423b = i8 + 1;
        return j6 | (255 & ((long) bArr[i8]));
    }

    public long q() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.f11423b;
        this.f11423b = i3 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.f11423b;
        this.f11423b = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 24);
        int i5 = this.f11423b;
        this.f11423b = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 32);
        int i6 = this.f11423b;
        this.f11423b = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 40);
        int i7 = this.f11423b;
        this.f11423b = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 48);
        int i8 = this.f11423b;
        this.f11423b = i8 + 1;
        return j6 | ((255 & ((long) bArr[i8])) << 56);
    }

    public int r() {
        byte[] bArr = this.f11422a;
        int i = this.f11423b;
        this.f11423b = i + 1;
        int i2 = this.f11423b;
        this.f11423b = i2 + 1;
        byte b2 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.f11423b += 2;
        return b2;
    }

    public int s() {
        return (g() << 21) | (g() << 14) | (g() << 7) | g();
    }

    public int t() {
        int n = n();
        if (n >= 0) {
            return n;
        }
        throw new IllegalStateException("Top bit not zero: " + n);
    }

    public int u() {
        int o = o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public long v() {
        long p = p();
        if (p >= 0) {
            return p;
        }
        throw new IllegalStateException("Top bit not zero: " + p);
    }

    public double w() {
        return Double.longBitsToDouble(p());
    }

    public String e(int i) {
        return a(i, Charset.defaultCharset());
    }

    public String a(int i, Charset charset) {
        String str = new String(this.f11422a, this.f11423b, i, charset);
        this.f11423b += i;
        return str;
    }

    public String f(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.f11423b + i) - 1;
        String str = new String(this.f11422a, this.f11423b, (i2 >= this.f11424c || this.f11422a[i2] != 0) ? i : i - 1);
        this.f11423b += i;
        return str;
    }

    public String x() {
        if (b() == 0) {
            return null;
        }
        int i = this.f11423b;
        while (i < this.f11424c && this.f11422a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f11422a;
        int i2 = this.f11423b;
        String str = new String(bArr, i2, i - i2);
        this.f11423b = i;
        int i3 = this.f11423b;
        if (i3 < this.f11424c) {
            this.f11423b = i3 + 1;
        }
        return str;
    }

    public String y() {
        if (b() == 0) {
            return null;
        }
        int i = this.f11423b;
        while (i < this.f11424c && !v.a((int) this.f11422a[i])) {
            i++;
        }
        int i2 = this.f11423b;
        if (i - i2 >= 3) {
            byte[] bArr = this.f11422a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f11423b = i2 + 3;
            }
        }
        byte[] bArr2 = this.f11422a;
        int i3 = this.f11423b;
        String str = new String(bArr2, i3, i - i3);
        this.f11423b = i;
        int i4 = this.f11423b;
        int i5 = this.f11424c;
        if (i4 == i5) {
            return str;
        }
        if (this.f11422a[i4] == 13) {
            this.f11423b = i4 + 1;
            if (this.f11423b == i5) {
                return str;
            }
        }
        byte[] bArr3 = this.f11422a;
        int i6 = this.f11423b;
        if (bArr3[i6] == 10) {
            this.f11423b = i6 + 1;
        }
        return str;
    }

    public long z() {
        int i;
        int i2;
        long j = (long) this.f11422a[this.f11423b];
        int i3 = 7;
        while (true) {
            i = 1;
            if (i3 < 0) {
                break;
            }
            int i4 = 1 << i3;
            if ((((long) i4) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= (long) (i4 - 1);
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 != 0) {
            while (i < i2) {
                byte b2 = this.f11422a[this.f11423b + i];
                if ((b2 & 192) == 128) {
                    j = (j << 6) | ((long) (b2 & 63));
                    i++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                }
            }
            this.f11423b += i2;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
    }
}
