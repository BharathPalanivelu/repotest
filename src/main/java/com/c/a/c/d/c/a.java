package com.c.a.c.d.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.a.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f6057a = true;

    public static Drawable a(Context context, int i) {
        return a(context, i, (Resources.Theme) null);
    }

    public static Drawable a(Context context, int i, Resources.Theme theme) {
        try {
            if (f6057a) {
                return b(context, i);
            }
        } catch (NoClassDefFoundError unused) {
            f6057a = false;
        }
        if (theme == null) {
            theme = context.getTheme();
        }
        return b(context, i, theme);
    }

    private static Drawable b(Context context, int i) {
        return androidx.appcompat.a.a.a.b(context, i);
    }

    private static Drawable b(Context context, int i, Resources.Theme theme) {
        return f.a(context.getResources(), i, theme);
    }
}
