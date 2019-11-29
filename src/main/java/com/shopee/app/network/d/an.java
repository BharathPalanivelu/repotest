package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetSearchShopCustomer;
import java.util.List;

public class an extends az {

    /* renamed from: a  reason: collision with root package name */
    public final List<Integer> f18111a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18112b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18113c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18114d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18115e;

    /* renamed from: f  reason: collision with root package name */
    public final int f18116f;

    public an(List<Integer> list, int i, String str, int i2, int i3, int i4) {
        this.f18111a = list;
        this.f18112b = i;
        this.f18113c = str;
        this.f18114d = i2;
        this.f18115e = i3;
        this.f18116f = i4;
        h();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetSearchShopCustomer.Builder builder = new GetSearchShopCustomer.Builder();
        builder.requestid(i().a()).customer_type(this.f18111a).shopid(Integer.valueOf(this.f18112b)).filter(this.f18113c).limit(Integer.valueOf(this.f18114d)).offset(Integer.valueOf(this.f18115e)).build();
        return new f(31, builder.build().toByteArray());
    }
}
