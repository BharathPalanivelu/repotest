package com.shopee.app.network.d;

import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetShop;
import com.squareup.wire.Message;

public class ao extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f18117a;

    public int b() {
        return 8;
    }

    public void a(int i) {
        this.f18117a = i;
        g();
    }

    public Message q_() {
        GetShop.Builder builder = new GetShop.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18117a));
        return builder.build();
    }
}
