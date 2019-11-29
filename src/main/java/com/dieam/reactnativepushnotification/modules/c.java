package com.dieam.reactnativepushnotification.modules;

import android.os.Build;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private ReactApplicationContext f6650a;

    public c(ReactApplicationContext reactApplicationContext) {
        this.f6650a = reactApplicationContext;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        if (this.f6650a.hasActiveCatalystInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.f6650a.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        String c2 = c(bundle);
        WritableMap createMap = Arguments.createMap();
        createMap.putString("dataJSON", c2);
        a("remoteNotificationReceived", createMap);
    }

    /* access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        String c2 = c(bundle);
        WritableMap createMap = Arguments.createMap();
        createMap.putString("dataJSON", c2);
        a("notificationActionReceived", createMap);
    }

    /* access modifiers changed from: package-private */
    public String c(Bundle bundle) {
        try {
            return d(bundle).toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject d(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                jSONObject.put(str, d((Bundle) obj));
            } else if (Build.VERSION.SDK_INT >= 19) {
                jSONObject.put(str, JSONObject.wrap(obj));
            } else {
                jSONObject.put(str, obj);
            }
        }
        return jSONObject;
    }
}
