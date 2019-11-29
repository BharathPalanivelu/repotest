package com.google.c;

import com.google.c.ad;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13715a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13716b;

    /* renamed from: c  reason: collision with root package name */
    private int f13717c;

    /* renamed from: d  reason: collision with root package name */
    private int f13718d;

    /* renamed from: e  reason: collision with root package name */
    private int f13719e;

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f13720f;

    /* renamed from: g  reason: collision with root package name */
    private int f13721g;
    private boolean h = false;
    private int i;
    private int j = Integer.MAX_VALUE;
    private int k;
    private int l = 100;
    private int m = 67108864;
    private a n = null;

    private interface a {
        void a();
    }

    public static long a(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static int c(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static g a(InputStream inputStream) {
        return new g(inputStream, 4096);
    }

    public static g a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static g a(byte[] bArr, int i2, int i3) {
        return a(bArr, i2, i3, false);
    }

    static g a(byte[] bArr, int i2, int i3, boolean z) {
        g gVar = new g(bArr, i2, i3, z);
        try {
            gVar.d(i3);
            return gVar;
        } catch (v e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public int a() throws IOException {
        if (z()) {
            this.f13721g = 0;
            return 0;
        }
        this.f13721g = t();
        if (ay.b(this.f13721g) != 0) {
            return this.f13721g;
        }
        throw v.f();
    }

    public void a(int i2) throws v {
        if (this.f13721g != i2) {
            throw v.g();
        }
    }

    public boolean b(int i2) throws IOException {
        int a2 = ay.a(i2);
        if (a2 == 0) {
            B();
            return true;
        } else if (a2 == 1) {
            f(8);
            return true;
        } else if (a2 == 2) {
            f(t());
            return true;
        } else if (a2 == 3) {
            b();
            a(ay.a(ay.b(i2), 4));
            return true;
        } else if (a2 == 4) {
            return false;
        } else {
            if (a2 == 5) {
                f(4);
                return true;
            }
            throw v.h();
        }
    }

    public void b() throws IOException {
        int a2;
        do {
            a2 = a();
            if (a2 == 0) {
                return;
            }
        } while (b(a2));
    }

    public double c() throws IOException {
        return Double.longBitsToDouble(x());
    }

    public float d() throws IOException {
        return Float.intBitsToFloat(w());
    }

    public long e() throws IOException {
        return u();
    }

    public long f() throws IOException {
        return u();
    }

    public int g() throws IOException {
        return t();
    }

    public long h() throws IOException {
        return x();
    }

    public int i() throws IOException {
        return w();
    }

    public boolean j() throws IOException {
        return u() != 0;
    }

    public String k() throws IOException {
        int t = t();
        int i2 = this.f13717c;
        int i3 = this.f13719e;
        if (t <= i2 - i3 && t > 0) {
            String str = new String(this.f13715a, i3, t, u.f14058a);
            this.f13719e += t;
            return str;
        } else if (t == 0) {
            return "";
        } else {
            if (t > this.f13717c) {
                return new String(i(t), u.f14058a);
            }
            g(t);
            String str2 = new String(this.f13715a, this.f13719e, t, u.f14058a);
            this.f13719e += t;
            return str2;
        }
    }

    public String l() throws IOException {
        byte[] bArr;
        int t = t();
        int i2 = this.f13719e;
        int i3 = 0;
        if (t <= this.f13717c - i2 && t > 0) {
            bArr = this.f13715a;
            this.f13719e = i2 + t;
            i3 = i2;
        } else if (t == 0) {
            return "";
        } else {
            if (t <= this.f13717c) {
                g(t);
                bArr = this.f13715a;
                this.f13719e = t + 0;
            } else {
                bArr = i(t);
            }
        }
        if (ax.a(bArr, i3, i3 + t)) {
            return new String(bArr, i3, t, u.f14058a);
        }
        throw v.k();
    }

    public void a(int i2, ad.a aVar, p pVar) throws IOException {
        int i3 = this.k;
        if (i3 < this.l) {
            this.k = i3 + 1;
            aVar.c(this, pVar);
            a(ay.a(i2, 4));
            this.k--;
            return;
        }
        throw v.i();
    }

    public void a(ad.a aVar, p pVar) throws IOException {
        int t = t();
        if (this.k < this.l) {
            int d2 = d(t);
            this.k++;
            aVar.c(this, pVar);
            a(0);
            this.k--;
            e(d2);
            return;
        }
        throw v.i();
    }

    public <T extends ad> T a(aj<T> ajVar, p pVar) throws IOException {
        int t = t();
        if (this.k < this.l) {
            int d2 = d(t);
            this.k++;
            T t2 = (ad) ajVar.b(this, pVar);
            a(0);
            this.k--;
            e(d2);
            return t2;
        }
        throw v.i();
    }

    public f m() throws IOException {
        f fVar;
        int t = t();
        int i2 = this.f13717c;
        int i3 = this.f13719e;
        if (t <= i2 - i3 && t > 0) {
            if (!this.f13716b || !this.h) {
                fVar = f.a(this.f13715a, this.f13719e, t);
            } else {
                fVar = f.b(this.f13715a, i3, t);
            }
            this.f13719e += t;
            return fVar;
        } else if (t == 0) {
            return f.f13707a;
        } else {
            return f.b(i(t));
        }
    }

    public int n() throws IOException {
        return t();
    }

    public int o() throws IOException {
        return t();
    }

    public int p() throws IOException {
        return w();
    }

    public long q() throws IOException {
        return x();
    }

    public int r() throws IOException {
        return c(t());
    }

    public long s() throws IOException {
        return a(u());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r2[r3] < 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int t() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f13719e
            int r1 = r5.f13717c
            if (r1 != r0) goto L_0x0007
            goto L_0x006a
        L_0x0007:
            byte[] r2 = r5.f13715a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.f13719e = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x0018
            goto L_0x006a
        L_0x0018:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0070
        L_0x0024:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r1 = r3
            goto L_0x0070
        L_0x0031:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0070
        L_0x003f:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x0070
        L_0x006a:
            long r0 = r5.v()
            int r1 = (int) r0
            return r1
        L_0x0070:
            r5.f13719e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.g.t():int");
    }

    private void B() throws IOException {
        int i2 = this.f13717c;
        int i3 = this.f13719e;
        if (i2 - i3 >= 10) {
            byte[] bArr = this.f13715a;
            int i4 = 0;
            while (i4 < 10) {
                int i5 = i3 + 1;
                if (bArr[i3] >= 0) {
                    this.f13719e = i5;
                    return;
                } else {
                    i4++;
                    i3 = i5;
                }
            }
        }
        C();
    }

    private void C() throws IOException {
        int i2 = 0;
        while (i2 < 10) {
            if (A() < 0) {
                i2++;
            } else {
                return;
            }
        }
        throw v.e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long u() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f13719e
            int r1 = r11.f13717c
            if (r1 != r0) goto L_0x0008
            goto L_0x00b6
        L_0x0008:
            byte[] r2 = r11.f13715a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0014
            r11.f13719e = r3
            long r0 = (long) r0
            return r0
        L_0x0014:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x001b
            goto L_0x00b6
        L_0x001b:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x002a
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0026:
            long r2 = (long) r0
            r3 = r2
            goto L_0x00bb
        L_0x002a:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x003b
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r3 = r9
            goto L_0x00bb
        L_0x003b:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0049
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0026
        L_0x0049:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0060
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x005c:
            long r1 = r1 ^ r3
            r3 = r1
        L_0x005e:
            r1 = r0
            goto L_0x00bb
        L_0x0060:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0074
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x0072:
            long r3 = r3 ^ r5
            goto L_0x00bb
        L_0x0074:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0087
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x005c
        L_0x0087:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x009a
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x0072
        L_0x009a:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x005e
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00bb
        L_0x00b6:
            long r0 = r11.v()
            return r0
        L_0x00bb:
            r11.f13719e = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.g.u():long");
    }

    /* access modifiers changed from: package-private */
    public long v() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte A = A();
            j2 |= ((long) (A & Byte.MAX_VALUE)) << i2;
            if ((A & 128) == 0) {
                return j2;
            }
        }
        throw v.e();
    }

    public int w() throws IOException {
        int i2 = this.f13719e;
        if (this.f13717c - i2 < 4) {
            g(4);
            i2 = this.f13719e;
        }
        byte[] bArr = this.f13715a;
        this.f13719e = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long x() throws IOException {
        int i2 = this.f13719e;
        if (this.f13717c - i2 < 8) {
            g(8);
            i2 = this.f13719e;
        }
        byte[] bArr = this.f13715a;
        this.f13719e = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    private g(byte[] bArr, int i2, int i3, boolean z) {
        this.f13715a = bArr;
        this.f13717c = i3 + i2;
        this.f13719e = i2;
        this.i = -i2;
        this.f13720f = null;
        this.f13716b = z;
    }

    private g(InputStream inputStream, int i2) {
        this.f13715a = new byte[i2];
        this.f13719e = 0;
        this.i = 0;
        this.f13720f = inputStream;
        this.f13716b = false;
    }

    public int d(int i2) throws v {
        if (i2 >= 0) {
            int i3 = i2 + this.i + this.f13719e;
            int i4 = this.j;
            if (i3 <= i4) {
                this.j = i3;
                D();
                return i4;
            }
            throw v.c();
        }
        throw v.d();
    }

    private void D() {
        this.f13717c += this.f13718d;
        int i2 = this.i;
        int i3 = this.f13717c;
        int i4 = i2 + i3;
        int i5 = this.j;
        if (i4 > i5) {
            this.f13718d = i4 - i5;
            this.f13717c = i3 - this.f13718d;
            return;
        }
        this.f13718d = 0;
    }

    public void e(int i2) {
        this.j = i2;
        D();
    }

    public int y() {
        int i2 = this.j;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.i + this.f13719e);
    }

    public boolean z() throws IOException {
        return this.f13719e == this.f13717c && !h(1);
    }

    private void g(int i2) throws IOException {
        if (!h(i2)) {
            throw v.c();
        }
    }

    private boolean h(int i2) throws IOException {
        int i3 = this.f13719e;
        if (i3 + i2 <= this.f13717c) {
            throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
        } else if (this.i + i3 + i2 > this.j) {
            return false;
        } else {
            a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f13720f != null) {
                int i4 = this.f13719e;
                if (i4 > 0) {
                    int i5 = this.f13717c;
                    if (i5 > i4) {
                        byte[] bArr = this.f13715a;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.i += i4;
                    this.f13717c -= i4;
                    this.f13719e = 0;
                }
                InputStream inputStream = this.f13720f;
                byte[] bArr2 = this.f13715a;
                int i6 = this.f13717c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.f13715a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read > 0) {
                    this.f13717c += read;
                    if ((this.i + i2) - this.m <= 0) {
                        D();
                        if (this.f13717c >= i2) {
                            return true;
                        }
                        return h(i2);
                    }
                    throw v.j();
                }
            }
            return false;
        }
    }

    public byte A() throws IOException {
        if (this.f13719e == this.f13717c) {
            g(1);
        }
        byte[] bArr = this.f13715a;
        int i2 = this.f13719e;
        this.f13719e = i2 + 1;
        return bArr[i2];
    }

    private byte[] i(int i2) throws IOException {
        if (i2 > 0) {
            int i3 = this.i;
            int i4 = this.f13719e;
            int i5 = i3 + i4 + i2;
            if (i5 <= this.m) {
                int i6 = this.j;
                if (i5 <= i6) {
                    InputStream inputStream = this.f13720f;
                    if (inputStream != null) {
                        int i7 = this.f13717c;
                        int i8 = i7 - i4;
                        this.i = i3 + i7;
                        this.f13719e = 0;
                        this.f13717c = 0;
                        int i9 = i2 - i8;
                        if (i9 < 4096 || i9 <= inputStream.available()) {
                            byte[] bArr = new byte[i2];
                            System.arraycopy(this.f13715a, i4, bArr, 0, i8);
                            while (i8 < bArr.length) {
                                int read = this.f13720f.read(bArr, i8, i2 - i8);
                                if (read != -1) {
                                    this.i += read;
                                    i8 += read;
                                } else {
                                    throw v.c();
                                }
                            }
                            return bArr;
                        }
                        ArrayList<byte[]> arrayList = new ArrayList<>();
                        while (i9 > 0) {
                            byte[] bArr2 = new byte[Math.min(i9, 4096)];
                            int i10 = 0;
                            while (i10 < bArr2.length) {
                                int read2 = this.f13720f.read(bArr2, i10, bArr2.length - i10);
                                if (read2 != -1) {
                                    this.i += read2;
                                    i10 += read2;
                                } else {
                                    throw v.c();
                                }
                            }
                            i9 -= bArr2.length;
                            arrayList.add(bArr2);
                        }
                        byte[] bArr3 = new byte[i2];
                        System.arraycopy(this.f13715a, i4, bArr3, 0, i8);
                        for (byte[] bArr4 : arrayList) {
                            System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                            i8 += bArr4.length;
                        }
                        return bArr3;
                    }
                    throw v.c();
                }
                f((i6 - i3) - i4);
                throw v.c();
            }
            throw v.j();
        } else if (i2 == 0) {
            return u.f14060c;
        } else {
            throw v.d();
        }
    }

    public void f(int i2) throws IOException {
        int i3 = this.f13717c;
        int i4 = this.f13719e;
        if (i2 > i3 - i4 || i2 < 0) {
            j(i2);
        } else {
            this.f13719e = i4 + i2;
        }
    }

    private void j(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.i;
            int i4 = this.f13719e;
            int i5 = i3 + i4 + i2;
            int i6 = this.j;
            if (i5 <= i6) {
                int i7 = this.f13717c;
                int i8 = i7 - i4;
                this.f13719e = i7;
                g(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.f13717c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.f13719e = i10;
                        g(1);
                    } else {
                        this.f13719e = i9;
                        return;
                    }
                }
            } else {
                f((i6 - i3) - i4);
                throw v.c();
            }
        } else {
            throw v.d();
        }
    }
}
