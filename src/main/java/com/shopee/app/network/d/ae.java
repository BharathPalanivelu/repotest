package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.GetItemList;

public class ae extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18085a;

    /* renamed from: b  reason: collision with root package name */
    private int f18086b;

    /* renamed from: c  reason: collision with root package name */
    private int f18087c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18088d;

    /* renamed from: e  reason: collision with root package name */
    private int f18089e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18090f;

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.f18086b = i2;
        this.f18087c = i3;
        this.f18085a = i4;
        this.f18088d = z;
        this.f18089e = i;
        this.f18090f = z2;
        g();
    }

    public int b() {
        return this.f18089e;
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a((az) this);
        GetItemList.Builder builder = new GetItemList.Builder();
        builder.requestid(i().a()).country("ID").type(Integer.valueOf(this.f18089e)).shopid(Integer.valueOf(this.f18086b)).limit(Integer.valueOf(this.f18085a)).no_banned(Boolean.valueOf(this.f18090f)).offset(Integer.valueOf(this.f18087c)).reverse(Boolean.valueOf(this.f18088d));
        return new f(5, builder.build().toByteArray());
    }

    public int c() {
        return this.f18087c;
    }
}
