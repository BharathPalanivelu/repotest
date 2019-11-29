package com.shopee.app.ui.myaccount.PhoneSettings;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    private c f23241a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) g.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_phone).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23241a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23241a.a(this);
    }

    /* renamed from: c */
    public c b() {
        return this.f23241a;
    }
}
