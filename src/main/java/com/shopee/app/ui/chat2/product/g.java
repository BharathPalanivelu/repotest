package com.shopee.app.ui.chat2.product;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.chat.c;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class g extends b implements x<com.shopee.app.ui.chat.b> {

    /* renamed from: a  reason: collision with root package name */
    int f20796a;

    /* renamed from: b  reason: collision with root package name */
    int f20797b;

    /* renamed from: c  reason: collision with root package name */
    String f20798c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.app.ui.chat.b f20799d;

    public String j() {
        return "chat_products";
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) o.a(this, this.f20797b, this.f20796a, this.f20798c));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_products).e(0).a((a.b) new a());
    }

    private class a extends a.b {
        public a() {
            super("ACTIVITY_SEARCH_PRODUCT", (int) R.drawable.com_garena_shopee_ic_search);
        }

        public void a() {
            g.this.v().d();
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f20799d = c.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f20799d.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.chat.b b() {
        return this.f20799d;
    }
}
