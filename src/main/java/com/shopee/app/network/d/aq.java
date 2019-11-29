package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetSnapshot;

public class aq extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18119a;

    /* renamed from: b  reason: collision with root package name */
    private long f18120b;

    public void a(int i, long j) {
        this.f18119a = i;
        this.f18120b = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetSnapshot.Builder builder = new GetSnapshot.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(this.f18119a)).snapshotid(Long.valueOf(this.f18120b));
        return new f(25, builder.build().toByteArray());
    }
}
