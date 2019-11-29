package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.c.c;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.ResponseOrderList;
import com.shopee.protocol.shop.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class y extends c {
    public int a() {
        return 112;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseOrderList responseOrderList = (ResponseOrderList) f.f18486a.parseFrom(bArr, 0, i, ResponseOrderList.class);
        c(responseOrderList.requestid);
        c().a(responseOrderList);
    }

    private a c() {
        return ar.f().e().newCheckoutOrderProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f18060a;

        public a(c cVar) {
            this.f18060a = cVar;
        }

        public void a(ResponseOrderList responseOrderList) {
            if (b(responseOrderList)) {
                if (!af.a(responseOrderList.order)) {
                    ArrayList arrayList = new ArrayList();
                    for (Order a2 : responseOrderList.order) {
                        DBOrderDetail dBOrderDetail = new DBOrderDetail();
                        b.a(a2, (OrderInfo) null, dBOrderDetail);
                        arrayList.add(dBOrderDetail);
                    }
                    this.f18060a.a((List<DBOrderDetail>) arrayList);
                }
                com.garena.android.appkit.b.b.a("GET_CHECKOUT_ORDER_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
            }
        }

        private boolean b(ResponseOrderList responseOrderList) {
            if (responseOrderList.errcode.intValue() == 0) {
                return true;
            }
            a(responseOrderList.errcode.intValue());
            return false;
        }

        private void a(int i) {
            com.garena.android.appkit.b.b.a("GET_CHECKOUT_ORDER_FAIL", new com.garena.android.appkit.b.a(Integer.valueOf(i)), b.a.NETWORK_BUS);
        }

        public void a(String str) {
            a(-100);
        }
    }

    public void a(String str) {
        c().a(str);
    }
}
