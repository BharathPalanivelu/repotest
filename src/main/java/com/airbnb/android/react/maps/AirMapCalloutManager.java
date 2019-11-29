package com.airbnb.android.react.maps;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class AirMapCalloutManager extends ViewGroupManager<a> {
    public String getName() {
        return "AIRMapCallout";
    }

    public a createViewInstance(ThemedReactContext themedReactContext) {
        return new a(themedReactContext);
    }

    @ReactProp(defaultBoolean = false, name = "tooltip")
    public void setTooltip(a aVar, boolean z) {
        aVar.setTooltip(z);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new q();
    }

    public void updateExtraData(a aVar, Object obj) {
        Map map = (Map) obj;
        float floatValue = ((Float) map.get("width")).floatValue();
        float floatValue2 = ((Float) map.get("height")).floatValue();
        aVar.f3248a = (int) floatValue;
        aVar.f3249b = (int) floatValue2;
    }
}
