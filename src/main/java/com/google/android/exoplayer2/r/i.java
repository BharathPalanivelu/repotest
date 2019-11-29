package com.google.android.exoplayer2.r;

import android.net.Uri;
import com.google.android.exoplayer2.s.a;
import java.util.Arrays;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f11313a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f11314b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11315c;

    /* renamed from: d  reason: collision with root package name */
    public final long f11316d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11317e;

    /* renamed from: f  reason: collision with root package name */
    public final String f11318f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11319g;

    public i(Uri uri, int i) {
        this(uri, 0, -1, (String) null, i);
    }

    public i(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public i(Uri uri, long j, long j2, String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    public i(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, (byte[]) null, j, j2, j3, str, i);
    }

    public i(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        a.a(j >= 0);
        a.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        a.a(z);
        this.f11313a = uri;
        this.f11314b = bArr;
        this.f11315c = j;
        this.f11316d = j2;
        this.f11317e = j3;
        this.f11318f = str;
        this.f11319g = i;
    }

    public boolean a(int i) {
        return (this.f11319g & i) == i;
    }

    public String toString() {
        return "DataSpec[" + this.f11313a + ", " + Arrays.toString(this.f11314b) + ", " + this.f11315c + ", " + this.f11316d + ", " + this.f11317e + ", " + this.f11318f + ", " + this.f11319g + "]";
    }

    public i a(long j) {
        long j2 = this.f11317e;
        long j3 = -1;
        if (j2 != -1) {
            j3 = j2 - j;
        }
        return a(j, j3);
    }

    public i a(long j, long j2) {
        if (j == 0 && this.f11317e == j2) {
            return this;
        }
        return new i(this.f11313a, this.f11314b, this.f11315c + j, this.f11316d + j, j2, this.f11318f, this.f11319g);
    }
}
