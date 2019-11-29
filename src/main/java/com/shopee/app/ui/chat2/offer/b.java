package com.shopee.app.ui.chat2.offer;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.chat.c;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<com.shopee.app.ui.chat.b> {

    /* renamed from: a  reason: collision with root package name */
    boolean f20605a = false;

    /* renamed from: b  reason: collision with root package name */
    int f20606b;

    /* renamed from: c  reason: collision with root package name */
    int f20607c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.app.ui.chat.b f20608d;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) d.a(this, this.f20606b, this.f20607c, this.f20605a));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_offers).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f20608d = c.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f20608d.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.chat.b b() {
        return this.f20608d;
    }
}
