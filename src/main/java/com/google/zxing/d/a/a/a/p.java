package com.google.zxing.d.a.a.a;

import com.google.zxing.m;

final class p extends q {

    /* renamed from: a  reason: collision with root package name */
    private final int f14548a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14549b;

    p(int i, int i2, int i3) throws m {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw m.a();
        }
        this.f14548a = i2;
        this.f14549b = i3;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f14548a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f14549b;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f14548a == 10;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f14549b == 10;
    }
}
