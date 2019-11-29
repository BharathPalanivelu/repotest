package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.w;
import com.shopee.app.data.store.x;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.aa;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.ResponseOrderList;
import com.shopee.protocol.shop.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ad extends c {
    public int a() {
        return 32;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseOrderList responseOrderList = (ResponseOrderList) f.f18486a.parseFrom(bArr, 0, i, ResponseOrderList.class);
        c(responseOrderList.requestid);
        c().a(responseOrderList);
    }

    private a c() {
        return ar.f().e().customerOrdersProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final x f17787a;

        /* renamed from: b  reason: collision with root package name */
        private final w f17788b;

        public a(x xVar, w wVar) {
            this.f17787a = xVar;
            this.f17788b = wVar;
        }

        public void a(ResponseOrderList responseOrderList) {
            if (b(responseOrderList)) {
                aa aaVar = (aa) o.a().f(responseOrderList.requestid);
                if (aaVar != null && aaVar.c() <= 0) {
                    this.f17788b.a();
                }
                if (!af.a(responseOrderList.order)) {
                    c cVar = new c();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Map<Integer, Integer> a2 = this.f17787a.a();
                    for (Order next : responseOrderList.order) {
                        if (next.status.intValue() == 0) {
                            arrayList2.add(next.orderid);
                        } else {
                            OrderInfo orderInfo = null;
                            for (OrderInfo next2 : responseOrderList.info) {
                                if (next.orderid.equals(next2.orderid)) {
                                    orderInfo = next2;
                                }
                            }
                            DBOrderDetail dBOrderDetail = new DBOrderDetail();
                            b.a(next, orderInfo, dBOrderDetail);
                            arrayList.add(dBOrderDetail);
                            arrayList3.add(next.orderid);
                        }
                    }
                    a2.put(Integer.valueOf(aaVar.b()), responseOrderList.total_orders);
                    this.f17787a.a(a2);
                    this.f17788b.a((List<Long>) arrayList3);
                    cVar.c((List<Long>) arrayList2);
                    cVar.a((List<DBOrderDetail>) arrayList);
                }
                com.garena.android.appkit.b.b.a("CUSTOMER_ORDER_LIST_SAVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
            }
        }

        private boolean b(ResponseOrderList responseOrderList) {
            if (responseOrderList.errcode.intValue() == 0) {
                return true;
            }
            com.garena.android.appkit.b.b.a("ORDER_LIST_ERROR", new com.garena.android.appkit.b.a(responseOrderList.errcode), b.a.NETWORK_BUS);
            return false;
        }
    }
}
