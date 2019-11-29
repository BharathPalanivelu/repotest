package com.google.zxing.d.a;

import com.google.zxing.y;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f14575a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14576b;

    /* renamed from: c  reason: collision with root package name */
    private final y[] f14577c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f14575a = i;
        this.f14576b = iArr;
        float f2 = (float) i4;
        this.f14577c = new y[]{new y((float) i2, f2), new y((float) i3, f2)};
    }

    public int a() {
        return this.f14575a;
    }

    public int[] b() {
        return this.f14576b;
    }

    public y[] c() {
        return this.f14577c;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof c) && this.f14575a == ((c) obj).f14575a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f14575a;
    }
}
