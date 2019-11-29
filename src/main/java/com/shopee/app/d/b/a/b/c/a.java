package com.shopee.app.d.b.a.b.c;

import android.app.Activity;
import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.e;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    protected final ReturnItem f16206c;

    /* renamed from: d  reason: collision with root package name */
    SettingConfigStore f16207d = ar.f().e().settingConfigStore();

    public a(ReturnItem returnItem) {
        super(returnItem);
        this.f16206c = returnItem;
    }

    public boolean r() {
        boolean isOfficialShop = this.f16206c.isOfficialShop();
        return false;
    }

    public boolean s() {
        boolean isOfficialShop = this.f16206c.isOfficialShop();
        return false;
    }

    public boolean t() {
        boolean isOfficialShop = this.f16206c.isOfficialShop();
        return false;
    }

    public boolean u() {
        return this.f16206c.isOfficialShop();
    }

    public long a() {
        return this.f16206c.getReturnId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = a.this.a(view);
                if (a2 != null) {
                    ar.f().e().actionTracker().a(((e) a2).A(), a.this.f16206c);
                    new ak(a2).a(a.this.f16206c.isSelling(), a.this.f16206c.getReturnId());
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public String v() {
        return com.garena.android.appkit.tools.a.a.c(this.f16206c.getSellerDueDay(), "ID");
    }
}
