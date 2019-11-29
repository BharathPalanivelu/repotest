package com.shopee.app.network.c.k;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.r;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCheckoutList;
import com.shopee.protocol.shop.Checkout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class f extends c {
    public int a() {
        return 117;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseCheckoutList) com.shopee.app.network.f.f18486a.parseFrom(bArr, 0, i, ResponseCheckoutList.class));
    }

    public a c() {
        return ar.f().e().checkoutListProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final r f18008a;

        /* renamed from: b  reason: collision with root package name */
        private final n f18009b;

        /* renamed from: c  reason: collision with root package name */
        private final q f18010c;

        public a(n nVar, r rVar, q qVar) {
            this.f18009b = nVar;
            this.f18008a = rVar;
            this.f18010c = qVar;
        }

        public void a(ResponseCheckoutList responseCheckoutList) {
            if (b(responseCheckoutList)) {
                List<Checkout> arrayList = responseCheckoutList.checkout != null ? responseCheckoutList.checkout : new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Checkout a2 : arrayList) {
                    DBCheckoutItem dBCheckoutItem = new DBCheckoutItem();
                    b.a(a2, dBCheckoutItem);
                    arrayList2.add(dBCheckoutItem);
                    arrayList3.add(Long.valueOf(dBCheckoutItem.a()));
                }
                this.f18008a.a((List<DBCheckoutItem>) arrayList2);
                az f2 = o.a().f(responseCheckoutList.requestid);
                if (f2 == null || !(f2 instanceof com.shopee.app.network.d.h.f)) {
                    this.f18010c.a();
                    this.f18010c.a((List<Long>) arrayList3);
                }
                this.f18009b.a("CHECKOUT_LIST_SAVED", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseCheckoutList responseCheckoutList) {
            return responseCheckoutList.errcode.intValue() == 0;
        }
    }
}
