package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.g.r;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bo extends c {
    public int a() {
        return 131;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    private a c() {
        return ar.f().e().newUnbindAccountProcessor();
    }

    public void a(String str) {
        c().a();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final al f17872a;

        /* renamed from: b  reason: collision with root package name */
        private final UserInfo f17873b;

        public a(al alVar, UserInfo userInfo) {
            this.f17872a = alVar;
            this.f17873b = userInfo;
        }

        public void a(ResponseCommon responseCommon) {
            if (c(responseCommon)) {
                r.c(responseCommon);
                b.b(responseCommon, this.f17873b);
                this.f17872a.a(this.f17873b);
                com.garena.android.appkit.b.b.a("UNBIND_ACCOUNT_SUCCESS", new com.garena.android.appkit.b.a(this.f17873b), b.a.NETWORK_BUS);
            }
        }

        public void b(ResponseCommon responseCommon) {
            com.garena.android.appkit.b.b.a("UNBIND_ACCOUNT_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }

        private boolean c(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            b(responseCommon);
            return false;
        }

        public void a() {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            b(builder.build());
        }
    }
}
