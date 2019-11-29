package com.shopee.app.network.c.k;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.c.b;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.h.h;
import com.shopee.app.network.d.h.j;
import com.shopee.app.network.d.h.k;
import com.shopee.app.network.d.h.l;
import com.shopee.app.network.d.h.m;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.ResponseOrderList;
import com.shopee.protocol.shop.BuyerOrderCntInfo;
import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.SellerOrderCntInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class i extends c implements com.shopee.app.network.a.a<ResponseOrderList> {
    public int a() {
        return 11;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseOrderList) f.f18486a.parseFrom(bArr, 0, i, ResponseOrderList.class));
    }

    private a c() {
        return ar.f().e().orderListProcessor();
    }

    public Pair<String, ResponseOrderList> a(byte[] bArr) throws IOException {
        ResponseOrderList responseOrderList = (ResponseOrderList) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseOrderList.class);
        return new Pair<>(responseOrderList.requestid, responseOrderList);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f18011a;

        /* renamed from: b  reason: collision with root package name */
        private final com.shopee.app.data.store.c.c f18012b;

        /* renamed from: c  reason: collision with root package name */
        private final b f18013c;

        /* renamed from: d  reason: collision with root package name */
        private final com.shopee.app.data.store.c.a f18014d;

        public a(n nVar, com.shopee.app.data.store.c.c cVar, b bVar, com.shopee.app.data.store.c.a aVar) {
            this.f18011a = nVar;
            this.f18012b = cVar;
            this.f18013c = bVar;
            this.f18014d = aVar;
        }

        public void a(ResponseOrderList responseOrderList) {
            if (b(responseOrderList)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                if (!af.a(responseOrderList.order)) {
                    for (Order next : responseOrderList.order) {
                        if (next.status.intValue() == 0) {
                            arrayList3.add(next.orderid);
                        } else {
                            if (next.status.intValue() == 5) {
                                arrayList4.add(next.orderid);
                            }
                            OrderInfo orderInfo = null;
                            for (OrderInfo next2 : responseOrderList.info) {
                                if (next.orderid.equals(next2.orderid)) {
                                    orderInfo = next2;
                                }
                            }
                            DBOrderDetail dBOrderDetail = new DBOrderDetail();
                            com.shopee.app.d.b.b.a(next, orderInfo, dBOrderDetail);
                            arrayList.add(dBOrderDetail);
                            arrayList2.add(next.orderid);
                        }
                    }
                }
                if (!arrayList4.isEmpty()) {
                    new m().a(arrayList4);
                }
                this.f18012b.c((List<Long>) arrayList3);
                this.f18012b.a((List<DBOrderDetail>) arrayList);
                az f2 = o.a().f(responseOrderList.requestid);
                if (f2 != null) {
                    if (f2 instanceof l) {
                        l lVar = (l) f2;
                        OrderKey c2 = lVar.c();
                        if (lVar.d() == 0) {
                            this.f18013c.a(c2, (List<Long>) arrayList2);
                        } else {
                            this.f18013c.b(c2, (List<Long>) arrayList2);
                        }
                        this.f18011a.a("ORDER_LIST_SAVED", (com.garena.android.appkit.b.a) new com.shopee.app.ui.order.a.a(c2));
                    }
                    if (f2 instanceof k) {
                        k kVar = (k) f2;
                        int b2 = kVar.b();
                        if (kVar.c() == 0) {
                            this.f18013c.a(b2, (List<Long>) arrayList2);
                        } else {
                            this.f18013c.b(b2, (List<Long>) arrayList2);
                        }
                        this.f18011a.a().an.a(Integer.valueOf(b2)).a();
                    }
                    if (f2 instanceof j) {
                        j jVar = (j) f2;
                        int c3 = jVar.c();
                        if (jVar.b() == 0) {
                            this.f18013c.c(c3, arrayList2);
                        } else {
                            this.f18013c.d(c3, arrayList2);
                        }
                        this.f18011a.a().bN.a(Integer.valueOf(c3)).a();
                    }
                    if (f2 instanceof h) {
                        h hVar = (h) f2;
                        if (hVar.d()) {
                            a(com.shopee.app.d.b.b.a(responseOrderList.group_buy_unpaid_order_cnt, 0), com.shopee.app.d.b.b.a(responseOrderList.group_buy_ongoing_group_cnt, 0));
                        }
                        if (hVar.c()) {
                            a(responseOrderList.seller_ordercnt_info);
                        } else {
                            a(responseOrderList.buyer_ordercnt_info, responseOrderList.buyer_to_rate_count);
                        }
                    }
                }
            }
        }

        public void a(BuyerOrderCntInfo buyerOrderCntInfo, Integer num) {
            if (buyerOrderCntInfo != null) {
                BuyerOrderCountItem buyerOrderCountItem = new BuyerOrderCountItem();
                com.shopee.app.d.b.b.a(buyerOrderCntInfo, buyerOrderCountItem, num);
                this.f18014d.a(buyerOrderCountItem);
                this.f18011a.a().cJ.a(buyerOrderCountItem).a();
            }
        }

        public void a(SellerOrderCntInfo sellerOrderCntInfo) {
            if (sellerOrderCntInfo != null) {
                SellerOrderCountItem sellerOrderCountItem = new SellerOrderCountItem();
                com.shopee.app.d.b.b.a(sellerOrderCntInfo, sellerOrderCountItem);
                this.f18014d.a(sellerOrderCountItem);
                this.f18011a.a().ch.a(sellerOrderCountItem).a();
            }
        }

        public void a(int i, int i2) {
            this.f18014d.a(i);
            this.f18014d.b(i2);
            this.f18011a.a().cz.a(new Pair(Integer.valueOf(i), Integer.valueOf(i2))).a();
        }

        private boolean b(ResponseOrderList responseOrderList) {
            return responseOrderList.errcode.intValue() == 0;
        }
    }
}
