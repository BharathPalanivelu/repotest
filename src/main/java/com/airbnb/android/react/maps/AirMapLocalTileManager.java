package com.airbnb.android.react.maps;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class AirMapLocalTileManager extends ViewGroupManager<d> {
    private DisplayMetrics metrics;

    public String getName() {
        return "AIRMapLocalTile";
    }

    public AirMapLocalTileManager(ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.metrics = new DisplayMetrics();
            ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
            return;
        }
        this.metrics = reactApplicationContext.getResources().getDisplayMetrics();
    }

    public d createViewInstance(ThemedReactContext themedReactContext) {
        return new d(themedReactContext);
    }

    @ReactProp(name = "pathTemplate")
    public void setPathTemplate(d dVar, String str) {
        dVar.setPathTemplate(str);
    }

    @ReactProp(defaultFloat = 256.0f, name = "tileSize")
    public void setTileSize(d dVar, float f2) {
        dVar.setTileSize(f2);
    }

    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(d dVar, float f2) {
        dVar.setZIndex(f2);
    }
}
