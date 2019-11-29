package com.shopee.app.network.d.g;

import com.beetalklib.network.d.f;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.CancelOffer;
import com.shopee.protocol.action.ChatMsg;

public class b extends az {

    /* renamed from: a  reason: collision with root package name */
    private DBChatMessage f18351a;

    /* renamed from: b  reason: collision with root package name */
    private long f18352b;

    public void a(DBChatMessage dBChatMessage, long j) {
        this.f18351a = dBChatMessage;
        this.f18352b = j;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        ChatMsg.Builder builder = new ChatMsg.Builder();
        builder.requestid(i().a()).msgid(Long.valueOf(this.f18351a.b())).content(e.f.a(this.f18351a.c())).from_userid(Integer.valueOf(this.f18351a.d())).to_userid(Integer.valueOf(this.f18351a.e())).timestamp(Integer.valueOf(this.f18351a.f())).opt(4).type(Integer.valueOf(this.f18351a.g())).seller_userid(Integer.valueOf(this.f18351a.e())).shopid(Integer.valueOf(this.f18351a.h())).itemid(Long.valueOf(this.f18351a.i())).chatid(Long.valueOf(this.f18351a.j()));
        if (this.f18351a.n() > 0) {
            builder.modelid(Long.valueOf(this.f18351a.n()));
        }
        CancelOffer.Builder builder2 = new CancelOffer.Builder();
        builder2.requestid(i().a()).shopid(Integer.valueOf(this.f18351a.h())).itemid(Long.valueOf(this.f18351a.i())).userid(Integer.valueOf(this.f18351a.e())).offerid(Long.valueOf(this.f18352b)).msg(builder.build());
        if (this.f18351a.n() > 0) {
            builder2.modelid(Long.valueOf(this.f18351a.n()));
        }
        return new f(89, builder2.build().toByteArray());
    }
}
