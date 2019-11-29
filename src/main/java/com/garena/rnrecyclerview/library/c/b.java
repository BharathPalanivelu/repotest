package com.garena.rnrecyclerview.library.c;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class b extends Event<b> {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.b<b> f8545a = new Pools.b<>(8);

    /* renamed from: b  reason: collision with root package name */
    private int f8546b;

    /* renamed from: c  reason: collision with root package name */
    private int f8547c;

    /* renamed from: d  reason: collision with root package name */
    private String f8548d;

    public static b a(int i, String str, int i2, int i3) {
        b acquire = f8545a.acquire();
        if (acquire == null) {
            acquire = new b();
        }
        acquire.b(i, str, i2, i3);
        return acquire;
    }

    private void b(int i, String str, int i2, int i3) {
        super.init(i);
        this.f8548d = str;
        this.f8546b = i2;
        this.f8547c = i3;
    }

    public String getEventName() {
        return this.f8548d;
    }

    public void onDispose() {
        f8545a.release(this);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("offsetY", (double) PixelUtil.toDIPFromPixel((float) this.f8547c));
        createMap.putDouble("dY", (double) PixelUtil.toDIPFromPixel((float) this.f8546b));
        return createMap;
    }
}
