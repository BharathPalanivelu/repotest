package com.shopee.app.ui.order.a;

import com.garena.android.appkit.b.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderKey;
import java.util.List;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private OrderKey f23459a;

    public b(OrderKey orderKey, List<OrderDetail> list) {
        this.f23459a = orderKey;
        this.data = list;
    }

    public OrderKey a() {
        return this.f23459a;
    }

    public List<OrderDetail> b() {
        return (List) this.data;
    }
}
