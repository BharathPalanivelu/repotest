package com.shopee.app.react.view.qrview.a;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class a extends Event<a> {

    /* renamed from: a  reason: collision with root package name */
    private final String f19093a;

    public String getEventName() {
        return "onScanComplete";
    }

    public a(int i, String str) {
        super(i);
        this.f19093a = str;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("output", this.f19093a);
        return createMap;
    }
}
