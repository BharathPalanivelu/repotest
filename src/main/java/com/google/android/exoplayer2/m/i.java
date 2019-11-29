package com.google.android.exoplayer2.m;

import android.net.Uri;
import com.google.android.exoplayer2.n.a;
import java.util.Arrays;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f10764a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f10765b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10766c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10767d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10768e;

    /* renamed from: f  reason: collision with root package name */
    public final String f10769f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10770g;

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
        this.f10764a = uri;
        this.f10765b = bArr;
        this.f10766c = j;
        this.f10767d = j2;
        this.f10768e = j3;
        this.f10769f = str;
        this.f10770g = i;
    }

    public boolean a(int i) {
        return (this.f10770g & i) == i;
    }

    public String toString() {
        return "DataSpec[" + this.f10764a + ", " + Arrays.toString(this.f10765b) + ", " + this.f10766c + ", " + this.f10767d + ", " + this.f10768e + ", " + this.f10769f + ", " + this.f10770g + "]";
    }
}
