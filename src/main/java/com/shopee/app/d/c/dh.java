package com.shopee.app.d.c;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.g.b;
import com.shopee.app.network.d.g.d;
import com.shopee.app.ui.chat2.a.a;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatOfferInfo;

public class dh extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16803c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16804d;

    /* renamed from: e  reason: collision with root package name */
    private long f16805e;

    /* renamed from: f  reason: collision with root package name */
    private int f16806f;

    /* renamed from: g  reason: collision with root package name */
    private int f16807g;
    private long h;
    private int i;
    private az j;
    private a k;

    /* access modifiers changed from: protected */
    public String d() {
        return "ReplyOfferChatInteractor";
    }

    public dh(n nVar, p pVar, UserInfo userInfo) {
        super(nVar);
        this.f16803c = pVar;
        this.f16804d = userInfo;
    }

    public void a(long j2, long j3, int i2, int i3, int i4, a aVar, az azVar) {
        this.h = j2;
        this.f16805e = j3;
        this.f16806f = i2;
        this.f16807g = i3;
        this.k = aVar;
        this.i = i4;
        this.j = azVar;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        ChatOfferInfo.Builder builder = new ChatOfferInfo.Builder();
        builder.price(Long.valueOf(this.k.j())).currency("IDR").quantity(Integer.valueOf(this.k.l())).offerStatus(Integer.valueOf(this.i)).itemid(Long.valueOf(this.f16805e)).item_name(this.k.b()).imageUrl(this.k.f()).price_before_discount(Long.valueOf(this.k.e())).offerid(Long.valueOf(this.k.a())).original_price(Long.valueOf(this.k.d())).shopid(Integer.valueOf(this.f16806f));
        if (this.k.i() > 0) {
            builder.modelid(Long.valueOf(this.k.i()));
            builder.model_name(this.k.c());
        }
        DBChatMessage dBChatMessage = new DBChatMessage();
        dBChatMessage.d(((Integer) ak.a().d().b(-1)).intValue());
        dBChatMessage.c(this.h);
        dBChatMessage.c(this.f16806f);
        dBChatMessage.e(this.f16807g);
        dBChatMessage.a(builder.build().toByteArray());
        dBChatMessage.b(this.f16805e);
        dBChatMessage.b(3);
        dBChatMessage.a(com.garena.android.appkit.tools.a.a.a());
        dBChatMessage.a(this.j.i().a());
        dBChatMessage.f(1);
        if (this.k.i() > 0) {
            dBChatMessage.e(this.k.i());
        }
        this.f16803c.a(dBChatMessage);
        az azVar = this.j;
        if (azVar instanceof b) {
            ((b) azVar).a(dBChatMessage, this.k.a());
        }
        az azVar2 = this.j;
        if (azVar2 instanceof com.shopee.app.network.d.g.a) {
            ((com.shopee.app.network.d.g.a) azVar2).a(dBChatMessage, this.k.a(), this.k.j(), this.k.l());
        }
        az azVar3 = this.j;
        if (azVar3 instanceof d) {
            ((d) azVar3).a(dBChatMessage, this.k.a(), this.k.j(), this.k.l());
        }
        this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16804d.isMyShop(this.f16806f))));
    }
}
