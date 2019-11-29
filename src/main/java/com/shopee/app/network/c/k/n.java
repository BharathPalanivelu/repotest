package com.shopee.app.network.c.k;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.r;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.ResponseUnpaidOrders;
import com.shopee.protocol.action.UnpaidOrder;
import com.shopee.protocol.shop.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class n extends c {
    public int a() {
        return 140;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseUnpaidOrders) f.f18486a.parseFrom(bArr, 0, i, ResponseUnpaidOrders.class));
    }

    public a c() {
        return ar.f().e().unpaidOrdersProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final r f18029a;

        /* renamed from: b  reason: collision with root package name */
        private final com.shopee.app.util.n f18030b;

        /* renamed from: c  reason: collision with root package name */
        private final q f18031c;

        /* renamed from: d  reason: collision with root package name */
        private final com.shopee.app.data.store.c.c f18032d;

        public a(com.shopee.app.util.n nVar, r rVar, q qVar, com.shopee.app.data.store.c.c cVar) {
            this.f18030b = nVar;
            this.f18029a = rVar;
            this.f18032d = cVar;
            this.f18031c = qVar;
        }

        public void a(ResponseUnpaidOrders responseUnpaidOrders) {
            if (b(responseUnpaidOrders)) {
                List<UnpaidOrder> arrayList = responseUnpaidOrders.unpaid_orders != null ? responseUnpaidOrders.unpaid_orders : new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (UnpaidOrder unpaidOrder : arrayList) {
                    DBCheckoutItem dBCheckoutItem = new DBCheckoutItem();
                    b.a(unpaidOrder.checkout, dBCheckoutItem);
                    if (unpaidOrder.orders != null && !unpaidOrder.orders.isEmpty()) {
                        for (Order a2 : unpaidOrder.orders) {
                            DBOrderDetail dBOrderDetail = new DBOrderDetail();
                            b.a(a2, (OrderInfo) null, dBOrderDetail);
                            arrayList3.add(dBOrderDetail);
                        }
                        arrayList2.add(dBCheckoutItem);
                        arrayList4.add(Long.valueOf(dBCheckoutItem.a()));
                    }
                }
                this.f18029a.a((List<DBCheckoutItem>) arrayList2);
                this.f18032d.a((List<DBOrderDetail>) arrayList3);
                this.f18031c.a();
                this.f18031c.a((List<Long>) arrayList4);
                this.f18030b.a("CHECKOUT_LIST_SAVED", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseUnpaidOrders responseUnpaidOrders) {
            return responseUnpaidOrders.errcode.intValue() == 0;
        }
    }
}
