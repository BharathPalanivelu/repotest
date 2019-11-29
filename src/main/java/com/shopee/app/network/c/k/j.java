package com.shopee.app.network.c.k;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.c.b;
import com.shopee.app.data.store.c.e;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBRefund;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.h.l;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.OrderWithRefunds;
import com.shopee.protocol.action.RespOrderRefundList;
import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.Refund;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class j extends c {
    public int a() {
        return 172;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((RespOrderRefundList) f.f18486a.parseFrom(bArr, 0, i, RespOrderRefundList.class));
    }

    private a c() {
        return ar.f().e().orderReturnProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f18015a;

        /* renamed from: b  reason: collision with root package name */
        private final com.shopee.app.data.store.c.c f18016b;

        /* renamed from: c  reason: collision with root package name */
        private final b f18017c;

        /* renamed from: d  reason: collision with root package name */
        private final e f18018d;

        a(n nVar, com.shopee.app.data.store.c.c cVar, e eVar, b bVar) {
            this.f18015a = nVar;
            this.f18016b = cVar;
            this.f18018d = eVar;
            this.f18017c = bVar;
        }

        public void a(RespOrderRefundList respOrderRefundList) {
            if (b(respOrderRefundList)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                if (!af.a(respOrderRefundList.items)) {
                    for (OrderWithRefunds next : respOrderRefundList.items) {
                        Order order = next.order;
                        if (order.status.intValue() == 0) {
                            arrayList4.add(order.orderid);
                        } else {
                            if (next.refunds != null && !next.refunds.isEmpty()) {
                                DBRefund dBRefund = new DBRefund();
                                for (Refund a2 : next.refunds) {
                                    com.shopee.app.d.b.b.a(a2, dBRefund);
                                    arrayList2.add(dBRefund);
                                }
                            }
                            DBOrderDetail dBOrderDetail = new DBOrderDetail();
                            com.shopee.app.d.b.b.a(order, (OrderInfo) null, dBOrderDetail);
                            arrayList.add(dBOrderDetail);
                            arrayList3.add(order.orderid);
                        }
                    }
                }
                this.f18018d.c((List<DBRefund>) arrayList2);
                this.f18016b.c((List<Long>) arrayList4);
                this.f18016b.a((List<DBOrderDetail>) arrayList);
                l lVar = (l) o.a().f(respOrderRefundList.requestid);
                if (lVar != null) {
                    OrderKey c2 = lVar.c();
                    if (lVar.d() == 0) {
                        this.f18017c.a(c2, (List<Long>) arrayList3);
                    } else {
                        this.f18017c.b(c2, (List<Long>) arrayList3);
                    }
                    this.f18015a.a("ORDER_LIST_SAVED", (com.garena.android.appkit.b.a) new com.shopee.app.ui.order.a.a(c2));
                }
            }
        }

        private boolean b(RespOrderRefundList respOrderRefundList) {
            return respOrderRefundList.errcode.intValue() == 0;
        }
    }
}
