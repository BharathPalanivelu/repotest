package com.airbnb.lottie.c;

import android.graphics.PointF;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f3509a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f3510b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f3511c;

    public a() {
        this.f3509a = new PointF();
        this.f3510b = new PointF();
        this.f3511c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f3509a = pointF;
        this.f3510b = pointF2;
        this.f3511c = pointF3;
    }

    public void a(float f2, float f3) {
        this.f3509a.set(f2, f3);
    }

    public PointF a() {
        return this.f3509a;
    }

    public void b(float f2, float f3) {
        this.f3510b.set(f2, f3);
    }

    public PointF b() {
        return this.f3510b;
    }

    public void c(float f2, float f3) {
        this.f3511c.set(f2, f3);
    }

    public PointF c() {
        return this.f3511c;
    }
}
