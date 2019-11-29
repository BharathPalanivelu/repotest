package com.shopee.feeds.feedlibrary.view.c;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected b f28554a;

    /* renamed from: b  reason: collision with root package name */
    protected Activity f28555b;

    /* renamed from: c  reason: collision with root package name */
    protected View f28556c;

    /* renamed from: d  reason: collision with root package name */
    protected View f28557d;

    /* renamed from: e  reason: collision with root package name */
    protected View f28558e;

    /* renamed from: f  reason: collision with root package name */
    private AnimationSet f28559f;

    /* renamed from: g  reason: collision with root package name */
    private AnimationSet f28560g;
    private boolean h;

    /* access modifiers changed from: protected */
    public abstract View c();

    /* access modifiers changed from: protected */
    public abstract View d();

    /* access modifiers changed from: protected */
    public abstract View e();

    public a(Activity activity) {
        this(activity, -1, -1);
    }

    public a(Activity activity, int i, int i2) {
        this.h = true;
        this.f28555b = activity;
        this.f28556c = c();
        this.f28556c.setFocusable(true);
        this.f28556c.setFocusableInTouchMode(true);
        this.f28557d = e();
        this.f28558e = d();
        this.f28559f = f();
        this.f28560g = g();
        this.f28554a = new b(this.f28556c, i, i2, this.f28558e, this.f28560g, this.f28557d, this.h);
        this.f28554a.setBackgroundDrawable(new ColorDrawable());
        this.f28554a.setFocusable(true);
        this.f28554a.setOutsideTouchable(true);
        this.f28554a.setAnimationStyle(0);
        View view = this.f28557d;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.b();
                }
            });
        }
    }

    public void a() {
        a((View) null, 0, 0, 0);
    }

    public void a(View view, int i, int i2, int i3) {
        if (view != null) {
            this.f28554a.showAtLocation(view, i3, i, i2);
        } else {
            this.f28554a.showAtLocation(this.f28555b.findViewById(16908290), i3, i, i2);
        }
        View view2 = this.f28558e;
        if (!(view2 == null || this.f28559f == null)) {
            view2.clearAnimation();
            this.f28558e.setAnimation(this.f28559f);
            this.f28559f.startNow();
        }
        if (this.h) {
            View view3 = this.f28557d;
            if (view3 != null) {
                view3.startAnimation(a(BitmapDescriptorFactory.HUE_RED, 1.0f));
            }
        }
    }

    public void b() {
        this.f28554a.dismiss();
    }

    /* access modifiers changed from: protected */
    public AnimationSet f() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a(BitmapDescriptorFactory.HUE_RED, 1.0f));
        animationSet.addAnimation(a(0.9f, 1.0f, 0.9f, 1.0f));
        return animationSet;
    }

    /* access modifiers changed from: protected */
    public AnimationSet g() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a(1.0f, BitmapDescriptorFactory.HUE_RED));
        animationSet.addAnimation(a(1.0f, 0.9f, 1.0f, 0.9f));
        return animationSet;
    }

    public static Animation a(float f2, float f3, float f4, float f5) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f4, f5, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    public static Animation a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }
}
