package com.shopee.app.network.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.c.c;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.network.d.h.g;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.OrdersnHint;
import com.shopee.protocol.action.ResponseOrdersnHint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ao extends c {
    public int a() {
        return FacebookRequestErrorClassification.EC_INVALID_TOKEN;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseOrdersnHint responseOrdersnHint = (ResponseOrdersnHint) f.f18486a.parseFrom(bArr, 0, i, ResponseOrdersnHint.class);
        c(responseOrdersnHint.requestid);
        ar.f().e().getOrdersnHintProcessor().a(responseOrdersnHint);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17814a;

        /* renamed from: b  reason: collision with root package name */
        private final c f17815b;

        public a(n nVar, c cVar) {
            this.f17814a = nVar;
            this.f17815b = cVar;
        }

        public void a(ResponseOrdersnHint responseOrdersnHint) {
            List<OrdersnHint> arrayList = responseOrdersnHint.hint == null ? new ArrayList<>() : responseOrdersnHint.hint;
            ArrayList arrayList2 = new ArrayList();
            for (OrdersnHint ordersnHint : arrayList) {
                if (b.a(ordersnHint.orderid) > 0) {
                    arrayList2.add(ordersnHint.orderid);
                }
            }
            List<DBOrderDetail> d2 = this.f17815b.d(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            for (DBOrderDetail next : d2) {
                if (next != null) {
                    arrayList3.add(Long.valueOf(next.a()));
                    arrayList2.remove(Long.valueOf(next.a()));
                }
            }
            if (arrayList2.size() > 0) {
                new g().a((List<Long>) arrayList2);
            } else {
                this.f17814a.a("ORDER_SN_HINT_LOAD", new com.garena.android.appkit.b.a(arrayList3));
            }
        }
    }
}
