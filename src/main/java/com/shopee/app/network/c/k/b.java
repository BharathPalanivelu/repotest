package com.shopee.app.network.c.k;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.h.m;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class b extends c {
    public int a() {
        return 19;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            com.shopee.app.data.store.c.c cVar = new com.shopee.app.data.store.c.c();
            DBOrderDetail b2 = cVar.b(responseCommon.orderid.longValue());
            if (b2 != null) {
                b2.f(5);
                cVar.a(b2);
                OrderKey orderKey = new OrderKey(b2);
                boolean a2 = m.a(b2.b());
                com.shopee.app.data.store.c.b bVar = new com.shopee.app.data.store.c.b();
                bVar.a(a2, b2.a());
                bVar.a(orderKey, b2.a());
                at atVar = new at();
                atVar.a(a2, b2.a());
                atVar.a(orderKey, b2.a());
            }
            com.garena.android.appkit.b.b.a("ORDER_CANCEL_SUCCESS", new a(responseCommon.orderid), b.a.NETWORK_BUS);
        }
    }

    private void a(ResponseCommon responseCommon) {
        com.garena.android.appkit.b.b.a("ORDER_UPDATE_ERROR", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    private boolean b(ResponseCommon responseCommon) {
        boolean z = responseCommon.errcode.intValue() == 0;
        if (!z) {
            a(responseCommon);
        }
        return z;
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
