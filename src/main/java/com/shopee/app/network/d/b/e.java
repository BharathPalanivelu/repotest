package com.shopee.app.network.d.b;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.GetChatMsgid;

public class e extends az {

    /* renamed from: a  reason: collision with root package name */
    private long f18149a;

    /* renamed from: b  reason: collision with root package name */
    private int f18150b;

    /* renamed from: c  reason: collision with root package name */
    private int f18151c;

    public void a(int i, long j, int i2) {
        this.f18151c = i;
        this.f18149a = j;
        this.f18150b = i2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetChatMsgid.Builder builder = new GetChatMsgid.Builder();
        builder.requestid(i().a()).userid(Integer.valueOf(this.f18151c)).chatid(0L).cursor(Long.valueOf(this.f18149a)).limit(Integer.valueOf(this.f18150b));
        return new f(72, builder.build().toByteArray());
    }
}
