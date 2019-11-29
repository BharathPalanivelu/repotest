package com.shopee.app.network.c.h;

import com.garena.android.appkit.b.b;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class a extends c {
    public int a() {
        return 93;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (responseCommon.errcode.intValue() != 0) {
            a(responseCommon);
        } else {
            b.a("ACCOUNT_FOUND_SUCCESS", new com.garena.android.appkit.b.a(responseCommon), b.a.NETWORK_BUS);
        }
    }

    private void a(ResponseCommon responseCommon) {
        b.a("ACCOUNT_FOUND_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
