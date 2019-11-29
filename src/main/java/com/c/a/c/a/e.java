package com.c.a.c.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f5658a = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final int f5659b = f5658a.length;

    /* renamed from: c  reason: collision with root package name */
    private static final int f5660c = (f5659b + 2);

    /* renamed from: d  reason: collision with root package name */
    private final byte f5661d;

    /* renamed from: e  reason: collision with root package name */
    private int f5662e;

    public boolean markSupported() {
        return false;
    }

    public e(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.f5661d = (byte) i;
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.f5662e
            r1 = 2
            if (r0 < r1) goto L_0x0017
            int r2 = f5660c
            if (r0 <= r2) goto L_0x000a
            goto L_0x0017
        L_0x000a:
            if (r0 != r2) goto L_0x000f
            byte r0 = r3.f5661d
            goto L_0x001b
        L_0x000f:
            byte[] r2 = f5658a
            int r0 = r0 - r1
            byte r0 = r2[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            goto L_0x001b
        L_0x0017:
            int r0 = super.read()
        L_0x001b:
            r1 = -1
            if (r0 == r1) goto L_0x0024
            int r1 = r3.f5662e
            int r1 = r1 + 1
            r3.f5662e = r1
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.a.e.read():int");
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.f5662e;
        int i5 = f5660c;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f5661d;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f5658a, this.f5662e - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f5662e += i3;
        }
        return i3;
    }

    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f5662e = (int) (((long) this.f5662e) + skip);
        }
        return skip;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
