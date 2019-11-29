package com.shopee.app.ui.myproduct;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    int f23427a;

    /* renamed from: b  reason: collision with root package name */
    private c f23428b;

    /* renamed from: c  reason: collision with root package name */
    private e f23429c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f23429c = f.a(this, this.f23427a);
        a((View) this.f23429c);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_my_products).e(0).a((a.b) new d(this));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23428b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23428b.a(this);
    }

    public void onBackPressed() {
        if (!this.f23429c.h()) {
            super.onBackPressed();
        }
    }

    /* renamed from: c */
    public c b() {
        return this.f23428b;
    }
}
