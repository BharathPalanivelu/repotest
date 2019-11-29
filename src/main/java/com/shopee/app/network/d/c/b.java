package com.shopee.app.network.d.c;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetBlockUserList;

public class b extends az {
    /* access modifiers changed from: protected */
    public f a() {
        GetBlockUserList.Builder builder = new GetBlockUserList.Builder();
        builder.requestid(i().a()).build();
        return new f(207, builder.build().toByteArray());
    }
}
