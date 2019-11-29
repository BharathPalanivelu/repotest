package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.b.g;
import com.shopee.app.util.g.b;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatProductInfo;
import java.util.List;

public class ds extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16843c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16844d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16845e;

    /* renamed from: f  reason: collision with root package name */
    private final av f16846f;

    /* renamed from: g  reason: collision with root package name */
    private int f16847g;
    private long h;
    private long i;
    private List<ItemDetail> j;

    /* access modifiers changed from: protected */
    public String d() {
        return "SendProductChatInteractor";
    }

    public ds(n nVar, p pVar, av avVar, UserInfo userInfo, JobManager jobManager) {
        super(nVar);
        this.f16843c = pVar;
        this.f16844d = userInfo;
        this.f16846f = avVar;
        this.f16845e = jobManager;
    }

    public void a(long j2, int i2, List<ItemDetail> list) {
        this.h = j2;
        this.j = list;
        this.i = 0;
        this.f16847g = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        for (ItemDetail next : this.j) {
            g gVar = new g();
            DBChatMessage dBChatMessage = new DBChatMessage();
            dBChatMessage.d(this.f16844d.getUserId());
            dBChatMessage.c(this.h);
            dBChatMessage.c(next.getShopId());
            dBChatMessage.e(this.f16847g);
            dBChatMessage.a(new ChatProductInfo.Builder().itemid(Long.valueOf(next.getId())).shopid(Integer.valueOf(next.getShopId())).name(next.getItemName()).thumbUrl(next.getThumbUrl()).price(next.getVariationNoOOSPriceString()).quantity(Integer.valueOf(next.getStock())).price_before_discount(next.getVariationNoOOSBeforeDiscountPriceString()).build().toByteArray());
            dBChatMessage.b(next.getId());
            dBChatMessage.b(4);
            dBChatMessage.a(a.a());
            dBChatMessage.a(gVar.i().a());
            dBChatMessage.f(1);
            dBChatMessage.d(this.i);
            this.f16843c.a(dBChatMessage);
            DBChat a2 = this.f16846f.a(this.f16847g);
            if (a2 != null) {
                a2.a(gVar.i().a());
                a2.g(a.a());
                this.f16846f.a(a2);
            }
            this.f16845e.addJobInBackground(new b(gVar.i().a()));
            this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16844d.isMyShop(next.getShopId()))));
        }
    }
}
