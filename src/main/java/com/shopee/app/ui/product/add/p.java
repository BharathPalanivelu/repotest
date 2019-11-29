package com.shopee.app.ui.product.add;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class p extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    String f24146a;

    /* renamed from: b  reason: collision with root package name */
    private d f24147b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) aa.a(this, this.f24146a));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_share_listings_to).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24147b = o.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24147b.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f24147b;
    }
}
