package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.r.r;
import com.google.android.exoplayer2.s.a;

public abstract class c implements r.c {

    /* renamed from: a  reason: collision with root package name */
    public final i f11543a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11544b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f11545c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11546d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f11547e;

    /* renamed from: f  reason: collision with root package name */
    public final long f11548f;

    /* renamed from: g  reason: collision with root package name */
    public final long f11549g;
    protected final f h;

    public abstract long e();

    public c(f fVar, i iVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.h = (f) a.a(fVar);
        this.f11543a = (i) a.a(iVar);
        this.f11544b = i;
        this.f11545c = format;
        this.f11546d = i2;
        this.f11547e = obj;
        this.f11548f = j;
        this.f11549g = j2;
    }
}
