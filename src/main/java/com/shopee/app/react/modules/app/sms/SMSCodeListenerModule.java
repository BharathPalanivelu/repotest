package com.shopee.app.react.modules.app.sms;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;
import com.shopee.app.util.n;
import d.d.b.j;
import io.b.b.b;

@ReactModule(name = "SMSCodeListener")
public final class SMSCodeListenerModule extends ReactBaseLifecycleModule<a> {
    private b disposable;
    private final n eventBus;

    public String getName() {
        return "SMSCodeListener";
    }

    public final n getEventBus() {
        return this.eventBus;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SMSCodeListenerModule(ReactApplicationContext reactApplicationContext, n nVar) {
        super(reactApplicationContext);
        j.b(nVar, "eventBus");
        this.eventBus = nVar;
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public final void listen(Promise promise) {
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        a aVar = (a) getHelper();
        if (aVar != null) {
            aVar.a(promise);
        }
    }

    public void onHostDestroy() {
        super.onHostDestroy();
        b bVar = this.disposable;
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
