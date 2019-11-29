package com.shopee.app.d.b.a.d;

import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16390c;

    public m(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16390c = orderDetail;
    }

    public long a() {
        return this.f16390c.getOrderId();
    }

    public String b() {
        return a((int) R.string.sp_no_rating);
    }

    public String j() {
        return a((int) R.string.sp_tab_seller_completed);
    }

    public String k() {
        return a((int) R.string.sp_order_completed);
    }
}
