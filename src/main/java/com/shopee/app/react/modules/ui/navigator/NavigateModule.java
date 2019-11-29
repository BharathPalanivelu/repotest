package com.shopee.app.react.modules.ui.navigator;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.garena.android.appkit.d.a;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;
import com.shopee.app.react.protocol.PopData;
import com.shopee.app.web.WebRegister;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "GANavigator")
public class NavigateModule extends ReactBaseLifecycleModule<a> implements ActivityEventListener {
    public static boolean HANDLED_POP_EVENT = false;
    protected static final String NAME = "GANavigator";
    private boolean mPopComplete;
    private Intent mPopIntent;

    public String getName() {
        return "GANavigator";
    }

    public void onNewIntent(Intent intent) {
    }

    public NavigateModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("RIGHT_TO_LEFT", 0);
        hashMap.put("BOTTOM_TO_UP", 1);
        hashMap.put("NONE", 2);
        return hashMap;
    }

    public a initHelper(c cVar) {
        return new a(cVar);
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
    public void navigateAppPath(final int i, final String str, final String str2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i)) {
                    ((a) NavigateModule.this.getHelper()).a(NavigateModule.this.getCurrentActivity(), str, str2);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (jSONObject.has("popSelf") && jSONObject.getInt("popSelf") == 1) {
                                NavigateModule.this.getCurrentActivity().finish();
                            }
                        } catch (JSONException e2) {
                            a.a(e2);
                        }
                    }
                }
            }
        });
    }

    @ReactMethod
    public void navigateAppRL(final int i, final String str, final String str2) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i)) {
                    ((a) NavigateModule.this.getHelper()).a(NavigateModule.this.getCurrentActivity(), str, str2);
                }
            }
        });
    }

    @ReactMethod
    public void navigateWeb(final int i, final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i)) {
                    ((a) NavigateModule.this.getHelper()).b(NavigateModule.this.getCurrentActivity(), str);
                }
            }
        });
    }

    @ReactMethod
    public void jump(final int i, final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (NavigateModule.this.isMatchingReactTag(i)) {
                    ((a) NavigateModule.this.getHelper()).c(NavigateModule.this.getCurrentActivity(), str);
                }
            }
        });
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        this.mPopComplete = true;
        if (i == 11028) {
            if (i2 == -1) {
                this.mPopIntent = intent;
            } else if (i2 == 13397 && intent != null) {
                int intExtra = intent.getIntExtra("pop_count", 0);
                if (intExtra > 0) {
                    ((a) getHelper()).a(activity, intent, intExtra);
                }
            }
        } else if (i == 100 && i2 == -1) {
            PopData popData = new PopData();
            popData.setCount(intent.getIntExtra("returnCountKey", 0));
            popData.setData(intent.getStringExtra("returnData"));
            Intent intent2 = new Intent();
            intent2.putExtra("popData", WebRegister.GSON.b((Object) popData));
            this.mPopIntent = intent2;
        } else if (i == 1021) {
            ar.f().e().navigator2().a(activity, i, i2, intent);
            if (!(activity instanceof com.shopee.navigator.b.a) && intent != null) {
                this.mPopIntent = intent;
            }
        } else {
            com.shopee.app.ui.d.c.a(activity, i, i2, intent);
        }
    }

    public void onHostResume() {
        super.onHostResume();
        if (this.mPopComplete) {
            this.mPopComplete = false;
            notifyWebWithResult();
            parseResultForNative();
            this.mPopIntent = null;
        }
    }

    private void notifyWebWithResult() {
        if (this.mPopIntent != null) {
            PopData a2 = ((a) getHelper()).a(getCurrentActivity(), this.mPopIntent);
            if (a2 != null) {
                HANDLED_POP_EVENT = true;
                o oVar = new o();
                oVar.a("reactTag", (Number) Integer.valueOf(getReactTag()));
                oVar.a("data", a2.getData());
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("viewWillReappear", oVar.toString());
                return;
            }
            HANDLED_POP_EVENT = true;
            com.shopee.navigator.c cVar = new com.shopee.navigator.c(this.mPopIntent);
            o oVar2 = new o();
            oVar2.a("reactTag", (Number) Integer.valueOf(getReactTag()));
            oVar2.a("data", cVar.d());
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("viewWillReappear", oVar2.toString());
        }
    }

    private void parseResultForNative() {
        if (this.mPopIntent != null) {
            ((a) getHelper()).a(getCurrentActivity(), this.mPopIntent);
        }
    }
}
