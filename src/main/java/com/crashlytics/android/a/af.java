package com.crashlytics.android.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import io.a.a.a.a.d.a;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class af implements a<ad> {
    af() {
    }

    public byte[] a(ad adVar) throws IOException {
        return b(adVar).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject b(ad adVar) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            ae aeVar = adVar.f6283a;
            jSONObject.put("appBundleId", aeVar.f6297a);
            jSONObject.put("executionId", aeVar.f6298b);
            jSONObject.put("installationId", aeVar.f6299c);
            if (TextUtils.isEmpty(aeVar.f6301e)) {
                jSONObject.put("androidId", aeVar.f6300d);
            } else {
                jSONObject.put("advertisingId", aeVar.f6301e);
            }
            jSONObject.put("limitAdTrackingEnabled", aeVar.f6302f);
            jSONObject.put("betaDeviceToken", aeVar.f6303g);
            jSONObject.put("buildId", aeVar.h);
            jSONObject.put("osVersion", aeVar.i);
            jSONObject.put("deviceModel", aeVar.j);
            jSONObject.put("appVersionCode", aeVar.k);
            jSONObject.put("appVersionName", aeVar.l);
            jSONObject.put("timestamp", adVar.f6284b);
            jSONObject.put("type", adVar.f6285c.toString());
            if (adVar.f6286d != null) {
                jSONObject.put("details", new JSONObject(adVar.f6286d));
            }
            jSONObject.put("customType", adVar.f6287e);
            if (adVar.f6288f != null) {
                jSONObject.put("customAttributes", new JSONObject(adVar.f6288f));
            }
            jSONObject.put("predefinedType", adVar.f6289g);
            if (adVar.h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(adVar.h));
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (Build.VERSION.SDK_INT >= 9) {
                throw new IOException(e2.getMessage(), e2);
            }
            throw new IOException(e2.getMessage());
        }
    }
}
