package com.shopee.app.ui.order.detail;

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
    long f23584a;

    /* renamed from: b  reason: collision with root package name */
    long f23585b;

    /* renamed from: c  reason: collision with root package name */
    private d f23586c;

    /* renamed from: d  reason: collision with root package name */
    private e f23587d;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f23587d = f.a(this, this.f23584a, this.f23585b);
        a((View) this.f23587d);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_label_order_details).a((a.b) new com.shopee.app.ui.actionbar.d(this));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23586c = com.shopee.app.ui.order.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23586c.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f23586c;
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
        aVar.a(hashCode(), this.f23587d);
    }
}
