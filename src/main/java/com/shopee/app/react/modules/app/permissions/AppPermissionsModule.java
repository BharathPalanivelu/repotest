package com.shopee.app.react.modules.app.permissions;

import android.app.Activity;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.WebRegister;
import com.shopee.react.sdk.bridge.modules.app.permissions.AppPermissionModule;
import com.shopee.web.sdk.bridge.a.f.b;
import d.d.b.j;
import d.m;
import java.util.List;

@ReactModule(name = "GAAppPermission")
public final class AppPermissionsModule extends ReactContextBaseJavaModule {
    public String getName() {
        return AppPermissionModule.NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppPermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
    }

    @ReactMethod
    public final void checkAppPermission(int i, String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (com.shopee.app.react.util.e.a(i, getCurrentActivity())) {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                com.shopee.web.sdk.bridge.a.f.a aVar = (com.shopee.web.sdk.bridge.a.f.a) currentActivity;
                a aVar2 = (a) WebRegister.GSON.a(str, a.class);
                aVar.a(aVar2 != null ? aVar2.a() : null, new d(promise));
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.web.sdk.bridge.module.permissions.PermissionAwareActivity");
        }
    }

    public static final class d implements b.C0475b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18773a;

        d(Promise promise) {
            this.f18773a = promise;
        }

        public void onResult(List<Boolean> list) {
            if (list == null) {
                this.f18773a.resolve(BridgeResult.Companion.fail(1).toString());
            } else {
                this.f18773a.resolve(BridgeResult.Companion.success(new c(list)).toString());
            }
        }
    }

    @ReactMethod
    public final void requestAppPermission(int i, String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (com.shopee.app.react.util.e.a(i, getCurrentActivity())) {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                com.shopee.web.sdk.bridge.a.f.a aVar = (com.shopee.web.sdk.bridge.a.f.a) currentActivity;
                b bVar = (b) WebRegister.GSON.a(str, b.class);
                String str2 = null;
                List<String> a2 = bVar != null ? bVar.a() : null;
                if (bVar != null) {
                    str2 = bVar.b();
                }
                aVar.a(a2, str2, new e(promise));
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.web.sdk.bridge.module.permissions.PermissionAwareActivity");
        }
    }

    public static final class e implements b.C0475b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18774a;

        e(Promise promise) {
            this.f18774a = promise;
        }

        public void onResult(List<Boolean> list) {
            if (list == null) {
                this.f18774a.resolve(BridgeResult.Companion.fail(1).toString());
            } else {
                this.f18774a.resolve(BridgeResult.Companion.success(new c(list)).toString());
            }
        }
    }

    public static class a {
        @com.google.a.a.c(a = "permissionList")

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f18770a;

        public final List<String> a() {
            return this.f18770a;
        }
    }

    public static final class b extends a {
        @com.google.a.a.c(a = "popupText")

        /* renamed from: a  reason: collision with root package name */
        private final String f18771a;

        public final String b() {
            return this.f18771a;
        }
    }

    public static final class c {
        @com.google.a.a.c(a = "resultList")

        /* renamed from: a  reason: collision with root package name */
        private final List<Boolean> f18772a;

        public c(List<Boolean> list) {
            j.b(list, "resultList");
            this.f18772a = list;
        }
    }
}
