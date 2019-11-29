package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetMultiOrders;
import java.util.List;

public class g extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18374a;

    /* renamed from: b  reason: collision with root package name */
    private int f18375b;

    public void a(List<Long> list) {
        this.f18374a = list;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetMultiOrders.Builder builder = new GetMultiOrders.Builder();
        builder.requestid(i().a()).orderid(this.f18374a);
        return new f(58, builder.build().toByteArray());
    }

    public int b() {
        return this.f18375b;
    }

    public void a(int i) {
        this.f18375b = i;
    }
}
