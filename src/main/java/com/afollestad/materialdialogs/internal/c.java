package com.afollestad.materialdialogs.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.afollestad.materialdialogs.e;

public class c {
    private static c v;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3188a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f3189b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f3190c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f3191d = null;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f3192e = null;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f3193f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f3194g = 0;
    public int h = 0;
    public Drawable i = null;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public e q = e.START;
    public e r = e.START;
    public e s = e.END;
    public e t = e.START;
    public e u = e.START;

    public static c a(boolean z) {
        if (v == null && z) {
            v = new c();
        }
        return v;
    }

    public static c a() {
        return a(true);
    }
}
