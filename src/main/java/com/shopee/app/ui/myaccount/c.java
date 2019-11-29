package com.shopee.app.ui.myaccount;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    private d f23367a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) com.shopee.app.ui.myaccount.a.c.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_account_settings).a((a.b) new d(this)).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23367a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23367a.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f23367a;
    }
}
