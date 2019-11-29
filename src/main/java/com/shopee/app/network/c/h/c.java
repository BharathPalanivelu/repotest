package com.shopee.app.network.c.h;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.network.f;
import com.shopee.app.ui.auth.signup.phone.g;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class c extends com.shopee.app.network.c.c {
    public int a() {
        return 16;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            b.a("PHONE_VERIFY_SUCCESS", (a) new g(responseCommon.requestid, 0, responseCommon.otp_token), b.a.NETWORK_BUS);
        }
    }

    private void a(ResponseCommon responseCommon) {
        b.a("PHONE_VERIFY_ERROR", new a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
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
