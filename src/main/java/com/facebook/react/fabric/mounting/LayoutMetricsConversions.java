package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class LayoutMetricsConversions {
    public static float getMinSize(int i) {
        return View.MeasureSpec.getMode(i) == 1073741824 ? (float) View.MeasureSpec.getSize(i) : BitmapDescriptorFactory.HUE_RED;
    }

    public static float getMaxSize(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 0) {
            return Float.POSITIVE_INFINITY;
        }
        return (float) size;
    }

    public static float getYogaSize(float f2, float f3) {
        if (f2 == f3) {
            return PixelUtil.toPixelFromDIP(f3);
        }
        if (Float.isInfinite(f3)) {
            return Float.POSITIVE_INFINITY;
        }
        return PixelUtil.toPixelFromDIP(f3);
    }

    public static YogaMeasureMode getYogaMeasureMode(float f2, float f3) {
        if (f2 == f3) {
            return YogaMeasureMode.EXACTLY;
        }
        if (Float.isInfinite(f3)) {
            return YogaMeasureMode.UNDEFINED;
        }
        return YogaMeasureMode.AT_MOST;
    }
}
