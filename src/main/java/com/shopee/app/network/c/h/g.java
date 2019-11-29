package com.shopee.app.network.c.h;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.v;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class g extends c {
    public int a() {
        return 165;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (responseCommon.errcode.intValue() != 0) {
            a(responseCommon.errcode.intValue());
            return;
        }
        ar.f().e().logoutProcessor().a();
        b.a("LOGOUT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
    }

    private void a(int i) {
        b.a("LOGOUT_FAIL", new com.garena.android.appkit.b.a(Integer.valueOf(i)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        a(-100);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final v f17936a;

        public a(v vVar) {
            this.f17936a = vVar;
        }

        public void a() {
            this.f17936a.a();
        }
    }
}
