package com.dieam.reactnativepushnotification.modules;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.dieam.reactnativepushnotification.a.a;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@ReactModule(name = "RNPushNotification")
public class RNPushNotification extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final String LOG_TAG = "RNPushNotification";
    /* access modifiers changed from: private */
    public c mJsDelivery;
    private b mRNPushNotificationHelper;
    private final Random mRandomNumberGenerator = new Random(System.currentTimeMillis());

    public String getName() {
        return LOG_TAG;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @ReactMethod
    public void requestPermissions(String str) {
    }

    public RNPushNotification(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.mRNPushNotificationHelper = new b((Application) reactApplicationContext.getApplicationContext());
        this.mJsDelivery = new c(reactApplicationContext);
        registerNotificationsRegistration();
    }

    public Map<String, Object> getConstants() {
        return new HashMap();
    }

    public void onNewIntent(Intent intent) {
        if (intent.hasExtra("notification")) {
            Bundle bundleExtra = intent.getBundleExtra("notification");
            bundleExtra.putBoolean("foreground", false);
            intent.putExtra("notification", bundleExtra);
            this.mJsDelivery.a(bundleExtra);
        }
    }

    private void registerNotificationsRegistration() {
        getReactApplicationContext().registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra("token");
                WritableMap createMap = Arguments.createMap();
                createMap.putString("deviceToken", stringExtra);
                RNPushNotification.this.mJsDelivery.a("remoteNotificationsRegistered", createMap);
            }
        }, new IntentFilter(getReactApplicationContext().getPackageName() + ".RNPushNotificationRegisteredToken"));
    }

    private void registerNotificationsReceiveNotificationActions(ReadableArray readableArray) {
        IntentFilter intentFilter = new IntentFilter();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            intentFilter.addAction(getReactApplicationContext().getPackageName() + "." + string);
        }
        getReactApplicationContext().registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                Bundle bundleExtra = intent.getBundleExtra("notification");
                RNPushNotification.this.mJsDelivery.b(bundleExtra);
                ((NotificationManager) context.getSystemService("notification")).cancel(Integer.parseInt(bundleExtra.getString("id")));
            }
        }, intentFilter);
    }

    @ReactMethod
    public void presentLocalNotification(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        setFallbackBundleId(bundle);
        this.mRNPushNotificationHelper.c(bundle);
    }

    @ReactMethod
    public void scheduleLocalNotification(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        setFallbackBundleId(bundle);
        this.mRNPushNotificationHelper.a(bundle);
    }

    private void setFallbackBundleId(Bundle bundle) {
        String string = bundle.getString("id");
        if (string == null) {
            bundle.putString("id", String.valueOf(this.mRandomNumberGenerator.nextInt()));
        } else {
            bundle.putString("id", Integer.toString(((int) Long.parseLong(string)) % Integer.MAX_VALUE));
        }
    }

    @ReactMethod
    public void getInitialNotification(Promise promise) {
        WritableMap createMap = Arguments.createMap();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Bundle bundleExtra = currentActivity.getIntent().getBundleExtra("notification");
            if (bundleExtra != null) {
                bundleExtra.putBoolean("foreground", false);
                createMap.putString("dataJSON", this.mJsDelivery.c(bundleExtra));
            }
        }
        promise.resolve(createMap);
    }

    @ReactMethod
    public void setApplicationIconBadgeNumber(int i) {
        a.f6632a.a(getReactApplicationContext(), i);
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    @ReactMethod
    public void cancelAllLocalNotifications() {
        this.mRNPushNotificationHelper.c();
        this.mRNPushNotificationHelper.b();
    }

    @ReactMethod
    public void cancelLocalNotifications(ReadableMap readableMap) {
        this.mRNPushNotificationHelper.a(readableMap);
    }

    @ReactMethod
    public void registerNotificationActions(ReadableArray readableArray) {
        registerNotificationsReceiveNotificationActions(readableArray);
    }
}
