package com.shopee.app.network.d.b;

import com.beetalklib.network.d.f;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ChatMsg;

public class g extends az {

    /* renamed from: a  reason: collision with root package name */
    private DBChatMessage f18153a;

    /* renamed from: b  reason: collision with root package name */
    private int f18154b;

    public g() {
    }

    public g(com.shopee.app.network.g gVar) {
        super(gVar);
    }

    public void a(DBChatMessage dBChatMessage, int i) {
        this.f18154b = i;
        this.f18153a = dBChatMessage;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ChatMsg.Builder builder = new ChatMsg.Builder();
        builder.requestid(i().a()).msgid(Long.valueOf(this.f18153a.b())).content(e.f.a(this.f18153a.c())).from_userid(Integer.valueOf(this.f18153a.d())).to_userid(Integer.valueOf(this.f18153a.e())).timestamp(Integer.valueOf(this.f18153a.f())).opt(4).type(Integer.valueOf(this.f18153a.g())).seller_userid(Integer.valueOf(this.f18154b)).shopid(Integer.valueOf(this.f18153a.h())).itemid(Long.valueOf(this.f18153a.i())).orderid(Long.valueOf(this.f18153a.m())).chatid(Long.valueOf(this.f18153a.j()));
        if (this.f18153a.n() > 0) {
            builder.modelid(Long.valueOf(this.f18153a.n()));
        }
        return new f(59, builder.build().toByteArray());
    }
}
