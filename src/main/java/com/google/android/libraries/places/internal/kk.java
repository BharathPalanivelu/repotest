package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class kk extends kb {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f12871a = Logger.getLogger(kk.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f12872b = nk.f13028c;

    /* renamed from: c  reason: collision with root package name */
    public nt f12873c;

    static class a extends kk {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f12874d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12875e;

        /* renamed from: f  reason: collision with root package name */
        private int f12876f;

        a(byte[] bArr, int i, int i2) {
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.f12874d = bArr;
                    this.f12876f = i;
                    this.f12875e = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void a(int i, int i2) throws IOException {
            b((i << 3) | i2);
        }

        public final void b(int i, int i2) throws IOException {
            a(i, 0);
            a(i2);
        }

        public final void c(int i, int i2) throws IOException {
            a(i, 0);
            b(i2);
        }

        public final void e(int i, int i2) throws IOException {
            a(i, 5);
            d(i2);
        }

        public final void a(int i, long j) throws IOException {
            a(i, 0);
            a(j);
        }

        public final void c(int i, long j) throws IOException {
            a(i, 1);
            c(j);
        }

        public final void a(int i, boolean z) throws IOException {
            a(i, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void a(int i, String str) throws IOException {
            a(i, 2);
            a(str);
        }

        public final void a(int i, kc kcVar) throws IOException {
            a(i, 2);
            a(kcVar);
        }

        public final void a(kc kcVar) throws IOException {
            b(kcVar.a());
            kcVar.a((kb) this);
        }

        public final void b(byte[] bArr, int i, int i2) throws IOException {
            b(i2);
            c(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i, ma maVar, mp mpVar) throws IOException {
            a(i, 2);
            b(((ju) maVar).a(mpVar));
            mpVar.a(maVar, this.f12873c);
        }

        public final void a(int i, ma maVar) throws IOException {
            a(1, 3);
            c(2, i);
            a(3, 2);
            a(maVar);
            a(1, 4);
        }

        public final void b(int i, kc kcVar) throws IOException {
            a(1, 3);
            c(2, i);
            a(3, kcVar);
            a(1, 4);
        }

        public final void a(ma maVar) throws IOException {
            b(maVar.h());
            maVar.a(this);
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f12874d;
                int i = this.f12876f;
                this.f12876f = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f12876f), Integer.valueOf(this.f12875e), 1}), e2);
            }
        }

        public final void a(int i) throws IOException {
            if (i >= 0) {
                b(i);
            } else {
                a((long) i);
            }
        }

        public final void b(int i) throws IOException {
            if (!kk.f12872b || jz.a() || h() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f12874d;
                    int i2 = this.f12876f;
                    this.f12876f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f12874d;
                    int i3 = this.f12876f;
                    this.f12876f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f12876f), Integer.valueOf(this.f12875e), 1}), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.f12874d;
                int i4 = this.f12876f;
                this.f12876f = i4 + 1;
                nk.a(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f12874d;
                int i5 = this.f12876f;
                this.f12876f = i5 + 1;
                nk.a(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.f12874d;
                    int i7 = this.f12876f;
                    this.f12876f = i7 + 1;
                    nk.a(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f12874d;
                int i8 = this.f12876f;
                this.f12876f = i8 + 1;
                nk.a(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.f12874d;
                    int i10 = this.f12876f;
                    this.f12876f = i10 + 1;
                    nk.a(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f12874d;
                int i11 = this.f12876f;
                this.f12876f = i11 + 1;
                nk.a(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.f12874d;
                    int i13 = this.f12876f;
                    this.f12876f = i13 + 1;
                    nk.a(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f12874d;
                int i14 = this.f12876f;
                this.f12876f = i14 + 1;
                nk.a(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.f12874d;
                int i15 = this.f12876f;
                this.f12876f = i15 + 1;
                nk.a(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void d(int i) throws IOException {
            try {
                byte[] bArr = this.f12874d;
                int i2 = this.f12876f;
                this.f12876f = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f12874d;
                int i3 = this.f12876f;
                this.f12876f = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f12874d;
                int i4 = this.f12876f;
                this.f12876f = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f12874d;
                int i5 = this.f12876f;
                this.f12876f = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f12876f), Integer.valueOf(this.f12875e), 1}), e2);
            }
        }

        public final void a(long j) throws IOException {
            if (!kk.f12872b || h() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f12874d;
                    int i = this.f12876f;
                    this.f12876f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f12874d;
                    int i2 = this.f12876f;
                    this.f12876f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f12876f), Integer.valueOf(this.f12875e), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f12874d;
                    int i3 = this.f12876f;
                    this.f12876f = i3 + 1;
                    nk.a(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f12874d;
                int i4 = this.f12876f;
                this.f12876f = i4 + 1;
                nk.a(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.f12874d;
                int i = this.f12876f;
                this.f12876f = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.f12874d;
                int i2 = this.f12876f;
                this.f12876f = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f12874d;
                int i3 = this.f12876f;
                this.f12876f = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f12874d;
                int i4 = this.f12876f;
                this.f12876f = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f12874d;
                int i5 = this.f12876f;
                this.f12876f = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f12874d;
                int i6 = this.f12876f;
                this.f12876f = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f12874d;
                int i7 = this.f12876f;
                this.f12876f = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f12874d;
                int i8 = this.f12876f;
                this.f12876f = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f12876f), Integer.valueOf(this.f12875e), 1}), e2);
            }
        }

        private final void c(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f12874d, this.f12876f, i2);
                this.f12876f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f12876f), Integer.valueOf(this.f12875e), Integer.valueOf(i2)}), e2);
            }
        }

        public final void a(byte[] bArr, int i, int i2) throws IOException {
            c(bArr, i, i2);
        }

        public final void a(String str) throws IOException {
            int i = this.f12876f;
            try {
                int g2 = g(str.length() * 3);
                int g3 = g(str.length());
                if (g3 == g2) {
                    this.f12876f = i + g3;
                    int a2 = nm.a(str, this.f12874d, this.f12876f, h());
                    this.f12876f = i;
                    b((a2 - i) - g3);
                    this.f12876f = a2;
                    return;
                }
                b(nm.a((CharSequence) str));
                this.f12876f = nm.a(str, this.f12874d, this.f12876f, h());
            } catch (np e2) {
                this.f12876f = i;
                kk.f12871a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", e2);
                byte[] bytes = str.getBytes(kx.f12918a);
                try {
                    b(bytes.length);
                    a(bytes, 0, bytes.length);
                } catch (IndexOutOfBoundsException e3) {
                    throw new b(e3);
                } catch (b e4) {
                    throw e4;
                }
            } catch (IndexOutOfBoundsException e5) {
                throw new b(e5);
            }
        }

        public final int h() {
            return this.f12875e - this.f12876f;
        }
    }

    public static int a() {
        return 4;
    }

    public static kk a(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int b() {
        return 4;
    }

    public static int c() {
        return 8;
    }

    public static int d() {
        return 8;
    }

    public static int e() {
        return 4;
    }

    public static int e(long j) {
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

    public static int f() {
        return 8;
    }

    public static int g() {
        return 1;
    }

    public static int g(int i) {
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

    private static long g(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int k(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i) throws IOException;

    public abstract void a(int i, int i2) throws IOException;

    public abstract void a(int i, long j) throws IOException;

    public abstract void a(int i, kc kcVar) throws IOException;

    public abstract void a(int i, ma maVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(int i, ma maVar, mp mpVar) throws IOException;

    public abstract void a(int i, String str) throws IOException;

    public abstract void a(int i, boolean z) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(kc kcVar) throws IOException;

    public abstract void a(ma maVar) throws IOException;

    public abstract void a(String str) throws IOException;

    public abstract void b(int i) throws IOException;

    public abstract void b(int i, int i2) throws IOException;

    public abstract void b(int i, kc kcVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void b(byte[] bArr, int i, int i2) throws IOException;

    public abstract void c(int i, int i2) throws IOException;

    public abstract void c(int i, long j) throws IOException;

    public abstract void c(long j) throws IOException;

    public abstract void d(int i) throws IOException;

    public abstract void e(int i, int i2) throws IOException;

    public abstract int h();

    public static class b extends IOException {
        public static final long serialVersionUID = -6947486886997889499L;

        b() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        b(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.kk.b.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    kk() {
    }

    public final void d(int i, int i2) throws IOException {
        c(i, k(i2));
    }

    public final void b(int i, long j) throws IOException {
        a(i, g(j));
    }

    public final void a(int i, float f2) throws IOException {
        e(i, Float.floatToRawIntBits(f2));
    }

    public final void a(int i, double d2) throws IOException {
        c(i, Double.doubleToRawLongBits(d2));
    }

    public final void c(int i) throws IOException {
        b(k(i));
    }

    public final void b(long j) throws IOException {
        a(g(j));
    }

    public final void a(float f2) throws IOException {
        d(Float.floatToRawIntBits(f2));
    }

    public final void a(double d2) throws IOException {
        c(Double.doubleToRawLongBits(d2));
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : 0);
    }

    public static int f(int i, int i2) {
        return e(i) + f(i2);
    }

    public static int g(int i, int i2) {
        return e(i) + g(i2);
    }

    public static int h(int i, int i2) {
        return e(i) + g(k(i2));
    }

    public static int i(int i, int i2) {
        return e(i) + 4;
    }

    public static int j(int i, int i2) {
        return e(i) + 4;
    }

    public static int d(int i, long j) {
        return e(i) + e(j);
    }

    public static int e(int i, long j) {
        return e(i) + e(j);
    }

    public static int f(int i, long j) {
        return e(i) + e(g(j));
    }

    public static int g(int i, long j) {
        return e(i) + 8;
    }

    public static int h(int i, long j) {
        return e(i) + 8;
    }

    public static int b(int i, float f2) {
        return e(i) + 4;
    }

    public static int b(int i, double d2) {
        return e(i) + 8;
    }

    public static int b(int i, boolean z) {
        return e(i) + 1;
    }

    public static int k(int i, int i2) {
        return e(i) + f(i2);
    }

    public static int b(int i, String str) {
        return e(i) + b(str);
    }

    public static int c(int i, kc kcVar) {
        int e2 = e(i);
        int a2 = kcVar.a();
        return e2 + g(a2) + a2;
    }

    public static int a(int i, lj ljVar) {
        int i2;
        int e2 = e(i);
        if (ljVar.f12934c != null) {
            i2 = ljVar.f12934c.a();
        } else {
            i2 = ljVar.f12933b != null ? ljVar.f12933b.h() : 0;
        }
        return e2 + g(i2) + i2;
    }

    static int b(int i, ma maVar, mp mpVar) {
        return e(i) + a(maVar, mpVar);
    }

    public static int b(int i, ma maVar) {
        return (e(1) << 1) + g(2, i) + e(3) + b(maVar);
    }

    public static int d(int i, kc kcVar) {
        return (e(1) << 1) + g(2, i) + c(3, kcVar);
    }

    public static int b(int i, lj ljVar) {
        return (e(1) << 1) + g(2, i) + a(3, ljVar);
    }

    public static int e(int i) {
        return g((i << 3) | 0);
    }

    public static int f(int i) {
        if (i >= 0) {
            return g(i);
        }
        return 10;
    }

    public static int h(int i) {
        return g(k(i));
    }

    public static int d(long j) {
        return e(j);
    }

    public static int f(long j) {
        return e(g(j));
    }

    public static int i(int i) {
        return f(i);
    }

    public static int b(String str) {
        int i;
        try {
            i = nm.a((CharSequence) str);
        } catch (np unused) {
            i = str.getBytes(kx.f12918a).length;
        }
        return g(i) + i;
    }

    public static int a(lj ljVar) {
        int i;
        if (ljVar.f12934c != null) {
            i = ljVar.f12934c.a();
        } else {
            i = ljVar.f12933b != null ? ljVar.f12933b.h() : 0;
        }
        return g(i) + i;
    }

    public static int b(kc kcVar) {
        int a2 = kcVar.a();
        return g(a2) + a2;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return g(length) + length;
    }

    public static int b(ma maVar) {
        int h = maVar.h();
        return g(h) + h;
    }

    static int a(ma maVar, mp mpVar) {
        int a2 = ((ju) maVar).a(mpVar);
        return g(a2) + a2;
    }

    public final void i() {
        if (h() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    @Deprecated
    static int c(int i, ma maVar, mp mpVar) {
        return (e(i) << 1) + ((ju) maVar).a(mpVar);
    }

    @Deprecated
    public static int c(ma maVar) {
        return maVar.h();
    }

    @Deprecated
    public static int j(int i) {
        return g(i);
    }
}
