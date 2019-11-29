package com.shopee.app.network.d.b;

import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetChatMsg;
import java.util.List;

public class f extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Long> f18152a;

    public void a(List<Long> list) {
        this.f18152a = list;
        g();
    }

    /* access modifiers changed from: protected */
    public com.beetalklib.network.d.f a() {
        GetChatMsg.Builder builder = new GetChatMsg.Builder();
        builder.requestid(i().a()).msgid(this.f18152a);
        return new com.beetalklib.network.d.f(73, builder.build().toByteArray());
    }
}
