package com.shopee.app.ui.chat2.a;

import android.util.Pair;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.d.c.br;
import com.shopee.app.d.c.c.c;
import com.shopee.app.d.c.dh;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.network.d.g.a;
import com.shopee.app.network.d.g.d;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bi;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final br f20224a;

    /* renamed from: c  reason: collision with root package name */
    private final i f20225c = com.garena.a.a.a.b.a(this);

    /* renamed from: d  reason: collision with root package name */
    private final c f20226d;

    /* renamed from: e  reason: collision with root package name */
    private final dh f20227e;

    /* renamed from: f  reason: collision with root package name */
    private final Cdo f20228f;

    /* renamed from: g  reason: collision with root package name */
    private final UserInfo f20229g;
    private final bi h;
    private long i;
    private int j;
    private long k;
    private long l;
    private VMOffer m;
    private a n;
    private ItemDetail o;

    public b(UserInfo userInfo, bi biVar, br brVar, c cVar, dh dhVar, Cdo doVar) {
        this.f20224a = brVar;
        this.f20226d = cVar;
        this.f20227e = dhVar;
        this.f20228f = doVar;
        this.f20229g = userInfo;
        this.h = biVar;
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public void a(long j2, int i2, long j3) {
        this.i = j2;
        this.j = i2;
        this.k = j3;
        this.f20224a.a(this.j, this.i);
    }

    public void a(long j2, long j3, int i2, long j4) {
        this.i = j3;
        this.j = i2;
        this.k = j4;
        this.l = j2;
        k();
        new com.shopee.app.network.d.c.c().a(Collections.singletonList(Long.valueOf(this.l)));
    }

    private void k() {
        long j2 = this.l;
        if (j2 > 0) {
            this.f20226d.a(j2);
        }
    }

    public void a() {
        this.f20225c.a();
    }

    public void b() {
        this.f20225c.b();
    }

    /* access modifiers changed from: package-private */
    public void a(ItemDetail itemDetail) {
        if (itemDetail.getShopId() == this.j && itemDetail.getId() == this.i) {
            this.o = itemDetail;
            ModelDetail modelDetail = null;
            List<ModelDetail> modelDetails = itemDetail.getModelDetails();
            if (modelDetails != null) {
                Iterator<ModelDetail> it = modelDetails.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ModelDetail next = it.next();
                    if (next.getModelId() == this.k) {
                        modelDetail = next;
                        break;
                    }
                }
            }
            ((d) this.f19220b).a(itemDetail, modelDetail);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(VMOffer vMOffer) {
        if (vMOffer.getOfferid() == this.l) {
            this.m = vMOffer;
            if (this.f20229g.getUserId() == vMOffer.getSellerUserid()) {
                b(vMOffer);
            } else {
                c(vMOffer);
            }
        }
    }

    private void b(VMOffer vMOffer) {
        int offerStatus = vMOffer.getOfferStatus();
        if (offerStatus == 1) {
            ((d) this.f19220b).b();
        } else if (offerStatus == 2) {
            ((d) this.f19220b).d();
        } else if (offerStatus == 3) {
            ((d) this.f19220b).f();
        } else if (offerStatus == 4) {
            ((d) this.f19220b).h();
        }
    }

    private void c(VMOffer vMOffer) {
        int offerStatus = vMOffer.getOfferStatus();
        if (offerStatus == 1) {
            ((d) this.f19220b).c();
        } else if (offerStatus == 2) {
            ((d) this.f19220b).e();
        } else if (offerStatus == 3) {
            ((d) this.f19220b).g();
        } else if (offerStatus == 4) {
            ((d) this.f19220b).i();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        k();
    }

    public void f() {
        this.f20227e.a(0, this.m.getItemid(), this.m.getShopid(), this.f20229g.getUserId() == this.m.getBuyerUserid() ? this.m.getSellerUserid() : this.m.getBuyerUserid(), 3, this.n, new d());
    }

    public void g() {
        this.f20227e.a(0, this.m.getItemid(), this.m.getShopid(), this.f20229g.getUserId() == this.m.getBuyerUserid() ? this.m.getSellerUserid() : this.m.getBuyerUserid(), 2, this.n, new a());
    }

    public void h() {
        this.f20227e.a(0, this.m.getItemid(), this.m.getShopid(), this.f20229g.getUserId() == this.m.getBuyerUserid() ? this.m.getSellerUserid() : this.m.getBuyerUserid(), 4, this.n, new com.shopee.app.network.d.g.b());
    }

    public void i() {
        if (this.o != null && this.m != null) {
            this.h.a().f7524d.a(new Pair(this.o, this.m)).a();
        }
    }

    public void j() {
        if (this.o != null && this.m != null) {
            this.h.a().U.a(new Pair(this.o, this.m)).a();
        }
    }
}
