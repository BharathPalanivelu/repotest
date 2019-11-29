package com.shopee.app.react.modules.ui.abtesting;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.o;
import com.shopee.app.react.modules.ui.abtesting.a;
import com.shopee.app.react.protocol.BridgeResult;
import d.d.b.j;

@ReactModule(name = "GAFirebaseRemoteConfig")
public final class AbTestingModule extends ReactContextBaseJavaModule {
    public static final a Companion = new a((g) null);
    public static final int FAILED = 1;
    public static final String KEY_RESULT = "result";
    public static final String NAME = "GAFirebaseRemoteConfig";
    private final a abTestingHandler;

    public String getName() {
        return NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbTestingModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
        j.b(aVar, "abTestingHandler");
        this.abTestingHandler = aVar;
    }

    @ReactMethod
    public final void getValue(String str, Promise promise) {
        j.b(str, "key");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.abTestingHandler.a(str, createAbTestingCallback(promise));
    }

    public static final class b implements a.C0285a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18795a;

        b(Promise promise) {
            this.f18795a = promise;
        }

        public void a(Object obj) {
            j.b(obj, "data");
            try {
                o oVar = new o();
                oVar.a(AbTestingModule.KEY_RESULT, (String) obj);
                this.f18795a.resolve(BridgeResult.Companion.success(oVar).toString());
            } catch (Exception e2) {
                this.f18795a.resolve(BridgeResult.Companion.fail(1, e2.getMessage()).toString());
            }
        }

        public void a(Exception exc) {
            j.b(exc, "e");
            this.f18795a.resolve(BridgeResult.Companion.fail(1, exc.getMessage()).toString());
        }
    }

    private final b createAbTestingCallback(Promise promise) {
        return new b(promise);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
