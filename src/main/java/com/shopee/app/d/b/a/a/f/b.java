package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    CheckoutItem f16141c;

    public b(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16141c = checkoutItem;
    }

    public long a() {
        return this.f16141c.getCheckoutId();
    }

    public String b() {
        if (this.f16141c.getPayByDate() <= 0) {
            return "";
        }
        return com.garena.android.appkit.tools.b.a(R.string.action_buyer_bank_transfer_rejected_summary_text, com.garena.android.appkit.tools.a.a.a(this.f16141c.getPayByDate(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_upload_receipt), 0, new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f15981b.a("GOTO_PAY_CHECKOUT_PAGE", new com.garena.android.appkit.b.a(b.this.f16141c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f15981b.a("CANCEL_CHECKOUT_ACTION", new com.garena.android.appkit.b.a(b.this.f16141c));
            }
        });
    }

    public a.C0251a f() {
        return ar.f().e().orderLogicProcessor().a(this.f16141c, this.f15981b);
    }

    public a.C0251a g() {
        return ar.f().e().orderLogicProcessor().b(this.f16141c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_status_payment_rejected);
    }

    public String k() {
        if (this.f16141c.getPayByDate() <= 0) {
            return "";
        }
        return com.garena.android.appkit.tools.b.a(R.string.action_buyer_bank_transfer_rejected_detail_text, com.garena.android.appkit.tools.a.a.a(this.f16141c.getPayByDate(), "ID"));
    }

    public String l() {
        return com.garena.android.appkit.tools.b.e(R.string.action_buyer_bank_transfer_rejected_tooltip_text);
    }
}
