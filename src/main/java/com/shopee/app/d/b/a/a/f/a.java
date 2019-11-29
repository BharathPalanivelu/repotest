package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    CheckoutItem f16140c;

    public a(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16140c = checkoutItem;
    }

    public long a() {
        return this.f16140c.getCheckoutId();
    }

    public String b() {
        return ar.f().e().settingConfigStore().getPaymentConfirmTimeStr();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.action_buyer_bank_transfer_pending_summary_text), 1, (View.OnClickListener) null);
    }

    public String j() {
        return a((int) R.string.sp_pending_review);
    }

    public String k() {
        if (this.f16140c.getReceiptProcessByDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_bank_transfer_pending_detail_text, com.garena.android.appkit.tools.a.a.c(this.f16140c.getReceiptProcessByDate(), "ID"));
    }

    public String l() {
        return b.e(R.string.action_buyer_bank_transfer_pending_tooltip_text);
    }
}
