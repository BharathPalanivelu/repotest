package com.airbnb.android.react.maps;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class AirMapOverlayManager extends ViewGroupManager<f> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapOverlay";
    }

    public AirMapOverlayManager(ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.metrics = new DisplayMetrics();
            ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
            return;
        }
        this.metrics = reactApplicationContext.getResources().getDisplayMetrics();
    }

    public f createViewInstance(ThemedReactContext themedReactContext) {
        return new f(themedReactContext);
    }

    @ReactProp(name = "bounds")
    public void setBounds(f fVar, ReadableArray readableArray) {
        fVar.setBounds(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(f fVar, float f2) {
        fVar.setZIndex(f2);
    }

    @ReactProp(name = "image")
    public void setImage(f fVar, String str) {
        fVar.setImage(str);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
