package com.shopee.app.react.modules.app.tracker;

import android.app.Activity;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.protocol.ScreenNameData;
import d.d.b.j;

public final class a extends b implements com.shopee.app.react.util.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.shopee.app.tracking.d.a f18794a;

    public void a() {
    }

    public void c() {
    }

    public void d() {
    }

    public a(c cVar) {
        j.b(cVar, "host");
        Activity a2 = cVar.a();
        j.a((Object) a2, "host.context");
        this.f18794a = new com.shopee.app.tracking.d.a(a2);
    }

    public final void a(ScreenNameData screenNameData) {
        j.b(screenNameData, "data");
        this.f18794a.a(screenNameData.getName());
    }

    public void b() {
        this.f18794a.a();
    }
}
