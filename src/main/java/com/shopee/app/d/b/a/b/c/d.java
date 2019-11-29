package com.shopee.app.d.b.a.b.c;

import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.id.R;

public class d extends a {
    public d(ReturnItem returnItem) {
        super(returnItem);
    }

    public String j() {
        if (this.f16207d.nonIntegratedMallReturnEnabled()) {
            if (this.f16206c.isShopeeHandle() && this.f16206c.hasValidJudgingTime()) {
                return a((int) R.string.sp_return_request_rejected);
            }
            if (!this.f16206c.hasValidJudgingTime()) {
                return a((int) R.string.sp_request_cancelled);
            }
        }
        if (this.f16206c.isOfficialShop()) {
            if (u() && !this.f16207d.b2cReturnEnabled()) {
                return a((int) R.string.sp_request_cancelled);
            }
            if (!this.f16207d.c2cReturnOfficialEnabled()) {
                return a((int) R.string.sp_request_cancelled);
            }
        } else if (!this.f16207d.c2cReturnEnabled()) {
            return a((int) R.string.sp_request_cancelled);
        }
        if (u() && !this.f16206c.isNonReceipt() && !this.f16206c.isInComplete()) {
            return a((int) R.string.sp_return_request_rejected);
        }
        if (this.f16206c.getJudgingTime() > 0) {
            return a((int) R.string.sp_label_dispute_resolved);
        }
        return a((int) R.string.sp_request_cancelled);
    }

    public String b() {
        if (this.f16207d.nonIntegratedMallReturnEnabled()) {
            if (this.f16206c.isShopeeHandle() && this.f16206c.hasValidJudgingTime()) {
                return "";
            }
            if (!this.f16206c.hasValidJudgingTime()) {
                return a((int) R.string.sp_label_return_request_cancelled);
            }
        }
        if (this.f16206c.isOfficialShop()) {
            if ((u() && !this.f16207d.b2cReturnEnabled()) || !this.f16207d.c2cReturnOfficialEnabled()) {
                return "";
            }
        } else if (!this.f16207d.c2cReturnEnabled()) {
            return "";
        }
        if ((!u() || this.f16206c.isNonReceipt() || this.f16206c.isInComplete()) && this.f16206c.getJudgingTime() <= 0) {
            return a((int) R.string.sp_label_return_request_cancelled);
        }
        return "";
    }
}
