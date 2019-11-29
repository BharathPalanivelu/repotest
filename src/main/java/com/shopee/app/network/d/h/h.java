package com.shopee.app.network.d.h;

import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetOrderList;
import com.squareup.wire.Message;

public class h extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18376a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18377b;

    public int b() {
        return 11;
    }

    public void a(boolean z) {
        this.f18376a = z;
        this.f18377b = false;
        g();
        h();
    }

    public void a(boolean z, boolean z2) {
        this.f18376a = z;
        this.f18377b = z2;
        g();
        h();
    }

    public boolean c() {
        return this.f18376a;
    }

    public boolean d() {
        return this.f18377b;
    }

    public Message q_() {
        GetOrderList.Builder builder = new GetOrderList.Builder();
        builder.requestid(i().a()).get_order_count(true).is_group_buy(Boolean.valueOf(this.f18377b)).is_seller(Boolean.valueOf(this.f18376a));
        return builder.build();
    }
}
