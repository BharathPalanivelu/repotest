package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.SetUserInfo;

public class bm extends az {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18208a;

    public void a(boolean z) {
        this.f18208a = z;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID").phone_public(Boolean.valueOf(this.f18208a));
        return new f(67, builder.build().toByteArray());
    }
}
