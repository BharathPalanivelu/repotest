package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.DelItemComment;

public class m extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18431a;

    /* renamed from: b  reason: collision with root package name */
    private long f18432b;

    /* renamed from: c  reason: collision with root package name */
    private long f18433c;

    public void a(int i, long j, long j2) {
        this.f18431a = i;
        this.f18432b = j;
        this.f18433c = j2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        DelItemComment.Builder builder = new DelItemComment.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18431a)).itemid(Long.valueOf(this.f18432b)).cmtid(Long.valueOf(this.f18433c));
        return new f(99, builder.build().toByteArray());
    }
}
