package com.shopee.app.ui.auth.signup.thirdparty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.io.Serializable;

public class a extends b implements x<com.shopee.app.ui.auth.signup.b> {

    /* renamed from: a  reason: collision with root package name */
    int f19925a = 0;

    /* renamed from: b  reason: collision with root package name */
    String f19926b;

    /* renamed from: c  reason: collision with root package name */
    String f19927c;

    /* renamed from: d  reason: collision with root package name */
    String f19928d;

    /* renamed from: e  reason: collision with root package name */
    Serializable f19929e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.ui.auth.signup.a.a f19930f;

    /* renamed from: g  reason: collision with root package name */
    com.shopee.app.ui.auth.signup.b.a f19931g;
    private d h;
    private com.shopee.app.ui.auth.signup.b i;
    private c j;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        if (this.f19925a != 2) {
            this.j = this.f19930f;
        } else {
            this.j = this.f19931g;
        }
        this.j.a(this.f19929e);
        this.h = e.a(this, this.j, this.f19926b, this.f19927c, this.f19928d);
        a((View) this.h);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_sign_up);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.i = com.shopee.app.ui.auth.signup.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.i.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.signup.b b() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Intent intent) {
        if (i2 == -1) {
            this.h.a(intent.getStringArrayListExtra("add_product_image_uri_list").get(0));
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.h.b(com.garena.android.appkit.tools.b.e(R.string.sp_error_user_name_duplicate));
    }

    /* access modifiers changed from: protected */
    public void w_() {
        this.h.b(com.garena.android.appkit.tools.b.e(R.string.sp_error_register_fail));
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.h.b(com.garena.android.appkit.tools.b.e(R.string.sp_try_another_email));
    }
}
