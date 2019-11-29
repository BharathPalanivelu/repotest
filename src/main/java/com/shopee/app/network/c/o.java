package com.shopee.app.network.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ai;
import com.shopee.app.data.store.ak;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;
import java.util.List;

public class o extends c {
    public int a() {
        return 3;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            new ah().b(responseCommon.itemid.longValue());
            new ao().a(((Integer) ak.a().i().b(0)).intValue());
            List<Integer> a2 = ai.a().a(responseCommon.itemid);
            if (a2.size() > 0) {
                for (Integer aVar : a2) {
                    com.shopee.app.h.o.a().a(responseCommon.requestid);
                    b.a("ITEM_DELETE", new a(aVar), b.a.NETWORK_BUS);
                }
                return;
            }
            b.a("ITEM_DELETE", new a(), b.a.NETWORK_BUS);
        }
    }

    public void a(ResponseCommon responseCommon) {
        b.a("ITEM_DELETE_ERROR", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
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
