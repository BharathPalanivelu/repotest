package com.google.android.exoplayer2.i.d;

import com.google.android.exoplayer2.Format;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f10118a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10119b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10120c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10121d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10122e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f10123f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10124g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final k[] k;

    public j(int i2, int i3, long j2, long j3, long j4, Format format, int i4, k[] kVarArr, int i5, long[] jArr, long[] jArr2) {
        this.f10118a = i2;
        this.f10119b = i3;
        this.f10120c = j2;
        this.f10121d = j3;
        this.f10122e = j4;
        this.f10123f = format;
        this.f10124g = i4;
        this.k = kVarArr;
        this.j = i5;
        this.h = jArr;
        this.i = jArr2;
    }

    public k a(int i2) {
        k[] kVarArr = this.k;
        if (kVarArr == null) {
            return null;
        }
        return kVarArr[i2];
    }
}
