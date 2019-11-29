package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.ReportUser;

public class bc extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18169a;

    /* renamed from: b  reason: collision with root package name */
    private String f18170b;

    public void a(int i, String str) {
        this.f18169a = i;
        this.f18170b = str;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ReportUser.Builder builder = new ReportUser.Builder();
        builder.requestid(i().a()).reason(this.f18170b).userid(Integer.valueOf(this.f18169a));
        return new f(26, builder.build().toByteArray());
    }
}
