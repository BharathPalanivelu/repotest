package com.shopee.app.network.c.h;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ak;
import com.shopee.app.g.r;
import com.shopee.app.h.m;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.f.h;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class i extends c {
    public int a() {
        return 12;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    private a c() {
        return ar.f().e().newRegisterProcessor();
    }

    public void a(String str) {
        c().a();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final aa f17937a;

        public a(aa aaVar) {
            this.f17937a = aaVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (c(responseCommon)) {
                r.a(responseCommon, 1);
                m.c();
                new h().a(ak.a(), this.f17937a.d(), false);
                b.a("REGISTER_SUCCESS", new com.garena.android.appkit.b.a(responseCommon), b.a.NETWORK_BUS);
            }
        }

        private void b(ResponseCommon responseCommon) {
            b.a("REGISTER_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }

        private boolean c(ResponseCommon responseCommon) {
            boolean z = responseCommon.errcode.intValue() == 0;
            if (!z) {
                b(responseCommon);
            }
            return z;
        }

        public void a() {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            b(builder.build());
        }
    }
}
