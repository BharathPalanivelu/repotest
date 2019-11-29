package com.garena.pay.android.c;

import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static float f8173a;

    /* renamed from: b  reason: collision with root package name */
    private static int f8174b;

    /* renamed from: c  reason: collision with root package name */
    private static float f8175c;

    /* renamed from: d  reason: collision with root package name */
    private static int f8176d;

    /* renamed from: e  reason: collision with root package name */
    private static String f8177e;

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<Context> f8178f;

    public static void a(Context context) {
        WeakReference<Context> weakReference = f8178f;
        if (weakReference == null || weakReference.get() == null) {
            f8178f = new WeakReference<>(context.getApplicationContext());
            a(((Context) f8178f.get()).getResources().getDisplayMetrics());
        }
    }

    public static void a(DisplayMetrics displayMetrics) {
        f8173a = displayMetrics.density;
        f8174b = (int) ((((float) displayMetrics.densityDpi) / f8173a) + 0.5f);
        f8175c = displayMetrics.scaledDensity;
        f8176d = displayMetrics.densityDpi;
        int i = displayMetrics.densityDpi;
        if (i == 120) {
            f8177e = "ldpi";
        } else if (i == 160) {
            f8177e = "mdpi";
        } else if (i == 240) {
            f8177e = "hdpi";
        } else if (i == 320) {
            f8177e = "xhdpi";
        } else if (displayMetrics.densityDpi > 320) {
            f8177e = "xxhdpi";
        } else {
            f8177e = "mdpi";
        }
    }

    public static int a(int i) {
        return (int) ((f8173a * ((float) i)) + 0.5f);
    }
}
