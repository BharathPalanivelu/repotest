package com.google.android.exoplayer2.e.b;

import com.google.android.exoplayer2.e.g;
import java.io.IOException;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f9361a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f9362b = new byte[8];

    /* renamed from: c  reason: collision with root package name */
    private int f9363c;

    /* renamed from: d  reason: collision with root package name */
    private int f9364d;

    public void a() {
        this.f9363c = 0;
        this.f9364d = 0;
    }

    public long a(g gVar, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.f9363c == 0) {
            if (!gVar.a(this.f9362b, 0, 1, z)) {
                return -1;
            }
            this.f9364d = a(this.f9362b[0] & 255);
            if (this.f9364d != -1) {
                this.f9363c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.f9364d;
        if (i2 > i) {
            this.f9363c = 0;
            return -2;
        }
        if (i2 != 1) {
            gVar.b(this.f9362b, 1, i2 - 1);
        }
        this.f9363c = 0;
        return a(this.f9362b, this.f9364d, z2);
    }

    public int b() {
        return this.f9364d;
    }

    public static int a(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f9361a;
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
            j &= f9361a[i - 1] ^ -1;
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
