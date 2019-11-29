package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.CartGetAllOrders;

public class h extends az {
    /* access modifiers changed from: protected */
    public f a() {
        CartGetAllOrders.Builder builder = new CartGetAllOrders.Builder();
        builder.requestid(i().a());
        return new f(86, builder.build().toByteArray());
    }
}
