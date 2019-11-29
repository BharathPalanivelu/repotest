package com.shopee.app.network;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.r;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.ui.order.detail.h;
import com.shopee.app.util.n;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.ResponseUnpaidOrder;
import com.shopee.protocol.shop.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class d extends c {
    public int a() {
        return 141;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseUnpaidOrder responseUnpaidOrder = (ResponseUnpaidOrder) f.f18486a.parseFrom(bArr, 0, i, ResponseUnpaidOrder.class);
        c(responseUnpaidOrder.requestid);
        c().a(responseUnpaidOrder);
    }

    public a c() {
        return ar.f().e().newGetCheckoutProcessor();
    }

    public void a(String str) {
        c().a(str);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.data.store.c.c f18061a;

        /* renamed from: b  reason: collision with root package name */
        private final r f18062b;

        /* renamed from: c  reason: collision with root package name */
        private final n f18063c;

        public a(n nVar, com.shopee.app.data.store.c.c cVar, r rVar) {
            this.f18063c = nVar;
            this.f18061a = cVar;
            this.f18062b = rVar;
        }

        public void a(ResponseUnpaidOrder responseUnpaidOrder) {
            if (b(responseUnpaidOrder)) {
                o.a().b(responseUnpaidOrder.requestid);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                DBCheckoutItem dBCheckoutItem = new DBCheckoutItem();
                b.a(responseUnpaidOrder.unpaid_order.checkout, dBCheckoutItem);
                if (responseUnpaidOrder.unpaid_order.orders != null) {
                    for (Order a2 : responseUnpaidOrder.unpaid_order.orders) {
                        DBOrderDetail dBOrderDetail = new DBOrderDetail();
                        b.a(a2, (OrderInfo) null, dBOrderDetail);
                        arrayList2.add(dBOrderDetail);
                    }
                }
                arrayList.add(dBCheckoutItem);
                arrayList3.add(Long.valueOf(dBCheckoutItem.a()));
                this.f18062b.a((List<DBCheckoutItem>) arrayList);
                this.f18061a.a((List<DBOrderDetail>) arrayList2);
                this.f18063c.a("GET_UNPAID_ORDER_SAVED", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseUnpaidOrder responseUnpaidOrder) {
            if (responseUnpaidOrder.errcode.intValue() == 0) {
                return true;
            }
            a(responseUnpaidOrder.requestid, responseUnpaidOrder.errcode.intValue());
            return false;
        }

        private void a(String str, int i) {
            com.garena.android.appkit.b.b.a("GET_UNPAID_ORDER_ERROR", (com.garena.android.appkit.b.a) new h(str, i), b.a.NETWORK_BUS);
        }

        public void a(String str) {
            a(str, -100);
        }
    }
}
