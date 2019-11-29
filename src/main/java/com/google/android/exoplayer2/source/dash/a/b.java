package com.google.android.exoplayer2.source.dash.a;

import android.net.Uri;
import com.google.android.exoplayer2.z;
import java.util.Collections;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f11842a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11843b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11844c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11845d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11846e;

    /* renamed from: f  reason: collision with root package name */
    public final long f11847f;

    /* renamed from: g  reason: collision with root package name */
    public final long f11848g;
    public final k h;
    public final Uri i;
    private final List<d> j;

    public b(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, k kVar, Uri uri, List<d> list) {
        this.f11842a = j2;
        this.f11843b = j3;
        this.f11844c = j4;
        this.f11845d = z;
        this.f11846e = j5;
        this.f11847f = j6;
        this.f11848g = j7;
        this.h = kVar;
        this.i = uri;
        this.j = list == null ? Collections.emptyList() : list;
    }

    public final int a() {
        return this.j.size();
    }

    public final d a(int i2) {
        return this.j.get(i2);
    }

    public final long b(int i2) {
        if (i2 != this.j.size() - 1) {
            return this.j.get(i2 + 1).f11860b - this.j.get(i2).f11860b;
        }
        long j2 = this.f11843b;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 - this.j.get(i2).f11860b;
    }

    public final long c(int i2) {
        return z.b(b(i2));
    }
}
