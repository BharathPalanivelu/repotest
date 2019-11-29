package com.shopee.app.d.b.a.b.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class c extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16220c;

    public c(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16220c = orderDetail;
    }

    public String b() {
        int expectedReceiveTime = this.f16220c.getExpectedReceiveTime();
        if (expectedReceiveTime <= 0) {
            expectedReceiveTime = this.f16220c.getReleaseTime();
        }
        if (expectedReceiveTime <= 0) {
            return "";
        }
        if (!ar.f().e().settingConfigStore().hideOrderReceived() || !this.f16220c.isOfficialShop()) {
            return b.a(R.string.sp_wait_buyer_confirm_by_day, com.garena.android.appkit.tools.a.a.c(expectedReceiveTime, "ID"));
        } else if (this.f16220c.logisticsDeliveryDone()) {
            return b.e(R.string.order_delivery_done);
        } else {
            return b.e(R.string.waiting_order_deliver);
        }
    }

    public String j() {
        if (!ar.f().e().settingConfigStore().hideOrderReceived() || !this.f16220c.isOfficialShop() || !this.f16220c.logisticsDeliveryDone()) {
            return a((int) R.string.sp_label_status_shipping);
        }
        return b.e(R.string.delivered);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_buyer), 0, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(c.this.f16220c));
            }
        });
    }
}
