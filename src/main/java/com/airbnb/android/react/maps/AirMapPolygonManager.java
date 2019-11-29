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

public class AirMapPolygonManager extends ViewGroupManager<g> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapPolygon";
    }

    public AirMapPolygonManager(ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.metrics = new DisplayMetrics();
            ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
            return;
        }
        this.metrics = reactApplicationContext.getResources().getDisplayMetrics();
    }

    public g createViewInstance(ThemedReactContext themedReactContext) {
        return new g(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(g gVar, ReadableArray readableArray) {
        gVar.setCoordinates(readableArray);
    }

    @ReactProp(name = "holes")
    public void setHoles(g gVar, ReadableArray readableArray) {
        gVar.setHoles(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(g gVar, float f2) {
        gVar.setStrokeWidth(this.metrics.density * f2);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "fillColor")
    public void setFillColor(g gVar, int i) {
        gVar.setFillColor(i);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(g gVar, int i) {
        gVar.setStrokeColor(i);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(g gVar, boolean z) {
        gVar.setTappable(z);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(g gVar, boolean z) {
        gVar.setGeodesic(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(g gVar, float f2) {
        gVar.setZIndex(f2);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
