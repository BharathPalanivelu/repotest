package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.n.a;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private final int f9047a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9048b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9049c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9050d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9051e = (this.f9050d * 2);

    /* renamed from: f  reason: collision with root package name */
    private final short[] f9052f;

    /* renamed from: g  reason: collision with root package name */
    private int f9053g;
    private short[] h;
    private int i;
    private short[] j;
    private int k;
    private short[] l;
    private int m;
    private int n;
    private float o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;

    public j(int i2, int i3) {
        this.f9047a = i2;
        this.f9048b = i3;
        this.f9049c = i2 / 400;
        this.f9050d = i2 / 65;
        int i4 = this.f9051e;
        this.f9052f = new short[i4];
        this.f9053g = i4;
        this.h = new short[(i4 * i3)];
        this.i = i4;
        this.j = new short[(i4 * i3)];
        this.k = i4;
        this.l = new short[(i4 * i3)];
        this.m = 0;
        this.n = 0;
        this.u = 0;
        this.o = 1.0f;
        this.p = 1.0f;
    }

    public void a(float f2) {
        this.o = f2;
    }

    public void b(float f2) {
        this.p = f2;
    }

    public void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.f9048b;
        int i3 = remaining / i2;
        b(i3);
        shortBuffer.get(this.h, this.q * this.f9048b, ((i2 * i3) * 2) / 2);
        this.q += i3;
        c();
    }

    public void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f9048b, this.r);
        shortBuffer.put(this.j, 0, this.f9048b * min);
        this.r -= min;
        short[] sArr = this.j;
        int i2 = this.f9048b;
        System.arraycopy(sArr, min * i2, sArr, 0, this.r * i2);
    }

    public void a() {
        int i2;
        int i3 = this.q;
        float f2 = this.o;
        float f3 = this.p;
        int i4 = this.r + ((int) ((((((float) i3) / (f2 / f3)) + ((float) this.s)) / f3) + 0.5f));
        b((this.f9051e * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f9051e;
            int i6 = this.f9048b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.h[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.q += i2 * 2;
        c();
        if (this.r > i4) {
            this.r = i4;
        }
        this.q = 0;
        this.t = 0;
        this.s = 0;
    }

    public int b() {
        return this.r;
    }

    private void a(int i2) {
        int i3 = this.r + i2;
        int i4 = this.i;
        if (i3 > i4) {
            this.i = i4 + (i4 / 2) + i2;
            this.j = Arrays.copyOf(this.j, this.i * this.f9048b);
        }
    }

    private void b(int i2) {
        int i3 = this.q + i2;
        int i4 = this.f9053g;
        if (i3 > i4) {
            this.f9053g = i4 + (i4 / 2) + i2;
            this.h = Arrays.copyOf(this.h, this.f9053g * this.f9048b);
        }
    }

    private void c(int i2) {
        int i3 = this.q - i2;
        short[] sArr = this.h;
        int i4 = this.f9048b;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.q = i3;
    }

    private void a(short[] sArr, int i2, int i3) {
        a(i3);
        int i4 = this.f9048b;
        System.arraycopy(sArr, i2 * i4, this.j, this.r * i4, i4 * i3);
        this.r += i3;
    }

    private int d(int i2) {
        int min = Math.min(this.f9051e, this.t);
        a(this.h, i2, min);
        this.t -= min;
        return min;
    }

    private void b(short[] sArr, int i2, int i3) {
        int i4 = this.f9051e / i3;
        int i5 = this.f9048b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f9052f[i8] = (short) (i9 / i6);
        }
    }

    private int a(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f9048b;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 255;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                short s2 = sArr[i5 + i11];
                short s3 = sArr[i5 + i3 + i11];
                i10 += s2 >= s3 ? s2 - s3 : s3 - s2;
            }
            if (i10 * i7 < i6 * i3) {
                i7 = i3;
                i6 = i10;
            }
            if (i10 * i9 > i8 * i3) {
                i9 = i3;
                i8 = i10;
            }
            i3++;
        }
        this.w = i6 / i7;
        this.x = i8 / i9;
        return i7;
    }

    private boolean a(int i2, int i3, boolean z) {
        if (i2 == 0 || this.u == 0) {
            return false;
        }
        if (z) {
            if (i3 <= i2 * 3 && i2 * 2 > this.v * 3) {
                return true;
            }
            return false;
        } else if (i2 <= this.v) {
            return false;
        } else {
            return true;
        }
    }

    private int a(short[] sArr, int i2, boolean z) {
        int i3;
        int i4 = this.f9047a;
        int i5 = i4 > 4000 ? i4 / 4000 : 1;
        if (this.f9048b == 1 && i5 == 1) {
            i3 = a(sArr, i2, this.f9049c, this.f9050d);
        } else {
            b(sArr, i2, i5);
            int a2 = a(this.f9052f, 0, this.f9049c / i5, this.f9050d / i5);
            if (i5 != 1) {
                int i6 = a2 * i5;
                int i7 = i5 * 4;
                int i8 = i6 - i7;
                int i9 = i6 + i7;
                int i10 = this.f9049c;
                if (i8 >= i10) {
                    i10 = i8;
                }
                int i11 = this.f9050d;
                if (i9 > i11) {
                    i9 = i11;
                }
                if (this.f9048b == 1) {
                    i3 = a(sArr, i2, i10, i9);
                } else {
                    b(sArr, i2, 1);
                    i3 = a(this.f9052f, 0, i10, i9);
                }
            } else {
                i3 = a2;
            }
        }
        int i12 = a(this.w, this.x, z) ? this.u : i3;
        this.v = this.w;
        this.u = i3;
        return i12;
    }

    private void e(int i2) {
        int i3 = this.r - i2;
        int i4 = this.s + i3;
        int i5 = this.k;
        if (i4 > i5) {
            this.k = i5 + (i5 / 2) + i3;
            this.l = Arrays.copyOf(this.l, this.k * this.f9048b);
        }
        short[] sArr = this.j;
        int i6 = this.f9048b;
        System.arraycopy(sArr, i2 * i6, this.l, this.s * i6, i6 * i3);
        this.r = i2;
        this.s += i3;
    }

    private void f(int i2) {
        if (i2 != 0) {
            short[] sArr = this.l;
            int i3 = this.f9048b;
            System.arraycopy(sArr, i2 * i3, sArr, 0, (this.s - i2) * i3);
            this.s -= i2;
        }
    }

    private short b(short[] sArr, int i2, int i3, int i4) {
        short s2 = sArr[i2];
        short s3 = sArr[i2 + this.f9048b];
        int i5 = this.n * i3;
        int i6 = this.m;
        int i7 = i6 * i4;
        int i8 = (i6 + 1) * i4;
        int i9 = i8 - i5;
        int i10 = i8 - i7;
        return (short) (((s2 * i9) + ((i10 - i9) * s3)) / i10);
    }

    private void a(float f2, int i2) {
        int i3;
        int i4;
        if (this.r != i2) {
            int i5 = this.f9047a;
            int i6 = (int) (((float) i5) / f2);
            while (true) {
                if (i6 <= 16384 && i5 <= 16384) {
                    break;
                }
                i6 /= 2;
                i5 /= 2;
            }
            e(i2);
            int i7 = 0;
            while (true) {
                int i8 = this.s;
                boolean z = true;
                if (i7 < i8 - 1) {
                    while (true) {
                        i3 = this.m;
                        int i9 = (i3 + 1) * i6;
                        i4 = this.n;
                        if (i9 <= i4 * i5) {
                            break;
                        }
                        a(1);
                        int i10 = 0;
                        while (true) {
                            int i11 = this.f9048b;
                            if (i10 >= i11) {
                                break;
                            }
                            this.j[(this.r * i11) + i10] = b(this.l, (i11 * i7) + i10, i5, i6);
                            i10++;
                        }
                        this.n++;
                        this.r++;
                    }
                    this.m = i3 + 1;
                    if (this.m == i5) {
                        this.m = 0;
                        if (i4 != i6) {
                            z = false;
                        }
                        a.b(z);
                        this.n = 0;
                    }
                    i7++;
                } else {
                    f(i8 - 1);
                    return;
                }
            }
        }
    }

    private int a(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (((float) i3) / (f2 - 1.0f));
        } else {
            this.t = (int) ((((float) i3) * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        a(i4);
        a(i4, this.f9048b, this.j, this.r, sArr, i2, sArr, i2 + i3);
        this.r += i4;
        return i4;
    }

    private int b(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((((float) i3) * f2) / (1.0f - f2));
        } else {
            this.t = (int) ((((float) i3) * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        int i5 = i3 + i4;
        a(i5);
        int i6 = this.f9048b;
        System.arraycopy(sArr, i2 * i6, this.j, this.r * i6, i6 * i3);
        a(i4, this.f9048b, this.j, this.r + i3, sArr, i2 + i3, sArr, i2);
        this.r += i5;
        return i4;
    }

    private void c(float f2) {
        int b2;
        int i2 = this.q;
        if (i2 >= this.f9051e) {
            int i3 = 0;
            do {
                if (this.t > 0) {
                    b2 = d(i3);
                } else {
                    int a2 = a(this.h, i3, true);
                    if (((double) f2) > 1.0d) {
                        b2 = a2 + a(this.h, i3, f2, a2);
                    } else {
                        b2 = b(this.h, i3, f2, a2);
                    }
                }
                i3 += b2;
            } while (this.f9051e + i3 <= i2);
            c(i3);
        }
    }

    private void c() {
        int i2 = this.r;
        float f2 = this.o / this.p;
        double d2 = (double) f2;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            c(f2);
        } else {
            a(this.h, 0, this.q);
            this.q = 0;
        }
        float f3 = this.p;
        if (f3 != 1.0f) {
            a(f3, i2);
        }
    }

    private static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i5 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i4 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i10] = (short) (((sArr2[i8] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i10 += i3;
                i8 += i3;
                i9 += i3;
            }
        }
    }
}
