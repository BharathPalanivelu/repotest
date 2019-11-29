package com.shopee.app.ui.chat2.a;

import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import java.util.Iterator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f20217a;

    /* renamed from: b  reason: collision with root package name */
    private long f20218b;

    /* renamed from: c  reason: collision with root package name */
    private String f20219c;

    /* renamed from: d  reason: collision with root package name */
    private long f20220d;

    /* renamed from: e  reason: collision with root package name */
    private int f20221e;

    /* renamed from: f  reason: collision with root package name */
    private long f20222f;

    /* renamed from: g  reason: collision with root package name */
    private long f20223g;
    private String h;
    private String i;
    private long j;
    private long k;
    private String l;
    private VMOffer m;

    public a(ChatOfferMessage chatOfferMessage) {
        this.f20217a = chatOfferMessage.getQuantity();
        this.f20218b = chatOfferMessage.getPrice();
        this.f20219c = chatOfferMessage.getCurrency();
        this.f20220d = chatOfferMessage.getItemId();
        this.f20221e = chatOfferMessage.getShopId();
        this.f20222f = chatOfferMessage.getModelId();
        this.f20223g = chatOfferMessage.getOfferId();
        this.h = chatOfferMessage.getItemName();
        this.i = chatOfferMessage.getModelName();
        this.j = chatOfferMessage.getPriceBeforeDiscount();
        this.k = chatOfferMessage.getOriginalPrice();
        this.l = chatOfferMessage.getImageUrl();
        this.m = chatOfferMessage.getOffer();
    }

    public a(VMOfferHistory vMOfferHistory) {
        this.m = vMOfferHistory.getOffer();
        this.f20217a = this.m.getBuyCount();
        this.f20218b = this.m.getOfferPrice();
        this.f20222f = this.m.getModelid();
        this.f20221e = this.m.getShopid();
        this.f20220d = this.m.getItemid();
        this.f20222f = this.m.getModelid();
        this.f20223g = this.m.getOfferid();
        if (vMOfferHistory.getSnapshot() == null && vMOfferHistory.getItemDetail() != null) {
            ItemDetail itemDetail = vMOfferHistory.getItemDetail();
            this.f20219c = itemDetail.getCurrency();
            this.h = itemDetail.getItemName();
            this.i = itemDetail.getModelName(this.f20222f);
            if (this.f20222f <= 0) {
                this.k = itemDetail.getPrice();
                this.j = itemDetail.getPriceBeforeDiscount();
            } else if (itemDetail.getModelDetails() != null) {
                Iterator<ModelDetail> it = itemDetail.getModelDetails().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ModelDetail next = it.next();
                    if (next.getModelId() == this.f20222f) {
                        this.k = next.getPrice();
                        this.j = next.getPriceBeforeDiscount();
                        break;
                    }
                }
            }
            String str = itemDetail.getImages().split(",")[0];
            this.l = "http://cf.shopee.co.id/file/" + str;
        } else if (vMOfferHistory.getSnapshot() != null) {
            ItemSnapshotInfo snapshot = vMOfferHistory.getSnapshot();
            this.f20219c = snapshot.getCurrency();
            this.h = snapshot.getItemName();
            this.i = snapshot.getModelName(this.f20222f);
            if (this.f20222f <= 0) {
                this.k = snapshot.getPrice();
                this.j = snapshot.getPriceBeforeDiscount();
            } else if (snapshot.getModels() != null) {
                Iterator<ModelDetail> it2 = snapshot.getModels().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ModelDetail next2 = it2.next();
                    if (next2.getModelId() == this.f20222f) {
                        this.k = next2.getPrice();
                        this.j = next2.getPriceBeforeDiscount();
                        break;
                    }
                }
            }
            String str2 = snapshot.getImages().split(",")[0];
            this.l = "http://cf.shopee.co.id/file/" + str2;
        }
    }

    public long a() {
        return this.f20223g;
    }

    public String b() {
        return this.h;
    }

    public String c() {
        return this.i;
    }

    public long d() {
        return this.k;
    }

    public long e() {
        return this.j;
    }

    public String f() {
        return this.l;
    }

    public long g() {
        return this.f20220d;
    }

    public int h() {
        return this.f20221e;
    }

    public long i() {
        return this.f20222f;
    }

    public long j() {
        return this.f20218b;
    }

    public String k() {
        return this.f20219c;
    }

    public int l() {
        return this.f20217a;
    }
}
