package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.FollowShop;

public class q extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18444a;

    public void a(int i) {
        this.f18444a = i;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        FollowShop.Builder builder = new FollowShop.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18444a));
        return new f(40, builder.build().toByteArray());
    }
}
