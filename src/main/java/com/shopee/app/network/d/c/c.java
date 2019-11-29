package com.shopee.app.network.d.c;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetOffer;
import java.util.List;

public class c extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18235a;

    public void a(List<Long> list) {
        this.f18235a = list;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetOffer.Builder builder = new GetOffer.Builder();
        builder.requestid(i().a()).offerid(this.f18235a).build();
        return new f(203, builder.build().toByteArray());
    }
}
