package com.shopee.app.d.b.a.d;

import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16342c;

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16342c = orderDetail;
    }

    public long a() {
        return this.f16342c.getOrderId();
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
