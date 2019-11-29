package com.shopee.app.ui.home.me.v3;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.react.g;
import com.shopee.app.tracking.trackingv3.a;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.m;
import com.shopee.app.ui.home.b;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.o.d;
import com.shopee.app.util.x;
import d.d.b.j;

public class f extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    public UserInfo f22536a;

    /* renamed from: b  reason: collision with root package name */
    private e f22537b;

    public String j() {
        return "seller";
    }

    public UserInfo c() {
        UserInfo userInfo = this.f22536a;
        if (userInfo == null) {
            j.b("userInfo");
        }
        return userInfo;
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new j(x(), this, (AttributeSet) null, 4, (g) null));
        d.a().a(this, x(), 0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        b.a c2 = com.shopee.app.ui.home.b.c();
        g a2 = g.a();
        j.a((Object) a2, "ReactApplication.get()");
        e a3 = c2.a(a2.e()).a(new com.shopee.app.a.b(this)).a();
        j.a((Object) a3, "DaggerHomeComponent.buil…\n                .build()");
        this.f22537b = a3;
        e eVar = this.f22537b;
        if (eVar == null) {
            j.b("component");
        }
        eVar.a(this);
    }

    /* access modifiers changed from: protected */
    public com.shopee.app.ui.a.d t() {
        com.shopee.app.ui.a.d t = super.t();
        t.getShadowContainer().a(false, false);
        j.a((Object) t, "super.initBaseView().app…e(false, false)\n        }");
        return t;
    }

    /* renamed from: l */
    public e b() {
        e eVar = this.f22537b;
        if (eVar == null) {
            j.b("component");
        }
        return eVar;
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        if (aVar != null) {
            a.C0296a f2 = aVar.f(1);
            Activity activity = this;
            m mVar = new m(activity);
            mVar.a(a.C0294a.f19171a.b(j()));
            a.C0296a a2 = f2.a((a.b) mVar);
            com.shopee.app.ui.actionbar.d dVar = new com.shopee.app.ui.actionbar.d(activity);
            dVar.a(a.C0294a.f19171a.a(j()));
            a2.a((a.b) dVar).e(0).a("");
        }
    }

    /* access modifiers changed from: protected */
    public o p_() {
        o oVar = new o();
        oVar.a("is_seller", Boolean.valueOf(c().isSeller()));
        return oVar;
    }
}
