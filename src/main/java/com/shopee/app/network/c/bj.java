package com.shopee.app.network.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bj extends c {
    public int a() {
        return 79;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (responseCommon.errcode.intValue() != 0) {
            a(responseCommon);
        } else {
            b.a("SEND_V_MAIL_SUCCESS", new a(responseCommon.requestid), b.a.NETWORK_BUS);
        }
    }

    private void a(ResponseCommon responseCommon) {
        b.a("SEND_V_MAIL_FAIL", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
