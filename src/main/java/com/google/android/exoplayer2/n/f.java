package com.google.android.exoplayer2.n;

import java.util.Arrays;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private int f10928a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f10929b;

    public f() {
        this(32);
    }

    public f(int i) {
        this.f10929b = new long[i];
    }

    public void a(long j) {
        int i = this.f10928a;
        long[] jArr = this.f10929b;
        if (i == jArr.length) {
            this.f10929b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f10929b;
        int i2 = this.f10928a;
        this.f10928a = i2 + 1;
        jArr2[i2] = j;
    }

    public long a(int i) {
        if (i >= 0 && i < this.f10928a) {
            return this.f10929b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f10928a);
    }

    public int a() {
        return this.f10928a;
    }

    public long[] b() {
        return Arrays.copyOf(this.f10929b, this.f10928a);
    }
}
