package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.CartBuyAgain;

public class c extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18368a;

    /* renamed from: b  reason: collision with root package name */
    private long f18369b;

    public void a(int i, long j) {
        this.f18368a = i;
        this.f18369b = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CartBuyAgain.Builder builder = new CartBuyAgain.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18368a)).orderid(Long.valueOf(this.f18369b));
        return new f(104, builder.build().toByteArray());
    }

    public long b() {
        return this.f18369b;
    }
}
