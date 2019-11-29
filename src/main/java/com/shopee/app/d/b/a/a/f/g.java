package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.util.s;
import com.shopee.id.R;

public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    CheckoutItem f16155c;

    /* renamed from: d  reason: collision with root package name */
    s f16156d = ar.f().e().featureToggleManager();

    public g(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16155c = checkoutItem;
    }

    public long a() {
        return this.f16155c.getCheckoutId();
    }

    public String b() {
        if (this.f16155c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_credit_card_unpaid_summary_text, com.garena.android.appkit.tools.a.a.a(this.f16155c.getPayByDate(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_label_pay_now), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("GOTO_PAY_CHECKOUT_PAGE", new com.garena.android.appkit.b.a(g.this.f16155c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("CANCEL_CHECKOUT_ACTION", new com.garena.android.appkit.b.a(g.this.f16155c));
            }
        });
    }

    public a.C0251a f() {
        if (!this.f16155c.isSupportChangePayment()) {
            return new a.C0251a();
        }
        return new a.C0251a(a((int) R.string.sp_change_payment_method), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("GOTO_CHANGE_CHECKOUT_PAY", new com.garena.android.appkit.b.a(g.this.f16155c));
            }
        });
    }

    public a.C0251a g() {
        return ar.f().e().orderLogicProcessor().b(this.f16155c, this.f15981b);
    }

    public String j() {
        if (!this.f16156d.a("to_pay_cc_installment")) {
            return a((int) R.string.sp_label_to_pay);
        }
        if (!this.f16156d.a("to_pay_cc_installment_pending") || this.f16155c.getPaymentStatus() != 101) {
            return a((int) R.string.sp_label_pay_now);
        }
        return a((int) R.string.sp_pending);
    }

    public String k() {
        if (this.f16155c.getPayByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_credit_card_unpaid_detail_text, com.garena.android.appkit.tools.a.a.a(this.f16155c.getPayByDate(), "ID"));
    }

    public String l() {
        return b.e(R.string.action_buyer_credit_card_unpaid_tooltip_text);
    }
}
