package com.shopee.app.network.d.g;

import com.beetalklib.network.d.f;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ChatMsg;
import com.shopee.protocol.action.MakeOffer;

public class c extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18353a;

    /* renamed from: b  reason: collision with root package name */
    private long f18354b;

    /* renamed from: c  reason: collision with root package name */
    private DBChatMessage f18355c;

    /* renamed from: d  reason: collision with root package name */
    private long f18356d;

    public void a(DBChatMessage dBChatMessage, int i, long j, long j2) {
        this.f18355c = dBChatMessage;
        this.f18353a = i;
        this.f18354b = j;
        this.f18356d = j2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        o.a().a((az) this);
        ChatMsg.Builder builder = new ChatMsg.Builder();
        builder.requestid(i().a()).msgid(Long.valueOf(this.f18355c.b())).content(e.f.a(this.f18355c.c())).from_userid(Integer.valueOf(this.f18355c.d())).to_userid(Integer.valueOf(this.f18355c.e())).timestamp(Integer.valueOf(this.f18355c.f())).opt(4).type(Integer.valueOf(this.f18355c.g())).seller_userid(Integer.valueOf(this.f18355c.e())).shopid(Integer.valueOf(this.f18355c.h())).itemid(Long.valueOf(this.f18355c.i())).chatid(Long.valueOf(this.f18355c.j()));
        if (this.f18355c.n() > 0) {
            builder.modelid(Long.valueOf(this.f18355c.n()));
        }
        MakeOffer.Builder builder2 = new MakeOffer.Builder();
        builder2.requestid(i().a()).shopid(Integer.valueOf(this.f18355c.h())).itemid(Long.valueOf(this.f18355c.i())).to_userid(Integer.valueOf(this.f18355c.e())).msg(builder.build()).buy_count(Integer.valueOf(this.f18353a)).offerid(Long.valueOf(this.f18356d)).modelid(Long.valueOf(this.f18355c.n())).offer_price(Long.valueOf(this.f18354b));
        if (this.f18355c.n() > 0) {
            builder2.modelid(Long.valueOf(this.f18355c.n()));
        }
        return new f(75, builder2.build().toByteArray());
    }

    public long b() {
        return this.f18354b;
    }

    public int c() {
        return this.f18353a;
    }

    public long d() {
        return this.f18355c.i();
    }

    public int e() {
        return this.f18355c.h();
    }
}
