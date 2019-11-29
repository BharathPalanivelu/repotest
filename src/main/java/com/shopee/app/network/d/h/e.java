package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ExtendOrder;

public class e extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18372a;

    public void a(long j) {
        this.f18372a = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ExtendOrder.Builder builder = new ExtendOrder.Builder();
        builder.requestid(i().a()).orderid(Long.valueOf(this.f18372a));
        return new f(123, builder.build().toByteArray());
    }
}
