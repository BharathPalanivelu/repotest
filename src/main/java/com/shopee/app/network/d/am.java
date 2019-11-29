package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetRecUserList;

public class am extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18110a = 20;

    /* access modifiers changed from: protected */
    public f a() {
        GetRecUserList.Builder builder = new GetRecUserList.Builder();
        builder.requestid(i().a()).country("ID").limit(Integer.valueOf(this.f18110a));
        return new f(179, builder.build().toByteArray());
    }
}
