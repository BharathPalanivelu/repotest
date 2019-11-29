package com.airbnb.android.react.maps;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class AirMapUrlTileManager extends ViewGroupManager<i> {
    private DisplayMetrics metrics;

    public String getName() {
        return "AIRMapUrlTile";
    }

    public AirMapUrlTileManager(ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.metrics = new DisplayMetrics();
            ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
            return;
        }
        this.metrics = reactApplicationContext.getResources().getDisplayMetrics();
    }

    public i createViewInstance(ThemedReactContext themedReactContext) {
        return new i(themedReactContext);
    }

    @ReactProp(name = "urlTemplate")
    public void setUrlTemplate(i iVar, String str) {
        iVar.setUrlTemplate(str);
    }

    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(i iVar, float f2) {
        iVar.setZIndex(f2);
    }

    @ReactProp(defaultFloat = 0.0f, name = "minimumZ")
    public void setMinimumZ(i iVar, float f2) {
        iVar.setMinimumZ(f2);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumZ")
    public void setMaximumZ(i iVar, float f2) {
        iVar.setMaximumZ(f2);
    }
}
