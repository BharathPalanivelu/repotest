package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetUnpaidOrders;

public class p extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18404a;

    public void a(long j) {
        this.f18404a = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetUnpaidOrders.Builder builder = new GetUnpaidOrders.Builder();
        builder.requestid(i().a()).limit(20).type(9).cursor(Long.valueOf(this.f18404a));
        return new f(140, builder.build().toByteArray());
    }
}
