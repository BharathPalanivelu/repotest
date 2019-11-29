package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.h.o;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class l extends c {
    public int a() {
        return 210;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newClearChatMsgProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f18034a;

        /* renamed from: b  reason: collision with root package name */
        private av f18035b;

        /* renamed from: c  reason: collision with root package name */
        private p f18036c;

        public a(n nVar, av avVar, p pVar) {
            this.f18034a = nVar;
            this.f18035b = avVar;
            this.f18036c = pVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                com.shopee.app.network.d.l lVar = (com.shopee.app.network.d.l) o.a().f(responseCommon.requestid);
                if (lVar != null) {
                    this.f18036c.a(lVar.b());
                    this.f18035b.a(Integer.valueOf(lVar.b()));
                }
                this.f18034a.a("CMD_CLEAR_CHAT_MSG_SUCCUSS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            this.f18034a.a("CMD_CLEAR_CHAT_MSG_ERROR", new com.garena.android.appkit.b.a(responseCommon.errcode));
            return false;
        }

        public void a() {
            this.f18034a.a("CMD_CLEAR_CHAT_MSG_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
