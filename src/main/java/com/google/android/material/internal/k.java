package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    ValueAnimator f13410a = null;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<a> f13411b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private a f13412c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f13413d = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            if (k.this.f13410a == animator) {
                k.this.f13410a = null;
            }
        }
    };

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.f13413d);
        this.f13411b.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f13411b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f13411b.get(i);
            if (StateSet.stateSetMatches(aVar.f13415a, iArr)) {
                break;
            }
            i++;
        }
        a aVar2 = this.f13412c;
        if (aVar != aVar2) {
            if (aVar2 != null) {
                b();
            }
            this.f13412c = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    private void a(a aVar) {
        this.f13410a = aVar.f13416b;
        this.f13410a.start();
    }

    private void b() {
        ValueAnimator valueAnimator = this.f13410a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f13410a = null;
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f13410a;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f13410a = null;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f13415a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f13416b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f13415a = iArr;
            this.f13416b = valueAnimator;
        }
    }
}
