package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;
import d.d.b.j;

public final class h extends a {

    /* renamed from: c  reason: collision with root package name */
    private final CheckoutItem f16160c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(CheckoutItem checkoutItem) {
        super(checkoutItem);
        j.b(checkoutItem, ProductAction.ACTION_CHECKOUT);
        this.f16160c = checkoutItem;
    }

    public long a() {
        return this.f16160c.getCheckoutId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_pending_review), 1, (View.OnClickListener) null);
    }

    public String j() {
        String a2 = a((int) R.string.sp_bank_pending);
        j.a((Object) a2, "string(R.string.sp_bank_pending)");
        return a2;
    }

    public String b() {
        String a2 = a((int) R.string.sp_bank_pending_review);
        j.a((Object) a2, "string(R.string.sp_bank_pending_review)");
        return a2;
    }
}
