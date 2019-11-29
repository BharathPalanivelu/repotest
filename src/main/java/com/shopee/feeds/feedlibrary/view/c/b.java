package com.shopee.feeds.feedlibrary.view.c;

import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.PopupWindow;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private View f28562a;

    /* renamed from: b  reason: collision with root package name */
    private View f28563b;

    /* renamed from: c  reason: collision with root package name */
    private AnimationSet f28564c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28565d;

    b(View view, int i, int i2, View view2, AnimationSet animationSet, View view3, boolean z) {
        super(view, i, i2);
        this.f28562a = view2;
        this.f28563b = view3;
        this.f28564c = animationSet;
        this.f28565d = z;
    }

    public void dismiss() {
        if (this.f28565d) {
            View view = this.f28563b;
            if (view != null) {
                view.startAnimation(a.a(1.0f, BitmapDescriptorFactory.HUE_RED));
            }
        }
        View view2 = this.f28562a;
        if (view2 == null || this.f28564c == null) {
            a();
            return;
        }
        view2.clearAnimation();
        this.f28562a.setAnimation(this.f28564c);
        this.f28564c.startNow();
        this.f28562a.postDelayed(new Runnable() {
            public void run() {
                b.this.a();
            }
        }, this.f28564c.getDuration());
    }

    /* access modifiers changed from: private */
    public void a() {
        super.dismiss();
    }
}
