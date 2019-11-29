package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.g.r;
import com.shopee.app.h.c.d;
import com.shopee.app.h.o;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bo;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bm extends c {
    public int a() {
        return 67;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        com.shopee.app.util.g.a e2 = o.a().e("UpdateGcmIDRegisterDeviceCallback");
        if (e2 != null) {
            e2.a();
        } else {
            c().a(responseCommon);
        }
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newSetUserInfoProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final al f17870a;

        /* renamed from: b  reason: collision with root package name */
        private final UserInfo f17871b;

        public a(al alVar, UserInfo userInfo) {
            this.f17870a = alVar;
            this.f17871b = userInfo;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                r.d(responseCommon);
                b.d(responseCommon, this.f17871b);
                az f2 = o.a().f(responseCommon.requestid);
                if (f2 != null && (f2 instanceof bo)) {
                    new au().a(this.f17871b.getUserId());
                }
                this.f17870a.a(this.f17871b);
                com.garena.android.appkit.b.b.a("SET_USER_INFO", (com.garena.android.appkit.b.a) new d(this.f17871b, responseCommon.requestid), b.a.NETWORK_BUS);
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            c(responseCommon);
            return false;
        }

        public void a() {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            c(builder.build());
        }

        private void c(ResponseCommon responseCommon) {
            com.garena.android.appkit.b.b.a("SET_USER_INFO_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }
    }
}
