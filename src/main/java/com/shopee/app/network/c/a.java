package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class a extends c {
    public int a() {
        return 191;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            b.a("ADD_FEED_COMMENT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    }

    private void a(ResponseCommon responseCommon) {
        b.a("ADD_FEED_COMMENT_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
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
