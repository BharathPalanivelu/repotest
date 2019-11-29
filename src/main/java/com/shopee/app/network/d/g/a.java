package com.shopee.app.network.d.g;

import com.beetalklib.network.d.f;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ChatMsg;
import com.shopee.protocol.action.OfferReply;

public class a extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18346a;

    /* renamed from: b  reason: collision with root package name */
    private long f18347b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18348c = true;

    /* renamed from: d  reason: collision with root package name */
    private DBChatMessage f18349d;

    /* renamed from: e  reason: collision with root package name */
    private long f18350e;

    public void a(DBChatMessage dBChatMessage, long j, long j2, int i) {
        this.f18349d = dBChatMessage;
        this.f18350e = j;
        this.f18347b = j2;
        this.f18346a = i;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ChatMsg.Builder builder = new ChatMsg.Builder();
        builder.requestid(i().a()).msgid(Long.valueOf(this.f18349d.b())).content(e.f.a(this.f18349d.c())).from_userid(Integer.valueOf(this.f18349d.d())).to_userid(Integer.valueOf(this.f18349d.e())).timestamp(Integer.valueOf(this.f18349d.f())).opt(4).type(Integer.valueOf(this.f18349d.g())).seller_userid(Integer.valueOf(this.f18349d.e())).shopid(Integer.valueOf(this.f18349d.h())).itemid(Long.valueOf(this.f18349d.i())).chatid(Long.valueOf(this.f18349d.j()));
        if (this.f18349d.n() > 0) {
            builder.modelid(Long.valueOf(this.f18349d.n()));
        }
        OfferReply.Builder builder2 = new OfferReply.Builder();
        builder2.requestid(i().a()).shopid(Integer.valueOf(this.f18349d.h())).accept(true).to_userid(Integer.valueOf(this.f18349d.e())).buy_count(Integer.valueOf(this.f18346a)).itemid(Long.valueOf(this.f18349d.i())).msg(builder.build()).offerid(Long.valueOf(this.f18350e)).offer_price(Long.valueOf(this.f18347b));
        if (this.f18349d.n() > 0) {
            builder2.modelid(Long.valueOf(this.f18349d.n()));
        }
        return new f(76, builder2.build().toByteArray());
    }
}
