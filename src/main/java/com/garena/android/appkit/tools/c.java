package com.garena.android.appkit.tools;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.garena.android.appkit.d.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f7697a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static float f7698b;

    /* renamed from: c  reason: collision with root package name */
    private static int f7699c;

    /* renamed from: d  reason: collision with root package name */
    private static float f7700d;

    /* renamed from: e  reason: collision with root package name */
    private static int f7701e;

    /* renamed from: f  reason: collision with root package name */
    private static String f7702f;

    public static c a() {
        return f7697a;
    }

    private c() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        f7698b = displayMetrics.density;
        f7699c = (int) ((((float) displayMetrics.densityDpi) / f7698b) + 0.5f);
        f7700d = displayMetrics.scaledDensity;
        f7701e = displayMetrics.densityDpi;
        int i = displayMetrics.densityDpi;
        if (i == 120) {
            f7702f = "ldpi";
        } else if (i == 160) {
            f7702f = "mdpi";
        } else if (i == 240) {
            f7702f = "hdpi";
        } else if (i == 320) {
            f7702f = "xhdpi";
        } else if (displayMetrics.densityDpi > 320) {
            f7702f = "xxhdpi";
        } else {
            f7702f = "hdpi";
        }
        a.e("Display info:%s :%d ", displayMetrics.toString(), Integer.valueOf(displayMetrics.densityDpi));
    }

    public int b() {
        return f7701e;
    }

    public int a(int i) {
        return (int) ((f7698b * ((float) i)) + 0.5f);
    }

    public int a(float f2) {
        return (int) ((f2 / f7698b) + 0.5f);
    }

    public float b(float f2) {
        return f2 * f7700d;
    }
}
