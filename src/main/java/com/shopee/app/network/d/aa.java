package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetCustomOrders;

public class aa extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18075a;

    /* renamed from: b  reason: collision with root package name */
    private int f18076b;

    /* renamed from: c  reason: collision with root package name */
    private int f18077c;

    public void a(int i, int i2, int i3) {
        this.f18075a = i;
        this.f18076b = i2;
        this.f18077c = i3;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetCustomOrders.Builder builder = new GetCustomOrders.Builder();
        builder.requestid(i().a()).offset(Integer.valueOf(this.f18076b)).limit(Integer.valueOf(this.f18077c)).userid(Integer.valueOf(this.f18075a));
        return new f(32, builder.build().toByteArray());
    }

    public int b() {
        return this.f18075a;
    }

    public int c() {
        return this.f18076b;
    }
}
