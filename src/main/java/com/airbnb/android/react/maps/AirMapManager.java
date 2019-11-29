package com.airbnb.android.react.maps;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import java.util.HashMap;
import java.util.Map;

public class AirMapManager extends ViewGroupManager<j> {
    private static final int ANIMATE_TO_BEARING = 4;
    private static final int ANIMATE_TO_COORDINATE = 2;
    private static final int ANIMATE_TO_NAVIGATION = 9;
    private static final int ANIMATE_TO_REGION = 1;
    private static final int ANIMATE_TO_VIEWING_ANGLE = 3;
    private static final int FIT_TO_COORDINATES = 7;
    private static final int FIT_TO_ELEMENTS = 5;
    private static final int FIT_TO_SUPPLIED_MARKERS = 6;
    private static final String REACT_CLASS = "AIRMap";
    private static final int SET_INDOOR_ACTIVE_LEVEL_INDEX = 10;
    private static final int SET_MAP_BOUNDARIES = 8;
    private final Map<String, Integer> MAP_TYPES = MapBuilder.of("standard", 1, "satellite", 2, "hybrid", 4, "terrain", 3, ViewProps.NONE, 0);
    private final ReactApplicationContext appContext;
    protected GoogleMapOptions googleMapOptions;

    public String getName() {
        return REACT_CLASS;
    }

    public AirMapManager(ReactApplicationContext reactApplicationContext) {
        this.appContext = reactApplicationContext;
        this.googleMapOptions = new GoogleMapOptions();
    }

    /* access modifiers changed from: protected */
    public j createViewInstance(ThemedReactContext themedReactContext) {
        return new j(themedReactContext, this.appContext, this, this.googleMapOptions);
    }

