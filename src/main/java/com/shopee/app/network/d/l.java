package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.ClearChatMsg;

public class l extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18430a;

    public void a(int i) {
        this.f18430a = i;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ClearChatMsg.Builder builder = new ClearChatMsg.Builder();
        builder.requestid(i().a()).userid(Integer.valueOf(this.f18430a)).build();
        return new f(210, builder.build().toByteArray());
    }

    public int b() {
        return this.f18430a;
    }
}
