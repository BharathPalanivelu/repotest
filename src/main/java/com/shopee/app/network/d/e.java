package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.CancelCheckout;

public class e extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18257a;

    public long b() {
        return this.f18257a;
    }

    public void a(long j) {
        this.f18257a = j;
        h();
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CancelCheckout.Builder builder = new CancelCheckout.Builder();
        builder.requestid(i().a()).checkoutid(Long.valueOf(this.f18257a));
        return new f(124, builder.build().toByteArray());
    }
}
