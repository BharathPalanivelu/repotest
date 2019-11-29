package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.x;

public final class n extends x {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f12108b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final long f12109c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12110d;

    /* renamed from: e  reason: collision with root package name */
    private final long f12111e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12112f;

    /* renamed from: g  reason: collision with root package name */
    private final long f12113g;
    private final long h;
    private final boolean i;
    private final boolean j;

    public int b() {
        return 1;
    }

    public int c() {
        return 1;
    }

    public n(long j2, boolean z) {
        this(j2, j2, 0, 0, z, false);
    }

    public n(long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z, z2);
    }

    public n(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2) {
        this.f12109c = j2;
        this.f12110d = j3;
        this.f12111e = j4;
        this.f12112f = j5;
        this.f12113g = j6;
        this.h = j7;
        this.i = z;
        this.j = z2;
    }

    public x.b a(int i2, x.b bVar, boolean z, long j2) {
        a.a(i2, 0, 1);
        Object obj = z ? f12108b : null;
        long j3 = this.h;
        if (this.j) {
            j3 += j2;
            if (j3 > this.f12112f) {
                j3 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.f12109c, this.f12110d, this.i, this.j, j3, this.f12112f, 0, 0, this.f12113g);
    }

    public x.a a(int i2, x.a aVar, boolean z) {
        a.a(i2, 0, 1);
        Object obj = z ? f12108b : null;
        return aVar.a(obj, obj, 0, this.f12111e, -this.f12113g);
    }

    public int a(Object obj) {
        return f12108b.equals(obj) ? 0 : -1;
    }
}
