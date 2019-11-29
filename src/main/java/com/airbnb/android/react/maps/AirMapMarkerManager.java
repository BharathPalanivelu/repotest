package com.airbnb.android.react.maps;

import android.graphics.Color;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.HashMap;
import java.util.Map;

public class AirMapMarkerManager extends ViewGroupManager<e> {
    private static final int ANIMATE_MARKER_TO_COORDINATE = 3;
    private static final int HIDE_INFO_WINDOW = 2;
    private static final int REDRAW = 4;
    private static final int SHOW_INFO_WINDOW = 1;

    public String getName() {
        return "AIRMapMarker";
    }

    public e createViewInstance(ThemedReactContext themedReactContext) {
        return new e(themedReactContext);
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(e eVar, ReadableMap readableMap) {
        eVar.setCoordinate(readableMap);
    }

    @ReactProp(name = "title")
    public void setTitle(e eVar, String str) {
        eVar.setTitle(str);
    }

    @ReactProp(name = "identifier")
    public void setIdentifier(e eVar, String str) {
        eVar.setIdentifier(str);
    }

    @ReactProp(name = "description")
    public void setDescription(e eVar, String str) {
        eVar.setSnippet(str);
    }

    @ReactProp(name = "anchor")
    public void setAnchor(e eVar, ReadableMap readableMap) {
        eVar.a((readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x"), (readableMap == null || !readableMap.hasKey("y")) ? 1.0d : readableMap.getDouble("y"));
    }

    @ReactProp(name = "calloutAnchor")
    public void setCalloutAnchor(e eVar, ReadableMap readableMap) {
        eVar.b((readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x"), (readableMap == null || !readableMap.hasKey("y")) ? 0.0d : readableMap.getDouble("y"));
    }

    @ReactProp(name = "image")
    public void setImage(e eVar, String str) {
        eVar.setImage(str);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "pinColor")
    public void setPinColor(e eVar, int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        eVar.setMarkerHue(fArr[0]);
    }

    @ReactProp(defaultFloat = 0.0f, name = "rotation")
    public void setMarkerRotation(e eVar, float f2) {
        eVar.setRotation(f2);
    }

    @ReactProp(defaultBoolean = false, name = "flat")
    public void setFlat(e eVar, boolean z) {
        eVar.setFlat(z);
    }

    @ReactProp(defaultBoolean = false, name = "draggable")
    public void setDraggable(e eVar, boolean z) {
        eVar.setDraggable(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "zIndex")
    public void setZIndex(e eVar, float f2) {
        super.setZIndex(eVar, f2);
        eVar.setZIndex(Math.round(f2));
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(e eVar, float f2) {
        super.setOpacity(eVar, f2);
        eVar.setOpacity(f2);
    }

    @ReactProp(defaultBoolean = true, name = "tracksViewChanges")
    public void setTracksViewChanges(e eVar, boolean z) {
        eVar.setTracksViewChanges(z);
    }

    public void addView(e eVar, View view, int i) {
        if (view instanceof a) {
            eVar.setCalloutView((a) view);
            return;
        }
        super.addView(eVar, view, i);
        eVar.a(true);
    }

    public void removeViewAt(e eVar, int i) {
        super.removeViewAt(eVar, i);
        eVar.a(true);
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("showCallout", 1, "hideCallout", 2, "animateMarkerToCoordinate", 3, "redraw", 4);
    }

    public void receiveCommand(e eVar, int i, ReadableArray readableArray) {
        if (i == 1) {
            ((Marker) eVar.getFeature()).showInfoWindow();
        } else if (i == 2) {
            ((Marker) eVar.getFeature()).hideInfoWindow();
        } else if (i == 3) {
            ReadableMap map = readableArray.getMap(0);
            eVar.a(new LatLng(Double.valueOf(map.getDouble("latitude")).doubleValue(), Double.valueOf(map.getDouble("longitude")).doubleValue()), Integer.valueOf(readableArray.getInt(1)));
        } else if (i == 4) {
            eVar.b();
        }
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map of = MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"), "onCalloutPress", MapBuilder.of("registrationName", "onCalloutPress"), "onDragStart", MapBuilder.of("registrationName", "onDragStart"), "onDrag", MapBuilder.of("registrationName", "onDrag"), "onDragEnd", MapBuilder.of("registrationName", "onDragEnd"));
        of.putAll(MapBuilder.of("onDragStart", MapBuilder.of("registrationName", "onDragStart"), "onDrag", MapBuilder.of("registrationName", "onDrag"), "onDragEnd", MapBuilder.of("registrationName", "onDragEnd")));
        return of;
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new q();
    }

    public void updateExtraData(e eVar, Object obj) {
        HashMap hashMap = (HashMap) obj;
        eVar.a((int) ((Float) hashMap.get("width")).floatValue(), (int) ((Float) hashMap.get("height")).floatValue());
    }
}
