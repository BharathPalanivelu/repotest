package com.google.c;

import com.google.c.ax;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class h extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f13722a = Logger.getLogger(h.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f13723b = aw.a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final long f13724c = aw.c();

    public static int b(double d2) {
        return 8;
    }

    public static int b(float f2) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int g(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int i(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int i(long j) {
        return 8;
    }

    public static int j(long j) {
        return 8;
    }

    public static int k(int i) {
        return 4;
    }

    public static long k(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int l(int i) {
        return 4;
    }

    public static int o(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int a();

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i) throws IOException;

    public abstract void a(int i, int i2) throws IOException;

    public abstract void a(int i, ad adVar) throws IOException;

    public abstract void a(int i, f fVar) throws IOException;

    public abstract void a(int i, String str) throws IOException;

    public abstract void a(int i, boolean z) throws IOException;

    public abstract void a(ad adVar) throws IOException;

    public abstract void a(f fVar) throws IOException;

    public abstract void a(String str) throws IOException;

    public abstract void a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void b(int i) throws IOException;

    public abstract void b(int i, int i2) throws IOException;

    public abstract void b(int i, long j) throws IOException;

    public abstract void b(int i, ad adVar) throws IOException;

    public abstract void b(int i, f fVar) throws IOException;

    public abstract void b(long j) throws IOException;

    public abstract void c(int i, int i2) throws IOException;

    public abstract void c(int i, long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void c(byte[] bArr, int i, int i2) throws IOException;

    public abstract void d(int i) throws IOException;

    public abstract void d(long j) throws IOException;

    public static h a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static h b(byte[] bArr, int i, int i2) {
        return new a(bArr, i, i2);
    }

    private h() {
    }

    public final void a(int i, long j) throws IOException {
        b(i, j);
    }

    public final void a(int i, double d2) throws IOException {
        c(i, Double.doubleToRawLongBits(d2));
    }

    public final void d(int i, int i2) throws IOException {
        b(i, i2);
    }

    public final void c(int i) throws IOException {
        b(o(i));
    }

    public final void e(int i) throws IOException {
        d(i);
    }

    public final void a(long j) throws IOException {
        b(j);
    }

    public final void c(long j) throws IOException {
        b(k(j));
    }

    public final void e(long j) throws IOException {
        d(j);
    }

    public final void a(float f2) throws IOException {
        d(Float.floatToRawIntBits(f2));
    }

    public final void a(double d2) throws IOException {
        d(Double.doubleToRawLongBits(d2));
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : 0);
    }

    public final void f(int i) throws IOException {
        a(i);
    }

    public final void b(byte[] bArr) throws IOException {
        c(bArr, 0, bArr.length);
    }

    public static int e(int i, int i2) {
        return g(i) + h(i2);
    }

    public static int f(int i, int i2) {
        return g(i) + i(i2);
    }

    public static int g(int i, int i2) {
        return g(i) + k(i2);
    }

    public static int d(int i, long j) {
        return g(i) + f(j);
    }

    public static int e(int i, long j) {
        return g(i) + g(j);
    }

    public static int f(int i, long j) {
        return g(i) + i(j);
    }

    public static int b(int i, double d2) {
        return g(i) + b(d2);
    }

    public static int b(int i, boolean z) {
        return g(i) + b(z);
    }

    public static int h(int i, int i2) {
        return g(i) + m(i2);
    }

    public static int b(int i, String str) {
        return g(i) + b(str);
    }

    public static int c(int i, f fVar) {
        return g(i) + b(fVar);
    }

    public static int a(int i, x xVar) {
        return g(i) + a(xVar);
    }

    public static int c(int i, ad adVar) {
        return g(i) + b(adVar);
    }

    public static int d(int i, ad adVar) {
        return (g(1) * 2) + f(2, i) + c(3, adVar);
    }

    public static int d(int i, f fVar) {
        return (g(1) * 2) + f(2, i) + c(3, fVar);
    }

    public static int b(int i, x xVar) {
        return (g(1) * 2) + f(2, i) + a(3, xVar);
    }

    public static int g(int i) {
        return i(ay.a(i, 0));
    }

    public static int h(int i) {
        if (i >= 0) {
            return i(i);
        }
        return 10;
    }

    public static int j(int i) {
        return i(o(i));
    }

    public static int f(long j) {
        return g(j);
    }

    public static int h(long j) {
        return g(k(j));
    }

    public static int m(int i) {
        return h(i);
    }

    public static int b(String str) {
        int i;
        try {
            i = ax.a((CharSequence) str);
        } catch (ax.c unused) {
            i = str.getBytes(u.f14058a).length;
        }
        return n(i);
    }

    public static int a(x xVar) {
        return n(xVar.b());
    }

    public static int b(f fVar) {
        return n(fVar.b());
    }

    public static int c(byte[] bArr) {
        return n(bArr.length);
    }

    public static int b(ad adVar) {
        return n(adVar.b());
    }

    static int n(int i) {
        return i(i) + i;
    }

    public final void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static class b extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        b() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        b(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, ax.c cVar) throws IOException {
        f13722a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", cVar);
        byte[] bytes = str.getBytes(u.f14058a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new b(e2);
        } catch (b e3) {
            throw e3;
        }
    }

    @Deprecated
    public final void e(int i, ad adVar) throws IOException {
        a(i, 3);
        c(adVar);
        a(i, 4);
    }

    @Deprecated
    public final void c(ad adVar) throws IOException {
        adVar.a(this);
    }

    @Deprecated
    public static int f(int i, ad adVar) {
        return (g(i) * 2) + d(adVar);
    }

    @Deprecated
    public static int d(ad adVar) {
        return adVar.b();
    }

    @Deprecated
    public final void p(int i) throws IOException {
        b(i);
    }

    @Deprecated
    public static int q(int i) {
        return i(i);
    }

    private static class a extends h {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f13725a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13726b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13727c;

        /* renamed from: d  reason: collision with root package name */
        private int f13728d;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f13725a = bArr;
                    this.f13726b = i;
                    this.f13728d = i;
                    this.f13727c = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void a(int i, int i2) throws IOException {
            b(ay.a(i, i2));
        }

        public final void b(int i, int i2) throws IOException {
            a(i, 0);
            a(i2);
        }

        public final void i(int i, int i2) throws IOException {
            a(i, 0);
            b(i2);
        }

        public final void c(int i, int i2) throws IOException {
            a(i, 5);
            d(i2);
        }

        public final void b(int i, long j) throws IOException {
            a(i, 0);
            b(j);
        }

        public final void c(int i, long j) throws IOException {
            a(i, 1);
            d(j);
        }

        public final void a(int i, boolean z) throws IOException {
            a(i, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void a(int i, String str) throws IOException {
            a(i, 2);
            a(str);
        }

        public final void a(int i, f fVar) throws IOException {
            a(i, 2);
            a(fVar);
        }

        public final void a(f fVar) throws IOException {
            b(fVar.b());
            fVar.a((e) this);
        }

        public final void c(byte[] bArr, int i, int i2) throws IOException {
            b(i2);
            d(bArr, i, i2);
        }

        public final void a(int i, ad adVar) throws IOException {
            a(i, 2);
            a(adVar);
        }

        public final void b(int i, ad adVar) throws IOException {
            a(1, 3);
            i(2, i);
            a(3, adVar);
            a(1, 4);
        }

        public final void b(int i, f fVar) throws IOException {
            a(1, 3);
            i(2, i);
            a(3, fVar);
            a(1, 4);
        }

        public final void a(ad adVar) throws IOException {
            b(adVar.b());
            adVar.a(this);
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f13725a;
                int i = this.f13728d;
                this.f13728d = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f13728d), Integer.valueOf(this.f13727c), 1}), e2);
            }
        }

        public final void a(int i) throws IOException {
            if (i >= 0) {
                b(i);
            } else {
                b((long) i);
            }
        }

        public final void b(int i) throws IOException {
            if (!h.f13723b || a() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f13725a;
                    int i2 = this.f13728d;
                    this.f13728d = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f13725a;
                    int i3 = this.f13728d;
                    this.f13728d = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f13728d), Integer.valueOf(this.f13727c), 1}), e2);
                }
            } else {
                long d2 = h.f13724c + ((long) this.f13728d);
                while ((i & -128) != 0) {
                    aw.a(this.f13725a, d2, (byte) ((i & 127) | 128));
                    this.f13728d++;
                    i >>>= 7;
                    d2 = 1 + d2;
                }
                aw.a(this.f13725a, d2, (byte) i);
                this.f13728d++;
            }
        }

        public final void d(int i) throws IOException {
            try {
                byte[] bArr = this.f13725a;
                int i2 = this.f13728d;
                this.f13728d = i2 + 1;
                bArr[i2] = (byte) (i & 255);
                byte[] bArr2 = this.f13725a;
                int i3 = this.f13728d;
                this.f13728d = i3 + 1;
                bArr2[i3] = (byte) ((i >> 8) & 255);
                byte[] bArr3 = this.f13725a;
                int i4 = this.f13728d;
                this.f13728d = i4 + 1;
                bArr3[i4] = (byte) ((i >> 16) & 255);
                byte[] bArr4 = this.f13725a;
                int i5 = this.f13728d;
                this.f13728d = i5 + 1;
                bArr4[i5] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f13728d), Integer.valueOf(this.f13727c), 1}), e2);
            }
        }

        public final void b(long j) throws IOException {
            if (!h.f13723b || a() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f13725a;
                    int i = this.f13728d;
                    this.f13728d = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f13725a;
                    int i2 = this.f13728d;
                    this.f13728d = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f13728d), Integer.valueOf(this.f13727c), 1}), e2);
                }
            } else {
                long d2 = h.f13724c + ((long) this.f13728d);
                while ((j & -128) != 0) {
                    aw.a(this.f13725a, d2, (byte) ((((int) j) & 127) | 128));
                    this.f13728d++;
                    j >>>= 7;
                    d2 = 1 + d2;
                }
                aw.a(this.f13725a, d2, (byte) ((int) j));
                this.f13728d++;
            }
        }

        public final void d(long j) throws IOException {
            try {
                byte[] bArr = this.f13725a;
                int i = this.f13728d;
                this.f13728d = i + 1;
                bArr[i] = (byte) (((int) j) & 255);
                byte[] bArr2 = this.f13725a;
                int i2 = this.f13728d;
                this.f13728d = i2 + 1;
                bArr2[i2] = (byte) (((int) (j >> 8)) & 255);
                byte[] bArr3 = this.f13725a;
                int i3 = this.f13728d;
                this.f13728d = i3 + 1;
                bArr3[i3] = (byte) (((int) (j >> 16)) & 255);
                byte[] bArr4 = this.f13725a;
                int i4 = this.f13728d;
                this.f13728d = i4 + 1;
                bArr4[i4] = (byte) (((int) (j >> 24)) & 255);
                byte[] bArr5 = this.f13725a;
                int i5 = this.f13728d;
                this.f13728d = i5 + 1;
                bArr5[i5] = (byte) (((int) (j >> 32)) & 255);
                byte[] bArr6 = this.f13725a;
                int i6 = this.f13728d;
                this.f13728d = i6 + 1;
                bArr6[i6] = (byte) (((int) (j >> 40)) & 255);
                byte[] bArr7 = this.f13725a;
                int i7 = this.f13728d;
                this.f13728d = i7 + 1;
                bArr7[i7] = (byte) (((int) (j >> 48)) & 255);
                byte[] bArr8 = this.f13725a;
                int i8 = this.f13728d;
                this.f13728d = i8 + 1;
                bArr8[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f13728d), Integer.valueOf(this.f13727c), 1}), e2);
            }
        }

        public final void d(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f13725a, this.f13728d, i2);
                this.f13728d += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f13728d), Integer.valueOf(this.f13727c), Integer.valueOf(i2)}), e2);
            }
        }

        public final void a(byte[] bArr, int i, int i2) throws IOException {
            d(bArr, i, i2);
        }

        public final void a(String str) throws IOException {
            int i = this.f13728d;
            try {
                int i2 = i(str.length() * 3);
                int i3 = i(str.length());
                if (i3 == i2) {
                    this.f13728d = i + i3;
                    int a2 = ax.a(str, this.f13725a, this.f13728d, a());
                    this.f13728d = i;
                    b((a2 - i) - i3);
                    this.f13728d = a2;
                    return;
                }
                b(ax.a((CharSequence) str));
                this.f13728d = ax.a(str, this.f13725a, this.f13728d, a());
            } catch (ax.c e2) {
                this.f13728d = i;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new b(e3);
            }
        }

        public final int a() {
            return this.f13727c - this.f13728d;
        }
    }
}
