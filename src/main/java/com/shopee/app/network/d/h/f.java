package com.shopee.app.network.d.h;

import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetCheckout;
import java.util.List;

public class f extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18373a;

    public void a(List<Long> list) {
        this.f18373a = list;
        g();
    }

    /* access modifiers changed from: protected */
    public com.beetalklib.network.d.f a() {
        o.a().a((az) this);
        GetCheckout.Builder builder = new GetCheckout.Builder();
        builder.requestid(i().a()).checkoutid(this.f18373a).build();
        return new com.beetalklib.network.d.f(121, builder.build().toByteArray());
    }
}
