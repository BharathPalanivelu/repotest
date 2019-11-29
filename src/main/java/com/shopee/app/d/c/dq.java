package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.h.m;
import com.shopee.app.network.d.b.g;
import com.shopee.app.util.au;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatProductInfo;

public class dq extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16834c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16835d;

    /* renamed from: e  reason: collision with root package name */
    private final av f16836e;

    /* renamed from: f  reason: collision with root package name */
    private int f16837f;

    /* renamed from: g  reason: collision with root package name */
    private long f16838g;
    private long h;
    private OrderItemInfo i;

    /* access modifiers changed from: protected */
    public String d() {
        return "SendOrderItemChatInteractor";
    }

    protected dq(n nVar, p pVar, av avVar, UserInfo userInfo) {
        super(nVar);
        this.f16834c = pVar;
        this.f16836e = avVar;
        this.f16835d = userInfo;
    }

    public void a(long j, long j2, int i2, OrderItemInfo orderItemInfo) {
        this.f16838g = j;
        this.h = j2;
        this.i = orderItemInfo;
        this.f16837f = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        g gVar = new g();
        DBChatMessage dBChatMessage = new DBChatMessage();
        int userId = this.f16835d.getUserId();
        dBChatMessage.d(userId);
        dBChatMessage.c(this.f16838g);
        dBChatMessage.c(this.i.getShopId());
        dBChatMessage.e(this.f16837f);
        ChatProductInfo.Builder quantity = new ChatProductInfo.Builder().shopid(Integer.valueOf(this.i.getShopId())).itemid(Long.valueOf(this.i.getItemId())).name(this.i.getItemName()).price(au.a(this.i.getOrderPrice(), this.i.getCurrency())).quantity(Integer.valueOf(this.i.getAmount()));
        dBChatMessage.a(quantity.thumbUrl(this.i.getItemImage() + "_tn").modelname(this.i.getModelName()).snapshopid(Long.valueOf(this.i.getSnapshotId())).build().toByteArray());
        dBChatMessage.b(4);
        dBChatMessage.a(a.a());
        dBChatMessage.a(gVar.i().a());
        dBChatMessage.f(1);
        dBChatMessage.d(this.h);
        if (this.i.getModelId() > 0) {
            dBChatMessage.e(this.i.getModelId());
        }
        this.f16834c.a(dBChatMessage);
        DBChat a2 = this.f16836e.a(this.f16837f);
        if (a2 != null) {
            a2.a(gVar.i().a());
            a2.g(a.a());
            this.f16836e.a(a2);
        }
        gVar.a(dBChatMessage, a(userId, this.f16837f, this.i.getShopId()));
        this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16835d.isMyShop(this.i.getShopId()))));
    }

    private int a(int i2, int i3, int i4) {
        return m.a(i4) ? i2 : i3;
    }
}
