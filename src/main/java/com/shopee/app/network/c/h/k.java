package com.shopee.app.network.c.h;

import com.shopee.app.application.ar;
import com.shopee.app.network.c.c;
import com.shopee.app.network.c.h.f;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class k extends c {
    public int a() {
        return 171;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon, 2);
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
