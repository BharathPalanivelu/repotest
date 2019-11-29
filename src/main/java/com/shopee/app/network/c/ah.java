package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ao;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBModel;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseItemList;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ah extends c {
    public int a() {
        return 94;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseItemList responseItemList = (ResponseItemList) f.f18486a.parseFrom(bArr, 0, i, ResponseItemList.class);
        c(responseItemList.requestid);
        if (a(responseItemList)) {
            c().a(responseItemList);
        }
    }

    public a c() {
        return ar.f().e().getItemBatchProcessor();
    }

    private boolean a(ResponseItemList responseItemList) {
        if (responseItemList.errcode.intValue() == 0) {
            return true;
        }
        a(responseItemList.errcode.intValue());
        return false;
    }

    public void a(int i) {
        b.a("BATCH_ITEM_LOAD_FAIL", new com.garena.android.appkit.b.a(Integer.valueOf(i)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        a(-100);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17793a;

        /* renamed from: b  reason: collision with root package name */
        private final com.shopee.app.data.store.ah f17794b;

        /* renamed from: c  reason: collision with root package name */
        private final ao f17795c;

        public a(n nVar, com.shopee.app.data.store.ah ahVar, ao aoVar) {
            this.f17793a = nVar;
            this.f17794b = ahVar;
            this.f17795c = aoVar;
        }

        /* access modifiers changed from: package-private */
        public void a(ResponseItemList responseItemList) {
            DBItemDetail dBItemDetail;
            ArrayList arrayList = new ArrayList();
            for (Item next : responseItemList.item) {
                if (next.status == null) {
                    dBItemDetail = DBItemDetail.a(next.shopid.intValue(), next.itemid.longValue());
                } else {
                    dBItemDetail = new DBItemDetail();
                    com.shopee.app.d.b.b.a(next, dBItemDetail);
                }
                arrayList.add(dBItemDetail);
                this.f17795c.c(next.itemid.longValue());
            }
            if (!af.a(responseItemList.models)) {
                ArrayList arrayList2 = new ArrayList();
                for (ItemModel a2 : responseItemList.models) {
                    DBModel dBModel = new DBModel();
                    com.shopee.app.d.b.b.a(a2, (IModelDetail) dBModel);
                    arrayList2.add(dBModel);
                }
                this.f17795c.a((List<DBModel>) arrayList2);
            }
            this.f17794b.a((List<DBItemDetail>) arrayList);
            this.f17793a.a("BATCH_ITEM_LOAD", new com.garena.android.appkit.b.a(responseItemList.requestid));
        }
    }
}
