package com.shopee.app.d.b.a.b.e;

import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16247c;

    public boolean s() {
        return false;
    }

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16247c = orderDetail;
    }

    /* access modifiers changed from: protected */
    public int r() {
        return this.f16247c.getShipByDate();
    }
}
