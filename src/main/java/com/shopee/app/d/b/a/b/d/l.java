package com.shopee.app.d.b.a.b.d;

import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class l extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16232c;

    public String m() {
        return "#1301";
    }

    public l(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16232c = orderDetail;
    }

    public long a() {
        return this.f16232c.getOrderId();
    }

    public String l() {
        return a((int) R.string.action_seller_escrow_shipped_tooltip_text);
    }
}
