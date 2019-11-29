package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;

public class i extends a {

    /* renamed from: c  reason: collision with root package name */
    CheckoutItem f16161c;

    public i(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16161c = checkoutItem;
    }

    public long a() {
        return this.f16161c.getCheckoutId();
    }

    public String b() {
        if (this.f16161c.getPaymentStatus() == 0) {
            return b.a(R.string.order_list_complete_aplplication, com.garena.android.appkit.tools.a.a.a(this.f16161c.getPayByDate(), "ID"));
        }
        return b.a(R.string.order_list_complete_application_pending_review, this.f16161c.getPaymentChannelName());
    }

    public a.C0251a d() {
        if (this.f16161c.getPaymentStatus() == 0) {
            return new a.C0251a(a((int) R.string.sp_label_pay_now), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.f15981b.a("GOTO_PAY_CHECKOUT_PAGE", new com.garena.android.appkit.b.a(i.this.f16161c));
                }
            });
        }
        return new a.C0251a(a((int) R.string.action_buyer_bank_transfer_pending_summary_text), 1, (View.OnClickListener) null);
    }

    public String j() {
        if (this.f16161c.getPaymentStatus() == 0) {
            return a((int) R.string.sp_label_order_status_to_pay);
        }
        return a((int) R.string.sp_payment_pending_review);
    }
}
