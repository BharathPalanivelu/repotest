package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ShipOrder;

public class s extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18409a;

    /* renamed from: b  reason: collision with root package name */
    private String f18410b;

    /* renamed from: c  reason: collision with root package name */
    private String f18411c;

    /* renamed from: d  reason: collision with root package name */
    private String f18412d;

    public void a(long j, String str, String str2, String str3) {
        this.f18409a = j;
        this.f18410b = str;
        this.f18411c = str2;
        this.f18412d = str3;
        h();
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ShipOrder.Builder builder = new ShipOrder.Builder();
        builder.requestid(i().a()).orderid(Long.valueOf(this.f18409a)).remark(this.f18412d).shipping_carrier(this.f18410b).shipping_traceno(this.f18411c);
        return new f(122, builder.build().toByteArray());
    }
}
