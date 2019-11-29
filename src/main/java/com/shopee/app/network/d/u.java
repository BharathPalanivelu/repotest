package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.GetChatItems;

public class u extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18451a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18452b;

    public void a(int i, boolean z) {
        this.f18451a = i;
        this.f18452b = z;
        o.a().a((az) this);
        g();
    }

    public boolean b() {
        return this.f18452b;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetChatItems.Builder builder = new GetChatItems.Builder();
        builder.requestid(i().a()).userid(Integer.valueOf(this.f18451a)).id_only(Boolean.valueOf(this.f18452b)).limit(20).no_banned(true).offset(0).build();
        return new f(212, builder.build().toByteArray());
    }

    public int c() {
        return this.f18451a;
    }
}
