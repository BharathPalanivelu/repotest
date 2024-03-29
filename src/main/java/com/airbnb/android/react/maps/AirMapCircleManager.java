package com.airbnb.android.react.maps;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;

public class AirMapCircleManager extends ViewGroupManager<b> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapCircle";
    }

    public AirMapCircleManager(ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.metrics = new DisplayMetrics();
            ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
            return;
        }
        this.metrics = reactApplicationContext.getResources().getDisplayMetrics();
    }

    public b createViewInstance(ThemedReactContext themedReactContext) {
        return new b(themedReactContext);
    }

    @ReactProp(name = "center")
    public void setCenter(b bVar, ReadableMap readableMap) {
        bVar.setCenter(new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude")));
    }

    @ReactProp(defaultDouble = 0.0d, name = "radius")
    public void setRadius(b bVar, double d2) {
        bVar.setRadius(d2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(b bVar, float f2) {
        bVar.setStrokeWidth(this.metrics.density * f2);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "fillColor")
    public void setFillColor(b bVar, int i) {
        bVar.setFillColor(i);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(b bVar, int i) {
        bVar.setStrokeColor(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(b bVar, float f2) {
        bVar.setZIndex(f2);
    }
}
