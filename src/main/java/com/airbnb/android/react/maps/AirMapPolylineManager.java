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

public class AirMapPolylineManager extends ViewGroupManager<h> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapPolyline";
    }

    public AirMapPolylineManager(ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.metrics = new DisplayMetrics();
            ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
            return;
        }
        this.metrics = reactApplicationContext.getResources().getDisplayMetrics();
    }

    public h createViewInstance(ThemedReactContext themedReactContext) {
        return new h(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(h hVar, ReadableArray readableArray) {
        hVar.setCoordinates(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(h hVar, float f2) {
        hVar.setWidth(this.metrics.density * f2);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(h hVar, int i) {
        hVar.setColor(i);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(h hVar, boolean z) {
        hVar.setGeodesic(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(h hVar, float f2) {
        hVar.setZIndex(f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "lineCap")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setlineCap(com.airbnb.android.react.maps.h r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = -894674659(0xffffffffcaac591d, float:-5647502.5)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 3035667(0x2e5213, float:4.253876E-39)
            if (r0 == r1) goto L_0x0020
            r1 = 108704142(0x67ab18e, float:4.715022E-35)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "round"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "butt"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "square"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = 2
            goto L_0x0035
        L_0x0034:
            r6 = -1
        L_0x0035:
            if (r6 == 0) goto L_0x004d
            if (r6 == r3) goto L_0x0047
            if (r6 == r2) goto L_0x0041
            com.google.android.gms.maps.model.RoundCap r6 = new com.google.android.gms.maps.model.RoundCap
            r6.<init>()
            goto L_0x0052
        L_0x0041:
            com.google.android.gms.maps.model.SquareCap r6 = new com.google.android.gms.maps.model.SquareCap
            r6.<init>()
            goto L_0x0052
        L_0x0047:
            com.google.android.gms.maps.model.RoundCap r6 = new com.google.android.gms.maps.model.RoundCap
            r6.<init>()
            goto L_0x0052
        L_0x004d:
            com.google.android.gms.maps.model.ButtCap r6 = new com.google.android.gms.maps.model.ButtCap
            r6.<init>()
        L_0x0052:
            r5.setLineCap(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.maps.AirMapPolylineManager.setlineCap(com.airbnb.android.react.maps.h, java.lang.String):void");
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
