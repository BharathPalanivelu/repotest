package com.shopee.app.ui.product.twitter;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<g> {

    /* renamed from: a  reason: collision with root package name */
    String f24903a;

    /* renamed from: b  reason: collision with root package name */
    c f24904b;

    /* renamed from: c  reason: collision with root package name */
    g f24905c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f24904b = d.a(this);
        a((View) this.f24904b);
        this.f24904b.setUrl(this.f24903a);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24905c = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24905c.a(this);
    }

    /* renamed from: c */
    public g b() {
        return this.f24905c;
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_twitter).e(0);
    }
}
