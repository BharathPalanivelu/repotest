package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.UpdateShop;
import com.shopee.protocol.shop.Shop;

public class bu extends az {

    /* renamed from: a  reason: collision with root package name */
    private Shop f18228a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18229b = false;

    public void a(Shop shop) {
        this.f18228a = shop;
        g();
    }

    public void a(Shop shop, boolean z) {
        this.f18228a = shop;
        this.f18229b = z;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        UpdateShop.Builder builder = new UpdateShop.Builder();
        builder.requestid(i().a()).shop(this.f18228a).post_to_feed(Boolean.valueOf(this.f18229b));
        return new f(7, builder.build().toByteArray());
    }
}
