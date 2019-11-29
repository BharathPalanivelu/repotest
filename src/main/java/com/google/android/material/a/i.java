package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f13112a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f13113b = 300;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f13114c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f13115d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f13116e = 1;

    public i(long j, long j2) {
        this.f13112a = j;
        this.f13113b = j2;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f13112a = j;
        this.f13113b = j2;
        this.f13114c = timeInterpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long a() {
        return this.f13112a;
    }

    public long b() {
        return this.f13113b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f13114c;
        return timeInterpolator != null ? timeInterpolator : a.f13099b;
    }

    public int d() {
        return this.f13115d;
    }

    public int e() {
        return this.f13116e;
    }

    static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f13115d = valueAnimator.getRepeatCount();
        iVar.f13116e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f13099b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f13100c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f13101d : interpolator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }
}
