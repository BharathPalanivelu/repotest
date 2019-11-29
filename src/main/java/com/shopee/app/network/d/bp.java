package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.SetUserInfo;
import com.shopee.protocol.shop.AccountExtInfo;

public class bp extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18213a;

    /* renamed from: b  reason: collision with root package name */
    private int f18214b;

    public void a(int i, int i2) {
        this.f18213a = i;
        this.f18214b = i2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID");
        AccountExtInfo.Builder builder2 = new AccountExtInfo.Builder();
        builder2.gender(Integer.valueOf(this.f18213a));
        builder2.birth_timestamp(Integer.valueOf(this.f18214b));
        builder.extinfo(e.f.a(builder2.build().toByteArray()));
        return new f(67, builder.build().toByteArray());
    }
}
