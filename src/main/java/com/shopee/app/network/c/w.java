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
import com.shopee.app.network.d.u;
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

public class w extends c {
    public int a() {
        return 212;
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
        return ar.f().e().newGetChatItemsProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ah f18054a;

        /* renamed from: b  reason: collision with root package name */
        private final n f18055b;

        /* renamed from: c  reason: collision with root package name */
        private final az f18056c;

        /* renamed from: d  reason: collision with root package name */
        private final ao f18057d;

        public a(n nVar, ah ahVar, ao aoVar, az azVar) {
            this.f18055b = nVar;
            this.f18054a = ahVar;
            this.f18056c = azVar;
            this.f18057d = aoVar;
        }

        public void a(ResponseItemList responseItemList) {
            if (b(responseItemList)) {
                u uVar = (u) o.a().f(responseItemList.requestid);
                if (uVar != null) {
                    ArrayList arrayList = new ArrayList();
                    if (!uVar.b()) {
                        if (!af.a(responseItemList.item)) {
                            ArrayList arrayList2 = new ArrayList();
                            for (Item next : responseItemList.item) {
                                DBItemDetail dBItemDetail = new DBItemDetail();
                                b.a(next, dBItemDetail);
                                arrayList2.add(dBItemDetail);
                                ShopItemId.Builder builder = new ShopItemId.Builder();
                                builder.itemid(Long.valueOf(dBItemDetail.a())).shopid(Integer.valueOf(dBItemDetail.b())).mtime(Integer.valueOf(dBItemDetail.k()));
                                arrayList.add(builder.build());
                                this.f18057d.c(next.itemid.longValue());
                            }
                            this.f18054a.a((List<DBItemDetail>) arrayList2);
                        }
                        if (!af.a(responseItemList.models)) {
                            ArrayList arrayList3 = new ArrayList();
                            for (ItemModel a2 : responseItemList.models) {
                                DBModel dBModel = new DBModel();
                                b.a(a2, (IModelDetail) dBModel);
                                arrayList3.add(dBModel);
                            }
                            this.f18057d.a((List<DBModel>) arrayList3);
                        }
                    }
                    if (uVar.b() && !af.a(responseItemList.idlist)) {
                        arrayList.addAll(responseItemList.idlist);
                    }
                    this.f18056c.a(uVar.c(), (List<ShopItemId>) arrayList);
                }
                this.f18055b.a("CMD_GET_CHAT_ITEMS_SUCCUSS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseItemList responseItemList) {
            if (responseItemList.errcode.intValue() == 0) {
                return true;
            }
            this.f18055b.a("CMD_GET_CHAT_ITEMS_ERROR", new com.garena.android.appkit.b.a(responseItemList.errcode));
            return false;
        }

        public void a() {
            this.f18055b.a("CMD_GET_CHAT_ITEMS_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
