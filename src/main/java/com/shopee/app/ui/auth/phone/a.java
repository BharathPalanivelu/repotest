package com.shopee.app.ui.auth.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.i;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<com.shopee.app.ui.auth.b.b> {

    /* renamed from: a  reason: collision with root package name */
    String f19680a;

    /* renamed from: b  reason: collision with root package name */
    int f19681b;

    /* renamed from: c  reason: collision with root package name */
    int f19682c;

    /* renamed from: d  reason: collision with root package name */
    int f19683d;

    /* renamed from: e  reason: collision with root package name */
    String f19684e;

    /* renamed from: f  reason: collision with root package name */
    String f19685f;

    /* renamed from: g  reason: collision with root package name */
    private com.shopee.app.ui.auth.b.b f19686g;
    private d h;

    public String j() {
        return "login_sms";
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.h = e.a(this, this.f19681b, this.f19682c, this.f19683d, this.f19680a, this.f19684e);
        a((View) this.h);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_label_phone).a((a.b) new i(this));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19686g = com.shopee.app.ui.auth.b.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19686g.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.b.b b() {
        return this.f19686g;
    }

    public void onBackPressed() {
        super.onBackPressed();
        com.shopee.app.c.a.a((Context) this);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public o p_() {
        o oVar = new o();
        oVar.a("acquisition_source", this.f19685f);
        return oVar;
    }
}
