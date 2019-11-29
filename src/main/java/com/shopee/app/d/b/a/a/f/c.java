package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    CheckoutItem f16144c;

    public c(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16144c = checkoutItem;
    }

    public long a() {
        return this.f16144c.getCheckoutId();
    }

    public String b() {
        if (this.f16144c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_bank_transfer_underpaid_summary_text, com.garena.android.appkit.tools.a.a.a(this.f16144c.getPayByDate(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_upload_receipt), 0, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f15981b.a("GOTO_PAY_CHECKOUT_PAGE", new com.garena.android.appkit.b.a(c.this.f16144c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f15981b.a("CANCEL_CHECKOUT_ACTION", new com.garena.android.appkit.b.a(c.this.f16144c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_underpaid);
    }

    public String k() {
        if (this.f16144c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_bank_transfer_underpaid_detail_text, com.garena.android.appkit.tools.a.a.a(this.f16144c.getPayByDate(), "ID"));
    }

    public String l() {
        return b.e(R.string.action_buyer_bank_transfer_underpaid_tooltip_text);
    }
}
