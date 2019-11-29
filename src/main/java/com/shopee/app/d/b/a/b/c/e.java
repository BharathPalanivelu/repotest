package com.shopee.app.d.b.a.b.c;

import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.id.R;

public class e extends a {
    public e(ReturnItem returnItem) {
        super(returnItem);
    }

    public String j() {
        if (this.f16207d.nonIntegratedMallReturnEnabled() && this.f16206c.isShopeeHandle()) {
            return a((int) R.string.sp_label_validation_in_progress);
        }
        if (this.f16206c.isOfficialShop()) {
            if (u() && !this.f16207d.b2cReturnEnabled()) {
                return a((int) R.string.sp_label_dispute_pending);
            }
            if (!this.f16207d.c2cReturnOfficialEnabled()) {
                return a((int) R.string.sp_label_dispute_pending);
            }
        } else if (!this.f16207d.c2cReturnEnabled()) {
            return a((int) R.string.sp_label_dispute_pending);
        }
        if (this.f16206c.isNonReceipt() || this.f16206c.isInComplete() || !u()) {
            return a((int) R.string.sp_label_dispute_pending);
        }
        return a((int) R.string.sp_label_validation_in_progress);
    }
}
