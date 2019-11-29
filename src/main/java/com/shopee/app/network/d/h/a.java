package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ArchiveOrder;

public class a extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18362a;

    /* renamed from: b  reason: collision with root package name */
    private int f18363b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18364c;

    public void a(long j, int i, boolean z) {
        this.f18362a = j;
        this.f18363b = i;
        this.f18364c = z;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ArchiveOrder.Builder builder = new ArchiveOrder.Builder();
        builder.requestid(i().a()).orderid(Long.valueOf(this.f18362a)).archive(Integer.valueOf(this.f18363b)).is_seller(Boolean.valueOf(this.f18364c));
        return new f(134, builder.build().toByteArray());
    }

    public long b() {
        return this.f18362a;
    }
}
