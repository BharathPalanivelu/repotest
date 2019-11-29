package com.shopee.app.react.modules.app.statusbar;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.garena.android.appkit.tools.c;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.react.util.e;
import com.shopee.app.util.o.d;
import d.a.z;
import d.d.b.j;
import d.l;
import java.util.Map;

@ReactModule(name = "GAStatusBar")
public final class StatusBarModule extends ReactContextBaseJavaModule {
    private final int constantStatusBarHeight;

    public String getName() {
        return "GAStatusBar";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "context");
        this.constantStatusBarHeight = c.a().a((float) com.shopee.app.util.o.c.a((Context) reactApplicationContext));
    }

    public Map<String, Integer> getConstants() {
        return z.b(l.a("statusBarHeight", Integer.valueOf(this.constantStatusBarHeight)));
    }

    @ReactMethod
    public final void configureStatusBarStyle(int i, int i2, Promise promise) {
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (e.a(i, getCurrentActivity())) {
            UiThreadUtil.runOnUiThread(new a(this, i2, promise));
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StatusBarModule f18791a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f18792b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f18793c;

        a(StatusBarModule statusBarModule, int i, Promise promise) {
            this.f18791a = statusBarModule;
            this.f18792b = i;
            this.f18793c = promise;
        }

        public final void run() {
            if (this.f18792b == 0) {
                com.shopee.app.util.o.c.b(this.f18791a.getCurrentActivity());
            } else {
                com.shopee.app.util.o.c.c(this.f18791a.getCurrentActivity());
            }
            d.a().b(this.f18791a.getCurrentActivity(), this.f18792b);
            this.f18793c.resolve(BridgeResult.Companion.success().toString());
        }
    }
}
