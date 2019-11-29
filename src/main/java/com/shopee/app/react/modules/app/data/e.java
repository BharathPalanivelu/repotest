package com.shopee.app.react.modules.app.data;

import com.google.a.o;
import com.shopee.app.data.store.bf;

public class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private bf f18750a;

    public e(bf bfVar) {
        this.f18750a = bfVar;
    }

    public boolean a(String str) {
        return "cartCount".equals(str);
    }

    public String b(String str) {
        this.f18750a.g();
        o oVar = new o();
        oVar.a("count", (Number) Integer.valueOf(this.f18750a.g()));
        return oVar.toString();
    }
}
