package com.shopee.app.d.b.a.b.c;

import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.id.R;

public class j extends a {
    public j(ReturnItem returnItem) {
        super(returnItem);
    }

    public String j() {
        if (this.f16206c.isOfficialShop()) {
            if (u() && !this.f16207d.b2cReturnEnabled()) {
                return a((int) R.string.sp_request_approved);
            }
            if (!this.f16207d.c2cReturnOfficialEnabled()) {
                return a((int) R.string.sp_request_approved);
            }
        } else if (!this.f16207d.c2cReturnEnabled()) {
            return a((int) R.string.sp_request_approved);
        }
        if (this.f16206c.getJudgingTime() <= 0) {
            return a((int) R.string.sp_request_approved);
        }
        if (!u() || this.f16206c.isNonReceipt() || this.f16206c.isInComplete()) {
            return a((int) R.string.sp_label_dispute_resolved);
        }
        return a((int) R.string.sp_request_approved);
    }

    public String k() {
        return a((int) R.string.action_seller_return_refund_paid_detail_text);
    }
}
