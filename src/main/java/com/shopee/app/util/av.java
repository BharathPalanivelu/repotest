package com.shopee.app.util;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.core.g.w;
import androidx.core.graphics.drawable.a;
import com.shopee.app.application.ar;
import com.shopee.id.R;

public class av {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f26170a = (Build.VERSION.SDK_INT >= 19 && ar.f().getResources().getBoolean(R.bool.isRightToLeft));

    public static void a(ImageView... imageViewArr) {
        if (f26170a) {
            for (ImageView drawable : imageViewArr) {
                Drawable drawable2 = drawable.getDrawable();
                if (drawable2 != null) {
                    Drawable g2 = a.g(drawable2);
                    if (g2 != null) {
                        g2.setAutoMirrored(true);
                    }
                }
            }
        }
    }

    public static void a(View view, int i) {
        view.setBackgroundResource(i);
        if (f26170a) {
            Drawable background = view.getBackground();
            if (background != null) {
                Drawable g2 = a.g(background);
                if (g2 != null) {
                    g2.setAutoMirrored(true);
                }
            }
        }
    }

    public static void a(View view, Drawable drawable) {
        w.a(view, drawable);
        if (f26170a) {
            Drawable background = view.getBackground();
            if (background != null) {
                Drawable g2 = a.g(background);
                if (g2 != null) {
                    g2.setAutoMirrored(true);
                }
            }
        }
    }
}
