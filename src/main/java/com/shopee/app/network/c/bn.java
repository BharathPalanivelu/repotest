package com.shopee.app.network.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bn extends c {
    public int a() {
        return 41;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (a(responseCommon)) {
            b.a("UN_FOLLOW_SUCCESS", new a(responseCommon.requestid), b.a.NETWORK_BUS);
            b.a("FOLLOW_USER_REFRESH", new a(), b.a.NETWORK_BUS);
        }
    }

    private boolean a(ResponseCommon responseCommon) {
        if (responseCommon.errcode.intValue() == 0) {
            return true;
        }
        b(responseCommon);
        return false;
    }

    private void b(ResponseCommon responseCommon) {
        b.a("UN_FOLLOW_ERROR", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        b(builder.build());
    }
}
