package com.facebook.react.views.checkbox;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

class ReactCheckBoxEvent extends Event<ReactCheckBoxEvent> {
    public static final String EVENT_NAME = "topChange";
    private final boolean mIsChecked;

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topChange";
    }

    public ReactCheckBoxEvent(int i, boolean z) {
        super(i);
        this.mIsChecked = z;
    }

    public boolean getIsChecked() {
        return this.mIsChecked;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putBoolean(AppMeasurementSdk.ConditionalUserProperty.VALUE, getIsChecked());
        return createMap;
    }
}
