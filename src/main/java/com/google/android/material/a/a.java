package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.f.a.a.b;
import androidx.f.a.a.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f13098a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f13099b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f13100c = new androidx.f.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f13101d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f13102e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i, int i2, float f2) {
        return i + Math.round(f2 * ((float) (i2 - i)));
    }
}
