package com.shopee.app.d.b.a.b.b;

import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16204c;

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16204c = orderDetail;
    }

    public long a() {
        return this.f16204c.getOrderId();
    }

    public String j() {
        return a((int) R.string.sp_rated);
    }

    public String k() {
        return a((int) R.string.sp_buyer_rated);
    }
}
