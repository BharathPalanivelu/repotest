package com.shopee.app.ui.product.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.places.model.PlaceFields;
import com.garena.c.a.a;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    private c f24628a;

    /* renamed from: b  reason: collision with root package name */
    private e f24629b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f24629b = f.a(this);
        a((View) this.f24629b);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            a aVar = new a();
            aVar.a(intent.getStringExtra(PlaceFields.LOCATION));
            this.f24629b.a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_location).e(0).a("LOCATION_NOTICE_SUBMIT_LOCATION", (int) R.drawable.com_garena_shopee_ic_done);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24628a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24628a.a(this);
    }

    /* renamed from: c */
    public c b() {
        return this.f24628a;
    }
}
