package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = "com.facebook.internal.FetchedAppGateKeepersManager";
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static Long timestamp = null;

    public static synchronized void loadAppGateKeepersAsync() {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (!isTimestampValid(timestamp)) {
                final Context applicationContext = FacebookSdk.getApplicationContext();
                final String applicationId = FacebookSdk.getApplicationId();
                final String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, new Object[]{applicationId});
                FacebookSdk.getExecutor().execute(new Runnable() {
                    public void run() {
                        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(FetchedAppGateKeepersManager.APP_GATEKEEPERS_PREFS_STORE, 0);
                        JSONObject jSONObject = null;
                        String string = sharedPreferences.getString(format, (String) null);
                        if (!Utility.isNullOrEmpty(string)) {
                            try {
                                jSONObject = new JSONObject(string);
                            } catch (JSONException e2) {
                                Utility.logd("FacebookSDK", (Exception) e2);
                            }
                            if (jSONObject != null) {
                                JSONObject unused = FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, jSONObject);
                            }
                        }
                        JSONObject access$100 = FetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
                        if (access$100 != null) {
                            Long unused2 = FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                            JSONObject unused3 = FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, access$100);
                            sharedPreferences.edit().putString(format, access$100.toString()).apply();
                        }
                    }
                });
            }
        }
    }

    public static JSONObject queryAppGateKeepers(String str, boolean z) {
        if (!z && fetchedAppGateKeepers.containsKey(str)) {
            return fetchedAppGateKeepers.get(str);
        }
        JSONObject appGateKeepersQueryResponse = getAppGateKeepersQueryResponse(str);
        if (appGateKeepersQueryResponse == null) {
            return null;
        }
        Context applicationContext = FacebookSdk.getApplicationContext();
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, new Object[]{str}), appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON(str, appGateKeepersQueryResponse);
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z) {
        loadAppGateKeepersAsync();
        return (str2 == null || !fetchedAppGateKeepers.containsKey(str2)) ? z : fetchedAppGateKeepers.get(str2).optBoolean(str, z);
    }

    /* access modifiers changed from: private */
    public static JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest((AccessToken) null, String.format("%s/%s", new Object[]{str, APPLICATION_GATEKEEPER_EDGE}), (GraphRequest.Callback) null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest.executeAndWait().getJSONObject();
    }

    /* access modifiers changed from: private */
    public static synchronized JSONObject parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            if (fetchedAppGateKeepers.containsKey(str)) {
                jSONObject2 = fetchedAppGateKeepers.get(str);
            } else {
                jSONObject2 = new JSONObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONObject jSONObject3 = null;
            if (optJSONArray != null) {
                jSONObject3 = optJSONArray.optJSONObject(0);
            }
            if (!(jSONObject3 == null || jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD) == null)) {
                JSONArray optJSONArray2 = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                        jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                    } catch (JSONException e2) {
                        Utility.logd("FacebookSDK", (Exception) e2);
                    }
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    private static boolean isTimestampValid(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < APPLICATION_GATEKEEPER_CACHE_TIMEOUT;
    }
}
