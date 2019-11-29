package com.shopee.app.network.d;

import com.shopee.protocol.action.CancelReturn;

public class f extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18263a;

    /* renamed from: b  reason: collision with root package name */
    private long f18264b;

    /* access modifiers changed from: protected */
    public com.beetalklib.network.d.f a() {
        CancelReturn.Builder builder = new CancelReturn.Builder();
        builder.requestid(i().a()).return_id(Long.valueOf(this.f18264b)).shopid(Integer.valueOf(this.f18263a));
        return new com.beetalklib.network.d.f(107, builder.build().toByteArray());
    }

    public long b() {
        return this.f18264b;
    }
}
