package com.garena.rnrecyclerview.library.c;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class a extends Event<a> {

    /* renamed from: a  reason: collision with root package name */
    private int f8544a;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return "onParallaxMove";
    }

    public a(int i, int i2) {
        super.init(i);
        this.f8544a = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("offsetY", ((int) PixelUtil.toDIPFromPixel((float) this.f8544a)) * -1);
        return createMap;
    }
}
