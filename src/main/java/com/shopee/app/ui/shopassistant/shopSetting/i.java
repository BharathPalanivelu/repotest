package com.shopee.app.ui.shopassistant.shopSetting;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class i extends b implements x<j> {

    /* renamed from: a  reason: collision with root package name */
    private j f25580a;

    /* renamed from: b  reason: collision with root package name */
    private n f25581b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f25581b = o.a(this);
        a((View) this.f25581b);
    }

    public void onBackPressed() {
        this.f25581b.d();
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_shop_settings).a((a.b) new d(this)).g().e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25580a = b.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25580a.a(this);
    }

    /* renamed from: c */
    public j b() {
        return this.f25580a;
    }
}
