package com.shopee.app.network.d.h;

import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetOrderDetail;
import com.squareup.wire.Message;

public class i extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private long f18378a;

    /* renamed from: b  reason: collision with root package name */
    private int f18379b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18380c = false;

    public int b() {
        return 10;
    }

    public void a(long j, int i) {
        this.f18378a = j;
        this.f18379b = i;
        g();
    }

    public void h() {
        super.h();
        this.f18380c = false;
    }

    public void a(boolean z) {
        super.h();
        this.f18380c = z;
    }

    public boolean c() {
        return this.f18380c;
    }

    public Message q_() {
        GetOrderDetail.Builder builder = new GetOrderDetail.Builder();
        builder.requestid(i().a()).orderid(Long.valueOf(this.f18378a));
        int i = this.f18379b;
        if (i != -1) {
            builder.shopid(Integer.valueOf(i));
        }
        return builder.build();
    }
}
