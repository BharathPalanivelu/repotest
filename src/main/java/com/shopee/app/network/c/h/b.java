package com.shopee.app.network.c.h;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class b extends c implements com.shopee.app.network.a.a<ResponseCommon> {
    public int a() {
        return 243;
    }

    public void c(byte[] bArr, int i) throws IOException {
        Pair<String, ResponseCommon> a2 = a(bArr);
        c((String) a2.first);
        c().a((ResponseCommon) a2.second);
    }

    private a c() {
        return ar.f().e().checkCaptchaProcessor();
    }

    public void a(String str) {
        c().a(str);
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17921a;

        public a(n nVar) {
            this.f17921a = nVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (c(responseCommon)) {
                this.f17921a.a().av.a(responseCommon.token).a();
            }
        }

        public void a(String str) {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            builder.requestid = str;
            b(builder.build());
        }

        private void b(ResponseCommon responseCommon) {
            this.f17921a.a().ai.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)).a();
        }

        private boolean c(ResponseCommon responseCommon) {
            boolean z = responseCommon.errcode.intValue() == 0;
            if (!z) {
                b(responseCommon);
            }
            return z;
        }
    }
}
