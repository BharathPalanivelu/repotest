package com.shopee.app.d.b.a.a.c;

import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.id.R;

public class e extends a {

    /* renamed from: d  reason: collision with root package name */
    private ReturnItem f16036d;

    public e(ReturnItem returnItem) {
        super(returnItem);
        this.f16036d = returnItem;
    }

    public String j() {
        if (this.f16027c.nonIntegratedMallReturnEnabled() && this.f16036d.isShopeeHandle()) {
            return a((int) R.string.sp_label_validation_in_progress);
        }
        if (this.f16036d.isOfficialShop()) {
            if (u() && !this.f16027c.b2cReturnEnabled()) {
                return a((int) R.string.sp_label_dispute_pending);
            }
            if (!this.f16027c.c2cReturnOfficialEnabled()) {
                return a((int) R.string.sp_label_dispute_pending);
            }
        } else if (!this.f16027c.c2cReturnEnabled()) {
            return a((int) R.string.sp_label_dispute_pending);
        }
        if (this.f16036d.isNonReceipt() || !u()) {
            return a((int) R.string.sp_label_dispute_pending);
        }
        return a((int) R.string.sp_label_validation_in_progress);
    }
}
