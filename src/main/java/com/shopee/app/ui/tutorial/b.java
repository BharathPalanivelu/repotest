package com.shopee.app.ui.tutorial;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<g> {

    /* renamed from: a  reason: collision with root package name */
    private g f25704a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        getWindow().setTitle(com.garena.android.appkit.tools.b.e(R.string.sp_label_select_language));
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) d.a(this));
        v().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
        aVar.b((int) R.string.sp_label_select_language);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25704a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25704a.a(this);
    }

    /* renamed from: c */
    public g b() {
        return this.f25704a;
    }
}
