package com.shopee.app.ui.chat2.order;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.chat.c;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<com.shopee.app.ui.chat.b> {

    /* renamed from: a  reason: collision with root package name */
    int f20643a;

    /* renamed from: b  reason: collision with root package name */
    int f20644b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.app.ui.chat.b f20645c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) e.a(this, this.f20644b, this.f20643a));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_orders).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f20645c = c.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f20645c.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.chat.b b() {
        return this.f20645c;
    }
}
