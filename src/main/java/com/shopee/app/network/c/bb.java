package com.shopee.app.network.c;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBModel;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.action.ResponseItem;
import com.shopee.protocol.shop.ItemModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bb extends c implements com.shopee.app.network.a.a<ResponseItem> {
    public int a() {
        return 4;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseItem responseItem = (ResponseItem) f.f18486a.parseFrom(bArr, 0, i, ResponseItem.class);
        c(responseItem.requestid);
        c().a(responseItem);
    }

    private a c() {
        return ar.f().e().getItemDetailProcessor();
    }

    public Pair<String, ResponseItem> a(byte[] bArr) throws IOException {
        ResponseItem responseItem = (ResponseItem) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseItem.class);
        return new Pair<>(responseItem.requestid, responseItem);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17849a;

        /* renamed from: b  reason: collision with root package name */
        private ah f17850b;

        /* renamed from: c  reason: collision with root package name */
        private ao f17851c;

        a(ah ahVar, n nVar, ao aoVar) {
            this.f17850b = ahVar;
            this.f17849a = nVar;
            this.f17851c = aoVar;
        }

        public void a(ResponseItem responseItem) {
            if (b(responseItem)) {
                DBItemDetail dBItemDetail = new DBItemDetail();
                b.a(responseItem.item, dBItemDetail, responseItem.reason);
                this.f17850b.a(dBItemDetail);
                this.f17851c.c(responseItem.item.itemid.longValue());
                ArrayList arrayList = new ArrayList();
                if (!af.a(responseItem.models)) {
                    for (ItemModel a2 : responseItem.models) {
                        DBModel dBModel = new DBModel();
                        b.a(a2, (IModelDetail) dBModel);
                        arrayList.add(dBModel);
                    }
                    this.f17851c.a((List<DBModel>) arrayList);
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(arrayList);
                ItemDetail itemDetail = new ItemDetail();
                b.a(dBItemDetail, (List<IModelDetail>) arrayList2, itemDetail);
                this.f17849a.a("ITEM_DETAIL_LOAD", new com.garena.android.appkit.b.a(itemDetail));
            }
        }

        private boolean b(ResponseItem responseItem) {
            boolean z = responseItem.errcode.intValue() == 0;
            if (!z) {
                a(responseItem.errcode.intValue());
            }
            return z;
        }

        /* access modifiers changed from: private */
        public void a(int i) {
            com.garena.android.appkit.b.b.a("ITEM_DETAIL_LOAD_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(i, "", (ResponseCommon) null)), b.a.NETWORK_BUS);
        }
    }

    public void a(String str) {
        c().a(-100);
    }
}
