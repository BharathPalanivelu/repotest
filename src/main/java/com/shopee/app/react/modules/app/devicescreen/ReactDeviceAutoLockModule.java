package com.shopee.app.react.modules.app.devicescreen;

import android.app.Activity;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.react.util.e;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.DeviceAutoLockMessage;
import d.d.b.j;

@ReactModule(name = "DeviceScreenAutoLock")
public final class ReactDeviceAutoLockModule extends ReactContextBaseJavaModule {
    public static final a Companion = new a((g) null);
    private static final int ERROR_CODE = 1;
    public static final String NAME = "DeviceScreenAutoLock";
    /* access modifiers changed from: private */
    public final com.shopee.app.util.e.a deviceAutoLockHandler;

    public String getName() {
        return NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactDeviceAutoLockModule(ReactApplicationContext reactApplicationContext, com.shopee.app.util.e.a aVar) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "context");
        j.b(aVar, "deviceAutoLockHandler");
        this.deviceAutoLockHandler = aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @ReactMethod
    public final void setEnabled(int i, String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (e.a(i, getCurrentActivity())) {
            setDeviceScreenAutoLockEnabled(str, promise);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactDeviceAutoLockModule f18767a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18768b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f18769c;

        b(ReactDeviceAutoLockModule reactDeviceAutoLockModule, String str, Promise promise) {
            this.f18767a = reactDeviceAutoLockModule;
            this.f18768b = str;
            this.f18769c = promise;
        }

        public final void run() {
            Activity access$getCurrentActivity = this.f18767a.getCurrentActivity();
            if (access$getCurrentActivity != null) {
                try {
                    com.shopee.app.util.e.a access$getDeviceAutoLockHandler$p = this.f18767a.deviceAutoLockHandler;
                    j.a((Object) access$getCurrentActivity, "activity");
                    access$getDeviceAutoLockHandler$p.a(access$getCurrentActivity, ((DeviceAutoLockMessage) WebRegister.GSON.a(this.f18768b, DeviceAutoLockMessage.class)).isEnabled());
                    this.f18769c.resolve(BridgeResult.Companion.success().toString());
                } catch (Exception unused) {
                    this.f18769c.resolve(BridgeResult.Companion.fail(1).toString());
                }
            }
        }
    }

    private final void setDeviceScreenAutoLockEnabled(String str, Promise promise) {
        UiThreadUtil.runOnUiThread(new b(this, str, promise));
    }
}
