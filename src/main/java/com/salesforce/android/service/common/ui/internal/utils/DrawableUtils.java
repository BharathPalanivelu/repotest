package com.salesforce.android.service.common.ui.internal.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.appcompat.a.a.a;
import androidx.core.content.b;

public class DrawableUtils {
    public static Drawable colorize(Drawable drawable, int i) {
        drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        return drawable;
    }

    public static Drawable getColoredIcon(Context context, int i, int i2) {
        int c2 = b.c(context, i2);
        Drawable b2 = a.b(context, i);
        if (b2 != null) {
            colorize(b2, c2);
        }
        return b2;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }
}
