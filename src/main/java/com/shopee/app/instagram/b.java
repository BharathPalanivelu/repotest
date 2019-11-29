package com.shopee.app.instagram;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<g> {

    /* renamed from: a  reason: collision with root package name */
    String f17746a;

    /* renamed from: b  reason: collision with root package name */
    c f17747b;

    /* renamed from: c  reason: collision with root package name */
    g f17748c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f17747b = d.a(this);
        a((View) this.f17747b);
        this.f17747b.setUrl(this.f17746a);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f17748c = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f17748c.a(this);
    }

    /* renamed from: a */
    public g b() {
        return this.f17748c;
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_instagram).e(0);
    }
}