    private void emitMapError(ThemedReactContext themedReactContext, String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
        createMap.putString("type", str2);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) themedReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onError", createMap);
    }

    @ReactProp(name = "region")
    public void setRegion(j jVar, ReadableMap readableMap) {
        jVar.setRegion(readableMap);
    }

    @ReactProp(name = "initialRegion")
    public void setInitialRegion(j jVar, ReadableMap readableMap) {
        jVar.setInitialRegion(readableMap);
    }

    @ReactProp(name = "mapType")
    public void setMapType(j jVar, String str) {
        jVar.f3306a.setMapType(this.MAP_TYPES.get(str).intValue());
    }

    @ReactProp(name = "customMapStyleString")
    public void setMapStyle(j jVar, String str) {
        jVar.f3306a.setMapStyle(new MapStyleOptions(str));
    }

    @ReactProp(name = "mapPadding")
    public void setMapPadding(j jVar, ReadableMap readableMap) {
        int i;
        int i2;
        int i3;
        double d2 = (double) jVar.getResources().getDisplayMetrics().density;
        int i4 = 0;
        if (readableMap != null) {
            if (readableMap.hasKey(ViewProps.LEFT)) {
                double d3 = readableMap.getDouble(ViewProps.LEFT);
                Double.isNaN(d2);
                i3 = (int) (d3 * d2);
            } else {
                i3 = 0;
            }
            if (readableMap.hasKey(ViewProps.TOP)) {
                double d4 = readableMap.getDouble(ViewProps.TOP);
                Double.isNaN(d2);
                i2 = (int) (d4 * d2);
            } else {
                i2 = 0;
            }
            if (readableMap.hasKey(ViewProps.RIGHT)) {
                double d5 = readableMap.getDouble(ViewProps.RIGHT);
                Double.isNaN(d2);
                i = (int) (d5 * d2);
            } else {
                i = 0;
            }
            if (readableMap.hasKey(ViewProps.BOTTOM)) {
                double d6 = readableMap.getDouble(ViewProps.BOTTOM);
                Double.isNaN(d2);
                i4 = (int) (d6 * d2);
            }
        } else {
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        jVar.f3306a.setPadding(i3, i2, i, i4);
    }

    @ReactProp(defaultBoolean = false, name = "showsUserLocation")
    public void setShowsUserLocation(j jVar, boolean z) {
        jVar.setShowsUserLocation(z);
    }

    @ReactProp(defaultBoolean = true, name = "showsMyLocationButton")
    public void setShowsMyLocationButton(j jVar, boolean z) {
        jVar.setShowsMyLocationButton(z);
    }

    @ReactProp(defaultBoolean = true, name = "toolbarEnabled")
    public void setToolbarEnabled(j jVar, boolean z) {
        jVar.setToolbarEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "handlePanDrag")
    public void setHandlePanDrag(j jVar, boolean z) {
        jVar.setHandlePanDrag(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsTraffic")
    public void setShowTraffic(j jVar, boolean z) {
        jVar.f3306a.setTrafficEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsBuildings")
    public void setShowBuildings(j jVar, boolean z) {
        jVar.f3306a.setBuildingsEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoors")
    public void setShowIndoors(j jVar, boolean z) {
        jVar.f3306a.setIndoorEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoorLevelPicker")
    public void setShowsIndoorLevelPicker(j jVar, boolean z) {
        jVar.f3306a.getUiSettings().setIndoorLevelPickerEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsCompass")
    public void setShowsCompass(j jVar, boolean z) {
        jVar.f3306a.getUiSettings().setCompassEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "scrollEnabled")
    public void setScrollEnabled(j jVar, boolean z) {
        jVar.f3306a.getUiSettings().setScrollGesturesEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "zoomEnabled")
    public void setZoomEnabled(j jVar, boolean z) {
        jVar.f3306a.getUiSettings().setZoomGesturesEnabled(z);
    }

    @ReactProp(defaultBoolean = true, name = "zoomControlEnabled")
    public void setZoomControlEnabled(j jVar, boolean z) {
        jVar.f3306a.getUiSettings().setZoomControlsEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "rotateEnabled")
    public void setRotateEnabled(j jVar, boolean z) {
        jVar.f3306a.getUiSettings().setRotateGesturesEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "cacheEnabled")
    public void setCacheEnabled(j jVar, boolean z) {
        jVar.setCacheEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "loadingEnabled")
    public void setLoadingEnabled(j jVar, boolean z) {
        jVar.a(z);
    }

    @ReactProp(defaultBoolean = true, name = "moveOnMarkerPress")
    public void setMoveOnMarkerPress(j jVar, boolean z) {
        jVar.setMoveOnMarkerPress(z);
    }

    @ReactProp(customType = "Color", name = "loadingBackgroundColor")
    public void setLoadingBackgroundColor(j jVar, Integer num) {
        jVar.setLoadingBackgroundColor(num);
    }

    @ReactProp(customType = "Color", name = "loadingIndicatorColor")
    public void setLoadingIndicatorColor(j jVar, Integer num) {
        jVar.setLoadingIndicatorColor(num);
    }

    @ReactProp(defaultBoolean = false, name = "pitchEnabled")
    public void setPitchEnabled(j jVar, boolean z) {
        jVar.f3306a.getUiSettings().setTiltGesturesEnabled(z);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(j jVar, float f2) {
        jVar.f3306a.setMinZoomPreference(f2);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(j jVar, float f2) {
        jVar.f3306a.setMaxZoomPreference(f2);
    }

    @ReactProp(name = "kmlSrc")
    public void setKmlSrc(j jVar, String str) {
        if (str != null) {
            jVar.setKmlSrc(str);
        }
    }

    public void receiveCommand(j jVar, int i, ReadableArray readableArray) {
        j jVar2 = jVar;
        ReadableArray readableArray2 = readableArray;
        switch (i) {
            case 1:
                ReadableMap map = readableArray2.getMap(0);
                Integer valueOf = Integer.valueOf(readableArray2.getInt(1));
                Double valueOf2 = Double.valueOf(map.getDouble("longitude"));
                Double valueOf3 = Double.valueOf(map.getDouble("latitude"));
                Double valueOf4 = Double.valueOf(map.getDouble("longitudeDelta"));
                Double valueOf5 = Double.valueOf(map.getDouble("latitudeDelta"));
                jVar2.a(new LatLngBounds(new LatLng(valueOf3.doubleValue() - (valueOf5.doubleValue() / 2.0d), valueOf2.doubleValue() - (valueOf4.doubleValue() / 2.0d)), new LatLng(valueOf3.doubleValue() + (valueOf5.doubleValue() / 2.0d), valueOf2.doubleValue() + (valueOf4.doubleValue() / 2.0d))), valueOf.intValue());
                return;
            case 2:
                ReadableMap map2 = readableArray2.getMap(0);
                Integer valueOf6 = Integer.valueOf(readableArray2.getInt(1));
                jVar2.a(new LatLng(Double.valueOf(map2.getDouble("latitude")).doubleValue(), Double.valueOf(map2.getDouble("longitude")).doubleValue()), valueOf6.intValue());
                return;
            case 3:
                jVar2.a((float) readableArray2.getDouble(0), Integer.valueOf(readableArray2.getInt(1)).intValue());
                return;
            case 4:
                jVar2.b((float) readableArray2.getDouble(0), Integer.valueOf(readableArray2.getInt(1)).intValue());
                return;
            case 5:
                jVar2.b(readableArray2.getBoolean(0));
                return;
            case 6:
                jVar2.a(readableArray2.getArray(0), readableArray2.getMap(1), readableArray2.getBoolean(2));
                return;
            case 7:
                jVar2.b(readableArray2.getArray(0), readableArray2.getMap(1), readableArray2.getBoolean(2));
                return;
            case 8:
                jVar2.a(readableArray2.getMap(0), readableArray2.getMap(1));
                return;
            case 9:
                ReadableMap map3 = readableArray2.getMap(0);
                jVar2.a(new LatLng(Double.valueOf(map3.getDouble("latitude")).doubleValue(), Double.valueOf(map3.getDouble("longitude")).doubleValue()), (float) readableArray2.getDouble(1), (float) readableArray2.getDouble(2), Integer.valueOf(readableArray2.getInt(3)).intValue());
                return;
            case 10:
                jVar2.setIndoorActiveLevelIndex(readableArray2.getInt(0));
                return;
            default:
                return;
        }
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map of = MapBuilder.of("onMapReady", MapBuilder.of("registrationName", "onMapReady"), "onPress", MapBuilder.of("registrationName", "onPress"), "onLongPress", MapBuilder.of("registrationName", "onLongPress"), "onMarkerPress", MapBuilder.of("registrationName", "onMarkerPress"), "onMarkerSelect", MapBuilder.of("registrationName", "onMarkerSelect"), "onMarkerDeselect", MapBuilder.of("registrationName", "onMarkerDeselect"), "onCalloutPress", MapBuilder.of("registrationName", "onCalloutPress"));
        of.putAll(MapBuilder.of("onUserLocationChange", MapBuilder.of("registrationName", "onUserLocationChange"), "onMarkerDragStart", MapBuilder.of("registrationName", "onMarkerDragStart"), "onMarkerDrag", MapBuilder.of("registrationName", "onMarkerDrag"), "onMarkerDragEnd", MapBuilder.of("registrationName", "onMarkerDragEnd"), "onPanDrag", MapBuilder.of("registrationName", "onPanDrag"), "onKmlReady", MapBuilder.of("registrationName", "onKmlReady"), "onPoiClick", MapBuilder.of("registrationName", "onPoiClick")));
        of.putAll(MapBuilder.of("onIndoorLevelActivated", MapBuilder.of("registrationName", "onIndoorLevelActivated"), "onIndoorBuildingFocused", MapBuilder.of("registrationName", "onIndoorBuildingFocused")));
        return of;
    }

    public Map<String, Integer> getCommandsMap() {
        Map<String, Integer> CreateMap = CreateMap("animateToRegion", 1, "animateToCoordinate", 2, "animateToViewingAngle", 3, "animateToBearing", 4, "fitToElements", 5, "fitToSuppliedMarkers", 6, "fitToCoordinates", 7, "animateToNavigation", 9);
        CreateMap.putAll(MapBuilder.of("setMapBoundaries", 8, "setIndoorActiveLevelIndex", 10));
        return CreateMap;
    }

    public static <K, V> Map<K, V> CreateMap(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        HashMap hashMap = new HashMap();
        K k9 = k;
        V v9 = v;
        hashMap.put(k, v);
        K k10 = k2;
        V v10 = v2;
        hashMap.put(k2, v2);
        K k11 = k3;
        V v11 = v3;
        hashMap.put(k3, v3);
        K k12 = k4;
        V v12 = v4;
        hashMap.put(k4, v4);
        K k13 = k5;
        V v13 = v5;
        hashMap.put(k5, v5);
        K k14 = k6;
        V v14 = v6;
        hashMap.put(k6, v6);
        K k15 = k7;
        hashMap.put(k7, v7);
        hashMap.put(k8, v8);
        return hashMap;
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new q();
    }

    public void addView(j jVar, View view, int i) {
        jVar.a(view, i);
    }

    public int getChildCount(j jVar) {
        return jVar.getFeatureCount();
    }

    public View getChildAt(j jVar, int i) {
        return jVar.a(i);
    }

    public void removeViewAt(j jVar, int i) {
        jVar.b(i);
    }

    public void updateExtraData(j jVar, Object obj) {
        jVar.a(obj);
    }

    /* access modifiers changed from: package-private */
    public void pushEvent(ThemedReactContext themedReactContext, View view, String str, WritableMap writableMap) {
        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), str, writableMap);
    }

    public void onDropViewInstance(j jVar) {
        jVar.a();
        super.onDropViewInstance(jVar);
    }
}
