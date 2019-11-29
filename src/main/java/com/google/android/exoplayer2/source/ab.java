package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ar;
import com.google.android.exoplayer2.n.a;

public final class ab extends ar {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f11528b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final long f11529c;

    /* renamed from: d  reason: collision with root package name */
    private final long f11530d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11531e;

    /* renamed from: f  reason: collision with root package name */
    private final long f11532f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11533g;
    private final boolean h;

    public int a() {
        return 1;
    }

    public int b() {
        return 1;
    }

    public ab(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public ab(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f11529c = j;
        this.f11530d = j2;
        this.f11531e = j3;
        this.f11532f = j4;
        this.f11533g = z;
        this.h = z2;
    }

    public ar.b a(int i, ar.b bVar, boolean z, long j) {
        a.a(i, 0, 1);
        Object obj = z ? f11528b : null;
        long j2 = this.f11532f;
        if (this.h) {
            j2 += j;
            if (j2 > this.f11530d) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, -9223372036854775807L, -9223372036854775807L, this.f11533g, this.h, j2, this.f11530d, 0, 0, this.f11531e);
    }

    public ar.a a(int i, ar.a aVar, boolean z) {
        a.a(i, 0, 1);
        Object obj = z ? f11528b : null;
        return aVar.a(obj, obj, 0, this.f11529c, -this.f11531e, false);
    }

    public int a(Object obj) {
        return f11528b.equals(obj) ? 0 : -1;
    }
}
