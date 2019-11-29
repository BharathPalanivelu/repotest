package com.shopee.app.ui.setting.notification2;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<m> {

    /* renamed from: a  reason: collision with root package name */
    private m f25267a;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) e.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_setting_push_notification).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25267a = com.shopee.app.ui.setting.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25267a.a(this);
    }

    /* renamed from: c */
    public m b() {
        return this.f25267a;
    }
}
