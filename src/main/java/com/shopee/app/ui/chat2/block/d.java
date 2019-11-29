package com.shopee.app.ui.chat2.block;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    private e f20312a;

    /* renamed from: b  reason: collision with root package name */
    private l f20313b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f20313b = m.a(this);
        a((View) this.f20313b);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_blocked_users).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f20312a = q.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f20312a.a(this);
    }

    /* renamed from: c */
    public e b() {
        return this.f20312a;
    }
}
