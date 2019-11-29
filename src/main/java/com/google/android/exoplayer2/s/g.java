package com.google.android.exoplayer2.s;

import java.util.Arrays;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private int f11402a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f11403b;

    public g() {
        this(32);
    }

    public g(int i) {
        this.f11403b = new long[i];
    }

    public void a(long j) {
        int i = this.f11402a;
        long[] jArr = this.f11403b;
        if (i == jArr.length) {
            this.f11403b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f11403b;
        int i2 = this.f11402a;
        this.f11402a = i2 + 1;
        jArr2[i2] = j;
    }

    public long a(int i) {
        if (i >= 0 && i < this.f11402a) {
            return this.f11403b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f11402a);
    }

    public int a() {
        return this.f11402a;
    }

    public long[] b() {
        return Arrays.copyOf(this.f11403b, this.f11402a);
    }
}
