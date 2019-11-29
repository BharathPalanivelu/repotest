package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetCheckout;
import java.util.ArrayList;
import java.util.List;

public class as extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18124a = new ArrayList();

    public void a(long j) {
        this.f18124a.add(Long.valueOf(j));
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetCheckout.Builder builder = new GetCheckout.Builder();
        builder.requestid(i().a()).checkoutid(this.f18124a);
        return new f(141, builder.build().toByteArray());
    }

    public List<Long> b() {
        return this.f18124a;
    }
}
