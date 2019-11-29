package com.shopee.app.network.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.data.store.c.e;
import com.shopee.app.h.o;
import com.shopee.app.network.d.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class b extends c {
    public int a() {
        return 135;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            c cVar = (c) o.a().f(responseCommon.requestid);
            if (cVar != null) {
                new e().b(cVar.b());
                com.garena.android.appkit.b.b.a("ARCHIVE_RETURN_SUCCESS", new a(), b.a.NETWORK_BUS);
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
        com.garena.android.appkit.b.b.a("ARCHIVE_RETURN_FAIL", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
