package com.google.zxing.e.b;

import com.google.zxing.y;

public final class d extends y {

    /* renamed from: a  reason: collision with root package name */
    private final float f14677a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14678b;

    d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    private d(float f2, float f3, float f4, int i) {
        super(f2, f3);
        this.f14677a = f4;
        this.f14678b = i;
    }

    public float c() {
        return this.f14677a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f14678b;
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f14677a);
        if (abs <= 1.0f || abs <= this.f14677a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public d b(float f2, float f3, float f4) {
        int i = this.f14678b;
        int i2 = i + 1;
        float a2 = (((float) i) * a()) + f3;
        float f5 = (float) i2;
        return new d(a2 / f5, ((((float) this.f14678b) * b()) + f2) / f5, ((((float) this.f14678b) * this.f14677a) + f4) / f5, i2);
    }
}
