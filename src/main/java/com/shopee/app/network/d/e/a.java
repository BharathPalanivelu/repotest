package com.shopee.app.network.d.e;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetShopBalance;

public class a extends az {
    /* access modifiers changed from: protected */
    public f a() {
        GetShopBalance.Builder builder = new GetShopBalance.Builder();
        builder.requestid(i().a());
        return new f(50, builder.build().toByteArray());
    }
}
