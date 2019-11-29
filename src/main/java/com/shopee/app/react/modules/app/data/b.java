package com.shopee.app.react.modules.app.data;

import com.google.a.o;
import com.shopee.app.application.ar;

public class b implements h, i {

    /* renamed from: a  reason: collision with root package name */
    c f18743a = ar.f().e().provideAppsFlyerStore();

    public boolean a(String str) {
        return "appsFlyerAttributionData".equals(str);
    }

    public String b(String str) {
        o oVar = new o();
        oVar.a("data", this.f18743a.a());
        return oVar.toString();
    }

    public String c(String str) {
        this.f18743a.a(str);
        return str;
    }
}
