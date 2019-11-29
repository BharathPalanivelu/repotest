package com.shopee.app.network.c.h;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.network.c.c;
import com.shopee.app.network.c.h.f;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class d extends c {
    public int a() {
        return 77;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (responseCommon.errcode.intValue() == 1) {
            b.a("FACEBOOK_LOGIN_REGISTER", new a(responseCommon), b.a.NETWORK_BUS);
        } else if (responseCommon.errcode.intValue() != 0) {
            if (!(responseCommon.errcode.intValue() == 11 || responseCommon.errcode.intValue() == 5)) {
                com.shopee.app.f.a.a().f();
            }
            b(responseCommon);
            a(responseCommon);
        } else {
            c().a(responseCommon, 0);
        }
    }

    private void a(ResponseCommon responseCommon) {
        b.a("FACEBOOK_LOGIN_FAIL_BASE", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    private void b(ResponseCommon responseCommon) {
        b.a("FACEBOOK_LOGIN_FAIL", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    private f.a c() {
        return ar.f().e().newLoginProcessor();
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        c().a(builder.build());
    }
}
