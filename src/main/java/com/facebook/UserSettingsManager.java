package com.facebook;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class UserSettingsManager {
    private static final String ADVERTISER_ID_KEY = "advertiser_id";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
    private static final String LAST_TIMESTAMP = "last_timestamp";
    private static final String TAG = "com.facebook.UserSettingsManager";
    private static final long TIMEOUT_7D = 604800000;
    private static final String USER_SETTINGS = "com.facebook.sdk.USER_SETTINGS";
    private static final String VALUE = "value";
    /* access modifiers changed from: private */
    public static UserSetting advertiserIDCollectionEnabled = new UserSetting(true, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY);
    private static UserSetting autoLogAppEventsEnabled = new UserSetting(true, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY);
    /* access modifiers changed from: private */
    public static UserSetting codelessSetupEnabled = new UserSetting(false, EVENTS_CODELESS_SETUP_ENABLED, (String) null);
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static SharedPreferences userSettingPref;
    private static SharedPreferences.Editor userSettingPrefEditor;

    UserSettingsManager() {
    }

    public static void initializeIfNotInitialized() {
        if (FacebookSdk.isInitialized() && isInitialized.compareAndSet(false, true)) {
            userSettingPref = FacebookSdk.getApplicationContext().getSharedPreferences(USER_SETTINGS, 0);
            userSettingPrefEditor = userSettingPref.edit();
            initializeUserSetting(autoLogAppEventsEnabled);
            initializeUserSetting(advertiserIDCollectionEnabled);
            initializeCodelessSepupEnabledAsync();
        }
    }

    private static void initializeUserSetting(UserSetting userSetting) {
        if (userSetting == codelessSetupEnabled) {
            initializeCodelessSepupEnabledAsync();
        } else if (userSetting.value == null) {
            readSettingFromCache(userSetting);
            if (userSetting.value == null && userSetting.keyInManifest != null) {
                loadSettingFromManifest(userSetting);
            }
        } else {
            writeSettingToCache(userSetting);
        }
    }

    private static void initializeCodelessSepupEnabledAsync() {
        readSettingFromCache(codelessSetupEnabled);
        final long currentTimeMillis = System.currentTimeMillis();
        if (codelessSetupEnabled.value == null || currentTimeMillis - codelessSetupEnabled.lastTS >= TIMEOUT_7D) {
            UserSetting userSetting = codelessSetupEnabled;
            userSetting.value = null;
            userSetting.lastTS = 0;
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    if (UserSettingsManager.advertiserIDCollectionEnabled.getValue()) {
                        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                        if (queryAppSettings != null && queryAppSettings.getCodelessEventsEnabled()) {
                            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                            if (((attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId()) != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString(UserSettingsManager.ADVERTISER_ID_KEY, attributionIdentifiers.getAndroidAdvertiserId());
                                bundle.putString("fields", UserSettingsManager.EVENTS_CODELESS_SETUP_ENABLED);
                                GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest((AccessToken) null, FacebookSdk.getApplicationId(), (GraphRequest.Callback) null);
                                newGraphPathRequest.setSkipClientToken(true);
                                newGraphPathRequest.setParameters(bundle);
                                JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                                if (jSONObject != null) {
                                    UserSettingsManager.codelessSetupEnabled.value = Boolean.valueOf(jSONObject.optBoolean(UserSettingsManager.EVENTS_CODELESS_SETUP_ENABLED, false));
                                    UserSettingsManager.codelessSetupEnabled.lastTS = currentTimeMillis;
                                    UserSettingsManager.writeSettingToCache(UserSettingsManager.codelessSetupEnabled);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void writeSettingToCache(UserSetting userSetting) {
        validateInitialized();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", userSetting.value);
            jSONObject.put(LAST_TIMESTAMP, userSetting.lastTS);
            userSettingPrefEditor.putString(userSetting.keyInCache, jSONObject.toString()).commit();
        } catch (JSONException e2) {
            Utility.logd(TAG, (Exception) e2);
        }
    }

    private static void readSettingFromCache(UserSetting userSetting) {
        validateInitialized();
        try {
            String string = userSettingPref.getString(userSetting.keyInCache, "");
            if (!string.isEmpty()) {
                JSONObject jSONObject = new JSONObject(string);
                userSetting.value = Boolean.valueOf(jSONObject.getBoolean("value"));
                userSetting.lastTS = jSONObject.getLong(LAST_TIMESTAMP);
            }
        } catch (JSONException e2) {
            Utility.logd(TAG, (Exception) e2);
        }
    }

    private static void loadSettingFromManifest(UserSetting userSetting) {
        validateInitialized();
        try {
            ApplicationInfo applicationInfo = FacebookSdk.getApplicationContext().getPackageManager().getApplicationInfo(FacebookSdk.getApplicationContext().getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(userSetting.keyInManifest)) {
                userSetting.value = Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.keyInManifest, userSetting.defaultVal));
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Utility.logd(TAG, (Exception) e2);
        }
    }

    private static void validateInitialized() {
        if (!isInitialized.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        autoLogAppEventsEnabled.value = Boolean.valueOf(z);
        autoLogAppEventsEnabled.lastTS = System.currentTimeMillis();
        if (isInitialized.get()) {
            writeSettingToCache(autoLogAppEventsEnabled);
        } else {
            initializeIfNotInitialized();
        }
    }

    public static boolean getAutoLogAppEventsEnabled() {
        initializeIfNotInitialized();
        return autoLogAppEventsEnabled.getValue();
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        advertiserIDCollectionEnabled.value = Boolean.valueOf(z);
        advertiserIDCollectionEnabled.lastTS = System.currentTimeMillis();
        if (isInitialized.get()) {
            writeSettingToCache(advertiserIDCollectionEnabled);
        } else {
            initializeIfNotInitialized();
        }
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        initializeIfNotInitialized();
        return advertiserIDCollectionEnabled.getValue();
    }

    public static boolean getCodelessSetupEnabled() {
        initializeIfNotInitialized();
        return codelessSetupEnabled.getValue();
    }

    private static class UserSetting {
        boolean defaultVal;
        String keyInCache;
        String keyInManifest;
        long lastTS;
        Boolean value;

        UserSetting(boolean z, String str, String str2) {
            this.defaultVal = z;
            this.keyInCache = str;
            this.keyInManifest = str2;
        }

        /* access modifiers changed from: package-private */
        public boolean getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }
}
