package com.shopee.app.ui.auth.password;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<i> {

    /* renamed from: a  reason: collision with root package name */
    private i f19592a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) e.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_password).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19592a = g.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19592a.a(this);
    }

    /* renamed from: c */
    public i b() {
        return this.f19592a;
    }
}
