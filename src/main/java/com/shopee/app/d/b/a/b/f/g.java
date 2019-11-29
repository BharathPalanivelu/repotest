package com.shopee.app.d.b.a.b.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class g extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16326c;

    public g(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16326c = orderDetail;
    }

    public long a() {
        return this.f16326c.getOrderId();
    }

    public String b() {
        if (this.f16326c.getPayByDay() <= 0) {
            return "";
        }
        return b.a(R.string.order_list_pay_by_seller, this.f16326c.getPaymentChannelName(), com.garena.android.appkit.tools.a.a.c(this.f16326c.getPayByDay(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_buyer), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(g.this.f16326c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_unpaid);
    }

    public String k() {
        if (this.f16326c.getPayByDay() <= 0) {
            return "";
        }
        return b.a(R.string.sp_action_seller_unpaid_detail_text, this.f16326c.getPaymentChannelName(), com.garena.android.appkit.tools.a.a.c(this.f16326c.getPayByDay(), "ID"));
    }

    public String l() {
        return b.e(R.string.action_buyer_credit_card_unpaid_tooltip_text);
    }
}
