package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.PayOrder;

public class r extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18407a;

    /* renamed from: b  reason: collision with root package name */
    private long f18408b;

    public void a(int i, long j, long j2) {
        this.f18407a = j;
        this.f18408b = j2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        PayOrder.Builder builder = new PayOrder.Builder();
        builder.requestid(i().a()).orderid(Long.valueOf(this.f18407a)).paid_amount(Long.valueOf(this.f18408b));
        return new f(17, builder.build().toByteArray());
    }
}
