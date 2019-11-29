package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseBackend;
import java.io.IOException;

public class e extends c {
    public int a() {
        return 211;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseBackend responseBackend = (ResponseBackend) f.f18486a.parseFrom(bArr, 0, i, ResponseBackend.class);
        c(responseBackend.requestid);
        c().a(responseBackend);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newCallBackendProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17898a;

        public a(n nVar) {
            this.f17898a = nVar;
        }

        public void a(ResponseBackend responseBackend) {
            if (b(responseBackend)) {
                this.f17898a.a("CMD_CALL_BACKEND_SUCCUSS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseBackend responseBackend) {
            if (responseBackend.errcode.intValue() == 0) {
                return true;
            }
            this.f17898a.a("CMD_CALL_BACKEND_ERROR", new com.garena.android.appkit.b.a(responseBackend.errcode));
            return false;
        }

        public void a() {
            this.f17898a.a("CMD_CALL_BACKEND_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
