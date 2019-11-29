package com.shopee.app.d.b.a.a.c;

import android.app.Activity;
import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class j extends a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ReturnItem f16051d;

    public j(ReturnItem returnItem) {
        super(returnItem);
        this.f16051d = returnItem;
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = j.this.a(view);
                if (a2 != null) {
                    new ak(a2).a(j.this.f16051d.isSelling(), j.this.f16051d.getReturnId());
                }
            }
        });
    }

    public String j() {
        if (this.f16051d.isOfficialShop()) {
            if (u() && !this.f16027c.b2cReturnEnabled()) {
                return a((int) R.string.sp_payment_transferred);
            }
            if (!this.f16027c.c2cReturnOfficialEnabled()) {
                return a((int) R.string.sp_payment_transferred);
            }
        } else if (!this.f16027c.c2cReturnEnabled()) {
            return a((int) R.string.sp_payment_transferred);
        }
        if (this.f16051d.getJudgingTime() <= 0) {
            return a((int) R.string.sp_payment_transferred);
        }
        if (!u() || !this.f16051d.isNonReceipt() || !this.f16051d.isInComplete()) {
            return a((int) R.string.sp_label_dispute_resolved);
        }
        return a((int) R.string.sp_request_approved);
    }

    public String l() {
        return a((int) R.string.action_buyer_return_refund_paid_tooltip_text);
    }
}
