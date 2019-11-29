package com.airbnb.lottie.g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f3734a;

    /* renamed from: b  reason: collision with root package name */
    public final T f3735b;

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f3736c;

    /* renamed from: d  reason: collision with root package name */
    public final float f3737d;

    /* renamed from: e  reason: collision with root package name */
    public Float f3738e;

    /* renamed from: f  reason: collision with root package name */
    public PointF f3739f;

    /* renamed from: g  reason: collision with root package name */
    public PointF f3740g;
    private final d h;
    private float i;
    private float j;

    public a(d dVar, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f3739f = null;
        this.f3740g = null;
        this.h = dVar;
        this.f3734a = t;
        this.f3735b = t2;
        this.f3736c = interpolator;
        this.f3737d = f2;
        this.f3738e = f3;
    }

    public a(T t) {
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.f3739f = null;
        this.f3740g = null;
        this.h = null;
        this.f3734a = t;
        this.f3735b = t;
        this.f3736c = null;
        this.f3737d = Float.MIN_VALUE;
        this.f3738e = Float.valueOf(Float.MAX_VALUE);
    }

    public float b() {
        d dVar = this.h;
        if (dVar == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (this.i == Float.MIN_VALUE) {
            this.i = (this.f3737d - dVar.d()) / this.h.k();
        }
        return this.i;
    }

    public float c() {
        if (this.h == null) {
            return 1.0f;
        }
        if (this.j == Float.MIN_VALUE) {
            if (this.f3738e == null) {
                this.j = 1.0f;
            } else {
                this.j = b() + ((this.f3738e.floatValue() - this.f3737d) / this.h.k());
            }
        }
        return this.j;
    }

    public boolean d() {
        return this.f3736c == null;
    }

    public boolean a(float f2) {
        return f2 >= b() && f2 < c();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f3734a + ", endValue=" + this.f3735b + ", startFrame=" + this.f3737d + ", endFrame=" + this.f3738e + ", interpolator=" + this.f3736c + '}';
    }
}
