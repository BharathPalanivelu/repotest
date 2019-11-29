package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class AspectRatioMeasure {

    public static class Spec {
        public int height;
        public int width;
    }

    private static boolean shouldAdjust(int i) {
        return i == 0 || i == -2;
    }

    public static void updateMeasureSpec(Spec spec, float f2, ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f2 > BitmapDescriptorFactory.HUE_RED && layoutParams != null) {
            if (shouldAdjust(layoutParams.height)) {
                spec.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(spec.width) - i)) / f2) + ((float) i2)), spec.height), 1073741824);
            } else if (shouldAdjust(layoutParams.width)) {
                spec.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(spec.height) - i2)) * f2) + ((float) i)), spec.width), 1073741824);
            }
        }
    }
}
