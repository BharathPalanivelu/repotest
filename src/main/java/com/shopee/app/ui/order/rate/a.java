package com.shopee.app.ui.order.rate;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.order.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    long f23757a;

    /* renamed from: b  reason: collision with root package name */
    int f23758b;

    /* renamed from: c  reason: collision with root package name */
    int f23759c;

    /* renamed from: d  reason: collision with root package name */
    int f23760d;

    /* renamed from: e  reason: collision with root package name */
    private d f23761e;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) g.a(this, this.f23757a, this.f23758b, this.f23759c, this.f23760d));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_rate_product).a("RATING_FINISH", (int) R.drawable.com_garena_shopee_ic_done);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23761e = com.shopee.app.ui.order.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23761e.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f23761e;
    }
}
