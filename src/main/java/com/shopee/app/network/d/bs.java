package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.SetUserInfo;
import com.shopee.protocol.shop.AccountExtInfo;

public class bs extends az {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18221a;

    public void a(boolean z) {
        this.f18221a = z;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID");
        AccountExtInfo.Builder builder2 = new AccountExtInfo.Builder();
        builder2.holiday_mode_on(Boolean.valueOf(this.f18221a));
        builder.extinfo(e.f.a(builder2.build().toByteArray()));
        return new f(67, builder.build().toByteArray());
    }
}
