package com.shopee.app.network.c.j;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class b extends c {
    public int a() {
        return 104;
    }

    public void c(byte[] bArr, int i) throws IOException {
        boolean z = false;
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            com.shopee.app.data.store.c.c cVar = new com.shopee.app.data.store.c.c();
            com.shopee.app.network.d.h.c cVar2 = (com.shopee.app.network.d.h.c) o.a().f(responseCommon.requestid);
            if (cVar2 != null) {
                DBOrderDetail b2 = cVar.b(cVar2.b());
                if (!(b2 == null || b2.A() == responseCommon.count.intValue())) {
                    z = true;
                }
                com.garena.android.appkit.b.b.a("ORDER_BUY_AGAIN_SUCCESS", new a(Boolean.valueOf(z)), b.a.NETWORK_BUS);
            }
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
