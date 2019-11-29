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

public class a extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    private e f19456a;

    public String j() {
        return "notification_folder";
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new b(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a((a.b) new d(this)).b((int) R.string.sp_activities);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19456a = com.shopee.app.ui.home.b.c().a(g.a().e()).a(new com.shopee.app.a.b(this)).a();
        this.f19456a.a(this);
    }

    /* access modifiers changed from: protected */
    public o p_() {
        o oVar = new o();
        oVar.a("noti_folder", com.shopee.app.tracking.a.a.c(3));
        oVar.a("noti_folder_tab", com.shopee.app.tracking.a.a.b(0));
        return oVar;
    }

    /* renamed from: c */
    public e b() {
        return this.f19456a;
    }
}
