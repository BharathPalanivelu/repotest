package com.shopee.live.livestreaming.ui.view.c;

import android.app.Activity;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.PopupWindow;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class g extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private View f29281a;

    /* renamed from: b  reason: collision with root package name */
    private View f29282b;

    /* renamed from: c  reason: collision with root package name */
    private AnimationSet f29283c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29284d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29285e;

    public void a(boolean z) {
        this.f29285e = z;
    }

    g(View view, int i, int i2, View view2, AnimationSet animationSet, View view3, boolean z) {
        super(view, i, i2);
        this.f29281a = view2;
        this.f29282b = view3;
        this.f29283c = animationSet;
        this.f29284d = z;
    }

    public void dismiss() {
        if (getContentView() != null && (getContentView().getContext() instanceof Activity) && !((Activity) getContentView().getContext()).isFinishing() && this.f29285e) {
            a();
        }
    }

    public void a() {
        if (this.f29284d) {
            View view = this.f29282b;
            if (view != null) {
                view.startAnimation(b.a(1.0f, BitmapDescriptorFactory.HUE_RED));
            }
        }
        View view2 = this.f29281a;
        if (view2 == null || this.f29283c == null) {
            b();
            return;
        }
        view2.clearAnimation();
        this.f29281a.setAnimation(this.f29283c);
        this.f29283c.startNow();
        this.f29281a.postDelayed(new Runnable() {
            public void run() {
                g.this.b();
            }
        }, this.f29283c.getDuration());
    }

    /* access modifiers changed from: private */
    public void b() {
        if (getContentView() == null || !(getContentView().getContext() instanceof Activity) || !((Activity) getContentView().getContext()).isFinishing()) {
            super.dismiss();
        }
    }
}
