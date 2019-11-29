package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.SetUserInfo;
import com.shopee.protocol.shop.AccountAccessConfig;
import com.shopee.protocol.shop.AccountExtInfo;

public class bo extends az {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18210a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18211b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18212c;

    public void a(boolean z, boolean z2, boolean z3) {
        this.f18210a = z;
        this.f18211b = z2;
        this.f18212c = z3;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID");
        AccountExtInfo.Builder builder2 = new AccountExtInfo.Builder();
        builder2.feed_private(Boolean.valueOf(this.f18210a));
        builder2.hide_from_contact(Boolean.valueOf(this.f18212c));
        AccountAccessConfig.Builder builder3 = new AccountAccessConfig.Builder();
        builder3.hide_likes(Integer.valueOf(this.f18211b ? 1 : 0));
        builder2.access(builder3.build());
        builder.extinfo(e.f.a(builder2.build().toByteArray()));
        return new f(67, builder.build().toByteArray());
    }
}
