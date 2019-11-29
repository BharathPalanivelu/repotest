package fr.castorflex.android.smoothprogressbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class c {
    public static Drawable a(int[] iArr, float f2) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        return new ShapeDrawable(new a(f2, iArr));
    }

    static void a(float f2) {
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
    }

    static void a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least 1 color");
        }
    }

    static void a(float f2, String str) {
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException(String.format("%s %d must be positive", new Object[]{str, Float.valueOf(f2)}));
        }
    }

    static void a(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("%s must not be null", new Object[]{str}));
        }
    }

    static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("%s must be not null", new Object[]{str}));
        }
    }
}
