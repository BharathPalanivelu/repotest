package com.shopee.app.d.b.a.b.b;

import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16205c;

    public c(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16205c = orderDetail;
    }

    public long a() {
        return this.f16205c.getOrderId();
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_completed);
    }

    public String k() {
        return a((int) R.string.sp_contact_seller_4_rate);
    }
}
