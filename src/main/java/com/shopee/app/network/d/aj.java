package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.GetOfferList;

public class aj extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18100a;

    /* renamed from: b  reason: collision with root package name */
    private int f18101b;

    /* renamed from: c  reason: collision with root package name */
    private int f18102c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18103d;

    public void a(int i, int i2, int i3, boolean z) {
        this.f18100a = i;
        this.f18101b = i2;
        this.f18102c = i3;
        this.f18103d = z;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a((az) this);
        GetOfferList.Builder builder = new GetOfferList.Builder();
        builder.requestid(i().a()).userid(Integer.valueOf(this.f18100a)).offset(Integer.valueOf(this.f18101b)).limit(Integer.valueOf(this.f18102c)).is_seller(Boolean.valueOf(this.f18103d)).build();
        return new f(209, builder.build().toByteArray());
    }

    public int b() {
        return this.f18100a;
    }

    public boolean c() {
        return this.f18103d;
    }
}
