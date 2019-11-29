package com.shopee.app.d.b.a.b.d;

import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class g extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16227c;

    public String m() {
        return "#1301";
    }

    public g(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16227c = orderDetail;
    }

    public long a() {
        return this.f16227c.getOrderId();
    }

    public String l() {
        return b.e(R.string.action_seller_escrow_ext_not_shipped_tooltip_text);
    }
}
