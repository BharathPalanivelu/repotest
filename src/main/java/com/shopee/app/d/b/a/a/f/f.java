package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;

public class f extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CheckoutItem f16153c;

    public f(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16153c = checkoutItem;
    }

    public long a() {
        return this.f16153c.getCheckoutId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_payment_pending_review), 1, (View.OnClickListener) null);
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f15981b.a("CANCEL_CHECKOUT_ACTION", new com.garena.android.appkit.b.a(f.this.f16153c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_to_pay);
    }

    public String k() {
        if (this.f16153c.getOrderDetailList().size() < 1) {
            return super.k();
        }
        if (this.f16153c.getOrderDetailList().get(0).getCODProcessByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_payment_under_review_info, com.garena.android.appkit.tools.a.a.c(this.f16153c.getOrderDetailList().get(0).getCODProcessByDate(), "ID"));
    }
}
