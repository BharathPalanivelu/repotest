package com.shopee.app.react.modules.app.appmanager;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.shopee.app.application.ar;
import com.shopee.app.util.ba;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.SimpleResponse;
import d.d.b.j;

public final class b implements com.shopee.react.sdk.bridge.modules.app.application.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.scottyab.rootbeer.b f18738a;

    public b(ReactContext reactContext) {
        j.b(reactContext, "reactContext");
        this.f18738a = new com.scottyab.rootbeer.b(reactContext);
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18739a = new a();

        a() {
        }

        public final void run() {
            ar.a(false);
        }
    }

    public void a() {
        UiThreadUtil.runOnUiThread(a.f18739a);
    }

    public void a(c<SimpleResponse> cVar) {
        j.b(cVar, BaseJavaModule.METHOD_TYPE_PROMISE);
        cVar.a(SimpleResponse.with((ba.a() || this.f18738a.a()) ? 1 : 0));
    }
}
