package com.shopee.app.react.view.rnreturnlistview;

import android.content.Context;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.shopee.app.a.b;
import com.shopee.app.application.ar;
import com.shopee.app.ui.order.a;
import com.shopee.app.ui.order.d;
import com.shopee.app.util.x;
import d.d.b.j;
import d.m;

public final class a extends ThemedReactContext implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    private final d f19094a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f19095b;

    public a(ReactApplicationContext reactApplicationContext, Context context) {
        super(reactApplicationContext, context);
        this.f19095b = context;
        a.C0369a c2 = com.shopee.app.ui.order.a.c();
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        a.C0369a a2 = c2.a(f2.e());
        Context context2 = this.f19095b;
        if (context2 != null) {
            d a3 = a2.a(new b((com.shopee.app.ui.a.b) context2)).a();
            j.a((Object) a3, "DaggerMyOrderComponent.b…ty))\n            .build()");
            this.f19094a = a3;
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.ui.base.BaseActionActivity");
    }

    /* renamed from: a */
    public d b() {
        return this.f19094a;
    }
}
