package com.shopee.app.react.modules.app.shake;

import android.app.Activity;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.react.util.e;
import com.shopee.app.util.m.a;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.StartShakeDetectionMessage;
import d.d.b.j;
import d.m;

@ReactModule(name = "GAShakeDetector")
public final class ShakeDetectionModule extends ReactContextBaseJavaModule {
    public String getName() {
        return com.shopee.react.sdk.bridge.modules.app.shake.ShakeDetectionModule.NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShakeDetectionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
    }

    @ReactMethod
    public final void startShakeDetection(int i, String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (e.a(i, getCurrentActivity())) {
            UiThreadUtil.runOnUiThread(new a(this, str, promise));
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShakeDetectionModule f18778a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18779b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f18780c;

        a(ShakeDetectionModule shakeDetectionModule, String str, Promise promise) {
            this.f18778a = shakeDetectionModule;
            this.f18779b = str;
            this.f18780c = promise;
        }

        public final void run() {
            Activity access$getCurrentActivity = this.f18778a.getCurrentActivity();
            if (access$getCurrentActivity == null) {
                return;
            }
            if (access$getCurrentActivity != null) {
                try {
                    Object b2 = ((x) access$getCurrentActivity).b();
                    if (b2 != null) {
                        com.shopee.app.util.m.a b3 = ((com.shopee.app.a.a) b2).b();
                        StartShakeDetectionMessage startShakeDetectionMessage = (StartShakeDetectionMessage) WebRegister.GSON.a(this.f18779b, StartShakeDetectionMessage.class);
                        j.a((Object) startShakeDetectionMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                        if (b3.a(startShakeDetectionMessage, new C0283a(this))) {
                            this.f18780c.resolve(BridgeResult.Companion.success().toString());
                        } else {
                            this.f18780c.resolve(BridgeResult.Companion.fail().toString());
                        }
                    } else {
                        throw new m("null cannot be cast to non-null type com.shopee.app.activity.ActivityComponent");
                    }
                } catch (Exception e2) {
                    this.f18780c.resolve(BridgeResult.Companion.fail(1, e2.toString()).toString());
                }
            } else {
                throw new m("null cannot be cast to non-null type com.shopee.app.util.HasComponent<*>");
            }
        }

        /* renamed from: com.shopee.app.react.modules.app.shake.ShakeDetectionModule$a$a  reason: collision with other inner class name */
        public static final class C0283a implements a.C0407a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f18781a;

            C0283a(a aVar) {
                this.f18781a = aVar;
            }

            public void shakeDetected() {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.f18781a.f18778a.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("SHAKE_EVENT", "");
            }
        }
    }

    @ReactMethod
    public final void stopShakeDetection(int i, String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (e.a(i, getCurrentActivity())) {
            UiThreadUtil.runOnUiThread(new b(this, promise));
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShakeDetectionModule f18782a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Promise f18783b;

        b(ShakeDetectionModule shakeDetectionModule, Promise promise) {
            this.f18782a = shakeDetectionModule;
            this.f18783b = promise;
        }

        public final void run() {
            Activity access$getCurrentActivity = this.f18782a.getCurrentActivity();
            if (access$getCurrentActivity == null) {
                return;
            }
            if (access$getCurrentActivity != null) {
                try {
                    Object b2 = ((x) access$getCurrentActivity).b();
                    if (b2 == null) {
                        throw new m("null cannot be cast to non-null type com.shopee.app.activity.ActivityComponent");
                    } else if (((com.shopee.app.a.a) b2).b().a()) {
                        this.f18783b.resolve(BridgeResult.Companion.success().toString());
                    } else {
                        this.f18783b.resolve(BridgeResult.Companion.fail().toString());
                    }
                } catch (Exception e2) {
                    this.f18783b.resolve(BridgeResult.Companion.fail(1, e2.toString()).toString());
                }
            } else {
                throw new m("null cannot be cast to non-null type com.shopee.app.util.HasComponent<*>");
            }
        }
    }
}
