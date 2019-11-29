package com.shopee.app.react.view.pager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class b extends Event<b> {

    /* renamed from: a  reason: collision with root package name */
    private final String f19070a;

    public String getEventName() {
        return PageScrollStateChangedEvent.EVENT_NAME;
    }

    protected b(int i, String str) {
        super(i);
        this.f19070a = str;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("pageScrollState", this.f19070a);
        return createMap;
    }
}
