package com.shopee.react.sdk.bridge.modules.ui.navigate;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.navigator.e;
import com.shopee.react.sdk.activity.a;
import com.shopee.react.sdk.bridge.modules.base.ReactBaseLifecycleModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "GANavigator")
public class NavigateModule extends ReactBaseLifecycleModule<a> implements ActivityEventListener {
    public static final String NAME = "GANavigator";
    private Class<? extends Activity> mLaunchActivity;
    private e mNavigator;

    public String getName() {
        return NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public NavigateModule(ReactApplicationContext reactApplicationContext, e eVar, Class<? extends Activity> cls) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        reactApplicationContext.addLifecycleEventListener(this);
        this.mLaunchActivity = cls;
        this.mNavigator = eVar;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("RIGHT_TO_LEFT", 0);
        hashMap.put("BOTTOM_TO_UP", 1);
        hashMap.put("NONE", 2);
        hashMap.put("TRANSPARENT", 3);
        return hashMap;
    }

    public a initHelper(a aVar) {
        return new a(this.mNavigator, this.mLaunchActivity);
    }

    @ReactMethod
    public void push(int i, String str, String str2, int i2, String str3) {
        final int i3 = i;
        final String str4 = str;
        final String str5 = str2;
        final int i4 = i2;
        final String str6 = str3;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i3)) {
                    ((a) NavigateModule.this.getHelper()).a(NavigateModule.this.getCurrentActivity(), str4, str5, i4, str6);
                }
            }
        });
    }

    @ReactMethod
    public void pop(final int i, final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i)) {
                    ((a) NavigateModule.this.getHelper()).a(NavigateModule.this.getCurrentActivity(), str);
                }
            }
        });
    }

    @ReactMethod
    public void pushAppRL(final int i, final String str, final String str2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i)) {
                    ((a) NavigateModule.this.getHelper()).a(NavigateModule.this.getCurrentActivity(), str, str2);
                }
            }
        });
    }

    @ReactMethod
    public void jump(final int i, final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i)) {
                    ((a) NavigateModule.this.getHelper()).b(NavigateModule.this.getCurrentActivity(), str);
                }
            }
        });
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        ((a) getHelper()).a(activity, i, i2, intent);
    }
}
