package com.shopee.app.react.view.effectimage;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.image.ReactImageView;
import com.garena.android.appkit.d.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class RNEffectImageViewManager extends ReactImageManager {
    private static final String FILTER_BLUR = "blur";
    private static final String FILTER_GRAYSCALE = "grayscale";
    private static final String FILTER_MONOCHROME = "monochrome";
    public static final ColorMatrix GRAYSCALE_MATRIX = new ColorMatrix(new float[]{lr, lg, lb, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, lr, lg, lb, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, lr, lg, lb, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED});
    private static final float lb = 0.0722f;
    private static final float lg = 0.7152f;
    private static final float lr = 0.2126f;

    public String getName() {
        return "RNEffectImageView";
    }

    public ReactImageView createViewInstance(ThemedReactContext themedReactContext) {
        return new a(themedReactContext, getDraweeControllerBuilder(), getCallerContext());
    }

    @ReactProp(name = "filters")
    public void setFilters(a aVar, ReadableArray readableArray) {
        if (readableArray != null && readableArray.size() != 0) {
            int i = 0;
            while (i < readableArray.size()) {
                try {
                    ReadableMap map = readableArray.getMap(i);
                    String string = map.getString("type");
                    char c2 = 65535;
                    int hashCode = string.hashCode();
                    if (hashCode != -1905977571) {
                        if (hashCode != -905411385) {
                            if (hashCode == 3027047) {
                                if (string.equals(FILTER_BLUR)) {
                                    c2 = 1;
                                }
                            }
                        } else if (string.equals(FILTER_GRAYSCALE)) {
                            c2 = 0;
                        }
                    } else if (string.equals(FILTER_MONOCHROME)) {
                        c2 = 2;
                    }
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 == 2) {
                                if (map.hasKey(ViewProps.COLOR)) {
                                    int parseColor = Color.parseColor(map.getString(ViewProps.COLOR));
                                    float f2 = 1.0f;
                                    if (map.hasKey("intensity")) {
                                        f2 = (float) map.getDouble("intensity");
                                    }
                                    aVar.a(parseColor, f2);
                                }
                            }
                        } else if (map.hasKey("radius")) {
                            double d2 = map.getDouble("radius");
                            if (d2 > 0.0d) {
                                aVar.setBlurRadius((float) d2);
                            }
                        }
                    } else if (map.hasKey("enable") && map.getBoolean("enable")) {
                        aVar.setColorFilter(new ColorMatrixColorFilter(GRAYSCALE_MATRIX));
                    }
                    i++;
                } catch (Exception e2) {
                    a.a(e2);
                    return;
                }
            }
        }
    }
}
