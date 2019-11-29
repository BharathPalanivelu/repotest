package com.shopee.app.ui.auth.password;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class r extends b implements x<i> {

    /* renamed from: a  reason: collision with root package name */
    String f19651a;

    /* renamed from: b  reason: collision with root package name */
    String f19652b;

    /* renamed from: c  reason: collision with root package name */
    String f19653c;

    /* renamed from: d  reason: collision with root package name */
    UserInfo f19654d;

    /* renamed from: e  reason: collision with root package name */
    private i f19655e;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) w.a(this, this.f19651a, this.f19652b, this.f19653c));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0);
        if (this.f19654d.loginHasPassword() || this.f19654d.hasPassword()) {
            aVar.b((int) R.string.sp_label_reset_password);
        } else {
            aVar.b((int) R.string.sp_set_new_password);
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19655e = g.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19655e.a(this);
    }

    /* renamed from: c */
    public i b() {
        return this.f19655e;
    }
}
