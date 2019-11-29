package com.google.android.exoplayer2.n;

import com.path.android.jobqueue.JobManager;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f10921a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10922b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10923c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10924d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10925e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10926f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10927g;
    public final long h;

    public e(byte[] bArr, int i) {
        j jVar = new j(bArr);
        jVar.a(i * 8);
        this.f10921a = jVar.c(16);
        this.f10922b = jVar.c(16);
        this.f10923c = jVar.c(24);
        this.f10924d = jVar.c(24);
        this.f10925e = jVar.c(20);
        this.f10926f = jVar.c(3) + 1;
        this.f10927g = jVar.c(5) + 1;
        this.h = (long) jVar.c(36);
    }

    public int a() {
        return this.f10927g * this.f10925e;
    }

    public long b() {
        return (this.h * JobManager.NS_PER_MS) / ((long) this.f10925e);
    }
}
