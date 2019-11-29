package com.shopee.app.network.c;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.g.r;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bh extends c implements com.shopee.app.network.a.a<ResponseCommon> {
    public int a() {
        return 14;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    private a c() {
        return ar.f().e().newResetPasswordProcess();
    }

    public void a(String str) {
        c().a();
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final al f17864a;

        /* renamed from: b  reason: collision with root package name */
        private final UserInfo f17865b;

        public a(al alVar, UserInfo userInfo) {
            this.f17864a = alVar;
            this.f17865b = userInfo;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                r.a(responseCommon);
                b.c(responseCommon, this.f17865b);
                this.f17864a.a(this.f17865b);
                com.garena.android.appkit.b.b.a("RESET_PASSWORD_SUCCESS", new com.garena.android.appkit.b.a(responseCommon), b.a.NETWORK_BUS);
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            c(responseCommon);
            return false;
        }

        private void c(ResponseCommon responseCommon) {
            com.garena.android.appkit.b.b.a("RESET_PASSWORD_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }

        public void a() {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            c(builder.build());
        }
    }
}
