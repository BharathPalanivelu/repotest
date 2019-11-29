package com.shopee.app.react.modules.app.checker;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.util.bm;
import com.shopee.app.web.WebRegister;
import d.d.b.j;
import d.m;

@ReactModule(name = "AppInstalledChecker")
public final class AppInstallationCheckerModule extends ReactContextBaseJavaModule {
    public static final b Companion = new b((g) null);
    private static final int NOT_INSTALLED = 1;
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "AppInstalledChecker";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInstallationCheckerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public final void isAppInstalled(int i, String str, Promise promise) {
        j.b(str, "param");
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            a aVar = (a) WebRegister.GSON.a(str, a.class);
            ReactApplicationContext reactApplicationContext = this.reactContext;
            if (reactApplicationContext == null) {
                throw new m("null cannot be cast to non-null type android.content.Context");
            } else if (bm.c(reactApplicationContext, aVar.a())) {
                promise.resolve(BridgeResult.Companion.success().toString());
            } else {
                promise.resolve(BridgeResult.Companion.fail(1).toString());
            }
        } catch (Exception e2) {
            promise.resolve(BridgeResult.Companion.fail(1, e2.toString()).toString());
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    public static final class a {
        @c(a = "packageName")

        /* renamed from: a  reason: collision with root package name */
        private final String f18742a;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && j.a((Object) this.f18742a, (Object) ((a) obj).f18742a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f18742a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "AppInstallationParam(packageName=" + this.f18742a + SQLBuilder.PARENTHESES_RIGHT;
        }

        public final String a() {
            return this.f18742a;
        }
    }
}
