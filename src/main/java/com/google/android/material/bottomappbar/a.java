package com.google.android.material.bottomappbar;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.i.b;
import com.google.android.material.i.d;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private float f13213a;

    /* renamed from: b  reason: collision with root package name */
    private float f13214b;

    /* renamed from: c  reason: collision with root package name */
    private float f13215c;

    /* renamed from: d  reason: collision with root package name */
    private float f13216d;

    /* renamed from: e  reason: collision with root package name */
    private float f13217e;

    public void a(float f2, float f3, d dVar) {
        float f4 = f2;
        d dVar2 = dVar;
        float f5 = this.f13215c;
        if (f5 == BitmapDescriptorFactory.HUE_RED) {
            dVar2.b(f4, BitmapDescriptorFactory.HUE_RED);
            return;
        }
        float f6 = ((this.f13214b * 2.0f) + f5) / 2.0f;
        float f7 = f3 * this.f13213a;
        float f8 = (f4 / 2.0f) + this.f13217e;
        float f9 = (this.f13216d * f3) + ((1.0f - f3) * f6);
        if (f9 / f6 >= 1.0f) {
            dVar2.b(f4, BitmapDescriptorFactory.HUE_RED);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float sqrt = (float) Math.sqrt((double) ((f10 * f10) - (f11 * f11)));
        float f12 = f8 - sqrt;
        float f13 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f11)));
        float f14 = 90.0f - degrees;
        float f15 = f12 - f7;
        dVar2.b(f15, BitmapDescriptorFactory.HUE_RED);
        float f16 = f7 * 2.0f;
        float f17 = degrees;
        dVar.a(f15, BitmapDescriptorFactory.HUE_RED, f12 + f7, f16, 270.0f, degrees);
        dVar.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        dVar.a(f13 - f7, BitmapDescriptorFactory.HUE_RED, f13 + f7, f16, 270.0f - f17, f17);
        dVar2.b(f4, BitmapDescriptorFactory.HUE_RED);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.f13217e = f2;
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f13217e;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f13216d;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        this.f13216d = f2;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f13215c;
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        this.f13215c = f2;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f13214b;
    }

    /* access modifiers changed from: package-private */
    public void d(float f2) {
        this.f13214b = f2;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f13213a;
    }

    /* access modifiers changed from: package-private */
    public void e(float f2) {
        this.f13213a = f2;
    }
}
