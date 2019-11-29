package com.shopee.app.network.c.k;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBOrderItem;
import com.shopee.app.h.m;
import com.shopee.app.h.o;
import com.shopee.app.network.a.a;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.h.i;
import com.shopee.app.network.f;
import com.shopee.app.util.an;
import com.shopee.protocol.action.ResponseOrder;
import com.shopee.protocol.shop.OrderItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class h extends c implements a {
    public int a() {
        return 10;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseOrder responseOrder = (ResponseOrder) f.f18486a.parseFrom(bArr, 0, i, ResponseOrder.class);
        c(responseOrder.requestid);
        if (a(responseOrder)) {
            com.shopee.app.data.store.c.c cVar = new com.shopee.app.data.store.c.c();
            ArrayList arrayList = new ArrayList();
            for (OrderItem next : responseOrder.items) {
                DBOrderItem a2 = cVar.a(next.orderid.longValue(), next.itemid.longValue(), b.a(next.modelid));
                if (a2 == null) {
                    a2 = new DBOrderItem();
                }
                b.a(next, a2);
                arrayList.add(a2);
            }
            if (arrayList.size() > 0) {
                cVar.b((List<DBOrderItem>) arrayList);
            }
            DBOrderDetail dBOrderDetail = new DBOrderDetail();
            b.a(responseOrder.order, responseOrder.info, dBOrderDetail);
            cVar.a((List<DBOrderDetail>) Arrays.asList(new DBOrderDetail[]{dBOrderDetail}));
            a(responseOrder.requestid, dBOrderDetail);
            com.garena.android.appkit.b.b.a("ORDER_DETAILS_SERVER_SAVED", new com.garena.android.appkit.b.a(Long.valueOf(dBOrderDetail.a())), b.a.NETWORK_BUS);
        }
    }

    private void a(String str, DBOrderDetail dBOrderDetail) {
        i iVar = (i) o.a().f(str);
        if (iVar != null && iVar.c()) {
            boolean z = true;
            boolean z2 = !m.a(dBOrderDetail.b());
            if (dBOrderDetail.t() != 1) {
                z = false;
            }
            OrderKey orderKey = new OrderKey(dBOrderDetail);
            com.shopee.app.data.store.c.b bVar = new com.shopee.app.data.store.c.b();
            bVar.a(orderKey, dBOrderDetail.a());
            OrderKey with = OrderKey.with(dBOrderDetail.b(), com.shopee.app.d.b.b.a(com.shopee.app.d.b.c.b(dBOrderDetail.H()).sub_list_type));
            bVar.a(with, dBOrderDetail.a());
            at atVar = new at();
            if (!z2 || !z) {
                atVar.a(orderKey, dBOrderDetail.a());
                atVar.a(with, dBOrderDetail.a());
            } else {
                atVar.a(orderKey, dBOrderDetail.z().longValue());
                atVar.a(with, dBOrderDetail.z().longValue());
            }
            HashMap hashMap = new HashMap();
            for (Integer intValue : an.f26158a) {
                int intValue2 = intValue.intValue();
                hashMap.put(Integer.valueOf(intValue2), Integer.valueOf(atVar.a(new OrderKey(orderKey.uType, intValue2)).size()));
            }
            com.garena.android.appkit.b.b.a("ORDER_UPDATE_NOTIFICATION", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(orderKey.uType), hashMap)), b.a.NETWORK_BUS);
        }
    }

    private boolean a(ResponseOrder responseOrder) {
        if (responseOrder.errcode.intValue() == 0) {
            return true;
        }
        a(responseOrder.requestid, responseOrder.errcode.intValue());
        return false;
    }

    private void a(String str, int i) {
        com.garena.android.appkit.b.b.a("ITEM_DETAIL_ITEMS_ERROR", (com.garena.android.appkit.b.a) new com.shopee.app.ui.order.detail.h(str, i), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        a(str, -100);
    }

    public Pair a(byte[] bArr) throws IOException {
        ResponseOrder responseOrder = (ResponseOrder) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseOrder.class);
        return new Pair(responseOrder.requestid, responseOrder);
    }
}
