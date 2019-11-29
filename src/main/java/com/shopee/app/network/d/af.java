package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.GetItemList;

public class af extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18091a;

    /* renamed from: b  reason: collision with root package name */
    private int f18092b;

    /* renamed from: c  reason: collision with root package name */
    private int f18093c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18094d;

    /* renamed from: e  reason: collision with root package name */
    private int f18095e;

    public int b() {
        return this.f18095e;
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a(i().a(), this.f18095e);
        o.a().a((az) this);
        GetItemList.Builder builder = new GetItemList.Builder();
        builder.requestid(i().a()).country("ID").type(Integer.valueOf(this.f18095e)).shopid(Integer.valueOf(this.f18092b)).limit(Integer.valueOf(this.f18091a)).offset(Integer.valueOf(this.f18093c)).reverse(Boolean.valueOf(this.f18094d));
        return new f(5, builder.build().toByteArray());
    }
}
