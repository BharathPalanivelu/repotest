package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f11997a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11998b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11999c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12000d;

    /* renamed from: e  reason: collision with root package name */
    public final long f12001e;

    /* renamed from: f  reason: collision with root package name */
    public final long f12002f;

    /* renamed from: g  reason: collision with root package name */
    public final long f12003g;
    public final k h;
    public final Uri i;
    private final List<e> j;

    public b(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, k kVar, Uri uri, List<e> list) {
        this.f11997a = j2;
        this.f11998b = j3;
        this.f11999c = j4;
        this.f12000d = z;
        this.f12001e = j5;
        this.f12002f = j6;
        this.f12003g = j7;
        this.h = kVar;
        this.i = uri;
        this.j = list == null ? Collections.emptyList() : list;
    }

    public final int a() {
        return this.j.size();
    }

    public final e a(int i2) {
        return this.j.get(i2);
    }

    public final long b(int i2) {
        if (i2 != this.j.size() - 1) {
            return this.j.get(i2 + 1).f12018b - this.j.get(i2).f12018b;
        }
        long j2 = this.f11998b;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 - this.j.get(i2).f12018b;
    }

    public final long c(int i2) {
        return com.google.android.exoplayer2.b.b(b(i2));
    }
}
