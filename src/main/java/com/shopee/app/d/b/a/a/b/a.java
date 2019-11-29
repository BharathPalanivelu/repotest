package com.shopee.app.d.b.a.a.b;

import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16024c;

    public a(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16024c = orderDetail;
    }

    public long a() {
        return this.f16024c.getOrderId();
    }

    public String j() {
        return a((int) R.string.sp_rated);
    }

    public String k() {
        return a((int) R.string.sp_thanks_4_rating);
    }
}
