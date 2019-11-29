package com.shopee.app.react.view.pager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class c extends Event<c> {

    /* renamed from: a  reason: collision with root package name */
    private final int f19071a;

    public String getEventName() {
        return PageSelectedEvent.EVENT_NAME;
    }

    protected c(int i, int i2) {
        super(i);
        this.f19071a = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(ViewProps.POSITION, this.f19071a);
        return createMap;
    }
}
