package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.h.o;
import com.shopee.app.network.d.bg;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bk extends c {
    public int a() {
        return 35;
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
        return ar.f().e().newSetChatLastReadProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ChatBadgeStore f17866a;

        /* renamed from: b  reason: collision with root package name */
        private n f17867b;

        public a(n nVar, ChatBadgeStore chatBadgeStore) {
            this.f17867b = nVar;
            this.f17866a = chatBadgeStore;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                bg bgVar = (bg) o.a().f(responseCommon.requestid);
                if (bgVar != null) {
                    this.f17866a.syncComplete(bgVar.b(), bgVar.c());
                }
                this.f17867b.a("CMD_SET_CHAT_LAST_READ_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            this.f17867b.a("CMD_SET_CHAT_LAST_READ_ERROR", new com.garena.android.appkit.b.a(responseCommon.errcode));
            return false;
        }

        public void a() {
            this.f17867b.a("CMD_SET_CHAT_LAST_READ_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
