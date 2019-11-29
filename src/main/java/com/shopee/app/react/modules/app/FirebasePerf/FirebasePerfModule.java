package com.shopee.app.react.modules.app.FirebasePerf;

import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.StartTraceInfo;
import com.shopee.app.web.protocol.TraceDataInfo;
import com.shopee.app.web.protocol.TraceInfo;
import d.d.b.j;

@ReactModule(name = "GAFirebasePerf")
public final class FirebasePerfModule extends ReactContextBaseJavaModule {
    private final a firebasePerf;
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "GAFirebasePerf";
    }

    public final ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    public final a getFirebasePerf() {
        return this.firebasePerf;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebasePerfModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
        j.b(aVar, "firebasePerf");
        this.reactContext = reactApplicationContext;
        this.firebasePerf = aVar;
    }

    @ReactMethod
    public final void startTrace(String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        StartTraceInfo startTraceInfo = (StartTraceInfo) WebRegister.GSON.a(str, StartTraceInfo.class);
        a aVar = this.firebasePerf;
        j.a((Object) startTraceInfo, "startTraceParams");
        promise.resolve(aVar.a(startTraceInfo, false).toString());
    }

    @ReactMethod
    public final void putMetric(String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        TraceDataInfo traceDataInfo = (TraceDataInfo) WebRegister.GSON.a(str, TraceDataInfo.class);
        a aVar = this.firebasePerf;
        j.a((Object) traceDataInfo, "traceDataInfo");
        promise.resolve(aVar.a(traceDataInfo).toString());
    }

    @ReactMethod
    public final void stopTrace(String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        TraceInfo traceInfo = (TraceInfo) WebRegister.GSON.a(str, TraceInfo.class);
        a aVar = this.firebasePerf;
        j.a((Object) traceInfo, "stopTraceParams");
        promise.resolve(aVar.a(traceInfo).toString());
    }
}
