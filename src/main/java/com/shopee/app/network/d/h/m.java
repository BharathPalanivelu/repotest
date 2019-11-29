package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetRefundsByOrders;
import java.util.List;

public class m extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18395a;

    public void a(List<Long> list) {
        this.f18395a = list;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetRefundsByOrders.Builder builder = new GetRefundsByOrders.Builder();
        builder.requestid(i().a()).orderids(this.f18395a);
        return new f(172, builder.build().toByteArray());
    }
}
