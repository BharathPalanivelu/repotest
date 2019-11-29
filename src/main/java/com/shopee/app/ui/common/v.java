package com.shopee.app.ui.common;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.ag;
import com.shopee.app.d.c.br;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chat.OfferItem;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;

public class v extends q<w> {

    /* renamed from: a  reason: collision with root package name */
    private final n f21346a;

    /* renamed from: c  reason: collision with root package name */
    private final br f21347c;

    /* renamed from: d  reason: collision with root package name */
    private final ag f21348d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f21349e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f21350f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f21351g;
    private e h = new g() {
        public void onEvent(a aVar) {
            ItemDetail itemDetail = (ItemDetail) aVar.data;
            if (itemDetail.getId() == v.this.f21349e) {
                ((w) v.this.f19220b).a(itemDetail);
            }
        }
    };
    private e i = new g() {
        public void onEvent(a aVar) {
            OfferItem offerItem = (OfferItem) aVar.data;
            if (offerItem.getShopId() == v.this.f21350f && offerItem.getUserId() == v.this.f21351g && offerItem.getItemId() == v.this.f21349e) {
                ((w) v.this.f19220b).setOfferInfo(offerItem);
            }
        }
    };

    public v(n nVar, ag agVar, br brVar) {
        this.f21346a = nVar;
        this.f21348d = agVar;
        this.f21347c = brVar;
    }

    public void a() {
        this.f21346a.a("ITEM_DETAIL_LOAD", this.h);
        this.f21346a.a("CHAT_OFFER_LOAD", this.i);
        this.f21346a.a("OFFER_CHANGED", this.i);
        this.f21346a.a("REPLY_OFFER_SUCCESS", this.i);
    }

    public void b() {
        this.f21346a.b("ITEM_DETAIL_LOAD", this.h);
        this.f21346a.b("CHAT_OFFER_LOAD", this.i);
        this.f21346a.b("OFFER_CHANGED", this.i);
        this.f21346a.b("REPLY_OFFER_SUCCESS", this.i);
    }

    public void e() {
        ((w) this.f19220b).a(this.f21350f, this.f21349e);
    }
}
