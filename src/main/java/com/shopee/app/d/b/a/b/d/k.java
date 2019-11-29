package com.shopee.app.d.b.a.b.d;

import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class k extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16231c;

    public String m() {
        return "#1201";
    }

    public k(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16231c = orderDetail;
    }

    public long a() {
        return this.f16231c.getOrderId();
    }

    public String l() {
        return b.e(R.string.action_seller_escrow_ext_not_shipped_tooltip_text);
    }
}
