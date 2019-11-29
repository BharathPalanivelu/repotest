package com.shopee.app.ui.shopassistant.shopProfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.places.model.PlaceFields;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    private f f25479a;

    /* renamed from: b  reason: collision with root package name */
    private c f25480b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f25479a = g.a(this);
        a((View) this.f25479a);
        getWindow().setSoftInputMode(3);
        if (bundle == null) {
            this.f25479a.b();
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_label_edit_shop_profile).a("EDIT_PROFILE_SUBMIT_PROFILE", (int) R.drawable.com_garena_shopee_ic_done);
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
        aVar.a(hashCode(), this.f25479a);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25480b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25480b.a(this);
    }

    /* renamed from: c */
    public c b() {
        return this.f25480b;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1028 && i2 == -1) {
            new com.garena.c.a.a().a(intent.getStringExtra(PlaceFields.LOCATION));
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            String str = intent.getStringArrayListExtra("add_product_image_uri_list").get(0);
            if (str != null) {
                this.f25479a.b(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i, Intent intent) {
        if (i == -1) {
            this.f25479a.c(intent.getStringArrayListExtra("add_product_image_uri_list").get(0));
        }
    }

    public void onBackPressed() {
        com.shopee.app.c.a.a((Context) this);
        this.f25479a.e();
    }
}
