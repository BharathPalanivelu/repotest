package com.shopee.app.ui.setting;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class h extends b implements x<m> {

    /* renamed from: a  reason: collision with root package name */
    private m f25237a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) j.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_notifications).a((a.b) new d(this)).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25237a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25237a.a(this);
    }

    /* renamed from: c */
    public m b() {
        return this.f25237a;
    }
}
