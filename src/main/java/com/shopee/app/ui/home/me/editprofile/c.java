package com.shopee.app.ui.home.me.editprofile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    private h f22351a;

    /* renamed from: b  reason: collision with root package name */
    private d f22352b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f22351a = i.a(this);
        a((View) this.f22351a);
        getWindow().setSoftInputMode(3);
        if (bundle == null) {
            this.f22351a.b();
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_edit_profile).a("EDIT_PROFILE_SUBMIT_PROFILE", (int) R.drawable.com_garena_shopee_ic_done);
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
        aVar.a(hashCode(), this.f22351a);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f22352b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f22352b.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f22352b;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            this.f22351a.a(intent.getStringArrayListExtra("add_product_image_uri_list").get(0));
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, String str) {
        if (i == -1) {
            this.f22351a.c(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i, String str) {
        if (i == -1) {
            this.f22351a.d(str);
        }
    }

    public void onBackPressed() {
        com.shopee.app.c.a.a((Context) this);
        this.f22351a.m();
    }
}
