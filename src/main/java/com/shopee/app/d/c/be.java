package com.shopee.app.d.c;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.az;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.d.ad;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ShopItemId;
import java.util.ArrayList;
import java.util.List;

public class be extends a {

    /* renamed from: c  reason: collision with root package name */
    private final ah f16562c;

    /* renamed from: d  reason: collision with root package name */
    private final ao f16563d;

    /* renamed from: e  reason: collision with root package name */
    private final az f16564e;

    /* renamed from: f  reason: collision with root package name */
    private int f16565f;

    /* renamed from: g  reason: collision with root package name */
    private int f16566g;
    private boolean h;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetOfferItemListByShopInteractor";
    }

    protected be(n nVar, az azVar, ah ahVar, ao aoVar) {
        super(nVar);
        this.f16562c = ahVar;
        this.f16563d = aoVar;
        this.f16564e = azVar;
    }

    public void a(int i, int i2, boolean z) {
        this.f16565f = i;
        this.f16566g = i2;
        this.h = z;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<ShopItemId> c2 = this.f16564e.c(this.f16565f);
        int i = 0;
        if (this.h && c2.size() > 20) {
            c2 = c2.subList(0, 20);
        }
        if (!af.a(c2)) {
            if (this.h) {
                ItemDetail itemDetail = new ItemDetail();
                itemDetail.setShopId(-2);
                itemDetail.setItemName(b.e(R.string.sp_recent_from_shop_msg));
                arrayList.add(itemDetail);
            }
            ArrayList arrayList3 = new ArrayList();
            for (ShopItemId shopItemId : c2) {
                arrayList3.add(shopItemId.itemid);
            }
            List<DBItemDetail> c3 = this.f16562c.c((List<Long>) arrayList3);
            int i2 = 0;
            for (ShopItemId next : c2) {
                ItemDetail itemDetail2 = new ItemDetail();
                DBItemDetail dBItemDetail = i2 < c3.size() ? c3.get(i2) : null;
                if (dBItemDetail == null || dBItemDetail.a() != next.itemid.longValue() || dBItemDetail.k() < next.mtime.intValue()) {
                    com.shopee.app.d.b.b.a(DBItemDetail.a(next.shopid.intValue(), next.itemid.longValue(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail2);
                    arrayList2.add(new Pair(next.shopid, next.itemid));
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.addAll(this.f16563d.b(dBItemDetail.a()));
                    com.shopee.app.d.b.b.a(dBItemDetail, (List<IModelDetail>) arrayList4, itemDetail2);
                    i2++;
                }
                if (!arrayList.contains(itemDetail2)) {
                    arrayList.add(itemDetail2);
                }
            }
        }
        List<ShopItemId> b2 = this.f16564e.b(this.f16565f);
        int i3 = (this.f16566g + 1) * 20;
        if (b2.size() > i3) {
            b2 = b2.subList(0, i3);
        }
        if (!af.a(b2)) {
            if (this.h) {
                ItemDetail itemDetail3 = new ItemDetail();
                itemDetail3.setShopId(-2);
                itemDetail3.setItemName(b.e(R.string.sp_label_all_products));
                arrayList.add(itemDetail3);
            }
            ArrayList arrayList5 = new ArrayList();
            for (ShopItemId shopItemId2 : b2) {
                arrayList5.add(shopItemId2.itemid);
            }
            List<DBItemDetail> c4 = this.f16562c.c((List<Long>) arrayList5);
            for (ShopItemId next2 : b2) {
                ItemDetail itemDetail4 = new ItemDetail();
                DBItemDetail dBItemDetail2 = i < c4.size() ? c4.get(i) : null;
                if (dBItemDetail2 == null || dBItemDetail2.a() != next2.itemid.longValue() || dBItemDetail2.k() < next2.mtime.intValue()) {
                    com.shopee.app.d.b.b.a(DBItemDetail.a(next2.shopid.intValue(), next2.itemid.longValue(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail4);
                    arrayList2.add(new Pair(next2.shopid, next2.itemid));
                } else {
                    ArrayList arrayList6 = new ArrayList();
                    arrayList6.addAll(this.f16563d.b(dBItemDetail2.a()));
                    com.shopee.app.d.b.b.a(dBItemDetail2, (List<IModelDetail>) arrayList6, itemDetail4);
                    i++;
                }
                if (!arrayList.contains(itemDetail4)) {
                    arrayList.add(itemDetail4);
                }
            }
        }
        if (arrayList.size() > 0 && ((ItemDetail) arrayList.get(arrayList.size() - 1)).getShopId() == -2) {
            arrayList.remove(arrayList.size() - 1);
        }
        if (!af.a(arrayList2)) {
            new ad().a(arrayList2);
        }
        this.f16402a.a("ITEM_BY_SHOP_LIST_LOCAL_LOAD", new a(new Pair(Integer.valueOf(this.f16565f), arrayList)));
    }
}
