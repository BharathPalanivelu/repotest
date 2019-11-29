package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.EditItem;
import com.shopee.protocol.shop.Item;

public class bj extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18193a;

    /* renamed from: b  reason: collision with root package name */
    private long f18194b;

    public void a(int i, long j) {
        this.f18193a = i;
        this.f18194b = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        EditItem.Builder builder = new EditItem.Builder();
        builder.requestid(i().a()).item(new Item.Builder().status(5).shopid(Integer.valueOf(this.f18193a)).itemid(Long.valueOf(this.f18194b)).build());
        return new f(2, builder.build().toByteArray());
    }
}
