package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.internal.n;
import java.util.ArrayList;

class b extends a {
    private InsetDrawable x;

    /* access modifiers changed from: package-private */
    public void g() {
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    b(n nVar, com.google.android.material.h.b bVar) {
        super(nVar, bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        this.f13298g = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.f13298g, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.f13298g, mode);
        }
        if (i > 0) {
            this.i = a(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.i, this.f13298g});
        } else {
            this.i = null;
            drawable = this.f13298g;
        }
        this.h = new RippleDrawable(com.google.android.material.g.a.a(colorStateList2), drawable, (Drawable) null);
        this.j = this.h;
        this.w.a(this.h);
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.h instanceof RippleDrawable) {
            ((RippleDrawable) this.h).setColor(com.google.android.material.g.a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.v.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(p, a(f2, f4));
            stateListAnimator.addState(q, a(f2, f3));
            stateListAnimator.addState(r, a(f2, f3));
            stateListAnimator.addState(s, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.v, "elevation", new float[]{f2}).setDuration(0));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.v, View.TRANSLATION_Z, new float[]{this.v.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.v, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(f13292a);
            stateListAnimator.addState(t, animatorSet);
            stateListAnimator.addState(u, a(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED));
            this.v.setStateListAnimator(stateListAnimator);
        }
        if (this.w.b()) {
            j();
        }
    }

    private Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.v, "elevation", new float[]{f2}).setDuration(0)).with(ObjectAnimator.ofFloat(this.v, View.TRANSLATION_Z, new float[]{f3}).setDuration(100));
        animatorSet.setInterpolator(f13292a);
        return animatorSet;
    }

    public float a() {
        return this.v.getElevation();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        j();
    }

    /* access modifiers changed from: package-private */
    public void b(Rect rect) {
        if (this.w.b()) {
            this.x = new InsetDrawable(this.h, rect.left, rect.top, rect.right, rect.bottom);
            this.w.a(this.x);
            return;
        }
        this.w.a(this.h);
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.v.isEnabled()) {
            this.v.setElevation(this.k);
            if (this.v.isPressed()) {
                this.v.setTranslationZ(this.m);
            } else if (this.v.isFocused() || this.v.isHovered()) {
                this.v.setTranslationZ(this.l);
            } else {
                this.v.setTranslationZ(BitmapDescriptorFactory.HUE_RED);
            }
        } else {
            this.v.setElevation(BitmapDescriptorFactory.HUE_RED);
            this.v.setTranslationZ(BitmapDescriptorFactory.HUE_RED);
        }
    }

    /* access modifiers changed from: package-private */
    public com.google.android.material.internal.a n() {
        return new com.google.android.material.internal.b();
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable q() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        if (this.w.b()) {
            float a2 = this.w.a();
            float a3 = a() + this.m;
            int ceil = (int) Math.ceil((double) com.google.android.material.h.a.b(a3, a2, false));
            int ceil2 = (int) Math.ceil((double) com.google.android.material.h.a.a(a3, a2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    static class a extends GradientDrawable {
        public boolean isStateful() {
            return true;
        }

        a() {
        }
    }
}
