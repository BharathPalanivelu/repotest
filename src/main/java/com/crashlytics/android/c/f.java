package com.crashlytics.android.c;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class f implements Flushable {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f6467a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6468b;

    /* renamed from: c  reason: collision with root package name */
    private int f6469c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final OutputStream f6470d;

    public static int b(float f2) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int l(int i) {
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

    public static int n(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private f(OutputStream outputStream, byte[] bArr) {
        this.f6470d = outputStream;
        this.f6467a = bArr;
        this.f6468b = bArr.length;
    }

    public static f a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static f a(OutputStream outputStream, int i) {
        return new f(outputStream, new byte[i]);
    }

    public void a(int i, float f2) throws IOException {
        g(i, 5);
        a(f2);
    }

    public void a(int i, long j) throws IOException {
        g(i, 0);
        a(j);
    }

    public void a(int i, boolean z) throws IOException {
        g(i, 0);
        a(z);
    }

    public void a(int i, c cVar) throws IOException {
        g(i, 2);
        a(cVar);
    }

    public void a(int i, int i2) throws IOException {
        g(i, 0);
        b(i2);
    }

    public void b(int i, int i2) throws IOException {
        g(i, 0);
        c(i2);
    }

    public void c(int i, int i2) throws IOException {
        g(i, 0);
        d(i2);
    }

    public void a(float f2) throws IOException {
        m(Float.floatToRawIntBits(f2));
    }

    public void a(long j) throws IOException {
        c(j);
    }

    public void a(int i) throws IOException {
        if (i >= 0) {
            k(i);
        } else {
            c((long) i);
        }
    }

    public void a(boolean z) throws IOException {
        i(z ? 1 : 0);
    }

    public void a(c cVar) throws IOException {
        k(cVar.a());
        c(cVar);
    }

    public void b(int i) throws IOException {
        k(i);
    }

    public void c(int i) throws IOException {
        a(i);
    }

    public void d(int i) throws IOException {
        k(n(i));
    }

    public static int b(int i, float f2) {
        return j(i) + b(f2);
    }

    public static int b(int i, long j) {
        return j(i) + b(j);
    }

    public static int b(int i, boolean z) {
        return j(i) + b(z);
    }

    public static int b(int i, c cVar) {
        return j(i) + b(cVar);
    }

    public static int d(int i, int i2) {
        return j(i) + f(i2);
    }

    public static int e(int i, int i2) {
        return j(i) + g(i2);
    }

    public static int f(int i, int i2) {
        return j(i) + h(i2);
    }

    public static int b(long j) {
        return d(j);
    }

    public static int e(int i) {
        if (i >= 0) {
            return l(i);
        }
        return 10;
    }

    public static int b(c cVar) {
        return l(cVar.a()) + cVar.a();
    }

    public static int f(int i) {
        return l(i);
    }

    public static int g(int i) {
        return e(i);
    }

    public static int h(int i) {
        return l(n(i));
    }

    private void a() throws IOException {
        OutputStream outputStream = this.f6470d;
        if (outputStream != null) {
            outputStream.write(this.f6467a, 0, this.f6469c);
            this.f6469c = 0;
            return;
        }
        throw new a();
    }

    public void flush() throws IOException {
        if (this.f6470d != null) {
            a();
        }
    }

    static class a extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public void a(byte b2) throws IOException {
        if (this.f6469c == this.f6468b) {
            a();
        }
        byte[] bArr = this.f6467a;
        int i = this.f6469c;
        this.f6469c = i + 1;
        bArr[i] = b2;
    }

    public void i(int i) throws IOException {
        a((byte) i);
    }

    public void c(c cVar) throws IOException {
        a(cVar, 0, cVar.a());
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f6468b;
        int i4 = this.f6469c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f6467a, i4, i2);
            this.f6469c += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f6467a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f6469c = this.f6468b;
        a();
        if (i7 <= this.f6468b) {
            System.arraycopy(bArr, i6, this.f6467a, 0, i7);
            this.f6469c = i7;
            return;
        }
        this.f6470d.write(bArr, i6, i7);
    }

    public void a(c cVar, int i, int i2) throws IOException {
        int i3 = this.f6468b;
        int i4 = this.f6469c;
        if (i3 - i4 >= i2) {
            cVar.a(this.f6467a, i, i4, i2);
            this.f6469c += i2;
            return;
        }
        int i5 = i3 - i4;
        cVar.a(this.f6467a, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f6469c = this.f6468b;
        a();
        if (i7 <= this.f6468b) {
            cVar.a(this.f6467a, i6, 0, i7);
            this.f6469c = i7;
            return;
        }
        InputStream b2 = cVar.b();
        long j = (long) i6;
        if (j == b2.skip(j)) {
            while (i7 > 0) {
                int min = Math.min(i7, this.f6468b);
                int read = b2.read(this.f6467a, 0, min);
                if (read == min) {
                    this.f6470d.write(this.f6467a, 0, read);
                    i7 -= read;
                } else {
                    throw new IllegalStateException("Read failed.");
                }
            }
            return;
        }
        throw new IllegalStateException("Skip failed.");
    }

    public void g(int i, int i2) throws IOException {
        k(aw.a(i, i2));
    }

    public static int j(int i) {
        return l(aw.a(i, 0));
    }

    public void k(int i) throws IOException {
        while ((i & -128) != 0) {
            i((i & 127) | 128);
            i >>>= 7;
        }
        i(i);
    }

    public void c(long j) throws IOException {
        while ((-128 & j) != 0) {
            i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        i((int) j);
    }

    public void m(int i) throws IOException {
        i(i & 255);
        i((i >> 8) & 255);
        i((i >> 16) & 255);
        i((i >> 24) & 255);
    }
}
