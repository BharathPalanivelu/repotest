package com.google.android.exoplayer2.i.b;

import java.io.IOException;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f10002a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f10003b = new byte[8];

    /* renamed from: c  reason: collision with root package name */
    private int f10004c;

    /* renamed from: d  reason: collision with root package name */
    private int f10005d;

    public void a() {
        this.f10004c = 0;
        this.f10005d = 0;
    }

    public long a(com.google.android.exoplayer2.i.f fVar, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.f10004c == 0) {
            if (!fVar.a(this.f10003b, 0, 1, z)) {
                return -1;
            }
            this.f10005d = a(this.f10003b[0] & 255);
            if (this.f10005d != -1) {
                this.f10004c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.f10005d;
        if (i2 > i) {
            this.f10004c = 0;
            return -2;
        }
        if (i2 != 1) {
            fVar.b(this.f10003b, 1, i2 - 1);
        }
        this.f10004c = 0;
        return a(this.f10003b, this.f10005d, z2);
    }

    public int b() {
        return this.f10005d;
    }

    public static int a(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f10002a;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= f10002a[i - 1] ^ -1;
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
