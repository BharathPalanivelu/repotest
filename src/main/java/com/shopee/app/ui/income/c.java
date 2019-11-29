package com.shopee.app.ui.income;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends b implements x<b> {

    /* renamed from: a  reason: collision with root package name */
    int f23167a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f23168b = R.string.sp_label_my_income;

    /* renamed from: c  reason: collision with root package name */
    private b f23169c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) e.a(this, this.f23167a));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a((a.b) new d(this)).b(this.f23168b);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23169c = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23169c.a(this);
    }

    /* renamed from: c */
    public b b() {
        return this.f23169c;
    }
}
