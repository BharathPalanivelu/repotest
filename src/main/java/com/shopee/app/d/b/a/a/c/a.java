package com.shopee.app.d.b.a.a.c;

import android.app.Activity;
import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    SettingConfigStore f16027c = ar.f().e().settingConfigStore();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ReturnItem f16028d;

    public a(ReturnItem returnItem) {
        super(returnItem);
        this.f16028d = returnItem;
    }

    public long a() {
        return this.f16028d.getReturnId();
    }

    public boolean r() {
        boolean isOfficialShop = this.f16028d.isOfficialShop();
        return false;
    }

    public boolean s() {
        boolean isOfficialShop = this.f16028d.isOfficialShop();
        return false;
    }

    public boolean t() {
        boolean isOfficialShop = this.f16028d.isOfficialShop();
        return false;
    }

    public boolean u() {
        return this.f16028d.isOfficialShop();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = a.this.a(view);
                if (a2 != null) {
                    new ak(a2).a(a.this.f16028d.isSelling(), a.this.f16028d.getReturnId());
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public String v() {
        return com.garena.android.appkit.tools.a.a.c(this.f16028d.getSellerDueDay(), "ID");
    }
}
