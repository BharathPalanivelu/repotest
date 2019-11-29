package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetMinAppversion;

public class ag extends az {
    /* access modifiers changed from: protected */
    public f a() {
        GetMinAppversion.Builder builder = new GetMinAppversion.Builder();
        builder.requestid(i().a()).country("ID").machine_code("android");
        return new f(27, builder.build().toByteArray());
    }
}
