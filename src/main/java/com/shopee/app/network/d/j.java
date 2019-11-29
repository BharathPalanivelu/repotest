package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.util.bd;
import com.shopee.protocol.action.CheckPassword;

public class j extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18427a;

    public void a(String str) {
        this.f18427a = bd.b(bd.a(str).getBytes());
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CheckPassword.Builder builder = new CheckPassword.Builder();
        builder.requestid(i().a()).password(this.f18427a);
        return new f(38, builder.build().toByteArray());
    }
}
