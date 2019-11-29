package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.ArchiveReturn;

public class c extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18230a;

    /* renamed from: b  reason: collision with root package name */
    private int f18231b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18232c;

    /* access modifiers changed from: protected */
    public f a() {
        ArchiveReturn.Builder builder = new ArchiveReturn.Builder();
        builder.requestid(i().a()).return_id(Long.valueOf(this.f18230a)).is_seller(Boolean.valueOf(this.f18232c)).archive(Integer.valueOf(this.f18231b));
        return new f(135, builder.build().toByteArray());
    }

    public long b() {
        return this.f18230a;
    }
}
