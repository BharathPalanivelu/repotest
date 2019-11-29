package com.shopee.app.network.c.h;

import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.g.a;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class h extends c {
    public int a() {
        return 158;
    }

    public void a(int i) {
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        a e2 = o.a().e("UpdateGcmIDRegisterDeviceCallback");
        if (e2 != null) {
            e2.a();
        } else {
            if (!a(responseCommon)) {
            }
        }
    }

    private boolean a(ResponseCommon responseCommon) {
        boolean z = responseCommon.errcode.intValue() == 0;
        if (!z) {
            a(responseCommon.errcode.intValue());
        }
        return z;
    }

    public void a(String str) {
        a(-100);
    }
}
