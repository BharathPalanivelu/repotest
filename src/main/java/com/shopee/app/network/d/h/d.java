package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ConfirmDelivery;

public class d extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18370a;

    /* renamed from: b  reason: collision with root package name */
    private long f18371b;

    public void a(int i, long j) {
        this.f18370a = i;
        this.f18371b = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ConfirmDelivery.Builder builder = new ConfirmDelivery.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18370a)).orderid(Long.valueOf(this.f18371b));
        return new f(48, builder.build().toByteArray());
    }
}
