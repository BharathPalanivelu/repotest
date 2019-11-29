package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.GetItemList;

public class ak extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18104a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18105b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f18106c = 7;

    public void a(int i) {
        this.f18104a = i;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a((az) this);
        GetItemList.Builder builder = new GetItemList.Builder();
        builder.requestid(i().a()).country("ID").type(Integer.valueOf(this.f18106c)).shopid(Integer.valueOf(this.f18104a)).limit(-1).no_banned(true).offset(0).id_only(true).reverse(Boolean.valueOf(this.f18105b));
        return new f(5, builder.build().toByteArray());
    }

    public int b() {
        return this.f18104a;
    }
}
