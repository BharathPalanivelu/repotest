package com.shopee.app.react.modules.app.bundle;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.garena.reactpush.d.e;
import com.google.a.o;
import com.shopee.app.react.g;
import com.shopee.app.react.protocol.BundleReloadData;
import com.shopee.app.web.WebRegister;

@ReactModule(name = "GABundleManager")
public class BundleManagerModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GABundleManager";

    public String getName() {
        return "GABundleManager";
    }

    public BundleManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void reload(String str, Promise promise) throws Exception {
        g.a();
        BundleReloadData bundleReloadData = (BundleReloadData) WebRegister.GSON.a(str, BundleReloadData.class);
        resolvePromise(promise, 1);
    }

    @ReactMethod
    public void sync(String str, final Promise promise) throws Exception {
        g.a().a((e) new e() {
            public void a(boolean z) {
                BundleManagerModule.this.resolvePromise(promise, z ? 2 : 1);
            }

            public void a(Exception exc) {
                BundleManagerModule.this.resolvePromise(promise, 0);
            }
        });
    }

    /* access modifiers changed from: private */
    public void resolvePromise(Promise promise, int i) {
        o oVar = new o();
        oVar.a("status", (Number) Integer.valueOf(i));
        promise.resolve(oVar.toString());
    }
}
