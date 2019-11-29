package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.GetRecentItems;

public class al extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18107a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18108b;

    /* renamed from: c  reason: collision with root package name */
    private int f18109c;

    public void a(int i, int i2) {
        this.f18107a = i;
        this.f18108b = true;
        this.f18109c = i2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a((az) this);
        GetRecentItems.Builder builder = new GetRecentItems.Builder();
        builder.requestid(i().a()).id_only(Boolean.valueOf(this.f18108b)).type(Integer.valueOf(this.f18109c)).no_banned(true).shopid(Integer.valueOf(this.f18107a)).build();
        return new f(205, builder.build().toByteArray());
    }

    public int b() {
        return this.f18107a;
    }

    public int c() {
        return this.f18109c;
    }

    public boolean d() {
        return this.f18108b;
    }
}
