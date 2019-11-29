package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.CancelOrder;

public class b extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18365a;

    /* renamed from: b  reason: collision with root package name */
    private int f18366b;

    /* renamed from: c  reason: collision with root package name */
    private int f18367c;

    public void a(long j, int i, int i2) {
        this.f18365a = j;
        this.f18366b = i;
        this.f18367c = i2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CancelOrder.Builder builder = new CancelOrder.Builder();
        builder.requestid(i().a()).orderid(Long.valueOf(this.f18365a)).shopid(Integer.valueOf(this.f18366b)).cancel_reason(Integer.valueOf(this.f18367c));
        return new f(19, builder.build().toByteArray());
    }
}
