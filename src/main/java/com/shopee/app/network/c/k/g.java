package com.shopee.app.network.c.k;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.ResponseOrderList;
import com.shopee.protocol.shop.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class g extends c {
    public int a() {
        return 58;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseOrderList responseOrderList = (ResponseOrderList) f.f18486a.parseFrom(bArr, 0, i, ResponseOrderList.class);
        if (a(responseOrderList)) {
            com.shopee.app.data.store.c.c cVar = new com.shopee.app.data.store.c.c();
            ArrayList arrayList = new ArrayList();
            if (!af.a(responseOrderList.order)) {
                for (Order next : responseOrderList.order) {
                    OrderInfo orderInfo = null;
                    for (OrderInfo next2 : responseOrderList.info) {
                        if (next.orderid.equals(next2.orderid)) {
                            orderInfo = next2;
                        }
                    }
                    DBOrderDetail dBOrderDetail = new DBOrderDetail();
                    b.a(next, orderInfo, dBOrderDetail);
                    arrayList.add(dBOrderDetail);
                }
            }
            cVar.a((List<DBOrderDetail>) arrayList);
            az f2 = o.a().f(responseOrderList.requestid);
            if (f2 instanceof com.shopee.app.network.d.h.g) {
                com.garena.android.appkit.b.b.a("MISS_ORDER_FETCHED", new a(Integer.valueOf(((com.shopee.app.network.d.h.g) f2).b())), b.a.NETWORK_BUS);
            }
            com.garena.android.appkit.b.b.a("ORDER_IN_BATCH_SAVED", new a(), b.a.NETWORK_BUS);
        }
    }

    private boolean a(ResponseOrderList responseOrderList) {
        return responseOrderList.errcode.intValue() == 0;
    }
}
