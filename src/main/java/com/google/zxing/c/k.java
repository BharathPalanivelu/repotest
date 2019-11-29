package com.google.zxing.c;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final float f14514a;

    /* renamed from: b  reason: collision with root package name */
    private final float f14515b;

    /* renamed from: c  reason: collision with root package name */
    private final float f14516c;

    /* renamed from: d  reason: collision with root package name */
    private final float f14517d;

    /* renamed from: e  reason: collision with root package name */
    private final float f14518e;

    /* renamed from: f  reason: collision with root package name */
    private final float f14519f;

    /* renamed from: g  reason: collision with root package name */
    private final float f14520g;
    private final float h;
    private final float i;

    private k(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f14514a = f2;
        this.f14515b = f5;
        this.f14516c = f8;
        this.f14517d = f3;
        this.f14518e = f6;
        this.f14519f = f9;
        this.f14520g = f4;
        this.h = f7;
        this.i = f10;
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return a(f10, f11, f12, f13, f14, f15, f16, f17).a(b(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public void a(float[] fArr) {
        float[] fArr2 = fArr;
        int length = fArr2.length;
        float f2 = this.f14514a;
        float f3 = this.f14515b;
        float f4 = this.f14516c;
        float f5 = this.f14517d;
        float f6 = this.f14518e;
        float f7 = this.f14519f;
        float f8 = this.f14520g;
        float f9 = this.h;
        float f10 = this.i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr2[i2];
            int i3 = i2 + 1;
            float f12 = fArr2[i3];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr2[i2] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr2[i3] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == BitmapDescriptorFactory.HUE_RED && f11 == BitmapDescriptorFactory.HUE_RED) {
            return new k(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new k((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    public static k b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return a(f2, f3, f4, f5, f6, f7, f8, f9).a();
    }

    /* access modifiers changed from: package-private */
    public k a() {
        float f2 = this.f14518e;
        float f3 = this.i;
        float f4 = this.f14519f;
        float f5 = this.h;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = this.f14520g;
        float f8 = this.f14517d;
        float f9 = (f4 * f7) - (f8 * f3);
        float f10 = (f8 * f5) - (f2 * f7);
        float f11 = this.f14516c;
        float f12 = this.f14515b;
        float f13 = (f11 * f5) - (f12 * f3);
        float f14 = this.f14514a;
        return new k(f6, f9, f10, f13, (f3 * f14) - (f11 * f7), (f7 * f12) - (f5 * f14), (f12 * f4) - (f11 * f2), (f11 * f8) - (f4 * f14), (f14 * f2) - (f12 * f8));
    }

    /* access modifiers changed from: package-private */
    public k a(k kVar) {
        k kVar2 = kVar;
        float f2 = this.f14514a;
        float f3 = kVar2.f14514a;
        float f4 = this.f14517d;
        float f5 = kVar2.f14515b;
        float f6 = this.f14520g;
        float f7 = kVar2.f14516c;
        float f8 = (f2 * f3) + (f4 * f5) + (f6 * f7);
        float f9 = kVar2.f14517d;
        float f10 = kVar2.f14518e;
        float f11 = kVar2.f14519f;
        float f12 = (f2 * f9) + (f4 * f10) + (f6 * f11);
        float f13 = kVar2.f14520g;
        float f14 = kVar2.h;
        float f15 = kVar2.i;
        float f16 = (f2 * f13) + (f4 * f14) + (f6 * f15);
        float f17 = this.f14515b;
        float f18 = f16;
        float f19 = this.f14518e;
        float f20 = f12;
        float f21 = this.h;
        float f22 = (f17 * f3) + (f19 * f5) + (f21 * f7);
        float f23 = (f21 * f15) + (f17 * f13) + (f19 * f14);
        float f24 = this.f14516c;
        float f25 = this.f14519f;
        float f26 = (f3 * f24) + (f5 * f25);
        float f27 = this.i;
        float f28 = (f24 * f13) + (f25 * f14) + (f27 * f15);
        return new k(f8, f20, f18, f22, (f17 * f9) + (f19 * f10) + (f21 * f11), f23, (f7 * f27) + f26, (f9 * f24) + (f10 * f25) + (f11 * f27), f28);
    }
}
