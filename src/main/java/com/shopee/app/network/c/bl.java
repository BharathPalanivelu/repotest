package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.am;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bh;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bl extends c {
    public int a() {
        return 126;
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
        return ar.f().e().newSetChatQuickReplyProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17868a;

        /* renamed from: b  reason: collision with root package name */
        private final am f17869b;

        public a(n nVar, am amVar) {
            this.f17868a = nVar;
            this.f17869b = amVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                az f2 = o.a().f(responseCommon.requestid);
                if (f2 != null) {
                    bh bhVar = (bh) f2;
                    this.f17869b.a(bhVar.b());
                    this.f17869b.a(bhVar.c());
                }
                this.f17868a.a("CMD_SET_CHAT_QUICKREPLY_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            this.f17868a.a("CMD_SET_CHAT_QUICKREPLY_ERROR", new com.garena.android.appkit.b.a(responseCommon.errcode));
            return false;
        }

        public void a() {
            this.f17868a.a("CMD_SET_CHAT_QUICKREPLY_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
