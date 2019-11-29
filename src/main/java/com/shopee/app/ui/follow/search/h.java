package com.shopee.app.ui.follow.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;

public class h extends b implements x<com.shopee.app.ui.follow.b> {

    /* renamed from: a  reason: collision with root package name */
    String f21786a;

    /* renamed from: b  reason: collision with root package name */
    int f21787b;

    /* renamed from: c  reason: collision with root package name */
    boolean f21788c;

    /* renamed from: d  reason: collision with root package name */
    String f21789d;

    /* renamed from: e  reason: collision with root package name */
    com.shopee.app.tracking.trackingv3.b f21790e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.ui.follow.b f21791f;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) n.a(this, this.f21786a, false, this.f21787b, this.f21788c, this.f21789d));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(2).b(com.garena.android.appkit.tools.b.e(this.f21787b == 1 ? R.string.sp_search_my_customer : R.string.sp_search_shops)).c(this.f21786a);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21791f = com.shopee.app.ui.follow.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21791f.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.follow.b b() {
        return this.f21791f;
    }

    /* access modifiers changed from: protected */
    public String h() {
        if (TextUtils.isEmpty(this.f21786a)) {
            return "";
        }
        o oVar = new o();
        oVar.a("userInput", this.f21786a);
        return WebRegister.GSON.a((l) oVar);
    }

    public String j() {
        if (this.f21788c) {
            return "shop_search";
        }
        return super.j();
    }

    /* access modifiers changed from: protected */
    public o p_() {
        if (!this.f21788c) {
            return super.p_();
        }
        o oVar = new o();
        oVar.a("keyword", this.f21786a);
        return oVar;
    }
}
