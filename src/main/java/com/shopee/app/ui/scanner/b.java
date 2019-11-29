package com.shopee.app.ui.scanner;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    private c f24991a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) e.a(this));
        v().setVisibility(8);
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(0);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_settings).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24991a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24991a.a(this);
    }

    /* renamed from: c */
    public c b() {
        return this.f24991a;
    }
}
