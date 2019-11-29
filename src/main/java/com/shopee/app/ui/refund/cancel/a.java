package com.shopee.app.ui.refund.cancel;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<com.shopee.app.ui.refund.b> {

    /* renamed from: a  reason: collision with root package name */
    long f24938a;

    /* renamed from: b  reason: collision with root package name */
    int f24939b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.app.ui.refund.b f24940c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) d.a(this, this.f24938a, this.f24939b));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_txt_cancel_this_order);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24940c = com.shopee.app.ui.refund.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24940c.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.refund.b b() {
        return this.f24940c;
    }
}
