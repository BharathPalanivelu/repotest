package com.shopee.app.d.b.a.a.c;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class d extends a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ReturnItem f16034d;

    public d(ReturnItem returnItem) {
        super(returnItem);
        this.f16034d = returnItem;
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                new ak(d.this.a(view)).a(d.this.f16034d.isSelling(), d.this.f16034d.getReturnId());
            }
        });
    }

    public String b() {
        if (this.f16027c.nonIntegratedMallReturnEnabled()) {
            if (this.f16034d.isShopeeHandle() && this.f16034d.hasValidJudgingTime()) {
                return "";
            }
            if (!this.f16034d.hasValidJudgingTime()) {
                return a((int) R.string.sp_label_return_request_cancelled);
            }
        }
        if (this.f16034d.isOfficialShop()) {
            if ((u() && !this.f16027c.b2cReturnEnabled()) || !this.f16027c.c2cReturnOfficialEnabled()) {
                return "";
            }
        } else if (!this.f16027c.c2cReturnEnabled()) {
            return "";
        }
        if ((!u() || this.f16034d.isNonReceipt() || this.f16034d.isInComplete()) && this.f16034d.getJudgingTime() <= 0) {
            return a((int) R.string.sp_label_return_request_cancelled);
        }
        return "";
    }

    public String j() {
        if (this.f16027c.nonIntegratedMallReturnEnabled()) {
            if (this.f16034d.isShopeeHandle() && this.f16034d.hasValidJudgingTime()) {
                return a((int) R.string.sp_return_request_rejected);
            }
            if (!this.f16034d.hasValidJudgingTime()) {
                return a((int) R.string.sp_request_cancelled);
            }
        }
        if (this.f16034d.isOfficialShop()) {
            if (u() && !this.f16027c.b2cReturnEnabled()) {
                return a((int) R.string.sp_request_cancelled);
            }
            if (!this.f16027c.c2cReturnOfficialEnabled()) {
                return a((int) R.string.sp_request_cancelled);
            }
        } else if (!this.f16027c.c2cReturnEnabled()) {
            return a((int) R.string.sp_request_cancelled);
        }
        if (this.f16034d.getJudgingTime() > 0) {
            return a((int) R.string.sp_label_dispute_resolved);
        }
        return a((int) R.string.sp_request_cancelled);
    }
}
