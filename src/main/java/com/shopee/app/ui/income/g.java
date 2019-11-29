package com.shopee.app.ui.income;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.income.b.e;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class g extends b implements x<b> {

    /* renamed from: a  reason: collision with root package name */
    int f23180a;

    /* renamed from: b  reason: collision with root package name */
    private b f23181b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) e.a(this, this.f23180a));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0);
        if (this.f23180a == 2) {
            aVar.b((int) R.string.sp_label_under_escrow);
        } else {
            aVar.b((int) R.string.sp_label_released_amount);
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23181b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23181b.a(this);
    }

    /* renamed from: c */
    public b b() {
        return this.f23181b;
    }
}
