package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;

public class l extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CheckoutItem f16169c;

    public l(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16169c = checkoutItem;
    }

    public long a() {
        return this.f16169c.getCheckoutId();
    }

    public String b() {
        if (this.f16169c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_unsupported_channel_unpaid_summary_text, com.garena.android.appkit.tools.a.a.a(this.f16169c.getPayByDate(), "ID"), this.f16169c.getPaymentChannelName());
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                l.this.f15981b.a("GOTO_PAY_CHECKOUT_PAGE", new com.garena.android.appkit.b.a(l.this.f16169c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                l.this.f15981b.a("CANCEL_CHECKOUT_ACTION", new com.garena.android.appkit.b.a(l.this.f16169c));
            }
        });
    }

    public a.C0251a f() {
        return ar.f().e().orderLogicProcessor().a(this.f16169c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_to_pay);
    }

    public String k() {
        if (this.f16169c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_unsupported_channel_unpaid_detail_text, com.garena.android.appkit.tools.a.a.a(this.f16169c.getPayByDate(), "ID"), this.f16169c.getPaymentChannelName());
    }

    public String l() {
        return b.a(R.string.action_buyer_unsupported_channel_unpaid_tooltip_text, this.f16169c.getPaymentChannelName());
    }
}
