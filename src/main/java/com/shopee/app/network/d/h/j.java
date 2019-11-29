package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetOrderList;

public class j extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18381a;

    /* renamed from: b  reason: collision with root package name */
    private int f18382b;

    /* renamed from: c  reason: collision with root package name */
    private int f18383c;

    /* renamed from: d  reason: collision with root package name */
    private int f18384d;

    public void a(int i, int i2, int i3) {
        this.f18381a = 6;
        this.f18384d = i;
        this.f18382b = i2;
        this.f18383c = i3;
        g();
    }

    public int b() {
        return this.f18382b;
    }

    public int c() {
        return this.f18384d;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetOrderList.Builder builder = new GetOrderList.Builder();
        builder.requestid(i().a()).type(Integer.valueOf(this.f18381a)).limit(Integer.valueOf(this.f18383c)).offset(Integer.valueOf(this.f18382b)).filter_shopid(Integer.valueOf(this.f18384d)).is_seller(false);
        return new f(11, builder.build().toByteArray());
    }
}
