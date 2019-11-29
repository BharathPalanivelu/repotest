package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;

public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    CheckoutItem f16166c;

    public k(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16166c = checkoutItem;
    }

    public long a() {
        return this.f16166c.getCheckoutId();
    }

    public String b() {
        if (this.f16166c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_unsupported_channel_unpaid_summary_text, com.garena.android.appkit.tools.a.a.a(this.f16166c.getPayByDate(), "ID"), this.f16166c.getPaymentChannelName());
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_label_pay_now), 0, new View.OnClickListener() {
            public void onClick(View view) {
                k.this.f15981b.a("GOTO_PAY_CHECKOUT_PAGE", new com.garena.android.appkit.b.a(k.this.f16166c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                k.this.f15981b.a("CANCEL_CHECKOUT_ACTION", new com.garena.android.appkit.b.a(k.this.f16166c));
            }
        });
    }

    public a.C0251a f() {
        return ar.f().e().orderLogicProcessor().a(this.f16166c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_to_pay);
    }

    public String k() {
        if (this.f16166c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_unsupported_channel_unpaid_detail_text, com.garena.android.appkit.tools.a.a.a(this.f16166c.getPayByDate(), "ID"), this.f16166c.getPaymentChannelName());
    }

    public String l() {
        return b.a(R.string.action_buyer_unsupported_channel_unpaid_tooltip_text, this.f16166c.getPaymentChannelName());
    }
}
