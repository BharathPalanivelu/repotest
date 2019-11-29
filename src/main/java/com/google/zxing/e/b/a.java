package com.google.zxing.e.b;

import com.google.zxing.y;

public final class a extends y {

    /* renamed from: a  reason: collision with root package name */
    private final float f14667a;

    a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f14667a = f4;
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f14667a);
        if (abs <= 1.0f || abs <= this.f14667a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public a b(float f2, float f3, float f4) {
        return new a((a() + f3) / 2.0f, (b() + f2) / 2.0f, (this.f14667a + f4) / 2.0f);
    }
}
