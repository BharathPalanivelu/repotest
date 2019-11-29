package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.DelItem;

public class n extends az {

    /* renamed from: a  reason: collision with root package name */
    private final long f18434a;

    public n(long j) {
        this.f18434a = j;
    }

    /* access modifiers changed from: protected */
    public f a() {
        DelItem.Builder builder = new DelItem.Builder();
        builder.requestid(i().a()).itemid(Long.valueOf(this.f18434a));
        return new f(3, builder.build().toByteArray());
    }
}
