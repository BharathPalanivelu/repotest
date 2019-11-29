package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.az;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBModel;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ae;
import com.shopee.app.network.d.ak;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseItemList;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ai extends c {
    public int a() {
        return 5;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ar.f().e().getItemListByTypeProcessor().a((ResponseItemList) f.f18486a.parseFrom(bArr, 0, i, ResponseItemList.class));
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ah f17796a;

        /* renamed from: b  reason: collision with root package name */
        private final ao f17797b;

        /* renamed from: c  reason: collision with root package name */
        private final n f17798c;

        /* renamed from: d  reason: collision with root package name */
        private final az f17799d;

        public a(n nVar, ah ahVar, az azVar, ao aoVar) {
            this.f17798c = nVar;
            this.f17796a = ahVar;
            this.f17797b = aoVar;
            this.f17799d = azVar;
        }

        public void a(ResponseItemList responseItemList) {
            if (b(responseItemList)) {
                ArrayList arrayList = new ArrayList();
                if (!af.a(responseItemList.item)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Item next : responseItemList.item) {
                        DBItemDetail dBItemDetail = new DBItemDetail();
                        b.a(next, dBItemDetail);
                        arrayList2.add(dBItemDetail);
                        arrayList.add(next.itemid);
                        this.f17797b.c(next.itemid.longValue());
                    }
                    this.f17796a.a((List<DBItemDetail>) arrayList2);
                }
                if (!af.a(responseItemList.models)) {
                    ArrayList arrayList3 = new ArrayList();
                    for (ItemModel a2 : responseItemList.models) {
                        DBModel dBModel = new DBModel();
                        b.a(a2, (IModelDetail) dBModel);
                        arrayList3.add(dBModel);
                    }
                    this.f17797b.a((List<DBModel>) arrayList3);
                }
                com.shopee.app.network.d.az f2 = o.a().f(responseItemList.requestid);
                if (f2 != null) {
                    if (f2 instanceof ae) {
                        ae aeVar = (ae) f2;
                        int b2 = aeVar.b();
                        if (aeVar.c() == 0) {
                            this.f17796a.a(arrayList, b2);
                        } else {
                            this.f17796a.c(arrayList, b2);
                        }
                        this.f17798c.a("ITEM_BY_TYPE_LIST_SAVED", new com.garena.android.appkit.b.a(Integer.valueOf(b2)));
                    }
                    if (f2 instanceof ak) {
                        ak akVar = (ak) f2;
                        ArrayList arrayList4 = new ArrayList();
                        if (!af.a(responseItemList.idlist)) {
                            arrayList4.addAll(responseItemList.idlist);
                        }
                        this.f17799d.b(akVar.b(), arrayList4);
                        this.f17798c.a("ITEM_BY_SHOP_LIST_SAVED", new com.garena.android.appkit.b.a(Integer.valueOf(akVar.b())));
                    }
                    if (f2 instanceof com.shopee.app.network.d.af) {
                        this.f17796a.b(arrayList, ((com.shopee.app.network.d.af) f2).b());
                        o.a().a(responseItemList.requestid);
                        this.f17798c.a("PRODUCT_ITEM_SAVED", new com.garena.android.appkit.b.a());
                    }
                }
            }
        }

        private boolean b(ResponseItemList responseItemList) {
            boolean z = responseItemList.errcode.intValue() == 0;
            if (!z) {
                int intValue = responseItemList.errcode.intValue();
            }
            return z;
        }
    }
}
