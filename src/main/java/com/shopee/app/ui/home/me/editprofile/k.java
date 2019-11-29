package com.shopee.app.ui.home.me.editprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.places.model.PlaceFields;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class k extends b implements x<l> {

    /* renamed from: a  reason: collision with root package name */
    private l f22408a;

    /* renamed from: b  reason: collision with root package name */
    private m f22409b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f22409b = n.a(this);
        Intent intent = getIntent();
        if (intent.hasExtra("BUNDLE_PRE_FILL_LOCATION_KEY")) {
            this.f22409b.a(intent.getStringExtra("BUNDLE_PRE_FILL_LOCATION_KEY"));
        }
        if (intent.hasExtra("BUNDLE_LATITUDE_KEY")) {
            this.f22409b.a(intent.getFloatExtra("BUNDLE_LATITUDE_KEY", 370.0f), intent.getFloatExtra("BUNDLE_LONGITUDE_KEY", 370.0f));
        }
        a((View) this.f22409b);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_shop_location);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f22408a = b.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f22408a.a(this);
    }

    /* renamed from: c */
    public l b() {
        return this.f22408a;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1041 && i2 == -1) {
            com.garena.c.a.a aVar = new com.garena.c.a.a();
            aVar.a(intent.getStringExtra(PlaceFields.LOCATION));
            this.f22409b.a(aVar);
        }
        super.onActivityResult(i, i2, intent);
    }
}
