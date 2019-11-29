package com.shopee.app.network.c.k;

import com.garena.android.appkit.b.b;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class a extends c {
    public int a() {
        return 134;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            com.shopee.app.network.d.h.a aVar = (com.shopee.app.network.d.h.a) o.a().f(responseCommon.requestid);
            if (aVar != null) {
                new com.shopee.app.data.store.c.c().c((List<Long>) Arrays.asList(new Long[]{Long.valueOf(aVar.b())}));
                b.a("ARCHIVE_ORDER_SUCCESS", new com.garena.android.appkit.b.a(Long.valueOf(aVar.b())), b.a.NETWORK_BUS);
            }
        }
    }

    private boolean b(ResponseCommon responseCommon) {
        if (responseCommon.errcode.intValue() == 0) {
            return true;
        }
        a(responseCommon);
        return false;
    }

    public void a(ResponseCommon responseCommon) {
        b.a("ARCHIVE_ORDER_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
