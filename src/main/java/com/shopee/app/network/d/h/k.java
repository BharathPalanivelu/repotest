package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetOrderList;

public class k extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18385a;

    /* renamed from: b  reason: collision with root package name */
    private int f18386b;

    /* renamed from: c  reason: collision with root package name */
    private int f18387c;

    /* renamed from: d  reason: collision with root package name */
    private int f18388d;

    public void a(int i, int i2, int i3) {
        this.f18385a = 6;
        this.f18388d = i;
        this.f18386b = i2;
        this.f18387c = i3;
        g();
    }

    public int b() {
        return this.f18388d;
    }

    public int c() {
        return this.f18386b;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetOrderList.Builder builder = new GetOrderList.Builder();
        builder.requestid(i().a()).type(Integer.valueOf(this.f18385a)).limit(Integer.valueOf(this.f18387c)).offset(Integer.valueOf(this.f18386b)).filter_userid(Integer.valueOf(this.f18388d)).is_seller(true);
        return new f(11, builder.build().toByteArray());
    }
}
