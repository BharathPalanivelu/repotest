package com.airbnb.lottie.f;

import android.view.Choreographer;
import com.airbnb.lottie.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class c extends a implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f3713a = false;

    /* renamed from: b  reason: collision with root package name */
    private float f3714b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3715c = false;

    /* renamed from: d  reason: collision with root package name */
    private long f3716d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f3717e = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: f  reason: collision with root package name */
    private int f3718f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f3719g = -2.14748365E9f;
    private float h = 2.14748365E9f;
    private d i;

    public Object getAnimatedValue() {
        return Float.valueOf(d());
    }

    public float d() {
        d dVar = this.i;
        if (dVar == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        return (this.f3717e - dVar.d()) / (this.i.e() - this.i.d());
    }

    public float getAnimatedFraction() {
        float k;
        float l;
        float k2;
        if (this.i == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (p()) {
            k = l() - this.f3717e;
            l = l();
            k2 = k();
        } else {
            k = this.f3717e - k();
            l = l();
            k2 = k();
        }
        return k / (l - k2);
    }

    public long getDuration() {
        d dVar = this.i;
        if (dVar == null) {
            return 0;
        }
        return (long) dVar.c();
    }

    public float e() {
        return this.f3717e;
    }

    public boolean isRunning() {
        return this.f3713a;
    }

    public void doFrame(long j) {
        m();
        if (this.i != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float o = ((float) (nanoTime - this.f3716d)) / o();
            float f2 = this.f3717e;
            if (p()) {
                o = -o;
            }
            this.f3717e = f2 + o;
            boolean z = !e.c(this.f3717e, k(), l());
            this.f3717e = e.b(this.f3717e, k(), l());
            this.f3716d = nanoTime;
            c();
            if (z) {
                if (getRepeatCount() == -1 || this.f3718f < getRepeatCount()) {
                    a();
                    this.f3718f++;
                    if (getRepeatMode() == 2) {
                        this.f3715c = !this.f3715c;
                        g();
                    } else {
                        this.f3717e = p() ? l() : k();
                    }
                    this.f3716d = nanoTime;
                } else {
                    this.f3717e = l();
                    n();
                    b(p());
                }
            }
            q();
        }
    }

    private float o() {
        d dVar = this.i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.f()) / Math.abs(this.f3714b);
    }

    public void f() {
        this.i = null;
        this.f3719g = -2.14748365E9f;
        this.h = 2.14748365E9f;
    }

    public void a(d dVar) {
        boolean z = this.i == null;
        this.i = dVar;
        if (z) {
            a((int) Math.max(this.f3719g, dVar.d()), (int) Math.min(this.h, dVar.e()));
        } else {
            a((int) dVar.d(), (int) dVar.e());
        }
        a((int) this.f3717e);
        this.f3716d = System.nanoTime();
    }

    public void a(int i2) {
        float f2 = (float) i2;
        if (this.f3717e != f2) {
            this.f3717e = e.b(f2, k(), l());
            this.f3716d = System.nanoTime();
            c();
        }
    }

    public void b(int i2) {
        a(i2, (int) this.h);
    }

    public void c(int i2) {
        a((int) this.f3719g, i2);
    }

    public void a(int i2, int i3) {
        d dVar = this.i;
        float d2 = dVar == null ? -3.4028235E38f : dVar.d();
        d dVar2 = this.i;
        float e2 = dVar2 == null ? Float.MAX_VALUE : dVar2.e();
        float f2 = (float) i2;
        this.f3719g = e.b(f2, d2, e2);
        float f3 = (float) i3;
        this.h = e.b(f3, d2, e2);
        a((int) e.b(this.f3717e, f2, f3));
    }

    public void g() {
        a(-h());
    }

    public void a(float f2) {
        this.f3714b = f2;
    }

    public float h() {
        return this.f3714b;
    }

    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 != 2 && this.f3715c) {
            this.f3715c = false;
            g();
        }
    }

    public void i() {
        this.f3713a = true;
        a(p());
        a((int) (p() ? l() : k()));
        this.f3716d = System.nanoTime();
        this.f3718f = 0;
        m();
    }

    public void j() {
        n();
        b(p());
    }

    public void cancel() {
        b();
        n();
    }

    private boolean p() {
        return h() < BitmapDescriptorFactory.HUE_RED;
    }

    public float k() {
        d dVar = this.i;
        if (dVar == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f2 = this.f3719g;
        return f2 == -2.14748365E9f ? dVar.d() : f2;
    }

    public float l() {
        d dVar = this.i;
        if (dVar == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f2 = this.h;
        return f2 == 2.14748365E9f ? dVar.e() : f2;
    }

    /* access modifiers changed from: protected */
    public void m() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        c(true);
    }

    /* access modifiers changed from: protected */
    public void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f3713a = false;
        }
    }

    private void q() {
        if (this.i != null) {
            float f2 = this.f3717e;
            if (f2 < this.f3719g || f2 > this.h) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f3719g), Float.valueOf(this.h), Float.valueOf(this.f3717e)}));
            }
        }
    }
}
