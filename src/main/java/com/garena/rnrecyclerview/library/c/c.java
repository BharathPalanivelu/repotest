package com.garena.rnrecyclerview.library.c;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class c extends Event<c> {

    /* renamed from: a  reason: collision with root package name */
    private int f8549a;

    /* renamed from: b  reason: collision with root package name */
    private String f8550b;

    /* renamed from: c  reason: collision with root package name */
    private String f8551c;

    public String getEventName() {
        return "onStickyHeaderChanged";
    }

    public c(int i, int i2, String str, String str2) {
        super.init(i);
        this.f8549a = i2;
        this.f8550b = str;
        this.f8551c = str2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("rowIndex", this.f8549a);
        createMap.putString("rowType", this.f8551c);
        createMap.putString("rowId", this.f8550b);
        return createMap;
    }
}
