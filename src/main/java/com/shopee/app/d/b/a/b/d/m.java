package com.shopee.app.d.b.a.b.d;

import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class m extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16233c;

    public String m() {
        return "#1201";
    }

    public m(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16233c = orderDetail;
    }

    public long a() {
        return this.f16233c.getOrderId();
    }

    public String l() {
        return a((int) R.string.action_seller_escrow_ext_not_shipped_tooltip_text);
    }
}
