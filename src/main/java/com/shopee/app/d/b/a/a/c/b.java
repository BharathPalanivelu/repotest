package com.shopee.app.d.b.a.a.c;

import android.app.Activity;
import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class b extends a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ReturnItem f16030d;

    public b(ReturnItem returnItem) {
        super(returnItem);
        this.f16030d = returnItem;
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = b.this.a(view);
                if (a2 != null) {
                    new ak(a2).a(b.this.f16030d.isSelling(), b.this.f16030d.getReturnId());
                }
            }
        });
    }

    public String b() {
        if (this.f16027c.nonIntegratedMallReturnEnabled() && this.f16030d.isShopeeHandle() && this.f16030d.hasValidJudgingTime()) {
            return "";
        }
        if (this.f16027c.nonIntegratedMallReturnEnabled() && this.f16030d.isShopeeHandle()) {
            return a((int) R.string.sp_request_approved);
        }
        if (r() || this.f16030d.getJudgingTime() != 0) {
            return a((int) R.string.action_buyer_return_accepted_bank_summary_text);
        }
        return "";
    }

    public String j() {
        if (this.f16027c.nonIntegratedMallReturnEnabled() && this.f16030d.isShopeeHandle() && this.f16030d.hasValidJudgingTime()) {
            return a((int) R.string.sp_request_approved);
        }
        if (r()) {
            return a((int) R.string.order_list_return_success);
        }
        if (this.f16030d.isOfficialShop()) {
            if (u() && !this.f16027c.b2cReturnEnabled()) {
                return a((int) R.string.sp_request_approved);
            }
            if (!this.f16027c.c2cReturnOfficialEnabled()) {
                return a((int) R.string.sp_request_approved);
            }
        } else if (!this.f16027c.c2cReturnEnabled()) {
            return a((int) R.string.sp_request_approved);
        }
        if (u() || this.f16030d.getJudgingTime() <= 0) {
            return a((int) R.string.sp_request_approved);
        }
        return a((int) R.string.sp_label_dispute_resolved);
    }
}
