package com.shopee.app.d.b.a.b.d;

import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class j extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16230c;

    public String m() {
        return "#1301";
    }

    public j(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16230c = orderDetail;
    }

    public long a() {
        return this.f16230c.getOrderId();
    }

    public String l() {
        return b.e(R.string.action_seller_escrow_ext_not_shipped_tooltip_text);
    }
}
