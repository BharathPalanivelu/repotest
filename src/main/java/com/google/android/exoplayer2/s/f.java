package com.google.android.exoplayer2.s;

import com.path.android.jobqueue.JobManager;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f11395a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11396b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11397c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11398d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11399e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11400f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11401g;
    public final long h;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.a(i * 8);
        this.f11395a = kVar.c(16);
        this.f11396b = kVar.c(16);
        this.f11397c = kVar.c(24);
        this.f11398d = kVar.c(24);
        this.f11399e = kVar.c(20);
        this.f11400f = kVar.c(3) + 1;
        this.f11401g = kVar.c(5) + 1;
        this.h = ((((long) kVar.c(4)) & 15) << 32) | (((long) kVar.c(32)) & 4294967295L);
    }

    public int a() {
        return this.f11401g * this.f11399e;
    }

    public long b() {
        return (this.h * JobManager.NS_PER_MS) / ((long) this.f11399e);
    }
}
