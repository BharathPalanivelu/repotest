package com.shopee.react.sdk.bridge.modules.app.edcprinter;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.navigator.b;
import com.shopee.react.sdk.bridge.modules.base.a;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.LineWrapReq;
import com.shopee.react.sdk.bridge.protocol.PrintBitmapReq;
import d.d.b.j;

@ReactModule(name = "GAEDCPrinter")
public final class EDCPrinterModule extends ReactContextBaseJavaModule {
    private final a implementation;

    public String getName() {
        return "GAEDCPrinter";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EDCPrinterModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
        j.b(aVar, "implementation");
        this.implementation = aVar;
    }

    public final a getImplementation() {
        return this.implementation;
    }

    @ReactMethod
    public final void initPrinter(String str, Promise promise) {
        j.b(str, "requestParams");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            this.implementation.a(new c(promise));
        } catch (Throwable th) {
            a.a(this, "GAEDCPrinter", th);
        }
    }

    @ReactMethod
    public final void printBitmap(String str, Promise promise) {
        j.b(str, "requestParams");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            this.implementation.a(((PrintBitmapReq) com.shopee.react.sdk.a.a.f30143a.a(str, PrintBitmapReq.class)).getUri(), (c<DataResponse<b>>) new c(promise));
        } catch (Throwable th) {
            a.a(this, "GAEDCPrinter", th);
        }
    }

    @ReactMethod
    public final void lineWrap(String str, Promise promise) {
        j.b(str, "requestParams");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            this.implementation.a(((LineWrapReq) com.shopee.react.sdk.a.a.f30143a.a(str, LineWrapReq.class)).getNum(), (c<DataResponse<b>>) new c(promise));
        } catch (Throwable th) {
            a.a(this, "GAEDCPrinter", th);
        }
    }

    @ReactMethod
    public final void disconnect(String str, Promise promise) {
        j.b(str, "requestParams");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            this.implementation.b(new c(promise));
        } catch (Throwable th) {
            a.a(this, "GAEDCPrinter", th);
        }
    }

    public void onCatalystInstanceDestroy() {
        try {
            this.implementation.a();
        } catch (Throwable th) {
            a.a(this, "GAEDCPrinter", th);
        }
    }
}
