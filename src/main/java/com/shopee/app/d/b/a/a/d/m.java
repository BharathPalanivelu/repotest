package com.shopee.app.d.b.a.a.d;

import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class m extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16079c;

    public String m() {
        return "#1201";
    }

    public m(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16079c = orderDetail;
    }

    public String k() {
        return a((int) R.string.action_buyer_escrow_ext_shipped_detail_text);
    }

    public String l() {
        return a((int) R.string.action_buyer_escrow_not_shipped_tooltip_text);
    }
}
