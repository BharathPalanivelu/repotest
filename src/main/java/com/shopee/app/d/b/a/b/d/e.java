package com.shopee.app.d.b.a.b.d;

import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class e extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16225c;

    public String m() {
        return "#pending";
    }

    public e(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16225c = orderDetail;
    }

    public long a() {
        return this.f16225c.getOrderId();
    }

    public String l() {
        return b.e(R.string.sp_tooltip_order_will_cancel);
    }
}
