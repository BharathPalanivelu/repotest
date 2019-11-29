package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.n.t;

public final class a implements m {

    /* renamed from: a  reason: collision with root package name */
    public final int f9304a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f9305b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f9306c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f9307d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f9308e;

    /* renamed from: f  reason: collision with root package name */
    private final long f9309f;

    public boolean a() {
        return true;
    }

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f9305b = iArr;
        this.f9306c = jArr;
        this.f9307d = jArr2;
        this.f9308e = jArr3;
        this.f9304a = iArr.length;
        int i = this.f9304a;
        if (i > 0) {
            this.f9309f = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.f9309f = 0;
        }
    }

    public int a(long j) {
        return t.a(this.f9308e, j, true, true);
    }

    public long b() {
        return this.f9309f;
    }

    public long b(long j) {
        return this.f9306c[a(j)];
    }
}
