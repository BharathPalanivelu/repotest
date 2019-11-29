package com.afollestad.materialdialogs.a;

import android.content.Context;
import android.graphics.Typeface;
import androidx.b.g;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final g<String, Typeface> f3143a = new g<>();

    public static Typeface a(Context context, String str) {
        synchronized (f3143a) {
            if (!f3143a.containsKey(str)) {
                try {
                    Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", new Object[]{str}));
                    f3143a.put(str, createFromAsset);
                    return createFromAsset;
                } catch (RuntimeException unused) {
                    return null;
                }
            } else {
                Typeface typeface = f3143a.get(str);
                return typeface;
            }
        }
    }
}
