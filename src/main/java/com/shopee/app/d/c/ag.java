package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.chat.OfferItem;
import com.shopee.app.database.orm.bean.DBChatToOffer;
import com.shopee.app.util.n;

public class ag extends a {

    /* renamed from: c  reason: collision with root package name */
    private final ao f16450c;

    /* renamed from: d  reason: collision with root package name */
    private final p f16451d;

    /* renamed from: e  reason: collision with root package name */
    private long f16452e;

    /* renamed from: f  reason: collision with root package name */
    private int f16453f;

    /* renamed from: g  reason: collision with root package name */
    private int f16454g;
    private long h;
    private long i;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetChatOfferInfoInteractor";
    }

    protected ag(n nVar, ao aoVar, p pVar) {
        super(nVar);
        this.f16450c = aoVar;
        this.f16451d = pVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBChatToOffer dBChatToOffer;
        long j = this.f16452e;
        if (j != 0) {
            dBChatToOffer = this.f16451d.b(j);
        } else {
            dBChatToOffer = this.f16451d.a(this.h, this.f16453f, this.f16454g, 0);
        }
        OfferItem offerItem = new OfferItem();
        if (dBChatToOffer == null) {
            offerItem.setChatId(this.f16452e);
            offerItem.setShopId(this.f16453f);
            offerItem.setUserId(this.f16454g);
            offerItem.setItemId(this.h);
            offerItem.setModelId(this.i);
            offerItem.setOfferStatus(0);
        } else {
            b.a(dBChatToOffer, this.f16450c.a(dBChatToOffer.h()), offerItem);
        }
        this.f16402a.a("CHAT_OFFER_LOAD", new a(offerItem));
    }
}
