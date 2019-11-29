package com.shopee.app.react.modules.app.phone;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactContext;
import com.google.a.o;
import com.shopee.app.util.as;
import com.shopee.react.sdk.bridge.modules.base.c;
import d.d.b.j;

public final class a implements com.shopee.react.sdk.bridge.modules.app.phone.a {

    /* renamed from: a  reason: collision with root package name */
    private final ReactContext f18777a;

    public a(ReactContext reactContext) {
        j.b(reactContext, "reactContext");
        this.f18777a = reactContext;
    }

    public void a(String str, c<o> cVar) {
        j.b(cVar, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (str == null) {
            cVar.a(new o());
        }
        String a2 = as.a((Context) this.f18777a, str);
        if (as.b(a2)) {
            o oVar = new o();
            oVar.a("phone_number", a2);
            cVar.a(oVar);
            return;
        }
        cVar.a(new o());
    }
}
