package com.otaliastudios.cameraview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

abstract class i<T extends View, Output> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final g f15643b = g.a(i.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    ak<Void> f15644a = new ak<>();

    /* renamed from: c  reason: collision with root package name */
    private a f15645c;

    /* renamed from: d  reason: collision with root package name */
    private T f15646d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f15647e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f15648f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f15649g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public int i;

    interface a {
        void a();

        void b();
    }

    /* access modifiers changed from: protected */
    public abstract T a(Context context, ViewGroup viewGroup);

    /* access modifiers changed from: package-private */
    public abstract Class<Output> b();

    /* access modifiers changed from: package-private */
    public abstract Output c();

    /* access modifiers changed from: package-private */
    public boolean g() {
        return true;
    }

    i(Context context, ViewGroup viewGroup, a aVar) {
        this.f15646d = a(context, viewGroup);
        this.f15645c = aVar;
    }

    /* access modifiers changed from: package-private */
    public final T a() {
        return this.f15646d;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        f15643b.b("setDesiredSize:", "desiredW=", Integer.valueOf(i2), "desiredH=", Integer.valueOf(i3));
        this.h = i2;
        this.i = i3;
        j();
    }

    /* access modifiers changed from: package-private */
    public final af d() {
        return new af(this.f15648f, this.f15649g);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.f15645c = aVar;
        if (this.f15648f != 0 || this.f15649g != 0) {
            this.f15645c.a();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, int i3) {
        f15643b.b("onSurfaceAvailable:", "w=", Integer.valueOf(i2), "h=", Integer.valueOf(i3));
        this.f15648f = i2;
        this.f15649g = i3;
        j();
        this.f15645c.a();
    }

    /* access modifiers changed from: protected */
    public final void c(int i2, int i3) {
        f15643b.b("onSurfaceSizeChanged:", "w=", Integer.valueOf(i2), "h=", Integer.valueOf(i3));
        if (i2 != this.f15648f || i3 != this.f15649g) {
            this.f15648f = i2;
            this.f15649g = i3;
            j();
            this.f15645c.b();
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        this.f15648f = 0;
        this.f15649g = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f15648f > 0 && this.f15649g > 0;
    }

    private final void j() {
        this.f15644a.a();
        if (!g()) {
            this.f15644a.a(null);
        } else {
            a().post(new Runnable() {
                public void run() {
                    float f2;
                    if (i.this.i == 0 || i.this.h == 0 || i.this.f15649g == 0 || i.this.f15648f == 0) {
                        i.this.f15644a.a(null);
                        return;
                    }
                    a a2 = a.a(i.this.f15648f, i.this.f15649g);
                    a a3 = a.a(i.this.h, i.this.i);
                    float f3 = 1.0f;
                    if (a2.a() >= a3.a()) {
                        f3 = a2.a() / a3.a();
                        f2 = 1.0f;
                    } else {
                        f2 = a3.a() / a2.a();
                    }
                    i.this.a(f2, f3);
                    boolean unused = i.this.f15647e = f2 > 1.02f || f3 > 1.02f;
                    i.f15643b.b("crop:", "applied scaleX=", Float.valueOf(f2));
                    i.f15643b.b("crop:", "applied scaleY=", Float.valueOf(f3));
                    i.this.f15644a.a(null);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        a().setScaleX(f2);
        a().setScaleY(f3);
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f15647e;
    }
}
