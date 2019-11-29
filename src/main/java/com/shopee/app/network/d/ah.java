package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetCustomList;

public class ah extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18096a;

    /* renamed from: b  reason: collision with root package name */
    private int f18097b;

    public void a(int i, int i2) {
        this.f18096a = i;
        this.f18097b = i2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetCustomList.Builder builder = new GetCustomList.Builder();
        builder.requestid(i().a()).offset(Integer.valueOf(this.f18096a)).limit(Integer.valueOf(this.f18097b));
        return new f(30, builder.build().toByteArray());
    }

    public int b() {
        return this.f18096a;
    }
}
