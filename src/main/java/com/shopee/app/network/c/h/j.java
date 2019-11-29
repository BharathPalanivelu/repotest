package com.shopee.app.network.c.h;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.h.o;
import com.shopee.app.network.a.a;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.f.m;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class j extends c implements a<ResponseCommon> {
    public int a() {
        return 15;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (responseCommon.errcode.intValue() != 0) {
            a(responseCommon);
            return;
        }
        az f2 = o.a().f(responseCommon.requestid);
        if (f2 instanceof m) {
            b.a("SEND_V_CODE_SUCCESS", new com.garena.android.appkit.b.a(new Pair(responseCommon.requestid, Boolean.valueOf(((m) f2).c()))), b.a.NETWORK_BUS);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ResponseCommon responseCommon) {
        b.a("SEND_V_CODE_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }
}
