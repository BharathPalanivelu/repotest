package com.google.android.exoplayer2.e.h;

import com.path.android.jobqueue.JobManager;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f9759a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9760b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9761c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9762d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9763e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9764f;

    /* renamed from: g  reason: collision with root package name */
    private long f9765g;
    private long h;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f9759a = i;
        this.f9760b = i2;
        this.f9761c = i3;
        this.f9762d = i4;
        this.f9763e = i5;
        this.f9764f = i6;
    }

    public long a() {
        return ((this.h / ((long) this.f9762d)) * JobManager.NS_PER_MS) / ((long) this.f9760b);
    }

    public int b() {
        return this.f9762d;
    }

    public int c() {
        return this.f9760b * this.f9763e * this.f9759a;
    }

    public int d() {
        return this.f9760b;
    }

    public int e() {
        return this.f9759a;
    }

    public long a(long j) {
        long j2 = (j * ((long) this.f9761c)) / JobManager.NS_PER_MS;
        int i = this.f9762d;
        return Math.min((j2 / ((long) i)) * ((long) i), this.h - ((long) i)) + this.f9765g;
    }

    public long b(long j) {
        return (j * JobManager.NS_PER_MS) / ((long) this.f9761c);
    }

    public boolean f() {
        return (this.f9765g == 0 || this.h == 0) ? false : true;
    }

    public void a(long j, long j2) {
        this.f9765g = j;
        this.h = j2;
    }

    public int g() {
        return this.f9764f;
    }
}
