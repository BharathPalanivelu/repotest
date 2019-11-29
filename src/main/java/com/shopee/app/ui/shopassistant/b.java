package com.shopee.app.ui.shopassistant;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.h.r;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    private c f25387a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) h.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_seller_assistant).a((a.b) new d(this)).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25387a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25387a.a(this);
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        if (i == -1) {
            r.a().b((int) R.string.sp_phone_changed);
        }
    }

    /* renamed from: c */
    public c b() {
        return this.f25387a;
    }
}
