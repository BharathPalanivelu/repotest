package com.shopee.app.network.d.b;

import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.MsgAck;

public class b extends az {

    /* renamed from: a  reason: collision with root package name */
    private Long f18146a;

    /* renamed from: b  reason: collision with root package name */
    private Long f18147b;

    public void a(Long l, Long l2) {
        this.f18146a = l;
        this.f18147b = l2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        MsgAck.Builder builder = new MsgAck.Builder();
        builder.requestid(i().a()).chatid(this.f18147b).msgid(this.f18146a);
        return new f(61, builder.build().toByteArray());
    }
}
