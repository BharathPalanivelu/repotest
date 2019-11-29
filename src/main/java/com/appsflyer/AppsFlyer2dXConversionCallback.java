package com.appsflyer;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener {
    public native void onAppOpenAttributionNative(Object obj);

    public native void onAttributionFailureNative(Object obj);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);

    public void onInstallConversionDataLoaded(Map<String, String> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void onInstallConversionFailure(String str) {
        m39("onAttributionFailure", str);
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public void onAttributionFailure(String str) {
        m39("onInstallConversionFailure", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m39(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", "failure");
            jSONObject.put("data", str2);
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1390007222) {
                if (hashCode == 1050716216) {
                    if (str.equals("onInstallConversionFailure")) {
                        c2 = 0;
                    }
                }
            } else if (str.equals("onAttributionFailure")) {
                c2 = 1;
            }
            if (c2 == 0) {
                onInstallConversionFailureNative(jSONObject);
            } else if (c2 == 1) {
                onAttributionFailureNative(jSONObject);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
