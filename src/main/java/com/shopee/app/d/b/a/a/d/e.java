package com.shopee.app.d.b.a.a.d;

import android.view.View;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class e extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16063c;

    public String m() {
        return "#pending";
    }

    public e(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16063c = orderDetail;
    }

    public long a() {
        return this.f16063c.getOrderId();
    }

    public String b() {
        if (this.f16063c.getReleaseTime() <= 0) {
            return "";
        }
        return b.a(R.string.sp_receive_and_pay_by_day, a.c(this.f16063c.getReleaseTime(), "ID"));
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_to_pay);
    }

    public String k() {
        if (this.f16063c.getReleaseTime() <= 0) {
            return "";
        }
        return b.a(R.string.sp_wait_delivery_by_day, a.c(this.f16063c.getReleaseTime(), "ID"));
    }

    public String l() {
        return b.e(R.string.sp_receive_and_pay_tooltip_text);
    }

    public a.C0251a d() {
        if (!ar.f().e().settingConfigStore().hideOrderReceived() || !this.f16063c.isOfficialShop()) {
            return new a.C0251a(b(R.string.sp_label_accept_order), 1, (View.OnClickListener) null);
        }
        return new a.C0251a(a((int) R.string.sp_contact_seller), 0, new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(e.this.f16063c));
            }
        });
    }
}
