package com.google.android.libraries.places.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

final class fo extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ View f12566a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ RecyclerView.w f12567b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ViewPropertyAnimator f12568c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ fn f12569d;

    fo(fn fnVar, View view, RecyclerView.w wVar, ViewPropertyAnimator viewPropertyAnimator) {
        this.f12569d = fnVar;
        this.f12566a = view;
        this.f12567b = wVar;
        this.f12568c = viewPropertyAnimator;
    }

    public final void onAnimationStart(Animator animator) {
        try {
            this.f12566a.setAlpha(BitmapDescriptorFactory.HUE_RED);
            this.f12569d.dispatchAddStarting(this.f12567b);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void onAnimationCancel(Animator animator) {
        try {
            fn fnVar = this.f12569d;
            fn.a(this.f12566a);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void onAnimationEnd(Animator animator) {
        try {
            this.f12568c.setListener((Animator.AnimatorListener) null);
            this.f12569d.dispatchAddFinished(this.f12567b);
            this.f12569d.f12562a.remove(this.f12567b);
            this.f12569d.a();
            this.f12568c.setStartDelay(0);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
