package com.shopee.livequiz.ui.view.a;

import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.PopupWindow;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;

class c extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private View f30008a;

    /* renamed from: b  reason: collision with root package name */
    private View f30009b;

    /* renamed from: c  reason: collision with root package name */
    private AnimationSet f30010c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30011d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30012e;

    c(View view, int i, int i2, View view2, AnimationSet animationSet, View view3, boolean z) {
        super(view, i, i2);
        this.f30008a = view2;
        this.f30009b = view3;
        this.f30010c = animationSet;
        this.f30011d = z;
    }

    public void a(boolean z) {
        this.f30012e = z;
    }

    public void dismiss() {
        if (this.f30012e) {
            a();
        }
    }

    public void a() {
        if (this.f30011d) {
            View view = this.f30009b;
            if (view != null) {
                view.startAnimation(b.a(1.0f, BitmapDescriptorFactory.HUE_RED));
            }
        }
        View view2 = this.f30008a;
        if (view2 == null || this.f30010c == null) {
            b();
            return;
        }
        view2.clearAnimation();
        this.f30008a.setAnimation(this.f30010c);
        this.f30010c.startNow();
        f.b(new e() {
            public void a() {
                c.this.b();
            }
        }, this.f30010c.getDuration());
    }

    /* access modifiers changed from: private */
    public void b() {
        super.dismiss();
    }
}
