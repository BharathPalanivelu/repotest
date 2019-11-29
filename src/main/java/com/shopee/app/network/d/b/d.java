package com.shopee.app.network.d.b;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetChatList;

public class d extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18148a;

    public d(int i) {
        this.f18148a = i;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetChatList.Builder builder = new GetChatList.Builder();
        builder.requestid(i().a()).last_timestamp(Integer.valueOf(this.f18148a));
        return new f(71, builder.build().toByteArray());
    }
}
