package com.afollestad.materialdialogs.internal.progress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import com.afollestad.materialdialogs.internal.progress.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@TargetApi(14)
class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Path f3201a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private static final Path f3202b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private static final Path f3203c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private static final Path f3204d = new Path();

    static {
        f3201a.moveTo(-522.6f, BitmapDescriptorFactory.HUE_RED);
        f3201a.rCubicTo(48.89972f, BitmapDescriptorFactory.HUE_RED, 166.02657f, BitmapDescriptorFactory.HUE_RED, 301.2173f, BitmapDescriptorFactory.HUE_RED);
        f3201a.rCubicTo(197.58128f, BitmapDescriptorFactory.HUE_RED, 420.9827f, BitmapDescriptorFactory.HUE_RED, 420.9827f, BitmapDescriptorFactory.HUE_RED);
        f3202b.moveTo(BitmapDescriptorFactory.HUE_RED, 0.1f);
        f3202b.lineTo(1.0f, 0.8268492f);
        f3202b.lineTo(2.0f, 0.1f);
        f3203c.moveTo(-197.6f, BitmapDescriptorFactory.HUE_RED);
        f3203c.rCubicTo(14.28182f, BitmapDescriptorFactory.HUE_RED, 85.07782f, BitmapDescriptorFactory.HUE_RED, 135.54689f, BitmapDescriptorFactory.HUE_RED);
        f3203c.rCubicTo(54.26191f, BitmapDescriptorFactory.HUE_RED, 90.42461f, BitmapDescriptorFactory.HUE_RED, 168.24332f, BitmapDescriptorFactory.HUE_RED);
        f3203c.rCubicTo(144.72154f, BitmapDescriptorFactory.HUE_RED, 316.40982f, BitmapDescriptorFactory.HUE_RED, 316.40982f, BitmapDescriptorFactory.HUE_RED);
        f3204d.moveTo(BitmapDescriptorFactory.HUE_RED, 0.1f);
        f3204d.lineTo(1.0f, 0.5713795f);
        f3204d.lineTo(2.0f, 0.90995026f);
        f3204d.lineTo(3.0f, 0.1f);
    }

    public static Animator a(Object obj) {
        ObjectAnimator a2 = e.a(obj, "translateX", (String) null, f3201a);
        a2.setDuration(2000);
        a2.setInterpolator(d.b.f3212a);
        a2.setRepeatCount(-1);
        ObjectAnimator a3 = e.a(obj, (String) null, "scaleX", f3202b);
        a3.setDuration(2000);
        a3.setInterpolator(d.a.f3210a);
        a3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{a2, a3});
        return animatorSet;
    }

    public static Animator b(Object obj) {
        ObjectAnimator a2 = e.a(obj, "translateX", (String) null, f3203c);
        a2.setDuration(2000);
        a2.setInterpolator(d.C0067d.f3216a);
        a2.setRepeatCount(-1);
        ObjectAnimator a3 = e.a(obj, (String) null, "scaleX", f3204d);
        a3.setDuration(2000);
        a3.setInterpolator(d.c.f3214a);
        a3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{a2, a3});
        return animatorSet;
    }

    public static Animator c(Object obj) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(obj, "trimPathStart", new float[]{BitmapDescriptorFactory.HUE_RED, 0.75f});
        ofFloat.setDuration(1333);
        ofFloat.setInterpolator(d.g.f3221a);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(obj, "trimPathEnd", new float[]{BitmapDescriptorFactory.HUE_RED, 0.75f});
        ofFloat2.setDuration(1333);
        ofFloat2.setInterpolator(d.f.f3219a);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(obj, "trimPathOffset", new float[]{BitmapDescriptorFactory.HUE_RED, 0.25f});
        ofFloat3.setDuration(1333);
        ofFloat3.setInterpolator(d.e.f3218a);
        ofFloat3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        return animatorSet;
    }

    public static Animator d(Object obj) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(obj, "rotation", new float[]{BitmapDescriptorFactory.HUE_RED, 720.0f});
        ofFloat.setDuration(6665);
        ofFloat.setInterpolator(d.e.f3218a);
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }
}
