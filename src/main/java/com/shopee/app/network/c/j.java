package com.shopee.app.network.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class j extends c {
    public int a() {
        return 38;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (a(responseCommon)) {
            b.a("CHECK_PASSWORD_SUCCESS", new a(), b.a.NETWORK_BUS);
        }
    }

    private boolean a(ResponseCommon responseCommon) {
        boolean z = responseCommon.errcode.intValue() == 0;
        if (!z) {
            b(responseCommon);
        }
        return z;
    }

    private void b(ResponseCommon responseCommon) {
        b.a("CHECK_PASSWORD_FAIL", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        b(builder.build());
    }
}
