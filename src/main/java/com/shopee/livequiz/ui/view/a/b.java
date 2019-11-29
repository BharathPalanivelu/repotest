package com.shopee.livequiz.ui.view.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.livequiz.g.m;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected c f30000a;

    /* renamed from: b  reason: collision with root package name */
    protected Activity f30001b;

    /* renamed from: c  reason: collision with root package name */
    protected View f30002c;

    /* renamed from: d  reason: collision with root package name */
    protected View f30003d;

    /* renamed from: e  reason: collision with root package name */
    protected View f30004e;

    /* renamed from: f  reason: collision with root package name */
    protected View f30005f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f30006g;
    private AnimationSet h;
    private AnimationSet i;
    private boolean j;

    /* access modifiers changed from: protected */
    public abstract View d();

    /* access modifiers changed from: protected */
    public abstract View e();

    /* access modifiers changed from: protected */
    public abstract View f();

    /* access modifiers changed from: protected */
    public abstract View g();

    public b(Activity activity) {
        this(activity, -1, -1);
    }

    public b(Activity activity, int i2, int i3) {
        this.j = true;
        this.f30001b = activity;
        this.f30002c = d();
        this.f30002c.setFocusable(true);
        this.f30002c.setFocusableInTouchMode(true);
        this.f30002c.setFitsSystemWindows(false);
        this.f30003d = e();
        this.f30004e = f();
        this.f30005f = g();
        this.h = h();
        this.i = i();
        this.f30000a = new c(this.f30002c, i2, i3, this.f30004e, this.i, this.f30003d, this.j);
        this.f30000a.setBackgroundDrawable(new ColorDrawable());
        this.f30000a.setFocusable(true);
        this.f30000a.setOutsideTouchable(true);
        this.f30000a.setAnimationStyle(0);
        this.f30000a.a(true);
        a(true);
        this.f30006g = true;
        View view = this.f30003d;
        if (view != null) {
            view.setFocusable(true);
            this.f30003d.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (m.a(b.this.f30005f, motionEvent.getRawX(), motionEvent.getRawY()) || !b.this.f30006g) {
                        return false;
                    }
                    int action = motionEvent.getAction();
                    if (action != 1 && action != 3) {
                        return false;
                    }
                    b.this.c();
                    return false;
                }
            });
        }
    }

    public void a() {
        a((View) null, 0, 0, 0);
    }

    public void a(View view, int i2, int i3, int i4) {
        if (view != null) {
            this.f30000a.showAtLocation(view, i4, i2, i3);
        } else {
            this.f30000a.showAtLocation(this.f30001b.findViewById(16908290), i4, i2, i3);
        }
        View view2 = this.f30004e;
        if (!(view2 == null || this.h == null)) {
            view2.clearAnimation();
            this.f30004e.setAnimation(this.h);
            this.h.startNow();
        }
        if (this.j) {
            View view3 = this.f30003d;
            if (view3 != null) {
                view3.startAnimation(a(BitmapDescriptorFactory.HUE_RED, 1.0f));
            }
        }
    }

    public b a(boolean z) {
        if (z) {
            this.f30000a.setBackgroundDrawable(new ColorDrawable());
            this.f30000a.setOutsideTouchable(true);
        } else {
            this.f30000a.setBackgroundDrawable((Drawable) null);
            this.f30000a.setOutsideTouchable(false);
        }
        return this;
    }

    public void b(boolean z) {
        this.f30006g = z;
        this.f30000a.a(z);
        a(z);
    }

    public boolean b() {
        return this.f30000a.isShowing();
    }

    public void c() {
        this.f30000a.a();
    }

    /* access modifiers changed from: protected */
    public AnimationSet h() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a(BitmapDescriptorFactory.HUE_RED, 1.0f));
        animationSet.addAnimation(a(0.9f, 1.0f, 0.9f, 1.0f));
        return animationSet;
    }

    /* access modifiers changed from: protected */
    public AnimationSet i() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a(1.0f, BitmapDescriptorFactory.HUE_RED));
        animationSet.addAnimation(a(1.0f, 0.9f, 1.0f, 0.9f));
        return animationSet;
    }

    public static Animation a(float f2, float f3, float f4, float f5) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f4, f5, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    public static Animation a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setDuration(250);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }
}
