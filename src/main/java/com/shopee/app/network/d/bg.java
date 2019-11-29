package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.protocol.action.SetChatLastRead;

public class bg extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18182a;

    /* renamed from: b  reason: collision with root package name */
    private long f18183b;

    public void a(int i, long j) {
        this.f18182a = i;
        this.f18183b = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a((az) this);
        SetChatLastRead.Builder builder = new SetChatLastRead.Builder();
        builder.requestid(i().a()).userid(Integer.valueOf(this.f18182a)).msgid(Long.valueOf(this.f18183b)).build();
        return new f(35, builder.build().toByteArray());
    }

    public int b() {
        return this.f18182a;
    }

    public long c() {
        return this.f18183b;
    }
}
