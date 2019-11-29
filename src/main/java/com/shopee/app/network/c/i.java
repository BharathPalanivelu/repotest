package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.az;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.CartItemInfo;
import com.shopee.protocol.action.ResponseCartAllOrders;
import com.shopee.protocol.action.ShopOrder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class i extends c {
    public int a() {
        return 86;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseCartAllOrders) f.f18486a.parseFrom(bArr, 0, i, ResponseCartAllOrders.class));
    }

    private a c() {
        return ar.f().e().getCartGetAllOrdersProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17938a;

        /* renamed from: b  reason: collision with root package name */
        private final az f17939b;

        /* renamed from: c  reason: collision with root package name */
        private final MeCounter f17940c;

        public a(n nVar, MeCounter meCounter, az azVar) {
            this.f17938a = nVar;
            this.f17939b = azVar;
            this.f17940c = meCounter;
        }

        public void a(ResponseCartAllOrders responseCartAllOrders) {
            if (b(responseCartAllOrders) && responseCartAllOrders.shoporders != null) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShopOrder next : responseCartAllOrders.shoporders) {
                    if (next.iteminfos != null) {
                        for (CartItemInfo next2 : next.iteminfos) {
                            i += next2.quantity == null ? 0 : next2.quantity.intValue();
                            long a2 = b.a(next2.offerid);
                            if (a2 > 0) {
                                arrayList.add(Long.valueOf(a2));
                            }
                        }
                    }
                }
                this.f17940c.setCartCount(i);
                this.f17939b.a((List<Long>) arrayList);
                this.f17938a.a().dl.a();
            }
        }

        private boolean b(ResponseCartAllOrders responseCartAllOrders) {
            return responseCartAllOrders.errcode.intValue() == 0;
        }
    }
}
