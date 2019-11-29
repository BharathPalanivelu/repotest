package com.shopee.app.network.d.g;

import com.beetalklib.network.d.f;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ChatMsg;
import com.shopee.protocol.action.OfferReply;

public class d extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18357a;

    /* renamed from: b  reason: collision with root package name */
    private long f18358b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18359c = false;

    /* renamed from: d  reason: collision with root package name */
    private DBChatMessage f18360d;

    /* renamed from: e  reason: collision with root package name */
    private long f18361e;

    public void a(DBChatMessage dBChatMessage, long j, long j2, int i) {
        this.f18360d = dBChatMessage;
        this.f18361e = j;
        this.f18358b = j2;
        this.f18357a = i;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ChatMsg.Builder builder = new ChatMsg.Builder();
        builder.requestid(i().a()).msgid(Long.valueOf(this.f18360d.b())).content(e.f.a(this.f18360d.c())).from_userid(Integer.valueOf(this.f18360d.d())).to_userid(Integer.valueOf(this.f18360d.e())).timestamp(Integer.valueOf(this.f18360d.f())).opt(4).type(Integer.valueOf(this.f18360d.g())).seller_userid(Integer.valueOf(this.f18360d.e())).shopid(Integer.valueOf(this.f18360d.h())).itemid(Long.valueOf(this.f18360d.i())).chatid(Long.valueOf(this.f18360d.j()));
        if (this.f18360d.n() > 0) {
            builder.modelid(Long.valueOf(this.f18360d.n()));
        }
        OfferReply.Builder builder2 = new OfferReply.Builder();
        builder2.requestid(i().a()).shopid(Integer.valueOf(this.f18360d.h())).accept(false).to_userid(Integer.valueOf(this.f18360d.e())).buy_count(Integer.valueOf(this.f18357a)).itemid(Long.valueOf(this.f18360d.i())).msg(builder.build()).offerid(Long.valueOf(this.f18361e)).offer_price(Long.valueOf(this.f18358b));
        if (this.f18360d.n() > 0) {
            builder2.modelid(Long.valueOf(this.f18360d.n()));
        }
        return new f(76, builder2.build().toByteArray());
    }
}
