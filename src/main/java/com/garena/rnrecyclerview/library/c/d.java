package com.garena.rnrecyclerview.library.c;

import androidx.core.util.Pools;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class d extends Event<d> {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.b<d> f8552a = new Pools.b<>(8);

    /* renamed from: b  reason: collision with root package name */
    private int f8553b;

    /* renamed from: c  reason: collision with root package name */
    private String f8554c;

    /* renamed from: d  reason: collision with root package name */
    private String f8555d;

    /* renamed from: e  reason: collision with root package name */
    private String f8556e;

    public String getEventName() {
        return "onUpdateView";
    }

    public static d a(int i, int i2, String str, String str2, String str3) {
        d acquire = f8552a.acquire();
        if (acquire == null) {
            acquire = new d();
        }
        acquire.b(i, i2, str, str2, str3);
        return acquire;
    }

    private void b(int i, int i2, String str, String str2, String str3) {
        super.init(i);
        this.f8553b = i2;
        this.f8555d = str;
        this.f8554c = str2;
        this.f8556e = str3;
    }

    public void onDispose() {
        f8552a.release(this);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), a());
    }

    private WritableMap a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("rowIndex", this.f8553b);
        createMap.putString("rowType", this.f8554c);
        createMap.putString("rowId", this.f8555d);
        createMap.putString(ServerProtocol.DIALOG_PARAM_STATE, this.f8556e);
        return createMap;
    }
}
