package com.google.android.exoplayer2.i.h;

import com.path.android.jobqueue.JobManager;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f10396a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10397b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10398c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10399d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10400e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10401f;

    /* renamed from: g  reason: collision with root package name */
    private long f10402g;
    private long h;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f10396a = i;
        this.f10397b = i2;
        this.f10398c = i3;
        this.f10399d = i4;
        this.f10400e = i5;
        this.f10401f = i6;
    }

    public long a() {
        return ((this.h / ((long) this.f10399d)) * JobManager.NS_PER_MS) / ((long) this.f10397b);
    }

    public int b() {
        return this.f10399d;
    }

    public int c() {
        return this.f10397b * this.f10400e * this.f10396a;
    }

    public int d() {
        return this.f10397b;
    }

    public int e() {
        return this.f10396a;
    }

    public long a(long j) {
        long j2 = (j * ((long) this.f10398c)) / JobManager.NS_PER_MS;
        int i = this.f10399d;
        return Math.min((j2 / ((long) i)) * ((long) i), this.h - ((long) i)) + this.f10402g;
    }

    public long b(long j) {
        return (j * JobManager.NS_PER_MS) / ((long) this.f10398c);
    }

    public boolean f() {
        return (this.f10402g == 0 || this.h == 0) ? false : true;
    }

    public void a(long j, long j2) {
        this.f10402g = j;
        this.h = j2;
    }

    public int g() {
        return this.f10401f;
    }
}
