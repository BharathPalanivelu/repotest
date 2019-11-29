package com.shopee.app.react.modules.ui.product;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.react.d;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.util.c.b;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.CoinAnimationMessage;
import d.d.b.j;
import d.m;

@ReactModule(name = "CoinAnimation")
public final class CoinAnimationModule extends ReactContextBaseJavaModule {
    public static final a Companion = new a((g) null);
    private static final int FAILED = 1;
    /* access modifiers changed from: private */
    public final SettingConfigStore setting;

    public String getName() {
        return "CoinAnimation";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoinAnimationModule(SettingConfigStore settingConfigStore, ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(settingConfigStore, "setting");
        j.b(reactApplicationContext, "reactContext");
        this.setting = settingConfigStore;
    }

    @ReactMethod
    public final void show(int i, String str, Promise promise) {
        j.b(str, "param");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                UiThreadUtil.runOnUiThread(new b(this, new com.shopee.app.util.c.a(new c(promise)), (d) currentActivity, (CoinAnimationMessage) WebRegister.GSON.a(str, CoinAnimationMessage.class)));
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.react.ReactActivity");
        } catch (Exception e2) {
            promise.resolve(BridgeResult.Companion.fail(1, e2.toString()).toString());
        }
    }

    static final class c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18936a;

        c(Promise promise) {
            this.f18936a = promise;
        }

        public final void a() {
            this.f18936a.resolve(BridgeResult.Companion.success().toString());
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CoinAnimationModule f18932a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.util.c.a f18933b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f18934c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CoinAnimationMessage f18935d;

        b(CoinAnimationModule coinAnimationModule, com.shopee.app.util.c.a aVar, d dVar, CoinAnimationMessage coinAnimationMessage) {
            this.f18932a = coinAnimationModule;
            this.f18933b = aVar;
            this.f18934c = dVar;
            this.f18935d = coinAnimationMessage;
        }

        public final void run() {
            com.shopee.app.util.c.a aVar = this.f18933b;
            View viewRef = this.f18934c.getViewRef();
            if (viewRef != null) {
                CoinAnimationMessage coinAnimationMessage = this.f18935d;
                j.a((Object) coinAnimationMessage, "coinMsg");
                long currentCoins = (long) coinAnimationMessage.getCurrentCoins();
                CoinAnimationMessage coinAnimationMessage2 = this.f18935d;
                j.a((Object) coinAnimationMessage2, "coinMsg");
                aVar.a((FrameLayout) viewRef, currentCoins, (long) coinAnimationMessage2.getCoinsToAdd(), this.f18932a.setting.coinMultiplier());
                return;
            }
            throw new m("null cannot be cast to non-null type android.widget.FrameLayout");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
