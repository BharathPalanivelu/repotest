package com.shopee.app.network.c.k;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.viewmodel.OrderRateItemInfo;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.h.q;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class o extends c {
    public int a() {
        return 101;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            new com.shopee.app.data.store.c.c().a(responseCommon.orderid.longValue());
            Pair<Integer, Integer> c2 = com.shopee.app.h.o.a().c(responseCommon.requestid);
            c().a(responseCommon);
            b.a("ORDER_RATE_SUCCESS", (com.garena.android.appkit.b.a) new com.shopee.app.ui.order.a.a(((Integer) c2.first).intValue(), ((Integer) c2.second).intValue(), responseCommon.requestid), b.a.NETWORK_BUS);
            com.shopee.app.h.o.a().a(responseCommon.requestid);
        }
    }

    public a c() {
        return ar.f().e().orderRateProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final bb f18033a;

        public a(bb bbVar) {
            this.f18033a = bbVar;
        }

        /* access modifiers changed from: package-private */
        public void a(ResponseCommon responseCommon) {
            for (OrderRateItemInfo next : ((q) com.shopee.app.h.o.a().f(responseCommon.requestid)).b()) {
                if (next.isRatingGood()) {
                    if (this.f18033a.h()) {
                        this.f18033a.c(com.garena.android.appkit.tools.a.a.a());
                        this.f18033a.b(next.getOrderItemInfo().getOrderId());
                        this.f18033a.b(0);
                    } else if (this.f18033a.j()) {
                        this.f18033a.c(com.garena.android.appkit.tools.a.a.a());
                        this.f18033a.b(next.getOrderItemInfo().getOrderId());
                        this.f18033a.b(0);
                    }
                }
            }
        }
    }

    private void a(ResponseCommon responseCommon) {
        b.a("ORDER_RATE_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    private boolean b(ResponseCommon responseCommon) {
        if (responseCommon.errcode.intValue() == 0) {
            return true;
        }
        a(responseCommon);
        return false;
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
