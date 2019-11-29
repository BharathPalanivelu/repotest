package com.shopee.app.ui.auth.password;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class k extends b implements x<i> {

    /* renamed from: a  reason: collision with root package name */
    String f19619a;

    /* renamed from: b  reason: collision with root package name */
    ak f19620b;

    /* renamed from: c  reason: collision with root package name */
    private i f19621c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) p.a(this, this.f19619a));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_reset_password).e(0);
    }

    /* access modifiers changed from: package-private */
    public void f_(int i) {
        if (i == -1) {
            r.a().b((int) R.string.sp_label_reset_password_success);
            setResult(i);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        if (i == -1) {
            setResult(i);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, String str, String str2) {
        if (i == -1) {
            this.f19620b.b(str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19621c = g.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19621c.a(this);
    }

    /* renamed from: c */
    public i b() {
        return this.f19621c;
    }
}
