package com.shopee.app.d.b.a.a.d;

import android.content.Context;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private SettingConfigStore f16056c = SettingConfigStore.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public OrderDetail f16057d;

    public c(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16057d = orderDetail;
    }

    public String b() {
        int r = r();
        if (r <= 0) {
            return "";
        }
        if (this.f16057d.logisticsDeliveryDone()) {
            return b.e(R.string.order_delivered);
        }
        return b.a(R.string.sp_receive_product_by_day, com.garena.android.appkit.tools.a.a.c(r, "ID"));
    }

    /* access modifiers changed from: protected */
    public int r() {
        int expectedReceiveTime = this.f16057d.getExpectedReceiveTime();
        return expectedReceiveTime != -1 ? expectedReceiveTime : this.f16057d.getReleaseTime();
    }

    public String j() {
        if (this.f16057d.logisticsDeliveryDone()) {
            return b.e(R.string.delivered);
        }
        return a((int) R.string.sp_label_order_status_to_receive);
    }

    public a.C0251a d() {
        if (this.f16056c.hideOrderReceived() && this.f16057d.isOfficialShop()) {
            return new a.C0251a(a((int) R.string.sp_contact_seller), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(c.this.f16057d));
                }
            });
        }
        if (com.garena.android.appkit.tools.a.a.a() - Math.max(this.f16057d.getDeliveryTime(), this.f16057d.getPayTime()) >= this.f16056c.delayOrderReceivedButtonHour() * 3600 || this.f16057d.isCODPaymentMethod() || this.f16057d.isReturnProcessing()) {
            return new a.C0251a(b(R.string.sp_label_accept_order), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.f15981b.a("ORDER_SHIP_RECEIVED", new com.garena.android.appkit.b.a(c.this.f16057d));
                }
            });
        }
        return new a.C0251a(b(R.string.sp_label_accept_order), 1, new View.OnClickListener() {
            public void onClick(View view) {
                com.shopee.app.ui.dialog.a.a((Context) c.this.a(view), 0, (int) R.string.msg_disable_order_receive_button, (int) R.string.button_ok, 0);
            }
        });
    }
}
