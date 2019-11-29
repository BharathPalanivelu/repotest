package com.airbnb.android.react.maps;

import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class p extends Event<p> {

    /* renamed from: a  reason: collision with root package name */
    private final LatLngBounds f3349a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3350b;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return "topChange";
    }

    public p(int i, LatLngBounds latLngBounds, boolean z) {
        super(i);
        this.f3349a = latLngBounds;
        this.f3350b = z;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("continuous", this.f3350b);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        LatLng center = this.f3349a.getCenter();
        writableNativeMap2.putDouble("latitude", center.latitude);
        writableNativeMap2.putDouble("longitude", center.longitude);
        writableNativeMap2.putDouble("latitudeDelta", this.f3349a.northeast.latitude - this.f3349a.southwest.latitude);
        writableNativeMap2.putDouble("longitudeDelta", this.f3349a.northeast.longitude - this.f3349a.southwest.longitude);
        writableNativeMap.putMap("region", writableNativeMap2);
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), writableNativeMap);
    }
}
