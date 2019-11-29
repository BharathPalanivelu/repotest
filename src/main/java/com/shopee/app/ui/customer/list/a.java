package com.shopee.app.ui.customer.list;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<com.shopee.app.ui.customer.a> {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.app.ui.customer.a f21394a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) f.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_my_customers).e(0).a((a.b) new C0316a()).a((a.b) new d(this));
    }

    /* renamed from: com.shopee.app.ui.customer.list.a$a  reason: collision with other inner class name */
    private class C0316a extends a.b {
        public C0316a() {
            super("ACTIVITY_SEARCH_FRIENDS", (int) R.drawable.com_garena_shopee_ic_search);
        }

        public void a() {
            a.this.v().d();
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21394a = com.shopee.app.ui.customer.b.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21394a.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.customer.a b() {
        return this.f21394a;
    }
}
