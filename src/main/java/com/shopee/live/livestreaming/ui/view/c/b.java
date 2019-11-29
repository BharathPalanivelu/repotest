package com.shopee.live.livestreaming.ui.view.c;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected g f29252a;

    /* renamed from: b  reason: collision with root package name */
    protected Activity f29253b;

    /* renamed from: c  reason: collision with root package name */
    protected View f29254c;

    /* renamed from: d  reason: collision with root package name */
    protected View f29255d;

    /* renamed from: e  reason: collision with root package name */
    protected View f29256e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f29257f;

    /* renamed from: g  reason: collision with root package name */
    private AnimationSet f29258g;
    private AnimationSet h;
    private boolean i;

    /* access modifiers changed from: protected */
    public abstract View d();

    /* access modifiers changed from: protected */
    public abstract View e();

    /* access modifiers changed from: protected */
    public abstract View f();

    /* access modifiers changed from: protected */
    public abstract void g();

    public b(Activity activity) {
        this(activity, -1, -1);
    }

    public b(Activity activity, int i2, int i3) {
        this.i = true;
        this.f29253b = activity;
        this.f29254c = d();
        this.f29254c.setFocusable(true);
        this.f29254c.setFocusableInTouchMode(true);
        this.f29255d = f();
        this.f29256e = e();
        this.f29258g = h();
        this.h = i();
        this.f29252a = new g(this.f29254c, i2, i3, this.f29256e, this.h, this.f29255d, this.i);
        this.f29252a.setBackgroundDrawable(new ColorDrawable());
        this.f29252a.setFocusable(true);
        this.f29252a.setOutsideTouchable(true);
        this.f29252a.a(true);
        this.f29252a.setAnimationStyle(0);
        this.f29252a.getContentView().setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4 || !b.this.f29257f) {
                }
                return true;
            }
        });
        View view = this.f29255d;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.c();
                }
            });
        }
    }

    public void a() {
        a((View) null, 0, 0, 0);
    }

    public void a(View view, int i2, int i3, int i4) {
        Activity activity = this.f29253b;
        if (activity == null || !activity.isFinishing()) {
            if (view != null) {
                this.f29252a.showAtLocation(view, i4, i2, i3);
            } else {
                this.f29252a.showAtLocation(this.f29253b.findViewById(16908290), i4, i2, i3);
            }
            View view2 = this.f29256e;
            if (!(view2 == null || this.f29258g == null)) {
                view2.clearAnimation();
                this.f29256e.setAnimation(this.f29258g);
                this.f29258g.startNow();
            }
            if (this.i) {
                View view3 = this.f29255d;
                if (view3 != null) {
                    view3.startAnimation(a(BitmapDescriptorFactory.HUE_RED, 1.0f));
                }
            }
            g();
        }
    }

    public b a(boolean z) {
        if (z) {
            this.f29255d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.c();
                }
            });
        } else {
            this.f29255d.setOnClickListener((View.OnClickListener) null);
        }
        return this;
    }

    public boolean b() {
        return this.f29252a.isShowing();
    }

    public void c() {
        this.f29252a.a();
    }

    /* access modifiers changed from: protected */
    public AnimationSet h() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(j());
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

    public static Animation j() {
        TranslateAnimation translateAnimation = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED);
        translateAnimation.setDuration(1500);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }
}
