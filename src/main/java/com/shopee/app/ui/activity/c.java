package com.shopee.app.ui.activity;

import android.os.Bundle;
import android.view.View;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.react.g;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    int f19458a;

    /* renamed from: b  reason: collision with root package name */
    private e f19459b;

    public String j() {
        return "notification_folder";
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        d dVar = new d(this);
        dVar.setSelectedIndex(this.f19458a);
        a((View) dVar);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a((a.b) new d(this)).b((int) R.string.notification_shop_updates);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19459b = com.shopee.app.ui.home.b.c().a(g.a().e()).a(new com.shopee.app.a.b(this)).a();
        this.f19459b.a(this);
    }

    /* access modifiers changed from: protected */
    public o p_() {
        o oVar = new o();
        oVar.a("noti_folder", com.shopee.app.tracking.a.a.c(3));
        oVar.a("noti_folder_tab", com.shopee.app.tracking.a.a.b(this.f19458a));
        return oVar;
    }

    /* renamed from: c */
    public e b() {
        return this.f19459b;
    }
}
