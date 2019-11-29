package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.s.v;

public final class a implements l {

    /* renamed from: a  reason: collision with root package name */
    public final int f9940a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f9941b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f9942c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f9943d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f9944e;

    /* renamed from: f  reason: collision with root package name */
    private final long f9945f;

    public boolean a() {
        return true;
    }

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f9941b = iArr;
        this.f9942c = jArr;
        this.f9943d = jArr2;
        this.f9944e = jArr3;
        this.f9940a = iArr.length;
        int i = this.f9940a;
        if (i > 0) {
            this.f9945f = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.f9945f = 0;
        }
    }

    public int a(long j) {
        return v.a(this.f9944e, j, true, true);
    }

    public long b() {
        return this.f9945f;
    }

    public long b(long j) {
        return this.f9942c[a(j)];
    }
}
