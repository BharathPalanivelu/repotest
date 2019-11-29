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
import com.shopee.app.network.d.al;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseItemList;
import com.shopee.protocol.action.ShopItemId;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ap extends c {
    public int a() {
        return 205;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseItemList responseItemList = (ResponseItemList) f.f18486a.parseFrom(bArr, 0, i, ResponseItemList.class);
        c(responseItemList.requestid);
        c().a(responseItemList);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetRecentItemsProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17816a;

        /* renamed from: b  reason: collision with root package name */
        private ah f17817b;

        /* renamed from: c  reason: collision with root package name */
        private ao f17818c;

        /* renamed from: d  reason: collision with root package name */
        private az f17819d;

        public a(n nVar, ah ahVar, ao aoVar, az azVar) {
            this.f17816a = nVar;
            this.f17817b = ahVar;
            this.f17818c = aoVar;
            this.f17819d = azVar;
        }

        public void a(ResponseItemList responseItemList) {
            if (b(responseItemList)) {
                al alVar = (al) o.a().f(responseItemList.requestid);
                if (alVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (!alVar.d()) {
                        if (!af.a(responseItemList.item)) {
                            ArrayList arrayList2 = new ArrayList();
                            for (Item next : responseItemList.item) {
                                DBItemDetail dBItemDetail = new DBItemDetail();
                                b.a(next, dBItemDetail);
                                arrayList2.add(dBItemDetail);
                                ShopItemId.Builder builder = new ShopItemId.Builder();
                                builder.itemid(Long.valueOf(dBItemDetail.a())).shopid(Integer.valueOf(dBItemDetail.b())).mtime(Integer.valueOf(dBItemDetail.k()));
                                arrayList.add(builder.build());
                                this.f17818c.c(next.itemid.longValue());
                            }
                            this.f17817b.a((List<DBItemDetail>) arrayList2);
                        }
                        if (!af.a(responseItemList.models)) {
                            ArrayList arrayList3 = new ArrayList();
                            for (ItemModel a2 : responseItemList.models) {
                                DBModel dBModel = new DBModel();
                                b.a(a2, (IModelDetail) dBModel);
                                arrayList3.add(dBModel);
                            }
                            this.f17818c.a((List<DBModel>) arrayList3);
                        }
                    }
                    if (alVar.d() && !af.a(responseItemList.idlist)) {
                        arrayList.addAll(responseItemList.idlist);
                    }
                    int c2 = alVar.c();
                    int b2 = alVar.b();
                    if (c2 == 0) {
                        this.f17819d.c(b2, arrayList);
                    } else if (c2 == 1) {
                        this.f17819d.d(b2, arrayList);
                    }
                }
                this.f17816a.a("CMD_GET_RECENT_ITEMS_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseItemList responseItemList) {
            if (responseItemList.errcode.intValue() == 0) {
                return true;
            }
            this.f17816a.a("CMD_GET_RECENT_ITEMS_ERROR", new com.garena.android.appkit.b.a(responseItemList.errcode));
            return false;
        }

        public void a() {
            this.f17816a.a("CMD_GET_RECENT_ITEMS_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
