package com.shopee.app.ui.customer.order;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.ui.customer.a;
import com.shopee.app.util.x;

public class b extends com.shopee.app.ui.a.b implements x<a> {

    /* renamed from: a  reason: collision with root package name */
    int f21435a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f21436b;

    /* renamed from: c  reason: collision with root package name */
    String f21437c = "";

    /* renamed from: d  reason: collision with root package name */
    String f21438d = "";

    /* renamed from: e  reason: collision with root package name */
    private a f21439e;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) d.a(this, this.f21435a, this.f21436b, this.f21437c));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        a.C0296a f2 = aVar.f(1);
        f2.a("@" + this.f21438d).e(0).a((a.b) new d(this));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21439e = com.shopee.app.ui.customer.b.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21439e.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.customer.a b() {
        return this.f21439e;
    }
}
