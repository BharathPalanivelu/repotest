package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.network.g;
import com.shopee.app.util.g.b;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatOfferInfo;
import java.util.Iterator;

public class dg extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16798c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16799d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16800e;

    /* renamed from: f  reason: collision with root package name */
    private long f16801f;

    /* renamed from: g  reason: collision with root package name */
    private long f16802g;
    private int h;
    private int i;
    private long j;
    private long k;
    private int l;
    private int m;
    private ItemSnapshotInfo n;
    private VMOffer o;

    /* access modifiers changed from: protected */
    public String d() {
        return "RemindOfferChatInteractor";
    }

    public dg(n nVar, p pVar, UserInfo userInfo, JobManager jobManager) {
        super(nVar);
        this.f16798c = pVar;
        this.f16799d = userInfo;
        this.f16800e = jobManager;
    }

    public void a(long j2, int i2, VMOffer vMOffer, ItemSnapshotInfo itemSnapshotInfo) {
        this.j = j2;
        this.f16801f = vMOffer.getItemid();
        this.f16802g = vMOffer.getModelid();
        this.h = vMOffer.getShopid();
        this.i = i2;
        this.k = vMOffer.getOfferPrice();
        this.l = vMOffer.getBuyCount();
        this.m = vMOffer.getOfferStatus();
        this.o = vMOffer;
        this.n = itemSnapshotInfo;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        g gVar = new g();
        DBChatMessage dBChatMessage = new DBChatMessage();
        ChatOfferInfo.Builder builder = new ChatOfferInfo.Builder();
        builder.price(Long.valueOf(this.k)).currency("IDR").quantity(Integer.valueOf(this.l)).offerStatus(Integer.valueOf(this.m)).itemid(Long.valueOf(this.f16801f)).item_name(this.n.getItemName()).imageUrl(this.n.getImages()).price_before_discount(Long.valueOf(this.n.getPriceBeforeDiscount())).original_price(Long.valueOf(this.n.getPrice())).offerid(Long.valueOf(this.o.getOfferid())).shopid(Integer.valueOf(this.h));
        long j2 = this.f16802g;
        if (j2 > 0) {
            builder.modelid(Long.valueOf(j2));
            if (this.n.getModels() != null) {
                Iterator<ModelDetail> it = this.n.getModels().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ModelDetail next = it.next();
                    if (next.getModelId() == this.f16802g) {
                        builder.model_name(next.getName()).price_before_discount(Long.valueOf(next.getPriceBeforeDiscount())).original_price(Long.valueOf(next.getPrice()));
                        break;
                    }
                }
            }
        }
        dBChatMessage.d(((Integer) ak.a().d().b(-1)).intValue());
        dBChatMessage.c(this.j);
        dBChatMessage.c(this.h);
        dBChatMessage.e(this.i);
        dBChatMessage.a(builder.build().toByteArray());
        dBChatMessage.b(this.f16801f);
        dBChatMessage.b(3);
        dBChatMessage.a(a.a());
        dBChatMessage.a(gVar.a());
        dBChatMessage.f(1);
        long j3 = this.f16802g;
        if (j3 > 0) {
            dBChatMessage.e(j3);
        }
        this.f16798c.a(dBChatMessage);
        this.f16800e.addJobInBackground(new b(gVar.a()));
        this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16799d.isMyShop(this.h))));
    }
}
